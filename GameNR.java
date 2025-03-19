import java.util.Scanner;

public class GameNR {

    Scanner scanner = new Scanner(System.in);
    Cordinate cordinate = new Cordinate(0, 0, 0, 0);


    Board board = new Board(10, '~');
    Board boardplayer1 = new Board(10, '~');
    Board boardplayer2 = new Board(10, '~');
    Player player2 = new Player("Player2", 4, board, boardplayer1);
    Player player1 = new Player("Player1", 4, board, boardplayer2);


    public boolean isGameOver() {
        return player1.getBoard().isSunk() || player2.getBoard().isSunk();
    }


    public void start() {

        board.print();
        player1.getBoard().placeShipByPlayer();
        player2.getBoard().placeShipByPlayer();


        boolean player1Turn = true;

        while (!isGameOver()) {

            if (player1Turn) {
                boolean canShot = true;
                boardplayer1.print();
                while (canShot) {
                    System.out.print("Enter Your Coordinate: ");
                    String input = scanner.next().toUpperCase();
                    if (cordinate.isValid(input)) {
                        int row = Integer.parseInt(input.substring(1));
                        int col = input.charAt(0) - 'A';
                        if (boardplayer1.grid[row][col] == '~') {
                            if (player1.getBoard().grid[row][col] == 'S') {
                                System.out.println("HIT! ");
                                boardplayer1.grid[row][col] = 'X';
                                player2.getBoard().grid[row][col] = 'X';
                            } else {
                                System.out.println("MISS!");
                                boardplayer1.grid[row][col] = 'O';
                            }
                            canShot = false;
                            player1Turn = false;
                        } else System.out.println("Already targeted");
                    } else System.out.print("Invalid input!");
                }
            }
            if (!player1Turn) {
                boolean canShot = true;
                boardplayer2.print();
                while (canShot) {
                    System.out.print("Enter Your Coordinate: ");
                    String input = scanner.next().toUpperCase();
                    if (cordinate.isValid(input)) {
                        int row = Integer.parseInt(input.substring(1));
                        int col = input.charAt(0) - 'A';
                        if (boardplayer2.grid[row][col] == '~') {
                            if (player2.getBoard().grid[row][col] == 'S') {
                                System.out.println("HIT! ");
                                boardplayer2.grid[row][col] = 'X';
                                player1.getBoard().grid[row][col] = 'X';
                            } else {
                                System.out.println("MISS!");
                                boardplayer2.grid[row][col] = 'O';
                            }
                            canShot = false;
                        } else System.out.println("Already targeted");
                    } else System.out.print("Invalid input!");
                }
            }
            player1Turn = true;
        }
    }
}