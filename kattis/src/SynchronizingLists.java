import java.util.Arrays;
import java.util.Scanner;

//Created by RakNoel, 28.03.2017.
public class SynchronizingLists {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n;

        do{
            n = scn.nextInt();
            Integer[] first = new Integer[n];
            Integer[] second = new Integer[n];

            for (int i = 0; i < n; i++)
                first[i] = scn.nextInt();

            for (int i = 0; i < n; i++)
                second[i] = scn.nextInt();

            Integer[] sSorted = second.clone();
            Integer[] fSorted = first.clone();
            Arrays.sort(sSorted);
            Arrays.sort(fSorted);

            int[] pointer = new int[n];

            for (int i = 0; i < n; i++)
                pointer[i] = Arrays.asList(fSorted).indexOf(first[i]);

            for (int i : pointer)
                System.out.println(sSorted[i]);

            System.out.println("");
        }while(n != 0);
    }
}
