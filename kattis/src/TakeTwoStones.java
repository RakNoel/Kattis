import java.util.Scanner;

//Created by RakNoel, 28.03.2017.
public class TakeTwoStones {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println((scn.nextInt()%2 == 0) ? "Bob" : "Alice");
    }
}
