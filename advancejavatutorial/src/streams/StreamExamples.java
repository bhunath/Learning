package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        Stream<String> wordStream = Stream.of("A", "B", "C");
        show(wordStream);

        Stream<String> lowerCaseStream = Stream.of("A", "B", "C").map(String::toLowerCase); /*wordStream can not be reused*/
        show(lowerCaseStream);

        Stream<String> echoStream = Stream.generate(() -> "Echo");
        show(echoStream);

        Stream<Double> randomStream = Stream.generate(Math::random).peek(aDouble -> System.out.println("Element Fetched "));
        show(randomStream);

        Stream<Integer> sequentialStream = Stream.iterate(1, integer -> integer++);
        show(sequentialStream);

        Stream<String> bhupendraStream = Stream.of("Bhupendra", "Nath");
        Stream<String> stringStream = bhupendraStream.flatMap(s -> Stream.of(s.split("")));
        show(stringStream);
    }

    private  static <T> void  show(Stream<T> wordStream) {
        wordStream.limit(20).forEach(System.out::print);
        System.out.println("\n");
    }


}
