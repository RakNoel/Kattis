package Java;

import java.util.ArrayList;
import java.util.Scanner;

//Created by RakNoel, 28.03.2017.
public class modulo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        ArrayList<Integer> inn = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            inn.add(scn.nextInt());

        System.out.println(inn.stream().map(i -> i%42).distinct().count());
    }
}