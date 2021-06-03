import java.math.BigInteger;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class NumberRounding {

    public static void main(String[] args) {
        Double doubleValue = 12.589;
        System.out.println(doubleValue.longValue());
        BigInteger bigInteger = BigInteger.probablePrime(10, new Random(10));
        System.out.println(bigInteger);
    }
}
