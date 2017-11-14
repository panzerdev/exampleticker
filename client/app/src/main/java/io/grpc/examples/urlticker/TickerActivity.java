/*
 * Copyright 2015, gRPC Authors All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.grpc.examples.urlticker;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.urlticker.grpc.LinkTitlesResponse;
import io.grpc.examples.urlticker.grpc.UrlRequest;
import io.grpc.examples.urlticker.grpc.UrlTickerGrpc;
import io.grpc.stub.StreamObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TickerActivity extends AppCompatActivity {

        private static final String mHostIp = "192.168.2.104";
//    private static final String mHostIp = "192.168.43.254";
    private static final int mPort = 3000;

    private TextView mResultText;
    private TextView mResultLable;
    private ManagedChannel mChan;
    private StreamObserver<UrlRequest> req;
    private UrlTickerGrpc.UrlTickerStub stub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloworld);

        mResultText = findViewById(R.id.grpc_response_text);
        mResultLable = findViewById(R.id.grpc_response_lable);
        mResultText.setMovementMethod(new ScrollingMovementMethod());

        mChan = ManagedChannelBuilder.forAddress(mHostIp, mPort)
                .usePlaintext(true)
                .build();
        stub = UrlTickerGrpc.newStub(mChan);
    }

    public void sendMessage(View view) {
        if (req == null) {
            AndroidStreamObserver<LinkTitlesResponse> aso = new AndroidStreamObserver<LinkTitlesResponse>();
            req = stub.streamTitles(aso);
            aso.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new Observer<LinkTitlesResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LinkTitlesResponse linkTitlesResponse) {
                            mResultText.setText(linkTitlesResponse.getTitle());
                            mResultLable.setText(linkTitlesResponse.getTopic());
                        }

                        @Override
                        public void onError(Throwable e) {
                            mResultText.setText(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            mResultLable.setText("Response: Over");
                            mResultText.setText("Over");
                            req = null;
                        }
                    });
        }
        Observable.just()
        req.onNext(UrlRequest.newBuilder().setUsername(Build.FINGERPRINT).build());
    }

    public void stopMessage(View view) {
        if (req != null) {
            req.onCompleted();
        }
    }
}
