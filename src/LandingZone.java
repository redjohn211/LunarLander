import java.awt.*;

public class LandingZone {
    private Rectangle region;


    public LandingZone(Point p) {
        region = new Rectangle(p.x, p.y);

    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(20, 390, 30,10);

    }
    private boolean contain(Point p) {
        return region.contains(p);
    }

    public boolean touch(Rocket rocket){
        return contain(rocket.bottomLeft()) || contain(rocket.bottomRight());
    }
}
