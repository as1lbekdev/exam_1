import com.fasterxml.jackson.core.JsonProcessingException;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
//        List<Integer> integers = List.of(1, 2, 3, 4);
//        List<String> strings = List.of("1290", "aksjas");
//        print(integers);
//        print(strings);
//
//        Generic generic = new Generic();
//        List<String> stringList = List.of("A", "B", "C");

        User user = new User();
        user.setAge(1000);
        MyImmutableClass myImmutableClass = new MyImmutableClass(
                100, "Test", user
        );

        System.out.println(myImmutableClass.hashCode());

        User user1 = myImmutableClass.getUser();
        user1.setAge(1900);
        System.out.println(myImmutableClass.hashCode());
    }














    private static void print(List<?> objects) {
        for (Object obj: objects) {
            System.out.println(obj);
        }
    }
}