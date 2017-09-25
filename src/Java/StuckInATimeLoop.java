package Java;

import java.util.Scanner;

//Created by RakNoel, 15.11.2016.
public class StuckInATimeLoop {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while (scn.hasNextInt()) {
            int loop =scn.nextInt();
            for (int i = 0; i < loop; i++)
                System.out.println((i + 1) + " Abracadabra");
        }
    }
}
