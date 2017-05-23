package eightQueens;

import java.util.Scanner;

//Created by RakNoel, 23.05.2017.
public class queensBit {

    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        long grid = 0x00;
//        byte columnCheck = 0x00;
//
////        Reads inn all values and adds them to a long only to use bit values
//        for (byte row = 7; row >= 0; row--) {
//            boolean linecheck = false;
//            char[] line = scn.nextLine().toCharArray();
//            for (byte x = 7, y = 0; x >= 0; x--, y++) {
//                if (line[y] == '*' && !linecheck) {
//                    grid |= (1L << (row * 8) + x);
//
//                    //Row and column check while we're at it
//                    linecheck = true;
//                    columnCheck |= (byte) Math.pow(10, x);
//                } else if (line[y] == '*' && linecheck) {
//                    System.out.println("invalid, due to linecheck"); //Change this!
//                    return;
//                }
//            }
//        }
//
//        //Check if any of columns are used twice
//        if (columnCheck != -1)
//            System.out.println("invalid, due to columnCheck"); //Change this!


        //TESTING!!!!!
        long grid = Long.parseLong("-9222800285438573536");



        //Check diagonals
        for (int x = 1; x < 8; x++) {



        }

        System.out.println(Long.toBinaryString(grid));
        System.out.println(grid);
    }
}
