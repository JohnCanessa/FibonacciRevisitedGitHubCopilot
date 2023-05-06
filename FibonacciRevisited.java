import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;


/**
 * 
 */
public class FibonacciRevisited {


    /**
     * Generate fibonacci number.
     * Recursive call.
     * Simple code but very ineficient.
     * Try it with n = 50
     * 
     * Time: O(2^n) - Space: O(n)
     */
    static int fib0(int n) {

        // **** base case ****
        if (n <= 2)
            return 1;

        // **** recursion ****
        return fib0(n - 2) + fib0(n - 1);
    }


    /**
     * Generate fibonacci number.
     * Entry call.
     */
    static int fib(int n) {

        // **** sanity check(s) ****
        if (n <= 2)
            return 1;

        // **** initialization ****
        int[] callCounter   = new int[] {0};
        int[] memo          = new int[n];
        memo[0] = memo[1]   = 1;

        // **** start recursion ****
        fib(n, memo, callCounter);

        // ???? ????
        // System.out.println("fib <<< callCounter: " + callCounter[0]);
        // System.out.println("fib <<< memo: " + Arrays.toString(memo));

        // **** return answer ****
        return memo[n - 1];
    }


    /**
     * Generate fibonacci number.
     * Recursive call with memoization.
     * 
    * Time: O(n) - Space: O(n)
     */
    static int fib(int n, int[] memo, int[] callCounter) {

        // ???? ????
        callCounter[0] += 1;

        // **** base case(s) ****
        if (n <= 1)
            return 1;

        // **** generate this value (if needed) ****
        if (memo[n - 1] == 0)
            memo[n - 1] = fib(n - 1, memo, callCounter);

        // **** generate this value (if needed) ****
        if (memo[n - 2] == 0)
            memo[n - 2] = fib(n - 2, memo, callCounter);

        // **** return result  ****
        return memo[n - 1] + memo[n - 2];
    }


    /**
     * Function to generate larger fibonacci numbers
     * @param args
     * @throws IOException
     */
    static void fib(int n, int[] res) {

        // **** initialize result ****
        res[0] = 0;
        res[1] = 1;

        // **** add previous 2 numbers in res[] with carry ****
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
    }


    /**
     * Function to generate large fibonacci numbers.
     * @param n
     */
    static void largeFib(int n) {

        // **** initialization ****
        BigDecimal a = new BigDecimal("0");
        BigDecimal b = new BigDecimal("1");
        BigDecimal c = new BigDecimal("0");

        // **** generate fibonacci number ****
        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;

            // **** display fibonacci number ****
            System.out.println("largeFib <<< i: " + i + " c: " + c);  
        }
    }


    /**
     * Test scaffold
     * 
     * On April 25, 2022 using GitHub Copilot to generate code
     * on Visual Studio Code.
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** prompt for fibonacci number ****
        System.out.print("main <<< n: ");

        // **** read n ****
        int n = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< n: " + n);


        // **** start to meassure elapsed time ****
        long startTime = System.currentTimeMillis();

        // **** generate and display Fibonacci number(s) ****
        for (int i = 1; i <= n; i++) {
            int fibonacci = fib0(i);
            if (fibonacci < 0) {
                System.out.println("main <<< i: " + i + " fib0: " + fibonacci + " ***** OVERFLOW *****");
                break;
            }
            else
                System.out.println("main <<< i: " + i + " fib0: " + fibonacci);
        }

        // **** stop to meassure elapsed time ****
        long stopTime = System.currentTimeMillis();

        // **** display elapsed time ****
        System.out.println("main <<< fib0 recursion elapsed time: " + (stopTime - startTime) + " ms.");

        // ???? ????
        System.out.println();


        // **** start to meassure elapsed time ****
        startTime = System.currentTimeMillis();

        // **** generate and display Fibonacci number(s) ****
        for (int i = 1; i <= n; i++) {
            int fibonacci = fib(i);
            if (fibonacci < 0) {
                System.out.println("main <<< i: " + i + " fib: " + fibonacci + " ***** OVERFLOW *****");
                break;
            }
            else
                System.out.println("main <<< i: " + i + " fib: " + fib(i));
        }

        // **** stop to meassure elapsed time ****
        stopTime = System.currentTimeMillis();

        // **** display elapsed time ****
        System.out.println("main <<< fib elapsed time: " + (stopTime - startTime) + " ms.");


        // ???? ????
        System.out.println();

        // **** start to meassure elapsed time ****
        startTime = System.currentTimeMillis();

        // **** generate and display Fibonacci numbers ****
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            fib(n, res);
            int fibonacci = res[i];
            if (fibonacci < 0) {
                System.out.println("main <<< i: " + i + " fib: " + fibonacci + " ***** OVERFLOW *****");
                break;
            }
            else
                System.out.println("main <<< i: " + i + " fib: " + fibonacci);
        }

        // **** stop to meassure elapsed time ****
        stopTime = System.currentTimeMillis();

        // **** display elapsed time ****
        System.out.println("main <<< fib elapsed time: " + (stopTime - startTime) + " ms.");


        // ???? ????
        System.out.println();

        // **** start to meassure elapsed time ****
        startTime = System.currentTimeMillis();

        // **** compute and display fibonacci numbers (no overflow) ****
        largeFib(n);

        // **** stop to meassure elapsed time ****
        stopTime = System.currentTimeMillis();

        // **** display elapsed time ****
        System.out.println("main <<< largeFib elapsed time: " + (stopTime - startTime) + " ms.");
    }
}