// Accepted

import java.util.Scanner;
import java.math.BigInteger;

public class fuel {
	public static void main(String[] args) {
		//System.out.println(Math.pow(2,));
		Scanner in = new Scanner(System.in);
		while(true) {

			System.out.println(answer(in.nextLine()));
		}
		
	}

	public static int answer(String n) { 

        // Your code goes here.
        BigInteger num = new BigInteger(n);
        String s = num.toString(2);
        return getMin(s);
    }


    // Pass as binary string to keep recursion as lightweight as possible
    public static int getMin(String s) {
        int res = 0;

        // If you reach 1 -> finished
        if(s.equals("1")) return 0;

        // Special case of 3
        if(s.equals("11")) return 2;

        BigInteger bi = new BigInteger(s,2);

        // Divide all evens by 2
        if(s.endsWith("0")) return 1+getMin(bi.divide(BigInteger.valueOf(2)).toString(2));

        // Always optimal to return the mininum operations of (number+1) unless (number-1)=multiple of 4
        if(bi.mod(BigInteger.valueOf(4)).equals(BigInteger.ONE)) return 1+getMin(bi.subtract(BigInteger.ONE).toString(2));
        else return 1+getMin(bi.add(BigInteger.ONE).toString(2));
    }
}