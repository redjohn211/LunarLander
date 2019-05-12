import java.awt.*;


public class Obstacle {

    private Polygon region;


    public Obstacle(Point left, Point top, Point right) {
        Point left1 = left;
        Point top1 = top;
        Point right1 = right;
        int[] xpoints = new int[]{(int) left.getX(), (int) top.getX(), (int) right.getX()};
        int[] ypoints = new int[]{(int) left.getY(), (int) top.getY(), (int) right.getY()};
        region = new Polygon(xpoints, ypoints, 3);

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(region);

    }

    private boolean contain(Point p) {
        return region.contains(p);
    }

    public boolean touch(Rocket rocket){
        return contain(rocket.bottomLeft()) || contain(rocket.bottomRight());
    }
}