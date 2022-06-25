package Reactive;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Flow;

@Data
@AllArgsConstructor
public class Subscription implements Flow.Subscription{

    private final Flow.Subscriber<? super Info> subscriber;
    private final String town;


    @Override
    public void request(long n) {
        for (long i = 0L; i < n; i++) {
            try{
                subscriber.onNext(Info.fetch(town));
            }catch (Exception e){
                subscriber.onError(e);
                break;
            }
        }
    }
    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
