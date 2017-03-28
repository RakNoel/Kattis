import java.util.Scanner;

//Created by RakNoel, 28.03.2017.
public class Soylent {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n; i++)
            System.out.println((int)Math.ceil(scn.nextDouble()/400));
    }
}
