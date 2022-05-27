public class ArrayFactory {

    int size;

    public ArrayFactory(int size) {
        this.size = size;
    }

    public double[][] getNewArray() {
        double[][] array = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = Math.random() * 10;
            }
        }
        return array;
    }
}
