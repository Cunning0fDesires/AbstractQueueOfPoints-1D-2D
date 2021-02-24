public abstract class AbstractArrayOfPoints {

    /* AbstractArrayOfPoints is an abstract queue type with three parent method bodies,
    including an override of Object's .toString() function. It contains abstract methods
    for adding pairs of x-y coordinates to an array, as well as a test method for
    populating and sorting a sample instance */

    //Rewrite point coordinate values at specified index
    public abstract void setPoint(int i, double x, double y);

    //Return x value of specified point
    public abstract double getX(int i);

    //Return y value of specified point
    public abstract double getY(int i);

    //Number of points in array
    public abstract int count();

    //Add a new point to the final array index
    public abstract void addPoint(double x, double y);

    //Remove point from the final array index
    public abstract void removeLast();

    //Bubble sort by the X coordinate in each array index, invoked in test()
    public void sortByX() {
        boolean mustSort;
        do {
            mustSort = false; //
            for (int i = 0; i < count() - 1; i++) {
                if (getX(i) > getX(i + 1)) { //if two consecutive array values are not sorted, swap them around
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    mustSort = true; //keep sorting until false
                }
            }
        }
        while (mustSort);
    }

    //String representation override from the Object base class,to add x and y coordinate labels to the console
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count(); i++) {
            s += "x = " + getX(i) + " y = " + getY(i) + "\n";
        }
        return s + "\n";
    }

    //Populate an array with eight points, sort and print the points
    public void test() {
        addPoint(22, 45);
        addPoint(4, 11);
        addPoint(30, 5.5);
        addPoint(-2, 48);
        addPoint(12, 45);
        addPoint(0, 11);
        addPoint(50, 5.5);
        addPoint(8, 48);
        sortByX();
        System.out.println(this);
    }
}
