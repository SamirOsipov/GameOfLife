package osipov;



public class FasterCellCounter {

    public static boolean getFirstDot(boolean[][] board, int len){
        int nc = 0;

        if (board[2][0]){
            nc++;
        }
        if (board[2][1]){
            nc++;
        }
        if (board[1][1]){
            nc++;
        }
        if (board[1][len-1]){
            nc++;
        }
        if (board[2][len-1]){
            nc++;
        }
        if (board[0][0]){
            nc++;
        }
        if (board[0][len-1]){
            nc++;
        }
        if (board[0][1]){
            nc++;
        }

        return board[1][0] && nc == 2 || nc == 3;
    }


    public static boolean getMiddleDot(boolean[][] board, int y){
        int nc = 0;

        if (board[2][y]){
            nc++;
        }
        if (board[2][y+1]){
            nc++;
        }
        if (board[1][y+1]){
            nc++;
        }
        if (board[1][y-1]){
            nc++;
        }
        if (board[2][y-1]){
            nc++;
        }
        if (board[0][y]){
            nc++;
        }
        if (board[0][y-1]){
            nc++;
        }
        if (board[0][y+1]){
            nc++;
        }

        return board[1][y] && nc == 2 || nc == 3;
    }

    public static boolean getLastDot(boolean[][] board, int len){
        int nc = 0;

        if (board[2][len-1]){
            nc++;
        }
        if (board[2][0]){
            nc++;
        }
        if (board[1][0]){
            nc++;
        }
        if (board[1][len-2]){
            nc++;
        }
        if (board[2][len-2]){
            nc++;
        }
        if (board[0][len-1]){
            nc++;
        }
        if (board[0][len-2]){
            nc++;
        }
        if (board[0][0]){
            nc++;
        }

        return board[1][len-1] && nc == 2 || nc == 3;
    }

}