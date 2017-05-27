package Java.statistics;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Created by RakNoel, 02.04.2017.
public class Statistics {
    public static void main(String[] args) {
        kattio kattio = new kattio(System.in, System.out);
        int counter = 0;
        while (kattio.hasMoreTokens()){
            int n = kattio.getInt();
            int[] num = new int[n];

            for(int i = 0; i < n; i++)
                num[i] = kattio.getInt();

            int max = Arrays.stream(num).max().getAsInt();
            int min = Arrays.stream(num).min().getAsInt();

            System.out.println("Case " + ++counter + ": " + min + " " + max + " " + (max-min));
        }
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