package Java.eightQueens;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static Java.eightQueens.eightQueensBitwise.checkBitwiseGrid;
import static junit.framework.TestCase.fail;

public class eqTest {

    private static String[] grids = new String[8000000];

    @BeforeClass
    public static void before() {
        //Generate 1000 test strings
        Random rnd = new Random();
        for (int j = 0; j < grids.length; j++) {
            StringBuilder genGrid = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                char[] genStr = {'.', '.', '.', '.', '.', '.', '.', '.'};
                genStr[rnd.nextInt(8)] = '*';
                genGrid.append(genStr);
            }
            grids[j] = genGrid.toString();

            if (j%100 == 0) System.out.println(j);
        }
    }

    @Test
    public void testStandardTime() {
        for (String g : grids)
            readGrid(g).checkGrid();
    }

    @Test
    public void testBitwiseTime() {
        for (String g : grids) {
            long grid = readBitGrid(g);
            if (grid != 0x00)
                checkBitwiseGrid(grid);
            else
                break;
        }
    }

    @Test
    public void Bitwise() {
        //TODO: Insert actual test
        fail("Test not created");
    }

    @Test
    public void Standard() {
        //TODO: Insert actual test
        fail("Test not created");
    }

    private queenGrid readGrid(String g) {
        queenGrid grid = new queenGrid(8, 8, '*');
        for (int i = 7; i >= 0; i--) {
            char[] line = g.substring(i * 8, ((i * 8) + 8)).toCharArray();

            for (int x = 0; x < 8; x++)
                if (line[x] == '*') {
                    grid.setPos(x, i, 'q');
//                        System.out.println(line);
//                        System.out.println("Pos: [" + x + ", " + i + "]");
                    break;
                }
        }
        return grid;
    }
    private long readBitGrid(String g) {
        long grid = 0x00;
        byte columnCheck = 0x00;

//          Reads inn all values and adds them to a long for bitwise array
        for (byte row = 7; row >= 0; row--) {
            boolean linecheck = false;
            char[] line = g.substring(row * 8, ((row * 8) + 8)).toCharArray();
            for (byte x = 7, y = 0; x >= 0; x--, y++) {
                if (line[y] == '*' && !linecheck) {
                    grid |= (1L << (row * 8) + x);

                    //Row and column check while we're at it
                    linecheck = true;
                    columnCheck |= (byte) Math.pow(10, x);
                } else if (line[y] == '*' && linecheck) {
                    return 0x00;
                }
            }
        }

        //Check if any of columns are used twice
        if (columnCheck != -1)
            return 0x00;

        return grid;
    }
}
