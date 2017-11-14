package main

import (
	"context"
	"fmt"
	"github.com/SlyMarbo/rss"
	"github.com/panzerdev/exampleticker/server/pb"
	"google.golang.org/grpc"
	"io"
	"log"
	"net"
	"os"
	"sync"
	"time"
)

type server struct {
	topics []*TickerTopic
}

func (s *server) StreamTitles(reqServer pb.UrlTicker_StreamTitlesServer) error {
	urlChan := make(chan bool)
	ctx, cancel := context.WithCancel(context.Background())
	go func(ctx context.Context, url chan bool) {
		pos := 0
		tick := time.Tick(time.Second)
		for {
			select {
			case <-ctx.Done():
				log.Println("Done with routine")
				return
			case <-url:
				pos++
				if pos == len(s.topics)-1 {
					pos = 0
				}
			case <-tick:
				err := reqServer.Send(&pb.LinkTitlesResponse{
					Title: s.topics[pos].GetCurrent(),
					Topic: s.topics[pos].topic,
				})
				if err != nil {
					log.Println("Error sending")
					return
				}


			}
		}
	}(ctx, urlChan)
	for {
		req, err := reqServer.Recv()
		if err == io.EOF {
			log.Println("Stream is over")
			cancel()
			return nil
		} else if err != nil {
			log.Println("Error Recv", err)
			cancel()
			return nil
		}

		urlChan <- true
		log.Println("Next for User:", req.Username)
	}
}

type TickerTopic struct {
	sync.RWMutex
	currentPos int
	titles     []string
	topic      string
}

func StartTopic(url string) *TickerTopic {
	tt := &TickerTopic{
		topic: url,
	}
	go tt.startTickering()
	return tt
}

func (tt *TickerTopic) startTickering() {
	titles, err := getTitles(tt.topic)
	if err != nil {
		log.Println("Error getting titles", err)
		time.Sleep(time.Second)
		go tt.startTickering()
		return
	}
	tt.titles = titles

	for {
		tt.Lock()
		tt.currentPos++
		if tt.currentPos >= len(titles) {
			tt.currentPos = 0
		}
		tt.Unlock()
		time.Sleep(time.Second * 3)
	}
}

func (tt *TickerTopic) GetCurrent() string {
	if len(tt.titles) == 0 {
		return "Nothing yet"
	}

	tt.RLock()
	s := tt.titles[tt.currentPos]
	tt.RUnlock()
	return s
}

func getTitles(newUrl string) (msg []string, err error) {
	feed, err := rss.Fetch(newUrl)
	if err != nil {
		// handle error.
	}
	for _, v := range feed.Items {
		msg = append(msg, fmt.Sprintf("%v\n\n%v", v.Title, v.Summary))
	}
	return msg, nil
}

func main() {
	port := os.Getenv("PORT")
	log.Println("Starting service on port", port)

	var topics []*TickerTopic
	topics = append(topics,
		StartTopic("http://www.faz.net/rss/aktuell/"),
		StartTopic("http://www.spiegel.de/schlagzeilen/tops/index.rss"),
		StartTopic("https://www.heise.de/newsticker/heise-atom.xml"))

	srv := &server{
		topics: topics,
	}

	lis, err := net.Listen("tcp", ":"+port)
	if err != nil {
		log.Fatalf("Failed to listen: %v", err)
	}
	s := grpc.NewServer()
	pb.RegisterUrlTickerServer(s, srv)
	log.Fatalln("GRPC ERROR", s.Serve(lis))
}
