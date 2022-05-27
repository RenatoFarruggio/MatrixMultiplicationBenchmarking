import org.apache.commons.lang3.NotImplementedException;

public class BenchmarkSuperclass<T> implements BenchmarkInterface<T> {

    T firstMatrix;
    T secondMatrix;
    T resultingMatrix;

    String methodName;

    public void setMatrices(double[][] firstArray, double[][] secondArray) {
        this.firstMatrix = arrayToMatrix(firstArray);
        this.secondMatrix = arrayToMatrix(secondArray);
    }

    @Override
    public void multiplyMatrices() {
        throw new NotImplementedException("multiplyMatrices not implemented in BenchmarkSuperclass. This method should never be called!");
    }

    @Override
    public T arrayToMatrix(double[][] array) {
        throw new NotImplementedException("arrayToMatrix cannot be called from the BenchmarkSuperclass. This method should never be called!");
    }

    public String getMethodName() {
        return this.methodName;
    }
}
