import reactive.Publisher;
import reactive.Subscriber;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow;


class MainTest {

    @Test
    public void test(){
    Publisher publisher = new Publisher("seoul");

    Flow.Subscriber subscriber1 = new Subscriber();
    Flow.Subscriber subscriber2 = new Subscriber();

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);
    }
}