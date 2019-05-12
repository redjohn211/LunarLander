import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class LaunchPanel extends JPanel {
private Rocket r;
private LandingZone l;
private ArrayList<Obstacle> mountains;
    private Point s;
public LaunchPanel(){

setPreferredSize(new Dimension(400,400));
    s = new Point(250, 250);
r = new Rocket(new Point(250,50));
mountains = new ArrayList<Obstacle>();
addKeyListener(new MoveRocket());
    setFocusable(true);
    setLandingSpace();
    generateMountains();


}
private void setLandingSpace(){


}

private void generateMountains(){

    for(int i = 0, j = 80; i < 4 ; i++,s.x+=80 ){
        Obstacle o = new Obstacle(s,s,s);
                j+=10;
        mountains.add(o);
    }
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        r.paint(g);
        l.paint(g);
        try{
            for(Obstacle o: mountains){
                o.paint(g);
            }
        }
        catch (ConcurrentModificationException c){}

        //r.setGravity();
        /*try {
            for (MovingDot d : dots) { d.paint(g); }
            for (Obstacle o : obstacles) { o.paint(g); } }

        catch (ConcurrentModificationException c){}*/
    }

    private class MoveRocket extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            //r.setGravity();
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                r.setMoveLeft(true);
                r.move(); }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) { r.setMoveRight(true);
            r.move();
            }
            if(e.getKeyCode() == KeyEvent.VK_UP){r.setMoveUp(true);
            r.move();}
            //if(e.getKeyCode() == KeyEvent.VK_DOWN){r.setCenterY(15);}
            repaint();
        }
    }
    private class Action implements Runnable {
private Rocket r;
private Obstacle o;
private LandingZone l;
    Action(Rocket r){
        this.r = r;
    }
private void action(){
        while(true){
            if(l.touch(r)){
                if(r.badLand()){
                r.FaultyLand();
            }
            else
                r.Win();
            }
            if(o.touch(r)){
                r.FaultyLand();
            }
            if(r.getFuel() < 0){
                r.FaultyLand();
            }


            repaint();
            try {
                Thread.sleep(15); }
            catch (InterruptedException e) {
                e.printStackTrace(); }
            repaint(); }
        }

        @Override
        public void run() {
            action();
        }

    }


    }


