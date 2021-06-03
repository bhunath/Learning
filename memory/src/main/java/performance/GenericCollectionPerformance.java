package performance;


import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.LongStream;

public class GenericCollectionPerformance {

    static int timeOut = 2*1000;

    private static void CheckPerformance(Collection collection, long elements){
        long start = System.currentTimeMillis();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        Timer timer = new Timer(timeOut, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atomicBoolean.set(false);
            }
        });
        timer.setRepeats(false);
        timer.start();
        LongStream.range(0,elements).takeWhile(value -> atomicBoolean.get()).forEach(value -> {
            collection.add(value);
        });
        System.out.println(collection.getClass().getCanonicalName() + " Operation Add completed in " + (System.currentTimeMillis()-start) +
                " Total Element Count : " + collection.size());
        collection.clear();

    }

    public static void main(String[] args) {
        List<? extends Class<? extends Collection>> classes = Arrays.asList(ArrayList.class,
                HashSet.class, LinkedList.class, TreeSet.class, CopyOnWriteArrayList.class, CopyOnWriteArraySet.class);
        long numberOfElement = 1000000000;

        classes.stream().forEach(aClass -> {
            new Thread(() -> {
                try {
                    CheckPerformance(aClass.newInstance(),numberOfElement);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }).start();
        });


    }

}
