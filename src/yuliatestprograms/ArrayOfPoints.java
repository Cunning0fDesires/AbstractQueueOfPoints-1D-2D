package yuliatestprograms;

public class ArrayOfPoints extends AbstractArrayOfPoints {

    /* ArrayOfPoints is a 1D implementation of the AbstractArrayOfPoints abstract class.
    It's structured as a 1D array in which consecutive pairs of array indices are
    encapsulated as a "point"*/

    private double [] arr = { };

    @Override
    public void setPoint(int i, double x, double y) {
        if (i < count()) {
            arr[i * 2] = x;
            arr[(i * 2) + 1] = y;
        }
    }

    @Override
    public double getX(int i) {
        return arr[i * 2];
    }

    @Override
    public double getY(int i) {
        return arr[(i * 2) + 1];
    }

    @Override
    public int count() {
        return arr.length / 2;
    } //Since there is one X/Y pair for every index of the internal array

    @Override
    public void addPoint(double x, double y) {
        double[] temp = new double[arr.length + 2]; //New array has two additional indices for one more X/Y pair
        for (int i = 0; i < arr.length ; i++) {
            temp[i] = arr[i]; //Assign original array values to a buffer
        }
        temp[temp.length - 2] = x;
        temp[temp.length - 1] = y;
        arr = temp; //Update contents of the buffer into the original array
    }

    @Override
    public void removeLast() {
        if (count() == 0) { //Length check
            return;
        }
        double[] temp = new double[arr.length - 2]; //temp buffer array with one less X/Y pair

        for (int i = 0; i < temp.length; i++) {
            temp[i]=arr[i]; ///Duplicate all values into buffer
        }
        arr = temp; //Reassign to the original array
    }

    //bubble sort overridden with a selection implementation
    @Override
    public void sortByX() {
        for (int i = 0; i < arr.length - 1; i=i+2) //check each X value (i.e. every second array index)
        {
            int minValue = i; //smallest array value to be compared, against every other value
            for (int j = i+2; j < arr.length; j=j+2)
                if (arr[j] < arr[minValue]) //reassign current value to minimum if it's smaller than the current minimum
                    minValue = j;
            double tempX = arr[minValue];
            double tempY = arr[minValue + 1];
            arr[minValue] = arr[i]; //begin next loop iteration from the current smallest confirmed X value
            arr[minValue + 1] = arr[i + 1]; //Y counterpart of X on the previous line
            arr[i] = tempX; //update current index to current smallest X value
            arr[i + 1] = tempY; //...and its matching Y value
        }
    }
}
