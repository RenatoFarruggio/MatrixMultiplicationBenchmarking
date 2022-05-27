import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;
import org.apache.commons.math3.linear.RealMatrix;
import org.ejml.simple.SimpleMatrix;
import org.la4j.Matrix;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static org.apache.commons.math3.linear.MatrixUtils.createRealMatrix;

public class MatrixMultiplicationBenchmarks {

    public static SimpleMatrix benchmarkEJML(double[][] firstArray, double[][] secondArray) {
        SimpleMatrix firstMatrix = new SimpleMatrix(firstArray);
        SimpleMatrix secondMatrix = new SimpleMatrix(secondArray);

        return firstMatrix.mult(secondMatrix);
    }

    public static INDArray benchmarkND4J (double[][] firstArray, double[][] secondArray) {
        INDArray firstMatrix = Nd4j.create(firstArray);
        INDArray secondMatrix = Nd4j.create(secondArray);

        return firstMatrix.mul(secondMatrix);
    }

    public static Matrix benchmarkLA4J (double[][] firstArray, double[][] secondArray) {
        Matrix firstMatrix = Matrix.from2DArray(firstArray);
        Matrix secondMatrix = Matrix.from2DArray(secondArray);

        return firstMatrix.multiply(secondMatrix);
    }

    public static RealMatrix benchmarkApacheCommons (double[][] firstArray, double[][] secondArray) {
        RealMatrix firstMatrix = createRealMatrix(firstArray);
        RealMatrix secondMatrix = createRealMatrix(secondArray);

        return firstMatrix.multiply(secondMatrix);
    }

    public static DoubleMatrix2D benchmarkColt (double[][] firstArray, double[][] secondArray) {
        Algebra algebra = new Algebra();
        DoubleMatrix2D firstMatrix = DoubleFactory2D.dense.make(firstArray);
        DoubleMatrix2D secondMatrix = DoubleFactory2D.dense.make(secondArray);

        return algebra.mult(firstMatrix, secondMatrix);
    }

}