import java.util.Scanner;

//Created by RakNoel, 11.11.2016.
public class problemA {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while (true) {
            int N = scn.nextInt();
            int sumN = 0;
            if (N > 9) {
                sumN = summerTall(N);
            } else if (N == 0) {
                System.exit(0);
            } else {
                sumN = N;
            }

            int m = 10;
            do {
                m++;
                int resultat = summerTall(m * N);
                if (resultat == sumN) {
                    System.out.println(m);
                    break;
                }

            } while (m < 100000);
        }
    }

    public static int summerTall(int tall) {
        char[] n = ("" + tall).toCharArray();
        String[] N = new String[n.length];
        for (int i = 0; i < n.length; i++)
            N[i] = "" + n[i];

        int m = 0;
        for (String s : N) {
            m += Integer.parseInt(s);
        }

        return m;
    }
}
