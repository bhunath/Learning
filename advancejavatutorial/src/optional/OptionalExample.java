package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalExample {
    public static void main(String[] args) {
        optionalFlatMapExampleList();
        optionalStreamMethodIdiomExample();
    }

    /**
     *
     */
    private static void optionalStreamMethodIdiomExample() {
        System.out.println("optionalStreamMethodIdiomExample=================================================");
        List<String> strings = Arrays.asList("bhupendra", "shubhi", "sucheta");
        final Stream<Optional<String>> optionalStream = strings.stream().map(OptionalExample::isShubhiFound);
        List<String> collect = optionalStream.flatMap(Optional::stream).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void optionalFlatMapExampleList() {
        System.out.println("optionalFlatMapExample=================================================");
        List<String> family = Arrays.asList("bhupendra", "shubhi", "sucheta");
        findS(family).flatMap(OptionalExample::isShubhiFound).ifPresent(System.out::println);
    }

    private static Optional<String> isShubhiFound(String value) {
        return Optional.ofNullable(value.contains("shu")?value:null);
    }

    private static Optional<String> findS(List<String> family) {
        return family.stream().filter(s -> s.contains("shu")).findFirst();
    }
}



