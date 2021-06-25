package IOStreams;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesReaderExample {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\bhunath\\IdeaProjects\\Learning\\advancejavatutorial\\src\\IOStreams\\IOStream.txt";
        Path path = Paths.get(fileName);
        title("File read all Lines");
        List<String> strings = Files.readAllLines(path);
        System.out.println(strings);

        /**
         * The disadvantage of using readAllLines is that if the file is very large
         * than it will make the call slow.
         * Instead we can use Files.lines which prepare the Stream and we can read the lines
         * as they are available.
         */
        String collect = Files.lines(path).collect(Collectors.joining());
        System.out.println(collect);

        title("PrintWriter with String Writer");
        final StringWriter out = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(out));
        System.out.println(out.toString());
    }

    private static void title(String value) {
        System.out.println("\n"+value);
    }
}
