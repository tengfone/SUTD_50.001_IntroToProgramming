import java.util.ArrayList;
public class GetPath { 
    
    //Fill in your answer for this method 
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        if (grid.length == 0) return false;
        if (path.size() == 0) path.add(new Point(0, 0));
        int x = path.get(path.size() - 1).x;
        int y = path.get(path.size() - 1).y;
        if (grid[x][y] != 0)return false;
        if (x == r && y == c) return true;
        Point upRight = new Point(x, y + 1);
        Point Rightup = new Point(x + 1, y);
        path.add(upRight);
        if (upRight.y <= c && getPath(r, c, path, grid)) return true;
        else path.remove(upRight);
        path.add(Rightup);
        if (Rightup.x <= r && getPath(r, c, path, grid)) return true;
        else path.remove(Rightup);
        return false;
    }
}

//You do not need to change any code below. 
class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

