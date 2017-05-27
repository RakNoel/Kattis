package Java;

import java.io.*;
import java.util.StringTokenizer;

//Created by RakNoel, 15.11.2016.
public class pot {
    public static void main(String[] args){
        Kattio katt = new Kattio(System.in, System.out);

        while(katt.hasMoreTokens()){
            int tall = katt.getInt();

            int sum = 0;
            for(int i = 0; i < tall; i++){
                String holder = "" + katt.getInt();
                int pow = Integer.parseInt(holder.substring(holder.length()-1));
                int P = Integer.parseInt(holder.substring(0, holder.length()-1));

                sum += Math.pow(P, pow);
            }
            System.out.println(sum);
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
