package Reactive;

import lombok.*;

import java.util.Random;


@Getter
@Setter
public class Info {
    public static final Random random = new Random();
    private final String town;
    private final int temp;

    public Info(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    public static Info fetch(String town){
        if(random.nextInt(10) == 0){
            throw new RuntimeException("error");
        }
        return new Info(town, random.nextInt(100));
    }

    @Override
    public String toString() {
        return "Info {" +
                "town='" + town + '\'' +
                ", temp=" + temp +
                '}' + " thread : " + Thread.currentThread().getName();
    }
}
