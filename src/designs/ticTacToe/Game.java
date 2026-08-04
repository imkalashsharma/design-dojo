package designs.ticTacToe;

import java.util.Scanner;

public class Game {
    private final Scanner sc;

    private final Board board;
    private final Player playerO;
    private final Player playerX;

    public Game(int n, Player p1, Player p2) {
        this.sc = new Scanner(System.in);

        this.board = new Board(n);
        this.playerO = p1;
        this.playerX = p2;
    }

    public void start() {
        GameStatus gameStatus = GameStatus.IN_PROGRESS;
        boolean playerOTurn = true;

        while(gameStatus == GameStatus.IN_PROGRESS) {
            board.display();

            System.out.println(playerOTurn ? playerO.getName() : playerX.getName());
            System.out.print("Enter your move: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // make move
            try{
                board.makeMove(row, col, playerOTurn ? playerO.getMarker() : playerX.getMarker());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            gameStatus = board.validateBoard(row, col);

            if(gameStatus == GameStatus.DRAW) {
                System.out.println("=== DRAW ===");
                break;
            } else if(gameStatus == GameStatus.WIN) {
                System.out.println("Win! " + (playerOTurn ? playerO.getName() : playerX.getName()));
                board.display();
                break;
            }

            playerOTurn = !playerOTurn;
        }
    }
}
