import com.sun.tools.javac.Main;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        var a = 89.56;
        Number b = 10;

//        System.out.println(a+b);

//        var list = new Object[]{23.56, 12, "Chandan", new Test(), 'C'};

        var list = List.of("Chandan", 12.5, 10, new Test(), 'A');
        var slist = List.of("Chandan", "Ravi", "Sam");
        var nlist = List.of(12, 45, 90.6);

//        list.forEach(System.out::println);

        list.forEach(item->{
            if(item instanceof String){
                System.out.println(item);
            }
        });

        var result = "";
        for (var item:slist){
            result = result.concat(item);
        }

        System.out.println(result);
    }
}
