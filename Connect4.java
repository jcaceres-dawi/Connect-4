package Dificultad5kyu;

public class Connect4 {

    int[][] board = {
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 } };
    int turn = 1;
    Boolean won = false;

    public String play(int column) {
        if (won) {
            return "Game has finished!";
        } else {
            boolean columnfull = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][column] == 0) {
                    columnfull = false;
                }
            }
            if (columnfull) {
                return "Column full!";
            }
            return insert(column);
        }
    }

    public String insert(int column) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][column] == 0) {
                if (turn == 1) {
                    board[i][column] = 1;
                    turn = 2;
                    if (checkwinner()) {
                        won = true;
                        return "Player 1 wins!";
                    } else {
                        return "Player 1 has a turn";
                    }
                } else {
                    board[i][column] = 2;
                    turn = 1;
                    if (checkwinner()) {
                        won = true;
                        return "Player 2 wins!";
                    } else {
                        return "Player 2 has a turn";
                    }
                }
            }
        }
        return "";
    }

    public boolean checkwinner() {

        // Horizontal
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 1 && board[i][j + 1] == 1 && board[i][j + 2] == 1 && board[i][j + 3] == 1) {
                    return true;
                }
                if (board[i][j] == 2 && board[i][j + 1] == 2 && board[i][j + 2] == 2 && board[i][j + 3] == 2) {
                    return true;
                }
            }
        }

        // Vertical
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && board[i + 1][j] == 1 && board[i + 2][j] == 1 && board[i + 3][j] == 1) {
                    return true;
                }
                if (board[i][j] == 2 && board[i + 1][j] == 2 && board[i + 2][j] == 2 && board[i + 3][j] == 2) {
                    return true;
                }
            }
        }

        // Diagonal izquierda derecha
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 1 && board[i + 1][j + 1] == 1 && board[i + 2][j + 2] == 1
                        && board[i + 3][j + 3] == 1) {
                    return true;
                }
                if (board[i][j] == 2 && board[i + 1][j + 1] == 2 && board[i + 2][j + 2] == 2
                        && board[i + 3][j + 3] == 2) {
                    return true;
                }
            }
        }

        // Diagonal derecha izquierda

        for (int i = 0; i < 3; i++) {
            for (int j = board[0].length - 1; j > 2; j--) {
                if (board[i][j] == 1 && board[i + 1][j - 1] == 1 && board[i + 2][j - 2] == 1
                        && board[i + 3][j - 3] == 1) {
                    return true;
                }
                if (board[i][j] == 2 && board[i + 1][j - 1] == 2 && board[i + 2][j - 2] == 2
                        && board[i + 3][j - 3] == 2) {
                    return true;
                }
            }
        }

        return false;
    }
}