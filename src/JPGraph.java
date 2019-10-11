import javax.swing.*;
import java.awt.*;

public class JPGraph extends JComponent {
    PGraph p;
    static final Color backGround = new Color(0,0,0);
    static final Color dotColor = new Color(100,100,255);

    public JPGraph(PGraph p){
        super();
        setBackground(backGround);
        setOpaque(true);
        this.p = p;
    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        setPreferredSize(new Dimension(1280, 720));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        Graphics2D g2 = (Graphics2D) g;
        //sets the origin of the pGraph's converted xy coords to somewhere near the bottom left of the screen
        Point[] XYCoords = p.getXYCoords(this.getWidth()/3, this.getHeight() - this.getHeight()/10);
        for(int i = 0; i < XYCoords.length; i++){

            //draw circle of size s with a center at given XY coord for each index

            //width and height here are for testing purposes only
            //g2.drawOval(XYCoords[i].x, XYCoords[i].y, 15,15);
            g2.setColor(dotColor);
            g2.fillOval(XYCoords[i].x, XYCoords[i].y, 10,10);
        }

        // use pgraph coordinates to draw some path that text should display along
    }


}