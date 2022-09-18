package prasad.research.java.fork_join;

import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Integer> {

    private final int from;
    private final int to;
    private final int batchSize;

    public RecursiveSum(int from, int to, int batchSize) {
        this.from = from;
        this.to = to;
        this.batchSize = batchSize;
    }

    @Override
    protected Integer compute() {
        if (to - from <= batchSize) {
            System.out.println("From " + from + ", To " + to + ", Thread: " + Thread.currentThread().getName());
            int sum = 0;
            for (int n = from; n <= to; n++) {
                sum += n;
            }
            return sum;
        } else {
            int mid = (from + to) / 2;
            RecursiveSum firstHalf = new RecursiveSum(from, mid, batchSize);
            firstHalf.fork();
            RecursiveSum secondHalf = new RecursiveSum(mid + 1, to, batchSize);
            return secondHalf.compute() + firstHalf.join();
        }
    }
}
