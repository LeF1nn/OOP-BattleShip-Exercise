import java.util.Scanner;

public class Player {

    private String name;
    private int shipCount;
    private Ship[] ships;
    private Board board;
    private Board opponentBoard;
    private Scanner scanner = new Scanner(System.in);
    private Cordinate cordinate;

    public Player(String name , int shipCount , Board board , Board opponentBoard ){
        this.name = name;
        this.shipCount = shipCount;
        this.ships = new Ship[shipCount];
        this.board = board;
        this.opponentBoard = opponentBoard;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getShipCount() {
        return shipCount;
    }
    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public Board getOpponentBoard() {
        return opponentBoard;
    }
    public void setOpponentBoard(Board opponentBoard) {
        this.opponentBoard = opponentBoard;
    }
    public Ship[] getShips() {
        return ships;
    }
    public void setShips(Ship[] ships) {
        this.ships = ships;
    }
}






