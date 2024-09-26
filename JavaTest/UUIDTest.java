import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {

        int uuidVersion = UUID.randomUUID().version();
        String uuid = UUID.randomUUID().toString();

        System.out.println(uuidVersion);
        System.out.println(uuid);

    }
}
