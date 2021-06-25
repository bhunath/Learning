package IOStreams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IOStreamExamples {


    public static void main(String[] args) throws IOException {
        title("reading file with Input Stream byte by byte");
        String fileName = "C:\\Users\\bhunath\\IdeaProjects\\Learning\\advancejavatutorial\\src\\IOStreams\\IOStream.txt";
        Path path = Paths.get(fileName);
        try(InputStream inputStream = Files.newInputStream(path)){
            int read = 0;
            while((read = inputStream.read()) != -1){
                byte byteValue = (byte) read;
                System.out.println("byte value:  " + byteValue + " , char value : " + ((char)byteValue));
            }
        }

        title("reading file with Input Stream with all byte at once");
        try(InputStream inputStream = Files.newInputStream(path)){
            int read = 0;
            try(OutputStream outputStream = new ByteArrayOutputStream()){
                while((read = inputStream.read()) != -1){
                    outputStream.write(read);
                }
                System.out.println("Reading Entire String with Output Stream : " + outputStream);
            }
        }

        title("reading all byte from java 9 : InputStream.transferTo");
        try(InputStream inputStream = Files.newInputStream(path)){
            int read = 0;
            try(OutputStream outputStream = new ByteArrayOutputStream()){
                inputStream.transferTo(outputStream);
                System.out.println("Reading Entire String with Output Stream : " + outputStream);
            }
        }

        title("reading all byte from java 9 : URL.readAllBytes");
        Path filePath = Paths.get(fileName);
        URL url = filePath.toUri().toURL();
        try(OutputStream outputStream = new ByteArrayOutputStream()){
            InputStream inputStream = url.openStream();
            outputStream.write(inputStream.readAllBytes());
            System.out.println("Reading Entire String with Output Stream : " + outputStream);
        }

        title("reading all byte from java 9 : Files.readAllBytes");
        String entireValue = new String(Files.readAllBytes(filePath),StandardCharsets.UTF_8);
        System.out.println(entireValue);

        title("using Scanner with Charsets");
        Scanner scanner = new Scanner(filePath, StandardCharsets.US_ASCII);
        String joinedString = scanner.tokens().collect(Collectors.joining());
        System.out.println("US_ASCII : "+ joinedString);

        scanner = new Scanner(filePath, StandardCharsets.UTF_8);
        joinedString = scanner.tokens().collect(Collectors.joining());
        System.out.println("UTF_8 : "+ joinedString);

        scanner = new Scanner(filePath, StandardCharsets.UTF_16);
        joinedString = scanner.tokens().collect(Collectors.joining());
        System.out.println("UTF_16 : "+ joinedString);

        scanner = new Scanner(filePath, StandardCharsets.ISO_8859_1);
        joinedString = scanner.tokens().collect(Collectors.joining());
        System.out.println("ISO_8859_1 : "+ joinedString);

        title(" Reading Content from URL : InputStream.transferTo");
        url = new URL("https://horstmann.com/unblog/index.html");
        long startTime = System.currentTimeMillis();
        try(InputStream inputStream = url.openStream()){
            try(OutputStream outputStream = new ByteArrayOutputStream()) {
                inputStream.transferTo(outputStream);
                String valueReadFromUrl = outputStream.toString();
                System.out.println("*********************Horstmann URL content ******************");
                System.out.println(valueReadFromUrl);
                System.out.println("%%%%% Reading content completed in : "+ (System.currentTimeMillis()-startTime));
            }
        }

        title(" Reading Content from URL : InputStream.readAllBytes");
        url = new URL("https://horstmann.com/unblog/index.html");
        startTime = System.currentTimeMillis();
        try(InputStream inputStream = url.openStream()){
            String valueReadFromUrl = new String(inputStream.readAllBytes(),StandardCharsets.UTF_8);
            System.out.println("*********************Horstmann URL content ******************");
            System.out.println(valueReadFromUrl);
            System.out.println("%%%%% Reading content completed in : "+ (System.currentTimeMillis()-startTime));
        }

    }

    private static void title(String value) {
        System.out.println("\n"+value);
    }
}
