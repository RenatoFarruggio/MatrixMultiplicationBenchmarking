import org.ejml.simple.SimpleMatrix;

public class BenchmarkEJML extends BenchmarkSuperclass<SimpleMatrix> implements BenchmarkInterface<SimpleMatrix> {

    public BenchmarkEJML() {
        this.methodName = "EJML";
    }

    @Override
    public void multiplyMatrices() {
        resultingMatrix = firstMatrix.mult(secondMatrix);
    }

    @Override
    public SimpleMatrix arrayToMatrix(double[][] array) {
        return new SimpleMatrix(array);
    }

}
