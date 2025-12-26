/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
    public static String toBinary(int x) {
        if (x == 0) return "0";
        long n = x;
        if (n < 0) return "-" + toBinaryRec(-n);
        return toBinaryRec(n);
    }

    private static String toBinaryRec(long n) {
        if (n == 0) return "";
        return toBinaryRec(n / 2) + (n % 2);
    }    
 }
