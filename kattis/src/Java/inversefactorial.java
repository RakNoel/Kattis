package Java;

import java.math.BigInteger;
import java.util.Scanner;

//Created by RakNoel, 11.04.2017.
public class inversefactorial {
    static BigInteger x = BigInteger.ONE;
    static BigInteger y = BigInteger.ZERO;

    public static void main(String[] args) {
        System.out.println(inverseFactorial(new BigInteger(new Scanner(System.in).nextLine())));
    }

    static BigInteger inverseFactorial(BigInteger n){
        return inverseFactorial(n, BigInteger.valueOf(2));
    }

    static BigInteger inverseFactorial(BigInteger n, BigInteger i){
        BigInteger newN = n.divide(i);

        if (newN.equals(x))
            return n;
        else if (!newN.equals(y))
            return inverseFactorial(newN, i.add(x));
        else return new BigInteger("0");
    }
}

//Denne må løses binært
