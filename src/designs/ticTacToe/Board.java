package designs.ticTacToe;

public class Board {
    private final int n;
    private final Marker[][] board;
    private int remainingSlot;

    public Board(int n) {
        this.n = n;
        this.board = new Marker[n][n];
        this.remainingSlot = n * n;
    }

    public void makeMove(int row, int col, Marker marker) {
        if (row < 0 || row > board.length - 1) {
            throw new RuntimeException("row out of bounds");
        }

        if(col < 0 || col > board[0].length - 1) {
            throw new RuntimeException("row out of bounds");
        }

        if(board[row][col] != null) {
            throw new RuntimeException("Cell is already occupied");
        }

        board[row][col] = marker;
        this.remainingSlot--;
    }

    public GameStatus validateBoard(int row, int col) {
        Marker target = board[row][col];

        // Row check
        boolean win = true;
        for (int c = 0; c < n; c++) {
            if (board[row][c] != target) {
                win = false;
                break;
            }
        }
        if (win) {
            return GameStatus.WIN;
        }

        // Column check
        win = true;
        for (int r = 0; r < n; r++) {
            if (board[r][col] != target) {
                win = false;
                break;
            }
        }
        if (win) {
            return GameStatus.WIN;
        }

        // Main diagonal check
        if (row == col) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != target) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return GameStatus.WIN;
            }
        }

        // Anti-diagonal check
        if (row + col == n - 1) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][n - 1 - i] != target) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return GameStatus.WIN;
            }
        }

        // Draw check
        if (this.remainingSlot == 0) {
            return GameStatus.DRAW;
        }

        return GameStatus.IN_PROGRESS;
    }

    public void display() {
        for (Marker[] markers : board) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(markers[col] == null ? "_  " : markers[col] + "  ");
            }
            System.out.println();
        }
    }
}
