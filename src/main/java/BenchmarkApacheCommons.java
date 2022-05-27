import org.apache.commons.math3.linear.RealMatrix;

import static org.apache.commons.math3.linear.MatrixUtils.createRealMatrix;

public class BenchmarkApacheCommons extends BenchmarkSuperclass<RealMatrix> implements BenchmarkInterface<RealMatrix> {

    public BenchmarkApacheCommons() {
        this.methodName = "Apache Commons";
    }

    @Override
    public void multiplyMatrices() {
        resultingMatrix = firstMatrix.multiply(secondMatrix);
    }

    @Override
    public RealMatrix arrayToMatrix(double[][] array) {
        return createRealMatrix(array);
    }

}
