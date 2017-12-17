package osipov;



public class SingleThreadComputer {
    private final boolean[][] board;
    private final int numGenerations;

    public SingleThreadComputer(boolean[][] board, int numGenerations) {
        this.board = board;
        this.numGenerations = numGenerations;
    }

    public boolean[][] compute(){
        boolean[][] next = board;
        final int len = board.length;

        for (int i = 0; i < numGenerations; i++){
            boolean[][] res = new boolean[len][len];  // empty board
            for (int j = 0; j < len; j++){     // loops through x-axis for computing the next generation
                for (int k = 0; k < len; k++){ // loops through y-axis
                    res[j][k] = BaseCellCounter.getDot(next, j, k, len, len);
                }
            }
            next = res;
        }

        return next;
    }
}