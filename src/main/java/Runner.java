import java.lang.*;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {

        double start, end, millisecondsSum;
        String method;

        int warmupRounds = 5;
        int testRounds = 10;

        int[] matrixSizes = {10, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000,
                2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};



        ArrayList<BenchmarkSuperclass> benchmarksList = new ArrayList<BenchmarkSuperclass>();
        benchmarksList.add(new BenchmarkND4J());
        benchmarksList.add(new BenchmarkEJML());
        benchmarksList.add(new BenchmarkLA4J());
        benchmarksList.add(new BenchmarkApacheCommons());

        for (int matrixSize: matrixSizes) {
            ArrayFactory arrayFactory = new ArrayFactory(matrixSize);
            System.out.println("RUNNING BENCHMARKS FOR MATRICES OF SIZE: " + matrixSize);
            System.out.println("");
            for (BenchmarkSuperclass benchmark : benchmarksList) {
                millisecondsSum = 0;
                method = benchmark.getMethodName();
                System.out.println("Start testing with method: " + method);
                System.out.print("Running " + warmupRounds + " warmups ");
                for (int i = 0; i < warmupRounds; i++) {    // Warmup
                    System.out.print(".");
                    benchmark.setMatrices(arrayFactory.getNewArray(), arrayFactory.getNewArray());
                    benchmark.multiplyMatrices();
                }
                System.out.println("");
                System.out.print("Benchmarking for " + testRounds + " rounds ");
                for (int i = 0; i < testRounds; i++) {    // Benchmark
                    if (i % 20 == 0) {
                        System.out.println("");
                    } else if (i % 5 == 0) {
                        System.out.print(" ");
                    }
                    System.out.print(".");
                    benchmark.setMatrices(arrayFactory.getNewArray(), arrayFactory.getNewArray());
                    start = System.nanoTime();
                    benchmark.multiplyMatrices();
                    end = System.nanoTime();

                    millisecondsSum += getMilliseconds(start, end);
                }
                System.out.println("");
                System.out.println("Average time taken per matrix with matrix size: " + matrixSize);
                System.out.println(" and method \"" + method + "\": " +
                        millisecondsSum / testRounds + "ms.");
                System.out.println("========== " + millisecondsSum / testRounds + " ==========");
                System.out.println("");
            }
            System.out.println("===============================================================");
            System.out.println("");
        }

    }

    private static double getMilliseconds(double start, double end) {
        return (end-start) / 1000000;
    }
}
