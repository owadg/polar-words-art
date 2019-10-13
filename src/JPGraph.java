import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class JPGraph extends JPanel {
    // color constants
    static final Color backGround = new Color(0,0,0);
    static final Color dotColor = new Color(100,100,255);
    Point center;

    //magic number is 25

    PGraph p;
    String s;

    //accepts a polar graph for it instance var
    public JPGraph(PGraph p){
        super();
        setBackground(backGround);
        this.p = p;
        s = "|| ";
        center = new Point(this.getWidth()/3, this.getHeight() - this.getHeight()/9);
    }

    public void setString(String str){
        s =  str;
    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        setPreferredSize(new Dimension(1280, 720));
    }

    public void paintComponent(Graphics g){
        Point center = new Point(this.getWidth()/3, this.getHeight() - this.getHeight()/9);
        //painting background is why i call that
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        //sets the origin of the pGraph's converted xy coords to somewhere near the bottom left of the screen
        Point[] XYCoords = p.getXYCoords(center.x, center.y);

        //var for manipulating rotation for string
        double degree = 0;


        //draws text first
        //conditional statement is such because it doesnt use the outside ring
        g2.setColor(Color.YELLOW);
        for(int i = 0; i < XYCoords.length - 45; i++) {
            if(i%11 == 0) {
               // System.out.println("next module curve: " +equivalentNextModuloClass + "current curve: " + i + "compared to: " + (i%44)*(44)+ "\n");
                drawRotatedChar(g2, XYCoords[i], XYCoords[i + 44], XYCoords[i + 19], s.substring(i % s.length(), (i % s.length()) + 1), i, center);
                System.out.println(s.substring(i % s.length(), i % s.length() + 1));
            }
        }


        //draws dots
        g2.setColor(dotColor);
        for(int i = 0; i < XYCoords.length; i++){
            /*
            if(i%44 == 0){
                g2.setColor(Color.RED);
                System.out.println("r");
            }
            if((i+19)%44 == 0){
                g2.setColor(Color.YELLOW);
                System.out.println("y");
            }
            if((i+31)%44 == 0){
                System.out.println("g");
                g2.setColor(Color.GREEN);
            }
            */
            g2.fillOval(XYCoords[i].x, XYCoords[i].y, 10,10);
        }
    }

    /*
        location is the point that the thing is on
        nextInCurve is the point that will be next in the macro curve
        nextValue is just the next plotted value
        x is a string with only 1 character
    */
    public void drawRotatedChar(Graphics2D g2, Point location, Point nextInCurve, Point nextValue, String x, int i, Point center){
        System.out.println("drawing rotated");

        // find height using the distance to the next point in the series
        System.out.println("nextValue.x: " + nextValue.x + "\n" + "location.x: " + location.x + "\nnextValue.y: " + nextValue.y + "\n" + "location.y: " + location.y);
        //double height = Math.sqrt(Math.pow(nextValue.x - location.x, 2) - Math.pow(nextValue.y - location.y, 2));
        double height = 0.025*i;

        //makes a font with the desired height (maybe) and sets it to the graphics object
        Font myFont = g2.getFont().deriveFont((float)height);
        g2.setFont(myFont);
        System.out.println("height: " + (float)height);


        // find angle using the horizontal and vertical components of the distance between the location and the next in the macrocurve
        double angle = (Math.atan2(nextInCurve.x - location.x, nextInCurve.y - location.y));
        System.out.println("angle: " + Math.toDegrees(angle));

        // rotates graphics for rendering rotated graphics and then rotates back
        AffineTransform old = g2.getTransform();
        g2.rotate(angle, center.x, center.y);
        g2.drawString(x, location.x, location.y);
        g2.setTransform(old);
    }
}