import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);

        int X = inn.nextInt();
        int Y = inn.nextInt();
        int N = inn.nextInt();

        for (int i = 1; i <= N; i++){
            if (i % X == 0 && i % Y == 0){
                System.out.println("FizzBuzz");
            } else if (i % X == 0){
                System.out.println("Fizz");
            }else if (i % Y == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}