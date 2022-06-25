package reactive;

import java.util.concurrent.Flow;

public class Subscriber implements Flow.Subscriber<Info>{

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Info item) {
        System.out.println(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("throwable.getMessage() = " + throwable.getMessage() + " [" + Thread.currentThread().getName() + "]");

    }

    @Override
    public void onComplete() {
        System.out.println(" Done ! " + " [" + Thread.currentThread().getName() + "]");
    }
}
