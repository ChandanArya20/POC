import java.io.*;

public class IOTest {

    public static void main(String[] args) throws IOException {

//        PrintWriter file = new PrintWriter(new FileWriter("data.txt",true));
//        file.println("My name is Chandan Kumar");
//        file.close();

//        var fileStream = new FileInputStream("kalki.mp4");
//        byte[] bytes = fileStream.readAllBytes();
//        System.out.println("Data is read successfully");

        // Start timing
        long startTime = System.currentTimeMillis();

        var fiStream = new FileInputStream("kalki.mp4");
        var foStream = new FileOutputStream("kalki_copy.mp4");

        var buffer = new byte[1024+1024];
        int chunk;

        while((chunk = fiStream.read(buffer))!=-1){
            foStream.write(buffer);
        }

        // End timing
        long endTime = System.currentTimeMillis();

        // Calculate the elapsed time
        long elapsedTimeMillis = endTime - startTime;
        double elapsedTimeSeconds = elapsedTimeMillis / 1000.0;

        // Close streams
        fiStream.close();
        foStream.close();

        System.out.println("Data read and write completed successfully.");
        System.out.println("Time taken: " + elapsedTimeMillis + " ms (" + elapsedTimeSeconds + " seconds)");
    }
}
