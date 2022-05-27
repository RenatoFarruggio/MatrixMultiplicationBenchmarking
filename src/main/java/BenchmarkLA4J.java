import org.la4j.Matrix;

public class BenchmarkLA4J extends BenchmarkSuperclass<Matrix> implements BenchmarkInterface<Matrix> {

    public BenchmarkLA4J() {
        this.methodName = "LA4J";
    }

    @Override
    public void multiplyMatrices() {
        resultingMatrix = firstMatrix.multiply(secondMatrix);
    }

    @Override
    public Matrix arrayToMatrix(double[][] array) {
        return Matrix.from2DArray(array);
    }

}
