import javax.swing.*;
import java.awt.*;

public class JPGraph extends JPanel {
    // color constants
    static final Color backGround = new Color(0,0,0);
    static final Color dotColor = new Color(100,100,255);

    PGraph p;
    //accepts a polar graph for it instance var
    public JPGraph(PGraph p){
        super();
        setBackground(backGround);
        this.p = p;
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
        for(int i = 0; i < XYCoords.length; i++){

            //draw circle of size s with a center at given XY coord for each index

            //width and height here are for testing purposes only
            //g2.drawOval(XYCoords[i].x, XYCoords[i].y, 15,15);
            g2.setColor(dotColor);
            if(i % 44 == 30){
                g2.setColor(new Color(255,0,0));
            }
            g2.fillOval(XYCoords[i].x, XYCoords[i].y, 10,10);
            if(i % 44 == 0){
                g2.setColor(dotColor);
            }
            //make 1 out of every 44 dots red (should highlight an arm)

        }

        // use pgraph coordinates to draw some path that text should display along
    }


}