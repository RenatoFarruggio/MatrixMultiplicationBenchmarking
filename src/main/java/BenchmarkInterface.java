public interface BenchmarkInterface<T> {

    public void setMatrices(double[][] firstArray, double[][] secondArray);

    public void multiplyMatrices();

    public T arrayToMatrix(double[][] array);
}
