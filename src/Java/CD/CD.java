package Java.CD;

import Java.kattio;

//Created by RakNoel, 02.04.2017.

public class CD {
    public static void main(String[] args) {
        kattio kattio = new kattio(System.in, System.out);

        while (true) {
            int jack = kattio.getInt();
            int jill = kattio.getInt();
            if (jack == 0 && jill == 0)
                break;

            int[] jackList = new int[jack];
            for (int i = 0; i < jack; i++)
                jackList[i] = kattio.getInt();

            int[] jillList = new int[jill];
            for (int i = 0; i < jill; i++)
                jillList[i] = kattio.getInt();

            int equalCD = 0;
            int lastKnown = 0;

            for (int i = 0; i < jack; i++)
                for (int j = lastKnown; j < jill; j++) {
                    if (jackList[i] == jillList[j]) {
                        equalCD++;
                        lastKnown = j + 1;
                        break;
                    } else if (jackList[i] < jillList[j]) {
                        lastKnown = j;
                        break;
                    }

                }

            System.out.println(equalCD);
        }
    }
}