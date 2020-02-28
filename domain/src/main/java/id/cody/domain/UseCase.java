package id.cody.domain;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public abstract class UseCase<RequestT,ResponseT> {


    Observable<ResponseT> sources;
    CaseObserver<ResponseT> observer;

    protected abstract Observable<ResponseT> buildObservable(RequestT request);

    public void execute(CaseObserver<ResponseT> observer, RequestT request){
        sources=buildObservable(request);
        sources.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        this.observer=observer;
    }


    public void dispose(){
        if(observer!=null){
            if (!observer.isDisposed()) {
                observer.dispose();
            }
        }
    }








}
