import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectorsFactories {

    @Test
    public void test(){
        List immutableList = List.of("con", "two", "three");
        Set immutableSet = Set.of("one", "tow", "three");
        Map<Integer, String> immutableMap = Map.of(1, "one1", 2, "two2", 3, "three3");


        immutableList.stream().forEach(System.out::println);
        immutableSet.stream().forEach(System.out::println);
        immutableMap.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
        immutableMap.entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println);
    }
}
