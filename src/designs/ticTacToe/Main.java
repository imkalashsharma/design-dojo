package designs.ticTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" === Tic Tac Toe ===");


        System.out.print("Enter player O name: ");
        String playerOName = sc.nextLine();

        System.out.print("Enter player X name: ");
        String playerXName = sc.nextLine();

        Player playerO = new Player(playerOName, Marker.O);
        Player playerX = new Player(playerXName, Marker.X);

        Game game = new Game(3, playerO, playerX);
        System.out.println(" === GAME START === ");
        game.start();
    }
}
