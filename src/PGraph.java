import java.awt.*;

public class PGraph {
    // r and o must be the same length
    int[] r;
    int[] o;
    double scale;

    public PGraph(int[] r, int[] o){
        this.r = r;
        this.o = o;
        scale = 0.4;
    }

    public void setScale(double s){
        scale = s;
    }

    public Point[] getXYCoords(int xOffset, int yOffset){
        Point[] xqc = new Point[r.length];
        for(int i = 0; i < xqc.length; i++){
            //test coords below
            //System.out.println(scale*r[i]*Math.cos(o[i]) + " " + scale*r[i]*Math.sin(o[i]));

            //converts r and theta to xy coordinate space
            xqc[i] = new Point((int)(scale*r[i]*Math.cos(o[i])),(int)(scale*r[i]*Math.sin(o[i])));
            //offsets xy coordinate space
            xqc[i].setLocation(xqc[i].getX() + xOffset, xqc[i].getY() + yOffset);
        }
        return xqc;
    }
}