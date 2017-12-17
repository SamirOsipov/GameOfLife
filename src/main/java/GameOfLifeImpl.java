
import osipov.SingleThreadComputer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class GameOfLifeImpl implements GameOfLife {
    private int N;
    private int M;

    @Override
    public List<String> play(String inputFile) {
        long startTime = System.nanoTime();
        List<String> lines = scanFIle(inputFile);
        String[] strings = lines.get(0).split(" ");
        N = Integer.valueOf(strings[0]);
        M = Integer.valueOf(strings[1]);
        boolean[][] field = new boolean[N][N];
        lines.remove(0);
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                field[i][j] = 1 == Character.getNumericValue(lines.get(i).charAt(j));
            }
        }

        //boolean[][] finalConcurrentBoard = ForkJoinPool.commonPool().invoke(new ParallelComputer(field, M)); //Многопоточный запуск
        boolean[][] finalConcurrentBoard = new SingleThreadComputer(field, M).compute(); //Запуск на одном потоке
        List<String> finished = printField(finalConcurrentBoard);
        System.out.println(System.nanoTime() - startTime);
        return finished;
    }

    private List<String> printField(boolean[][] field) {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < N; j++) {
                builder.append(field[i][j] ? 1 : 0);
            }
            lines.add(builder.toString());
        }
        return lines;
    }

    private List<String> scanFIle (String fileName) {
        List<String> lines = new ArrayList<>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File(fileName));
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }

        return lines;
    }
}
