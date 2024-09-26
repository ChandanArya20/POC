public class LoopTimeTest {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for(int i=1;i<100000;i++){
//            System.out.println(i);
            if(i==50000){
                System.out.println("Half");
            }
        }

        System.out.println("Time take: "+(System.currentTimeMillis()-start));
    }
}
