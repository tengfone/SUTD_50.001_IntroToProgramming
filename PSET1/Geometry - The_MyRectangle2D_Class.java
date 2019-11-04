public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        return (2*getHeight()+2*getWidth());
    }
    
    public boolean contains(double x,double y){
        double leftPointX = this.x - (width/2);
        double leftPointY = this.y - (height/2);
        double rightPointX = this.x + (width/2);
        double rightPointY = this.y + (height/2);
        //if (x < rightPointX && x> leftPointX){
        //    if( y < rightPointY && y> leftPointY){
        //        return true;
        //    } else{return false;}
        //} else{
        //   return false;
        //}
        if ( x > leftPointX && x< rightPointX && y>leftPointY && y<rightPointY){
            return true;
        }
        return false;
    }
    
    public boolean contains(MyRectangle2D r){
        double leftPointX = this.x - (width/2);
        double leftPointY = this.y - (height/2);
        double rightPointX = this.x + (width/2);
        double rightPointY = this.y + (height/2);

        double inLeftPointX = r.getX() - (r.getWidth()/2);
        double inLeftPointY = r.getY() - (r.getHeight()/2);
        double inRightPointX = r.getX() + (r.getWidth()/2);
        double inRightPointY = r.getY() + (r.getHeight()/2);
        
        if (inLeftPointX > leftPointX && inLeftPointY > leftPointY && inRightPointX < rightPointX && inRightPointY < rightPointY){
            return true;
        }
        return false;
    }
    
    public boolean overlaps(MyRectangle2D r){
        double l1x = this.x - (width/2);
        double l1y = this.y + (height/2);
        double r1x = this.x + (width/2);
        double r1y = this.y - (height/2);
        double l2x = r.getX() - (r.getWidth()/2);
        double l2y = r.getY() + (r.getHeight()/2);
        double r2x = r.getX() + (r.getWidth()/2);
        double r2y = r.getY() - (r.getHeight()/2);
        
        if (l1x > r2x || l2x > r1x || l1y< r2y || l2y < r1y)
            return false;
        return true;
        
    }

    
    MyRectangle2D() {
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
