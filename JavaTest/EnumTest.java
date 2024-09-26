public class EnumTest {
    public static void main(String[] args) {
        var gender = "MALE";

        if(gender.equals(Gender.TRANSGENDER.toString())){
            System.out.println("Gender is male");
        }else {
            System.out.println("some Other gender");
        }
    }
}
