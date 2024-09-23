import java.util.Map;

public class VarTest {
    public static void main(String[] args) {
        var result = fuc("Chandan");
        System.out.println(result);

        var mapList = Map.of(
                "name","Chandan",
                "age",21,
                "City","Bettiah",
                "Mobo", 9905669732L

        );

        for (var entry:mapList.entrySet()){
            System.out.println("Key :"+entry.getKey()+" -- "+"Value :"+entry.getValue());
        }
    }

    static String fuc(String name){
        return "Helo "+name;
    }
}
