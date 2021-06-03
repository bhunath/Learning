package analysis;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;

public class MemoryAnalysis {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println(VM.current().details());

        System.out.println("======================================");
        System.out.println(ClassLayout.parseClass(SimpleInt.class).toPrintable());

        System.out.println("======================================");
        System.out.println(ClassLayout.parseClass(SimpleString.class).toPrintable());

        System.out.println("======================================");
        SimpleString instance = new SimpleString();
        instance.name="Bhupndra Nath";
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());

        System.out.println("======================================");
        System.out.println(ClassLayout.parseInstance(instance.name).toPrintable());

        System.out.println("======================================");
        System.out.println(ClassLayout.parseInstance(instance.name.getBytes()).toPrintable());

        System.out.println("======================================");
        System.out.println("HashCode is =>" +instance.hashCode());
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());

        System.out.println("======================================");
        System.out.println(ClassLayout.parseClass(ArrayList.class).toPrintable());

        ArrayList list = new ArrayList();
        list.add(instance);

        System.out.println("======================================");
        System.out.println(ClassLayout.parseInstance(list).toPrintable());

        System.out.println("======================================");
        System.out.println(GraphLayout.parseInstance(list).toFootprint());
    }

}
