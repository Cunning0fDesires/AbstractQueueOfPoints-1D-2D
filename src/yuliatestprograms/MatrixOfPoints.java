package yuliatestprograms;

public class MatrixOfPoints extends AbstractArrayOfPoints {

       /* MatrixOfPoint is a 2D implementation of the AbstractArrayOfPoints abstract class.
    It contains six overridden methods of the parent class. These are useful
    for managing pairs of x-y coordinates in a 2D array - setting, adding, removing
    points or getting their coordinates */

    private double[][] matrix = new double[0][0];

    @Override
    public void setPoint(int i, double x, double y) {
        if (i < count()) {
            matrix[i][0] = x; //each row of the matrix corresponds to an X/Y pair
            matrix[i][1] = y;
        }
    }

    @Override
    public double getX(int i) {
        return matrix[i][0];
    }

    @Override
    public double getY(int i) {
        return  matrix[i][1];
    }

    @Override
    public int count() { //since a number of subarrays represents a point
        return matrix.length;
    }

    @Override
    public void addPoint(double x, double y) {
        double[][] temp = new double[matrix.length + 1][2]; //One additional row for a new point in a temp buffer
        for (int i = 0; i < matrix.length; i++) {
            temp[i][0]=matrix[i][0]; //This and the next line assign the original array values to a buffer
            temp[i][1]=matrix[i][1];
        }
        temp[temp.length - 1][0] = x; //Assign x-y coordinates for a new point
        temp[temp.length - 1][1] = y;
        matrix = temp; //Update contents of the buffer into the original array
    }

    @Override
    public void removeLast() {
        if (count() == 0) { //Length check
            return;
        }
        double[][] temp = new double[matrix.length - 1][2]; //Temporary buffer with one less row
        for (int i = 0; i < matrix.length - 1; i++) {
            temp[i][0]=matrix[i][0]; //This and the next line duplicate all values into buffer
            temp[i][1]=matrix[i][1];
        }
        matrix = temp; //Reassign to the original array
    }
}
