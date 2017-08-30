package Java.eightQueens;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static Java.eightQueens.eightQueensBitwise.checkBitwiseGrid;
import static junit.framework.TestCase.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class eqTest {

    private static String[] fails = new String[4];
    private static String[] valid = new String[4];

    @BeforeClass
    public static void before() {

        fails[0] = ("*......." +
                "..*....." +
                "....*..." +
                "......*." +
                ".*......" +
                ".......*" +
                ".....*.." +
                "...*....");

        //Missing queen
        fails[1] = ("*......." +
                "....*..." +
                ".......*" +
                ".....*.." +
                "..*....." +
                "......*." +
                ".*......" +
                "........");

        //Vertical collision
        fails[2] = ("*......." +
                "....*..." +
                ".......*" +
                ".....*.." +
                "..*....." +
                "......*." +
                ".*......" +
                ".*......");

        //Horizontal collision
        fails[3] = ("*......." +
                "....*..." +
                ".......*" +
                ".....*.." +
                "..*....." +
                "......*." +
                ".*.*...." +
                "........");

        //Standard
        valid[0] = ("*......." +
                "......*." +
                "....*..." +
                ".......*" +
                ".*......" +
                "...*...." +
                ".....*.." +
                "..*.....");

        //Bitwise right filter test
        valid[1] = (".......*" +
                ".*......" +
                "...*...." +
                "*......." +
                "......*." +
                "....*..." +
                "..*....." +
                ".....*..");

        //Bitwise left filter test
        valid[2] = ("*......." +
                "....*..." +
                ".......*" +
                ".....*.." +
                "..*....." +
                "......*." +
                ".*......" +
                "...*....");

        //Bitwise left filter test
        valid[3] = ("*......." +
                "....*..." +
                ".......*" +
                ".....*.." +
                "..*....." +
                "......*." +
                ".*......" +
                "...*....");
    }

    @Test
    public void BitTest() {
        for (String grid : fails) {
            long test = readBitGrid(grid);
            if (test != 0x00)
                assertFalse(checkBitwiseGrid(test));
        }

        for (String grid : valid) {
            long test = readBitGrid(grid);
            if (test != 0x00)
                assertTrue(checkBitwiseGrid(test));
            else
                fail("Invalid != Valid! " + grid);
        }
    }

    @Test
    public void OOTest() {
        for (String grid : fails) {
            queenGrid test = readGrid(grid);
            assertFalse(test.checkGrid());
        }

        for (String grid : valid) {
            queenGrid test = readGrid(grid);
            assertTrue(test.checkGrid());
        }
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

//      Reads inn all values and adds them to a long for bitwise array
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