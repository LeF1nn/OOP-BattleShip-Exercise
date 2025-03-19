import java.util.Random;
import java.util.Scanner;

public class Board {

    Scanner scanner= new Scanner(System.in);
    private int size = 10;
    public char[][] grid;
    private char filleedwith;



    public Board(int size, char filleedwith) {
        this.size = size;
        this.filleedwith = filleedwith;
        this.grid = new char[size][size];
        fill();
    }
    private void fill() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = filleedwith;
            }
        }
    }
    public void print() {
        System.out.print("  ");
        for (int i = 0; i < this.size; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < this.size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");
    }
    public boolean canPlaceShip(char[][] grid, int row, int col, int size, boolean horizontal) {
        int count = 0;

        if (horizontal) {
            if (col + size > 10) return false;
            while (count < size) {
                if (grid[row][col + count] == 'S') return false;
                count++;
            }
            count = 0;
        } else  {
            if (row + size > 10) return false;
            while (count < size) {
                if (grid[row + count][col] == 'S') return false;
                count++;
            }
        }
        return true;
    }
    public void placeShipRandom() {
            for (int i = 2; i < 6; i++) {
                boolean place = false;
                while (!place) {
                    Random rand = new Random();
                    int row = (int) (Math.random() * 10);
                    int col = (int) (Math.random() * 10);
                    boolean horizontal = Math.random() < 0.5;
                    if (canPlaceShip(grid, row, col, i, horizontal)) {
                        if (horizontal) {
                            for (int j=0; j<i; j++) {
                                grid[row][col + j] = 'S';
                            }
                        } else {
                            for (int j=0; j<i; j++) {
                                grid[row+j][col] = 'S';
                            }
                        }
                        place = true;
                    }
                }
            }
    }
    public void placeShip(Ship[] ships) {

        for (Ship ship : ships) {
            for (int i = ship.getCordinate().getStartRow(); i < ship.getCordinate().getEndRow(); i++) {
                for (int j = ship.getCordinate().getStartCol(); j < ship.getCordinate().getEndCol(); j++) {
                    this.grid[i][j] = 'S';

                }
            }
        }
    }
    public boolean isSunk() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == 'S') return false;
            }
        }
        return true;
    }
    public void placeShipByPlayer() {
        System.out.println("horizontal(1) or vertical(2)? ");
        int hv = scanner.nextInt();
        scanner.nextLine();

        for (int i = 2; i < 6; i++) {
            if (hv == 1) {
                boolean place = false;
                while (!place) {
                    System.out.println("starCol: ");
                    String starCol = scanner.nextLine();
                    System.out.println("endCol: ");
                    String endCol = scanner.nextLine();
                    int row = Integer.parseInt(starCol.substring(1));
                    int sc = starCol.indexOf(0);
                    int ec = endCol.indexOf(0);


                    if (ec - sc == i) {
                        System.out.println("ship size: " + i);
                        if (canPlaceShip(grid, row, sc, i, true))
                            for (int j = 0; j < i; j++) {
                                grid[row][sc + j] = 'S';
                            }
                        place = true;
                    } else {
                        System.out.println("enter correct coordinate: ");
                    }
                }

            } else {
                boolean place = false;
                while (!place) {
                    System.out.println("starRow: ");
                    String starRow = scanner.nextLine();
                    System.out.println("endRow: ");
                    String endRow = scanner.nextLine();
                    int col = starRow.indexOf(0);
                    int sc = Integer.parseInt(starRow.substring(1));
                    int ec = Integer.parseInt(endRow.substring(1));

                    if (ec - sc == i) {
                        System.out.println("ship size: " + i); 
                        if (canPlaceShip(grid, sc, col, i, true))
                            for (int j = 0; j < i; j++) {
                                grid[sc + j][col] = 'S';
                            }
                        place = true;
                    } else {
                        System.out.println("enter correct coordinate: ");
                    }
                }
            }
        }
    }
}

