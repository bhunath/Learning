package IOStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.LongStream;

/**
 * 1) Binary Data Stream are used if we want faster processing.
 *    . DataInputStream
 *    . DataOutputStream
 * 2) MemoryMapped Streams are faster and used to load Large files in system.
 *
 */
public class BinaryStreamsPerformanceTest {

    public static void main(String[] args) throws IOException {
        checkBinaryDataPerformance();
        checkCharacterStreamDataPerformance();
    }

    private static void checkCharacterStreamDataPerformance() throws IOException {
        title("Writing using Byte Streams.");
        String fileName = "C:\\Users\\bhunath\\IdeaProjects\\Learning\\advancejavatutorial\\src\\IOStreams\\characterStream.out";
        File file = new File(fileName);
        final boolean newFile = file.createNewFile();
        final Path path = file.toPath();
        System.out.println("File is at : "+ path);
        long startTime = System.currentTimeMillis();
        try (OutputStream outputStream = Files.newOutputStream(path)){
            LongStream.rangeClosed(0, 10000).boxed().
                    forEach(value -> {
                        try {
                            outputStream.write(value.byteValue());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        System.out.println("Writing completed in : " + (System.currentTimeMillis() - startTime) + " ms");

        title("Reading a in Character format.");
        startTime = System.currentTimeMillis();
        try(InputStream dis = Files.newInputStream(file.toPath())){
            while(dis.available() > 0){
                System.out.println(dis.readAllBytes());
            }
        }

        System.out.println("Reading completed in : " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void checkBinaryDataPerformance() throws IOException {
        title("Writing using Binary Data Streams");
        String fileName = "C:\\Users\\bhunath\\IdeaProjects\\Learning\\advancejavatutorial\\src\\IOStreams\\binaryOutput.out";
        File file = new File(fileName);
        final boolean newFile = file.createNewFile();
        final Path path = file.toPath();
        System.out.println("File is at : "+ path);
        long startTime = System.currentTimeMillis();
        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(path))){
            LongStream.rangeClosed(0, 10000).boxed().
                    forEach(value -> {
                        try {
                            dataOutputStream.writeLong(value);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        System.out.println("Writing completed in : " + (System.currentTimeMillis() - startTime) + " ms");

        title("Reading a Binary file");
        startTime = System.currentTimeMillis();
        try(DataInputStream dis = new DataInputStream(Files.newInputStream(file.toPath()))){
            long readValue = 0;
            while(dis.available() > 0){
                System.out.println(dis.readAllBytes());
            }
        }

        System.out.println("Reading completed in : " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void title(String value) {
        System.out.println("\n"+value);
    }
}
