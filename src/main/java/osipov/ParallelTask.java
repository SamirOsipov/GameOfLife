package osipov;

import java.util.concurrent.RecursiveTask;

public class ParallelTask extends RecursiveTask{

    private boolean[][] slice;

    public ParallelTask(boolean[][] slice) {
        this.slice = slice;
    }

    protected boolean[] compute() {
        int len = slice[1].length;
        boolean[] newRow = new boolean[len];

        newRow[0] = FasterCellCounter.getFirstDot(slice, len);
        for (int i=1; i < len - 1; i++){
            newRow[i] = FasterCellCounter.getMiddleDot(slice, i);
        }
        newRow[len-1] = FasterCellCounter.getLastDot(slice, len);
        return newRow;
    }
}