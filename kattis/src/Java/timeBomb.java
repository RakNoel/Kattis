package Java;

import java.util.ArrayList;
import java.util.Scanner;

//Created by RakNoel, 01.04.2017.
public class timeBomb {
    public static void main(String[] args) {

        /**

         ***   * *** *** * * *** *** *** *** ***
         * *   *   *   * * * *   *     * * * * *
         * *   * *** *** *** *** ***   * *** ***
         * *   * *     *   *   * * *   * * *   *
         ***   * *** ***   * *** ***   * *** ***

         */
        Scanner scn = new Scanner(System.in);
        String[] possibilities = {
                "**** ** ** ****", //0
                "  *  *  *  *  *", //1
                "***  *****  ***", //2
                "***  ****  ****", //3
                "* ** ****  *  *", //4
                "****  ***  ****", //5
                "****  **** ****", //6
                "***  *  *  *  *", //7
                "**** ***** ****", //8
                "**** ****  ****", //9
        };

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();

        //Read all 5 lines
        for (int i = 0; i < 5; i++)
            lines.add(scn.nextLine());

        int i = 0;

        //I = number selector
        while (i < lines.get(0).length()) {
            String number = "";

            //Bygger streng
            for (String s : lines)
                number += s.substring(i, (i + 3));

            i += 4;

            //Finner tall
            for (int x = 0; x < possibilities.length; x++)
                if (number.equals(possibilities[x])) {
                    numbers.add(x);
                    break;
                }else if(x == possibilities.length-1) {
                    System.out.println("BOOM!!");
                    System.exit(0);
                }
        }

        int finalout = 0;
        for (int x = numbers.size()-1, pot = 0; x >= 0; x--, pot++)
            finalout += (numbers.get(x) * Math.pow(10,pot));

        if (finalout%6 == 0)
            System.out.println("BEER!!");
        else
            System.out.println("BOOM!!");
    }
}
