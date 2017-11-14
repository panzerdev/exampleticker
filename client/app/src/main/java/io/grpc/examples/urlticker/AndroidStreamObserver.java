package io.grpc.examples.urlticker;

import io.grpc.stub.StreamObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by mpa on 20.11.17.
 */

public class AndroidStreamObserver<T> extends Observable<T> implements StreamObserver<T> {

    private Observer<? super T> mObserver;

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        mObserver = observer;
    }


    @Override
    public void onNext(T value) {
        if (mObserver != null){
            mObserver.onNext(value);
        }
    }

    @Override
    public void onError(Throwable t) {
        if (mObserver != null){
            mObserver.onError(t);
        }
    }

    @Override
    public void onCompleted() {
        if (mObserver != null){
            mObserver.onComplete();
        }
    }
}
