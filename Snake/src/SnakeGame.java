import javax.swing.*;
import java.awt.*;

public class SnakeGame {
    public static void main(String[] args) {
        SnakeGame sg = new SnakeGame();
        sg.background();
        DirectionKey dk = new DirectionKey();
        dk.initButton();
        dk.addEvent();
    }

    public void background(){
        DrawPicture drawPicture = new DrawPicture();
        Environment e = new Environment();

        JFrame frame = new JFrame("Gluttonous Snake");
        frame.setSize(e.CELLWIDTH*e.WIDTH,e.CELLHEIGHT*e.HEIGHT);
        frame.setVisible(true);
        frame.add(drawPicture);
    }




}
