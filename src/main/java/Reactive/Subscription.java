package Reactive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;


public class Subscription implements Flow.Subscription{

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);
    private final Flow.Subscriber<? super Info> subscriber;
    private final String town;


    public Subscription(Flow.Subscriber<? super Info> subscriber,
                          String town) {
        this.subscriber = subscriber;
        this.town = town;
    }
    @Override
    public void request(long n) {
//        executor.submit(()->{
            for (long i = 0L; i < n; i++) {
                try{
                    subscriber.onNext(Info.fetch(town));
                }catch (Exception e){
                    subscriber.onError(e);
                    break;
                }
            }
//        });
    }
    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
