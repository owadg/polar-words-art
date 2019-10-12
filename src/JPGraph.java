import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class JPGraph extends JPanel {
    // color constants
    static final Color backGround = new Color(0,0,0);
    static final Color dotColor = new Color(100,100,255);

    PGraph p;
    String s;

    //accepts a polar graph for it instance var
    public JPGraph(PGraph p){
        super();
        setBackground(backGround);
        this.p = p;
        s = "Mathematica";
    }

    public void setString(String str){
        s =  str;
    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        setPreferredSize(new Dimension(1280, 720));
    }

    public void paintComponent(Graphics g){
        /* TODO
          add the text
          text should be added at a given point, rotated to match the slope the next residual modulus 44 class sequence
          height (and thus font) should match the distance between the current point and the next point
         */



        //painting background is why i call that
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //sets the origin of the pGraph's converted xy coords to somewhere near the bottom left of the screen
        Point[] XYCoords = p.getXYCoords(this.getWidth()/3, this.getHeight() - this.getHeight()/10);

        //var for manipulating rotation for string
        double degree = 0;


        //draws text first
        //conditional statement is such because it doesnt use the outside ring
        for(int i = 0; i < XYCoords.length - 44; i++) {
            drawRotatedChar(g2, XYCoords[i], XYCoords[i+44], XYCoords[i+1], s.substring(i%s.length(),i%s.length()+1));
        }


        //draws dots
        for(int i = 0; i < XYCoords.length; i++){

            //draw circle of size s with a center at given XY coord for each index

            //width and height here are for testing purposes only
            //g2.drawOval(XYCoords[i].x, XYCoords[i].y, 15,15);


            g2.setColor(dotColor);
            g2.fillOval(XYCoords[i].x, XYCoords[i].y, 10,10);

            //make 1 out of every 44 dots red (should highlight an arm)

        }

        // use pgraph coordinates to draw some path that text should display along
    }

    /*
        location is the point that the thing is on
        nextInCurve is the point that will be next in the macro curve
        nextValue is just the next plotted value
        x is a string with only 1 character
    */
    public void drawRotatedChar(Graphics2D g2, Point location, Point nextInCurve, Point nextValue, String x){
        // find height using the distance to the next point in the series
        double height = Math.sqrt(Math.pow(nextValue.x - location.x, 2) - Math.pow(nextValue.y - location.y, 2));

        //makes a font with the desired height (maybe) and sets it to the graphics object
        Font myFont = g2.getFont().deriveFont((float)height);
        g2.setFont(myFont);

        //prolly useless
//        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
//        float f = metrics.getHeight();

        // find angle using the horizontal and vertical components of the distance between the location and the next in the macrocurve
        double angle = Math.atan2(nextInCurve.x - location.x, nextInCurve.y - location.y);

        // rotates graphics for rendering rotated graphics and then rotates back
        AffineTransform old = g2.getTransform();
        g2.rotate(Math.toRadians(angle));
        g2.drawString(x, location.x, location.y);
        g2.setTransform(old);
    }
}