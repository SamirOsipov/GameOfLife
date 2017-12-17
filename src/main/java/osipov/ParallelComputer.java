package osipov; /**

 */
import java.util.concurrent.RecursiveTask;

public class ParallelComputer extends RecursiveTask<boolean[][]>{
    private final boolean[][] board;
    private final int numGenerations;


    public ParallelComputer(boolean[][] board, int numGenerations) {
        this.board = board;
        this.numGenerations = numGenerations;
    }

    protected boolean[][] compute() {
        boolean[][] next = board;
        final int len = board.length;
        final RecursiveTask<boolean[]>[] tasks = new RecursiveTask[len];

        for (int i=0; i < numGenerations; i++){
            // Separately handle first and last row
            ParallelTask task = new ParallelTask(new boolean[][]{next[len-1], next[0], next[1]});
            task.fork();
            tasks[0] = task;
            for (int j = 1; j < len - 1; j++){
                task = new ParallelTask(new boolean[][]{next[j-1], next[j], next[j+1]});
                task.fork();
                tasks[j] = task;
            }
            task = new ParallelTask(new boolean[][]{next[len-2], next[len-1], next[0]});
            task.fork();
            tasks[len-1] = task;

            boolean[][] res = new boolean[len][len];
            for (int j = 0; j < len; j++) {
                res[j] = tasks[j].join();
            }
            next = res;
        }
        return next;
    }
}