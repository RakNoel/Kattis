package Java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to read inn 3 integers, then ABC and then print
 * out the integers sorted by the ABC strings char values.
 * <p>
 * Eks:
 * 1 2 3
 * CBA
 * <p>
 * would give:
 * 3 2 1
 *
 * @author RakNoel
 * @version 3.0
 * @since 03.04.2017
 */
public class ABC {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] tall = Arrays.stream(scn.nextLine()
                .split(" "))                                        //Split to char array
                .mapToInt(Integer::parseInt)                        //Convert all chars to integers
                .sorted()                                           //Sort the integers
                .toArray();                                         //Export as int[]

        scn.nextLine()
                .chars()                                            //Convert to char/int stream
                .map(x -> x - (int) 'A')                            //Map all integers to be [A,B,C] -> [0,1,2];
                .forEach(x -> System.out.print(tall[x] + " "));     //Print from sorted numbers; for ( x : {0,1,2} )
    }
}

//    public static void main(String[] args){
//        Scanner scn = new Scanner(System.in);
//        int[] tall = Arrays.stream(scn.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
//        scn.nextLine().chars().map(x -> x - (int) 'A').forEach(x -> System.out.print(tall[x] + " "));
//    }


