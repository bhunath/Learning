package streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamCollectorsExample {

    public static void main(String[] args) {
        title("iterator");
        Iterator<Integer> iterator = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        iterator.forEachRemaining(System.out::print);
        System.out.println("");
        title("toArray without Argument");
        // toArray without Argument return a Array of type Object
        Object[] objects = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println(objects);
        System.out.println(Arrays.toString(objects));

        title("toArray with type Argument");
        Integer[] integers = Stream.iterate(0,n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println(integers);
        System.out.println(Arrays.toString(integers));

        title("toMap");
        Map<String, String> mapOfLocaleByCountry = Stream.of(Locale.getAvailableLocales()).
                collect(toMap(Locale::getCountry, Locale::getDisplayCountry, (existingValue, newValue) -> newValue));

        System.out.println(mapOfLocaleByCountry);

        title("groupBy");
        Map<String, List<Locale>> localeGroupByCountry = Stream.of(Locale.getAvailableLocales()).collect(groupingBy(Locale::getCountry));
        System.out.println(localeGroupByCountry);

        title("mapPartitioningBy");
        Map<Boolean, List<Locale>> indianLocale = Stream.of(Locale.getAvailableLocales()).collect(partitioningBy(locale -> locale.getCountry().equals("IN")));
        System.out.println(indianLocale.get(true));

        title("SummarizingInt");
        Stream<String> familyLocal = Stream.of("Bhupendra", "Shubhi", "Sucheta");
        IntSummaryStatistics summaryStatistics = familyLocal.collect(summarizingInt(String::length));
        System.out.println(summaryStatistics);


        title("Downstream Collectors 1.set");
        Map<String, Set<Locale>> groupByUsingDownStreamSet = Stream.of(Locale.getAvailableLocales()).collect(
                groupingBy(Locale::getDisplayCountry, toSet())
        );

        title("Downstream Collectors 2.Collectors.counting");
        Map<String, Long> countingDownStreamCollectors = Stream.of(Locale.getAvailableLocales()).
                filter(locale -> !isStringEmpty(locale.getDisplayCountry())).
                collect(groupingBy(Locale::getDisplayCountry, counting()));
        System.out.println(countingDownStreamCollectors);

        title("Downstrem Collectors 3.mapping");
        Map<String, Set<String>> groupByCountry = Stream.of(Locale.getAvailableLocales()).
                filter(locale -> !isStringEmpty(locale.getDisplayCountry())).
                collect(groupingBy(Locale::getCountry, mapping(Locale::getDisplayLanguage, toSet())));
        System.out.println(groupByCountry);

        title("Collectors maxBy");
        Optional<Locale> localWithMaxCountryName = Stream.of(Locale.getAvailableLocales()).collect(maxBy(Comparator.comparing(locale -> locale.getDisplayCountry().length())));
        System.out.println(localWithMaxCountryName.get().getDisplayCountry());

        title("Primitive int stream to array");
        int[] ints = IntStream.of(0, 100).toArray();
        System.out.println(ints);

        title("Primitive int stream boxed to Object array");
        Object[] objectArray = IntStream.of(0, 100).boxed().toArray();
        System.out.println(objectArray);

        title("Primitive int stream boxed to Typed array");
        Integer[] integerTypedArray = IntStream.of(0, 100).boxed().toArray(Integer[]::new);
        System.out.println(integerTypedArray);

        title("Object Stream Max with Comparator ");
        Optional<Locale> max = Stream.of(Locale.getAvailableLocales()).max(Comparator.comparing(locale -> locale.getDisplayCountry().length()));
        System.out.println(max.get().getDisplayCountry());

    }

    private static boolean isStringEmpty(String displayCountry) {
        if(displayCountry == null || "".equals(displayCountry)){
            return true;
        }
        return false;
    }

    private static void title(String title) {
        System.out.println("========="+title+"================");
    }
}
