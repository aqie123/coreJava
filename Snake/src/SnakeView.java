import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SnakeView extends JPanel{
    public static void main(String[] args) {
        SnakeView sv = new SnakeView();
        JFrame frame = new JFrame("贪吃蛇");
        frame.add(sv);
        frame.setSize(CELLWIDTH*WIDTH,CELLHEIGHT*HEIGHT);
        frame.setVisible(true);
        sv.initEnvironment();
        sv.initSnake();

    }
    // 宽
    public static final int WIDTH= 41;
    // 高
    public static final int HEIGHT = 42;

    //格子宽
    public static final int CELLWIDTH = 20;
    //高
    public static final int CELLHEIGHT = 20;

    // 地图
    boolean[][] environment = new boolean[HEIGHT][WIDTH];

    // 初始化地图
    public void initEnvironment(){
        for(int rows = 0;rows < HEIGHT;rows++){
            for(int column = 0;column<WIDTH;column++){
                if(rows == 0 || rows == (HEIGHT-1) || column == 0 || column == (WIDTH-1)){
                    environment[rows][column] = true;
                }else{
                    environment[rows][column] = false;
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0;i<HEIGHT;i++){
            for(int j = 0;j<WIDTH;j++){
                if(environment[i][j]){
                    g.setColor(Color.GRAY);
                }else{
                    g.setColor(Color.WHITE);
                }
                // 使用画笔画矩形
                g.fill3DRect(i*CELLWIDTH,j*CELLHEIGHT,CELLWIDTH,CELLHEIGHT,true);

            }
        }
        // 画蛇
        Point head = snakes.getFirst();
        g.setColor(Color.RED);
        g.fill3DRect(head.x*CELLWIDTH,head.y*CELLHEIGHT,CELLWIDTH,CELLHEIGHT,true);
        // 蛇身
        g.setColor(Color.GREEN);
        for(int i = 1;i<snakes.size();i++){
            Point body = snakes.get(i);
            g.fill3DRect(body.x*CELLWIDTH,body.y*CELLHEIGHT,CELLWIDTH,CELLHEIGHT,true);
        }
    }

    // 蛇
    private LinkedList<Point> snakes = new LinkedList<>();

    // 初始化蛇节点
    private void initSnake(){
        int x = WIDTH/2;
        int y = HEIGHT/2;
        snakes.addFirst(new Point(x-1,y));
        snakes.addFirst(new Point(x,y));
        snakes.addFirst(new Point(x+1,y));
    }

    // 向上移动


}
