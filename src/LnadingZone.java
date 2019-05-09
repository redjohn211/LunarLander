import java.awt.*;

public class LnadingZone {
    private Rectangle region;
    private Color color;
    private  Point center;
    LnadingZone(Point center){
        this.center = center;
       int size = 25;
        region = new Rectangle(center.x-size/2,center.y-size/2, size*3, size);
        /*Image img = new Image ("/image/rocket.png")
        region.setFill(new ImagePattern())*/
        color = color.RED;
    }
    protected void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(region.x,region.y, region.width,region.height);
    }

    public int top(){
    return region.y;}
}
