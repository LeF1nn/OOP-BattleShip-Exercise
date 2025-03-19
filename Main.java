import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {

        Game game = new Game();
        GameNR gameNR = new GameNR();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter number: ");
        System.out.println("1.Random place ships: ");
        System.out.println("2.Player enter the ships coordinate: ");
        System.out.println("3.Exit: ");

        boolean ex = false;

       while (!ex) {
           int in = scanner.nextInt();
           scanner.nextLine();

           switch (in) {
               case 1:
                   game.start();
                   break;
               case 2:
                   gameNR.start();
                   break;
               case 3:
                   ex = true;
                   break;

               default:
                   System.out.println("pls enter correct num: ");
                   break;
           }
       }
       System.exit(0);
    }
}