import java.util.Arrays;
import java.util.Scanner;

//Created by RakNoel, 02.04.2017.
public class ABC {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] tall = Arrays.stream(scn.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).sorted().toArray();
        scn.nextLine().chars().map(x -> x - (int) 'A').forEach(x -> System.out.print(tall[x] + " "));
    }
}
