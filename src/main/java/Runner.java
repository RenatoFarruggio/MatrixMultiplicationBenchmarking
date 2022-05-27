import java.lang.*;

public class Runner {

    public static void main(String[] args) {

        double start, end, millisecondsSum;
        String method;

        int warmupRounds = 5;
        int testRounds = 10;
        int matrixSize = 200;

        ArrayFactory arrayFactory = new ArrayFactory(matrixSize);


        // EJML
        method = "EJML";
        millisecondsSum = 0;
        System.out.println("Start testing with method: " + method + "...");
        for (int i = 0; i < warmupRounds; i++) {    // Warmup
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkEJML(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Warmup round " + (i+1) + "/" + warmupRounds + " took " + getMilliseconds(start, end) + "ms.");
        }
        for (int i = 0; i < testRounds; i++) {    // Benchmark
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkEJML(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Benchmark round " + (i+1) + "/" + testRounds + " took " + getMilliseconds(start, end) + "ms.");
            millisecondsSum += getMilliseconds(start, end);
        }
        System.out.println("Average time taken per matrix with method (" + method + "): " + millisecondsSum / testRounds);
        System.out.println("");


        // ND4J
        method = "ND4J";
        millisecondsSum = 0;
        System.out.println("Start testing with method: " + method + "...");
        for (int i = 0; i < warmupRounds; i++) {    // Warmup
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkND4J(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Warmup round " + (i+1) + "/" + warmupRounds + " took " + getMilliseconds(start, end) + "ms.");
        }
        for (int i = 0; i < testRounds; i++) {    // Benchmark
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkND4J(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Benchmark round " + (i+1) + "/" + testRounds + " took " + getMilliseconds(start, end) + "ms.");
            millisecondsSum += getMilliseconds(start, end);
        }
        System.out.println("Average time taken per matrix with method (" + method + "): " + millisecondsSum / testRounds);
        System.out.println("");


        // LA4J
        method = "LA4J";
        millisecondsSum = 0;
        System.out.println("Start testing with method: " + method + "...");
        for (int i = 0; i < warmupRounds; i++) {    // Warmup
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkLA4J(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Warmup round " + (i+1) + "/" + warmupRounds + " took " + getMilliseconds(start, end) + "ms.");
        }
        for (int i = 0; i < testRounds; i++) {    // Benchmark
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkLA4J(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Benchmark round " + (i+1) + "/" + testRounds + " took " + getMilliseconds(start, end) + "ms.");
            millisecondsSum += getMilliseconds(start, end);
        }
        System.out.println("Average time taken per matrix with method (" + method + "): " + millisecondsSum / testRounds);
        System.out.println("");


        // Apache commons
        method = "Apache Commons";
        millisecondsSum = 0;
        System.out.println("Start testing with method: " + method + "...");
        for (int i = 0; i < warmupRounds; i++) {    // Warmup
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkApacheCommons(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Warmup round " + (i+1) + "/" + warmupRounds + " took " + getMilliseconds(start, end) + "ms.");
        }
        for (int i = 0; i < testRounds; i++) {    // Benchmark
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkApacheCommons(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Benchmark round " + (i+1) + "/" + testRounds + " took " + getMilliseconds(start, end) + "ms.");
            millisecondsSum += getMilliseconds(start, end);
        }
        System.out.println("Average time taken per matrix with method (" + method + "): " + millisecondsSum / testRounds);
        System.out.println("");


        // Colt
        method = "Colt";
        millisecondsSum = 0;
        System.out.println("Start testing with method: " + method + "...");
        for (int i = 0; i < warmupRounds; i++) {    // Warmup
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkColt(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Warmup round " + (i+1) + "/" + warmupRounds + " took " + getMilliseconds(start, end) + "ms.");
        }
        for (int i = 0; i < testRounds; i++) {    // Benchmark
            start = System.nanoTime();
            MatrixMultiplicationBenchmarks.benchmarkColt(arrayFactory.getNewArray(), arrayFactory.getNewArray());
            end = System.nanoTime();

            System.out.println("Benchmark round " + (i+1) + "/" + testRounds + " took " + getMilliseconds(start, end) + "ms.");
            millisecondsSum += getMilliseconds(start, end);
        }
        System.out.println("Average time taken per matrix with method (" + method + "): " + millisecondsSum / testRounds);
        System.out.println("");

    }

    private static double getMilliseconds(double start, double end) {
        return (end-start) / 1000000;
    }
}
