import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class BenchmarkND4J extends BenchmarkSuperclass<INDArray> implements BenchmarkInterface<INDArray> {

    public BenchmarkND4J() {
        this.methodName = "ND4J";
    }

    @Override
    public void multiplyMatrices() {
        resultingMatrix = firstMatrix.mul(secondMatrix);
    }

    @Override
    public INDArray arrayToMatrix(double[][] array) {
        return Nd4j.create(array);
    }
}
