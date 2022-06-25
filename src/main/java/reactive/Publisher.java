package reactive;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Flow;

@Data
@AllArgsConstructor
public class Publisher implements Flow.Publisher<Info>{
    private String town;

    @Override
    public void subscribe(Flow.Subscriber<? super Info> subscriber) {
        subscriber.onSubscribe(new Subscription(subscriber, town));
    }
}
