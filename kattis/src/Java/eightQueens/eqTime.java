package Java.eightQueens;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class eqTime {

    private static String[] randomGrids = new String[8000000];
    private static ArrayList<String> genGrids = new ArrayList<>();

    @BeforeClass
    public static void before() {
        generateRandomGrids();

        for (int[] x : genPermutations()) {
            StringBuilder build = new StringBuilder();
            for (int y : x) {
                char[] base = {'.', '.', '.', '.', '.', '.', '.', '.'};
                base[y] = '*';
                build.append(base);
            }
            genGrids.add(build.toString());
        }
    }

    @Test
    public void OORndTime() {
        long startTime = System.nanoTime();

        for (String g : randomGrids) {
            OOGridCheck(g);
        }

        long endTime = System.nanoTime();
        System.out.printf("OoRndTime: %d %n", (endTime - startTime));
    }

    @Test
    public void BitRndTime() {
        long startTime = System.nanoTime();

        for (String g : randomGrids) {
            BitGridCheck(g);
        }

        long endTime = System.nanoTime();
        System.out.printf("BitRndTime: %d %n", (endTime - startTime));
    }

    @Test
    public void OOWorstTime() {
        long startTime = System.nanoTime();

        for (String g : genGrids) {
            OOGridCheck(g);
        }

        long endTime = System.nanoTime();
        System.out.printf("OoWorstTime: %d %n", (endTime - startTime));
    }

    @Test
    public void BitWorstTime() {
        long startTime = System.nanoTime();

        for (String g : genGrids) {
            BitGridCheck(g);
        }

        long endTime = System.nanoTime();
        System.out.printf("BitWorstTime: %d %n", (endTime - startTime));
    }



    private boolean OOGridCheck(String g) {
        //TODO: Method body
        return false;
    }

    private boolean BitGridCheck(String g) {
        //TODO: Method body
        return false;
    }

    /**
     * Method to generate a lot of random grids
     * valid or not
     */
    private static void generateRandomGrids() {
        //Generate 8'000'000 test strings
        Random rnd = new Random();
        for (int j = 0; j < randomGrids.length; j++) {
            StringBuilder genGrid = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                char[] genStr = {'.', '.', '.', '.', '.', '.', '.', '.'};
                genStr[rnd.nextInt(8)] = '*';
                genGrid.append(genStr);
            }
            randomGrids[j] = genGrid.toString();
        }
    }

    /**
     * A method to find all permutations 8! so that
     * we can test all worst cases
     *
     * @author Ingrid Johansen
     */
    private static int[][] genPermutations() {

        int ant = 40320;
        int[][] gen = new int[ant][8];
        int[] list = new int[8];
        int counter = 0;

        for (int i = 0; i < 8; i++) {
            list[0] = i;

            for (int j = 0; j < 8; j++) {
                if (j != i) {
                    list[1] = j;

                    for (int k = 0; k < 8; k++) {
                        if (k != i && k != j) {
                            list[2] = k;

                            for (int l = 0; l < 8; l++) {
                                if (l != i && l != j && l != k) {
                                    list[3] = l;

                                    for (int m = 0; m < 8; m++) {
                                        if (m != i && m != j && m != k && m != l) {
                                            list[4] = m;

                                            for (int n = 0; n < 8; n++) {
                                                if (n != i && n != j && n != k && n != l && n != m) {
                                                    list[5] = n;

                                                    for (int o = 0; o < 8; o++) {
                                                        if (o != i && o != j && o != k && o != l && o != m && o != n) {
                                                            list[6] = o;

                                                            for (int p = 0; p < 8; p++) {
                                                                if (p != i && p != j && p != k && p != l && p != m && p != n && p != o) {
                                                                    list[7] = p;
                                                                    gen[counter] = list;
                                                                    counter++;

                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(counter);
        return gen;
    }
}