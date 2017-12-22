import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DirectionKey {
    JFrame jFrame = new JFrame("方向控制器");
    JButton button = new JButton("方向按钮");
    Snake snake = new Snake();
    public void initButton(){
        jFrame.add(new JButton("↑"), BorderLayout.NORTH);
        jFrame.add(new JButton("↓"),BorderLayout.SOUTH);
        jFrame.add(new JButton("←"),BorderLayout.WEST);
        jFrame.add(new JButton("→"),BorderLayout.EAST);

        jFrame.add(button);
        jFrame.setVisible(true);
        // 获取屏幕分辨率
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 获取屏幕分辨率
        Dimension dimension = toolkit.getScreenSize();
        int x = (int)dimension.getWidth();
        int y = (int)dimension.getHeight();
        jFrame.setBounds((x-300)/2,(y-200)/2,300,200);
    }
    public void addEvent(){
        // 给按钮添加事件监听器
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode =  e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        snake.changeDirection(snake.DIRECTION_UP);
                        System.out.println("up");
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.changeDirection(snake.DIRECTION_DOWN);
                        System.out.println("down");
                        break;
                    case KeyEvent.VK_LEFT:
                        snake.changeDirection(snake.DIRECTION_LEFT);
                        System.out.println("left");
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.changeDirection(snake.DIRECTION_RIGHT);
                        System.out.println("right");
                        break;
                    default:
                        break;
                }
                snake.move();
                // 每行走一步，判断是否结束
                snake.GameOver();
                if(snake.isGameOver == true){
                    System.out.println("游戏结束");
                    // snake.refresh();
                    // System.exit(0);     // 退出游戏
                }
                // 刷新
               // snake.refresh();
            }
        });
    }

}
