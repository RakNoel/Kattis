import java.util.Arrays;
import java.util.Scanner;

//Created by RakNoel, 02.04.2017.
public class ABC {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] tall = new int[3];
        for (int i = 0; i < 3; i++)
            tall[i] = scn.nextInt();

        scn.nextLine();
        char[] bokst = scn.nextLine().toCharArray();

        Arrays.sort(tall);

        String[] print = new String[3];

        for (int i = 0; i < 3; i++)
            if (bokst[i] == 'A')
                print[i] = ""+tall[0];
            else if (bokst[i] == 'B')
                print[i] = ""+tall[1];
            else
                print[i] = ""+tall[2];

        System.out.println(print[0] + " " + print[1] + " " + print[2]);
    }
}
