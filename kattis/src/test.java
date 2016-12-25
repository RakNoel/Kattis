import java.util.ArrayList;
import java.util.Scanner;

//Created by RakNoel, 14.11.2016.
public class test {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        while (true){
            System.out.println("Skriv inn Streng med ASCII");
            char[] test =  scn.nextLine().toCharArray();

            if (test.length == 0)
                System.exit(0);

            for(char i : test)
                System.out.println(i + ": " + (int)i);
        }
    }
}
