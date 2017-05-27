package Java;

import java.util.Scanner;

//Created by RakNoel, 04.04.2017.
public class textureanalysis {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int i = 0;

        while (true) {
            String line = scn.nextLine();
            if (line.equals("END"))
                break;

            System.out.println(chkStr(line) ? ++i + " EVEN" : ++i + " NOT EVEN");
        }
    }

    private static boolean chkStr(String s) {
        int space = 0, tryspace = 0;
        if (s.length() == 1)
            return true;

        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == '.') space++;
            else break;

        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == '*')
                if (tryspace != space) return false;
                else tryspace = 0;
            else tryspace++;

        return true;
    }
}

