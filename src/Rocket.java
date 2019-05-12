import javax.swing.*;
import java.awt.*;

public class Rocket {

    private Rectangle region;
    private double x;
    private double y;
    private double changeX;
    private double changeY;
    private int fuel;
    private double maxY;
    private Point p;
    private Boolean Up, Right, Left;
    private ImageIcon rocket;

    Rocket(Point p){
        rocket = new ImageIcon("rocket.png");
        region = new Rectangle(p.x,p.y, 40, 40);
        x = 15;y = 15;changeX = 0;changeY= 0.02;fuel = 2000;maxY = -4;Up = false;Right = false;Left = false;
    }

    protected void move(){
        if (Up){moveUp();}
        if (Left){moveLeft();}
        if (Right){moveRight();}

        if (changeY<maxY){
            changeY = maxY;
        }
        x += changeX;
        y += changeY;
        region.x = (int)x;
        region.y = (int)y;

    }

    private void moveLeft(){ fuel --;
        changeY -= 0.1;
    }

    private void moveRight(){
        fuel --;
        changeX += 0.01;
    }private void moveUp(){
        fuel --;
        changeY -= 0.1;
    }


    protected int getFuel() {return fuel;
    }


    boolean badLand(){ return changeY>= 0.8;
    }


    protected Point bottomLeft()  { return new Point((int)x,(int)y+30); }
    protected Point bottomRight() { return new Point((int)x+30, (int)y+30); }


    protected void paint(Graphics g){
        g.drawImage(rocket.getImage(), (int)x, (int)y, region.width,region.height,null);
    }

    protected void setMoveUp(Boolean Up) {
        this.Up = Up;
    }

    protected void setMoveRight(Boolean Right) {
        this.Right = Right;
    }

    protected void setMoveLeft(Boolean Left) {
        this.Left = Left;
    }


    protected void FaultyLand(){
        rocket = new ImageIcon("crash.jpg");
        JOptionPane.showMessageDialog(null, "Bad Land");
    }
    protected void Win(){
        rocket = new ImageIcon("landed.jpg");
        JOptionPane.showMessageDialog(null, "Mission Accomplished");
    }

}