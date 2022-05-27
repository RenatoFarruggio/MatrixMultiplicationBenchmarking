import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;

public class BenchmarkColt extends BenchmarkSuperclass<DoubleMatrix2D> implements BenchmarkInterface<DoubleMatrix2D> {

    Algebra algebra;
    public BenchmarkColt() {
        this.methodName = "Colt";
        this.algebra = new Algebra();
    }

    @Override
    public void multiplyMatrices() {
        resultingMatrix = algebra.mult(firstMatrix, secondMatrix);
    }

    @Override
    public DoubleMatrix2D arrayToMatrix(double[][] array) {
        return DoubleFactory2D.dense.make(array);
    }

}
