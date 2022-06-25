package Reactive;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class Info {
    public static final Random random = new Random();

    private final String town;
    private final int temp;


    public static Info fetch(String town){
        if(random.nextInt(10) ==0){
            throw new RuntimeException("error");
        }
        return new Info(town, random.nextInt(100));
    }
}
