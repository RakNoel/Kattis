package eightQueens;

import java.io.*;
import java.util.StringTokenizer;

//Created by RakNoel, 23.05.2017.
public class eightQueensBitwise {

    public static void main(String[] args) {
        kattio kattio = new kattio(System.in, System.out);
        long grid = 0x00;
        byte columnCheck = 0x00;

//      Reads inn all values and adds them to a long only to use bit values
        for (byte row = 7; row >= 0; row--) {
            boolean linecheck = false;
            char[] line = kattio.getWord().toCharArray();
            for (byte x = 7, y = 0; x >= 0; x--, y++) {
                if (line[y] == '*' && !linecheck) {
                    grid |= (1L << (row * 8) + x);

                    //Row and column check while we're at it
                    linecheck = true;
                    columnCheck |= (byte) Math.pow(10, x);
                } else if (line[y] == '*' && linecheck) {
                    System.out.println("invalid");
                    return;
                }
            }
        }

        //Check if any of columns are used twice
        if (columnCheck != -1) {
            System.out.println("invalid");
            return;
        }


//        //TESTING!!!!!
//        long grid = Long.parseLong("-9222800285438573536");

        long clone1 = grid; // /
        long clone2 = grid; // \
        long mask1 = ~Long.valueOf("72340172838076673"); //Clean column 0
        long mask2 = mask1 << 7; //Clean column 7

        //Check diagonals
        for (int x = 0; x < 7; x++) {
            clone1 = (mask2 & clone1) >>> 7;
            clone2 = (mask1 & clone2) >>> 9;

            if ( (clone1 & grid) != 0L || (clone2 & grid) != 0L) {
                System.out.println("invalid");
                return;
            }
        }

        System.out.println("valid");

    }
}

class kattio extends PrintWriter {
    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    public kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}