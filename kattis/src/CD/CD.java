package CD;

import java.io.*;
import java.util.StringTokenizer;

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

            for(int i = 0; i < jack; i++)
                for (int j = lastKnown; j < jill; j++){
                    if(jackList[i] == jillList[j]) {
                        equalCD++;
                        lastKnown = j+1;
                        break;
                    }
                    else if (jackList[i] < jillList[j]) {
                        lastKnown = j;
                        break;
                    }

                }

            System.out.println(equalCD);
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