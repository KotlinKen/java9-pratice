package reactive;

import java.util.concurrent.Flow;

/**
 * A component that acts as both a Subscriber and Publisher.
 * Type parameters:
 * T - the subscribed item type
 * R - the published item type
 *
 * Subscriber : Info
 * Publisher : INfo
 */
public class Processor implements Flow.Processor<Info,Info>{
    private Flow.Subscriber<? super Info> subscriber;

    @Override
    public void subscribe(Flow.Subscriber<? super Info> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(Info item) {
        subscriber.onNext(new Info(item.getTown() + ", 온도", (item.getTemp() - 32) * 5 / 9));
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();;
    }
}
