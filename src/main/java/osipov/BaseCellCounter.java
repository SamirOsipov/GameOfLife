package osipov;

/**
 * Created by Максим on 17.12.2017.
 */
public class BaseCellCounter {
    public static int mod (int x, int m){ // deals with java's % returning negative vals for
        m = Math.abs(m);                   // negative inputs
        return (x % m + m) % m;
    }

    public static int getNeighborCount(boolean[][] board, int x, int y, int xsize, int ysize){
        int nc = 0;   // this function rather messily counts up the neighbors

        if (board[mod(x+1,xsize)][y]){
            nc++;
        }
        if (board[mod(x+1,xsize)][mod(y+1, ysize)]){
            nc++;
        }
        if (board[x][mod(y+1,ysize)]){
            nc++;
        }
        if (board[x][mod(y-1,ysize)]){
            nc++;
        }
        if (board[mod(x+1,xsize)][mod(y-1,ysize)]){
            nc++;
        }
        if (board[mod(x-1,xsize)][y]){
            nc ++;
        }
        if (board[mod(x-1,xsize)][mod(y-1,ysize)]){
            nc ++;
        }
        if (board[mod(x-1,xsize)][mod(y+1,ysize)]){
            nc ++;
        }
        return nc;
    }

    public static boolean getDot(boolean[][] board, int x, int y, int xsize, int ysize){
        // this function applies the rules of the game on one square

        return board[x][y] && getNeighborCount(board, x, y, xsize, ysize) == 2
                || getNeighborCount(board, x, y, xsize, ysize) == 3;
    }
}