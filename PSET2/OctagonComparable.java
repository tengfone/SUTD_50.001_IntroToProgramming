//Modify the class header and implement any necessary methods
public class Octagon implements Comparable<Octagon>{
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    
    @Override
    public int compareTo(Octagon other){
        if (this.side < other.side)
            return -1;
        if (this.side == other.side)
            return 0;
        else return 1;
    }

}
