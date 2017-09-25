package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Program to read inn a string of "encrypted" text and convert it back to its original form
 * using The Ohaver’s encryption scheme.
 *
 * @author RakNoel
 * @version 2.0 / 06.04.2017
 * @since 11.11.2016
 */
public class falseSecurity {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scn = new Scanner(System.in);
        HashMap<String, String> convert = new HashMap<>();
        String[] MorseAlphabeth = {"*-", "-***", "-*-*", "-**", "*", "**-*", "--*", "****", "**", "*---",
                "-*-", "*-**", "--", "-*", "---", "*--*", "--*-", "*-*", "***", "-", "**-", "***-", "*--",
                "-**-", "-*--", "--**",
        };

        //Add the first few
        convert.put("_", "**--");
        convert.put(",", "*-*-");
        convert.put(".", "---*");
        convert.put("?", "----");
        convert.put("**--", "_");
        convert.put("*-*-", ",");
        convert.put("---*", ".");
        convert.put("----", "?");

        //Create HasMap
        for (int i = 0; i < MorseAlphabeth.length; i++) {
            convert.put("" + (char) (i + 'A'), MorseAlphabeth[i]);
            convert.put(MorseAlphabeth[i], "" + (char) (i + 'A'));
        }

        /*
        Main convertion part, Reads in an then executes
        and finally prints anwser
         */
        while (scn.hasNext()) {
            ArrayList<Integer> encLine = new ArrayList<>();
            StringBuilder encrypted = new StringBuilder();
            StringBuilder decoded = new StringBuilder();

            //Magic -> lambda / streams
            scn.nextLine().chars().forEach(x -> {
                String s = convert.get("" + (char) x);
                encLine.add(s.length());
                encrypted.append(s);
            });

            for (int i = encLine.size() - 1, seqCounter = 0; i >= 0; i--)
                decoded.append(convert.get(encrypted.substring(seqCounter, seqCounter += encLine.get(i))));

            System.out.println(decoded.toString());
        }
    }
}
