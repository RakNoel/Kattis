package Java;

import java.util.Scanner;
//Created by RakNoel, 15.11.2016.
public class SolvingforCarrots {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        while (scn.hasNextLine()){
            int linjer = scn.nextInt();
            int gulroetter = scn.nextInt();

            for (int i = 0; i <= linjer; i++)
                scn.nextLine();

            System.out.println(gulroetter);
        }
    }
}
