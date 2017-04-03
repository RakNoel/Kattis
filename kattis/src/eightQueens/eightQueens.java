package eightQueens;

import java.util.ArrayList;
import java.util.Scanner;

//Created by RakNoel, 02.04.2017.
public class eightQueens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        queenGrid grid = new queenGrid(8, 8, '*');


        for (int i = 7; i >= 0; i--) {
            char[] line = scn.nextLine().toCharArray();
            for (int x = 0; x < 8; x++)
                if (line[x] == '*') {
                    grid.setPos(x, i, 'q');
//                    System.out.println("Pos: [" + x + ", " + i + "]");
                    break;
                }
        }


        if (grid.checkGrid())
            System.out.println("valid");
        else
            System.out.println("invalid");

    }
}

class queenGrid {
    private char[] grid;
    private int width;
    private int height;
    private ArrayList<Position> queensPos;

    /**
     * Consturctor for the queenGrid object
     *
     * @param height is the height of the grid
     * @param width  is the width of the grid
     * @param fill   is the fill which every tile should be set to by default
     */
    queenGrid(int height, int width, char fill) {
        this.grid = new char[height * width];
        this.width = width;
        this.height = height;
        this.queensPos = new ArrayList<>();

        for (int i = 0; i < grid.length; i++)
            grid[i] = fill;
    }

    /**
     * Method to set the character in the position given to the character given
     *
     * @param x  coordinate
     * @param y  coordinate
     * @param ch the character to set the position to
     */
    void setPos(int x, int y, char ch) {
        this.grid[(y * width + x)] = ch;
        if (ch == 'q')
            this.queensPos.add(new Position(x, y));
    }

    /**
     * A method to get and return the character in the position given
     *
     * @param x coordinate
     * @param y coordinate
     * @return the caracter in selected pos
     */
    private char getPos(int x, int y) {
        return this.grid[y * width + x];
    }

    /**
     * Method to return if a column contains more than one queen
     *
     * @param x the colum-width
     * @return returns true if passes, false if the column has too many queens
     */
    private boolean checkColumn(int x) {
        int queens = 0;
        for (int i = 0; i < height; i++)
            if (this.getPos(x, i) == 'q')
                queens++;

        return (queens == 1);
    }

    /**
     * Method to return if a Row contains more than one queen
     *
     * @param y the row-height
     * @return returns true if passes, false if the row has too many queens
     */
    private boolean checkRow(int y) {
        int queens = 0;
        for (int i = 0; i < height; i++)
            if (this.getPos(i, y) == 'q')
                queens++;

        return (queens == 1);
    }

    /**
     * Method to check a Queens diagonals to see if there are possible attacks
     *
     * @param x x coordinate of queen
     * @param y y coordinate of queen
     * @return returns logical value true if check pass, false if possible to attack
     */
    private boolean checkDiag(int x, int y) {
        int queens = 0;
//        System.out.println("Testing queen at: [" + x + ", " + y + "]");
        for (int chk1 = (x - y), thX = (x - y); chk1 < width * height && thX < width; chk1 += width + 1, thX++)
            if (chk1 >= 0 && thX >= 0 && this.grid[chk1] == 'q') {
//                System.out.println("Queen at: " + chk1);
                if (++queens > 1)
                    return false;
            }

        queens = 0;
        for (int chk2 = x + y, thX = x + y; chk2 < width * height && thX >= 0; chk2 += width - 1, thX--)
            if (thX < width && this.grid[chk2] == 'q') {
//                System.out.println("Queen at: " + chk2);
                if (++queens > 1)
                    return false;
            }
        return true;
    }

    /***
     * Checks the entire grid to see if it is valid.
     * @return logical value if valid grid or not
     */

    boolean checkGrid() {
        for (int x = 0; x < width; x++)
            if (!checkColumn(x))
                return false;

        for (int y = 0; y < height; y++)
            if (!checkRow(y))
                return false;

        for (Position p : queensPos)
            if (!checkDiag(p.getX(), p.getY()))
                return false;

        return true;
    }
}

class Position {
    private int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}

