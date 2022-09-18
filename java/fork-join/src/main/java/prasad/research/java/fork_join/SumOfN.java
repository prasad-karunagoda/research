package prasad.research.java.fork_join;

import java.util.concurrent.ForkJoinPool;

public class SumOfN {

    public static void main(String[] args) {
        int N = 100;
        int THREAD_COUNT = 5;
        ForkJoinPool pool = new ForkJoinPool(THREAD_COUNT);
        int sum = pool.invoke(new RecursiveSum(1, N, N / THREAD_COUNT));
        System.out.println("Sum = " + sum);
    }
}
