public class LinearEquation {
    private double a,b,c,d,e,f;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable(){
        if (getA()*getD() - getB()*getC() == 0){
            return false;
        } else{
            return true;
        }
    }

    public double getX() {
        double det = ((getA()*getD()-getB()*getC()));
        double x = ((getD()*getE()-getB()*getF())) / det;
        return x;
    }

    public double getY() {
        double det = ((getA()*getD()-getB()*getC()));
        double y =  ((getA()*getF()-getC()*getE())) / det;
        return y;
    }
    LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

}
