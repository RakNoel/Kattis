package Java;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

//Created by RakNoel, 15.11.2016.
public class DiceCup {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);

        while(io.hasMoreTokens()) {
            int T1 = io.getInt();
            int T2 = io.getInt();

            int maxSum = T1 + T2;
            int[] muligheter = new int[maxSum];

            for (int i = 1; i < T1; i++)
                for (int j = 1; j < T2; j++)
                    muligheter[j+i]++;

            int maksInniRekke = 0;

            for (int i : muligheter)
                if (i > maksInniRekke)
                    maksInniRekke = i;

            for (int i = 0; i < muligheter.length; i++)
                if(muligheter[i] == maksInniRekke)
                    System.out.println((i+1));

        }

    }

    static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
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



        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) { }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}
