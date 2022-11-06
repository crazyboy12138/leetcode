
import java.util.*;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2020-01-09
 */
public class Test {
    public void test1() {
        new Test().primeNumber();
    }

    private int n = 10;


    private int[] prime = new int[n];

    // 求前n个素数
    private void primeNumber() {
        int count = 0;
        for (int i = 2; count < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime[count++] = i;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            System.out.println(prime[i]);
        }
    }
}
