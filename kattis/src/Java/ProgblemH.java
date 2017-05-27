package Java;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

//Created by RakNoel, 22.09.2016.
public class ProgblemH {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while (true) {
            int N, M, counter = 0;
            final int MAX = 1000000;

            N = io.getInt();
            M = io.getInt();

            if (M + N == 0)
                break;

            int[] Jack = new int[MAX];
            int[] Jill = new int[MAX];

            for (int i = 0; i < N; i++)
                Jack[i] = io.getInt();

            for (int i = 0; i < M; i++)
                Jill[i] = io.getInt();

            int JackPointer = 0, JillPointer = 0;

            while (Jack[JackPointer] < N && Jill[JillPointer] < M){
                if (Jack[JackPointer] < Jill[JillPointer]) {
                    JackPointer++;
                } else if (Jack[JackPointer] > Jill[JillPointer]) {
                    JillPointer++;
                }else{
                    JackPointer++;
                    JillPointer++;
                    counter++;
                }
            }
            io.println(counter);
            io.flush();
        }
        io.close();
    }

    /** Simple yet moderately fast I/O routines.
     *
     * Example usage:
     *
     * Kattio io = new Kattio(System.in, System.out);
     *
     * while (io.hasMoreTokens()) {
     *    int n = io.getInt();
     *    double d = io.getDouble();
     *    double ans = d*n;
     *
     *    io.println("Answer: " + ans);
     * }
     *
     * io.close();
     *
     *
     * Some notes:
     *
     * - When done, you should always do io.close() or io.flush() on the
     *   Kattio-instance, otherwise, you may lose output.
     *
     * - The getInt(), getDouble(), and getLong() methods will throw an
     *   exception if there is no more data in the input, so it is generally
     *   a good idea to use hasMoreTokens() to check for end-of-file.
     *
     * @author: Kattis
     */


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
