import javax.swing.*;
import java.awt.*;

public class DrawPicture extends JPanel {
    // 内部维护  环境对象 snake对象
    Environment e = new Environment();
    Snake snake = Snake.getInstance();
    Food f= new Food();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 初始化地图
        e.initEnvironment();

        // 使用画笔画矩形   绘制背景
        for(int i = 0;i<e.HEIGHT;i++){
            for(int j = 0;j<e.WIDTH;j++){
                if(e.environment[i][j]){      // true 灰色
                    g.setColor(Color.GRAY);
                }else{                      // false 白色
                    g.setColor(Color.WHITE);
                }
                g.fill3DRect(i*e.CELLWIDTH,j*e.CELLHEIGHT,e.CELLWIDTH,e.CELLHEIGHT,true);

            }
        }
        // 画snake head
        Point head = snake.snakes.getFirst();
        g.setColor(Color.RED);
        g.fill3DRect(head.x*e.CELLWIDTH,head.y*e.CELLHEIGHT,e.CELLWIDTH,e.CELLHEIGHT,true);
        // snake body
        g.setColor(Color.BLACK);
        for(int i = 1;i<snake.snakes.size();i++){
            Point body = snake.snakes.get(i);
            g.fill3DRect(body.x*e.CELLWIDTH,body.y*e.CELLHEIGHT,e.CELLWIDTH,e.CELLHEIGHT,true);
        }
        // 绘制food
        g.setColor(Color.YELLOW);
        g.fill3DRect(f.food.x*e.CELLWIDTH,f.food.y*e.CELLHEIGHT,e.CELLWIDTH,e.CELLHEIGHT,true);
    }
}
