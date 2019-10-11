import javax.swing.*;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        int max = 10000;

        int[] pRGraphValues = new int[max];
        int[] pOGraphValues = new int[max];

        for (int i = 0; i < pRGraphValues.length; i++) {
            pOGraphValues[i] = i;
            pRGraphValues[i] = i;
        }

        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(new Dimension(1920, 1080));

        PGraph pGraph = new PGraph(pRGraphValues, pOGraphValues);
        JPGraph jpGraph = new JPGraph(pGraph);
        j.add(jpGraph);
        j.setVisible(true);

    }

}
