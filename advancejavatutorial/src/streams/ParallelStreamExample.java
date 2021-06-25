package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * Speed up speed operation with parallel streams.
 */
public class ParallelStreamExample {

    /**
     * 1. Parallel Stream compute Stream Result Concurrently.
     * 2. Faster with Large In Memory Streams as smaller stream will add Thread Creation time.
     * 3. We can turn any Collection or Steam into parallel Stream.
     * 4. Beware of race condition.
     *
     * Parallel Stream cut the Stream into Segment each segment is processed in a separate Core.
     * Some operation like counting require the results to combined; which is done correctly behind the scene.
     *
     *
     * Parallel Stream is faster with In-Memory Streams. If elements needs to be fetched on real time than
     * Fetching the element can interfere with the performance of the parallel stream.
     *
     * For Ordered Stream such as List,Array,iterator,range etc
     * Order is maintained in Stream Result and Stream Result is determinstic.
     * Ordering does not preclude concurrent processing.
     *
     * @param args
     */
    public static void main(String[] args) {
        title("Parallel Stream Examples");
        List<String> strings = Arrays.asList(new String("Shubhi"),
                new String("Sucheta"),new String("Shubhi"),
                new String("Sucheta"), new String("Bhupendra"),
                new String("Sucheta"), new String("Bhupendra"),
                new String("Sucheta"), new String("Bhupendra"),
                new String("Shubhi"), new String("Bhupendra"),
                new String("Sucheta"));

        title("Group By Counting without parallel stream");
        long startTime = System.currentTimeMillis();
        Map<String, Long> stringByCount = strings.stream().collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
        System.out.println(stringByCount + " calculated in : " + (System.currentTimeMillis()-startTime) +" ms");


        title("Group By Counting with parallel stream");
        startTime = System.currentTimeMillis();
        Map<String, Long> stringByCountpl = strings.parallelStream().collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
        System.out.println(stringByCountpl +" calculated in : " + (System.currentTimeMillis()-startTime) +" ms");


        title("Stream.map with Normal Stream");
        startTime = System.currentTimeMillis();
        List<String> mapToSameObjectN = strings.stream().map(Function.identity()).collect(toList());
        System.out.println(mapToSameObjectN.equals(strings)+" calculated in : " + (System.currentTimeMillis()-startTime) +" ms");

        title("Stream.map with Normal Stream");
        startTime = System.currentTimeMillis();
        List<String> mapToSameObjectP = strings.stream().map(Function.identity()).collect(toList());
        System.out.println(mapToSameObjectP.equals(strings)+" calculated in : " + (System.currentTimeMillis()-startTime) +" ms");

        /**
         *  Distinct is used to give the First Occurrence of Multiple values.
         *  In case of parallel stream distinct is faster if we drop the order.
         */
        for (int i = 0; i < 2; i++) {
            title("Distinct with Order normal stream ");
            startTime = System.currentTimeMillis();
            strings.stream().distinct().forEach(s -> System.out.println(System.identityHashCode(s) + " : " + s.hashCode()));
            System.out.println(" calculated in : " + (System.currentTimeMillis()-startTime) +" ms");

            title("Distinct with dropping Order in normal stream ");
            startTime = System.currentTimeMillis();
            strings.stream().unordered().distinct().forEach(s -> System.out.println(System.identityHashCode(s)+" : " + s.hashCode()));
            System.out.println(" calculated in : " + (System.currentTimeMillis()-startTime) +" ms");
        }

        for (int i = 0; i < 2; i++) {
            title("Distinct with Order parallel stream ");
            startTime = System.currentTimeMillis();
            strings.parallelStream().distinct().forEach(s -> System.out.println(System.identityHashCode(s) + " : " + s.hashCode()));
            System.out.println(" calculated in : " + (System.currentTimeMillis()-startTime) +" ms");

            title("Distinct with dropping Order in parallel stream ");
            startTime = System.currentTimeMillis();
            strings.parallelStream().unordered().distinct().forEach(s -> System.out.println(System.identityHashCode(s)+" : " + s.hashCode()));
            System.out.println(" calculated in : " + (System.currentTimeMillis()-startTime) +" ms");
        }
        /**
         * Merge in Group By in Parallel Stream is an Expensive Operation.
         * Instead we should use groupByConcurrent only draw back is it do not maintain the order.
         */
        title("Merge in Group By in Parallel Stream");

    }

    private static void title(String stringValue) {
        System.out.println("\n"+stringValue);
    }
}
