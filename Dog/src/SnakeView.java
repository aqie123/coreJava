import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class SnakeView extends JPanel{
    public static void main(String[] args) throws InterruptedException {
        SnakeView sv = new SnakeView();
        JFrame frame = new JFrame("贪吃蛇");
        frame.add(sv);
        frame.setSize(CELLWIDTH*WIDTH,CELLHEIGHT*HEIGHT);
        frame.setVisible(true);
        sv.initEnvironment();
        sv.initSnake();
        sv.createFood();


        JFrame jFrame = new JFrame("方向控制器");
        jFrame.add(new JButton("↑"),BorderLayout.NORTH);
        jFrame.add(new JButton("↓"),BorderLayout.SOUTH);
        jFrame.add(new JButton("←"),BorderLayout.WEST);
        jFrame.add(new JButton("→"),BorderLayout.EAST);
        JButton button = new JButton("方向按钮");
        jFrame.add(button);
        // 给按钮添加事件监听器
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               int keyCode =  e.getKeyCode();
               switch (keyCode){
                   case KeyEvent.VK_UP:
                       sv.changeDirection(DIRECTION_UP);
                       System.out.println("up");
                       break;
                   case KeyEvent.VK_DOWN:
                       sv.changeDirection(DIRECTION_DOWN);
                       System.out.println("down");
                       break;
                   case KeyEvent.VK_LEFT:
                       sv.changeDirection(DIRECTION_LEFT);
                       System.out.println("left");
                       break;
                   case KeyEvent.VK_RIGHT:
                       sv.changeDirection(DIRECTION_RIGHT);
                       System.out.println("right");
                       break;
                   default:
                       break;
               }
               sv.move();
               // 每行走一步，判断是否结束
               sv.GameOver();
               if(sv.isGameOver == true){
                    System.out.println("游戏结束");
                    sv.refresh();
                    // System.exit(0);     // 退出游戏
               }
               // 刷新
               sv.refresh();
            }
        });
        jFrame.setSize(300,300);
        jFrame.setVisible(true);

    }
    // 地图宽
    private static final int WIDTH= 41;
    // 地图高
    private static final int HEIGHT = 42;

    // 格子宽
    private static final int CELLWIDTH = 20;

    // 格子高
    private static final int CELLHEIGHT = 20;

    // 游戏是否结束
    private boolean isGameOver = false;

    // 地图二维数组
    private boolean[][] environment = new boolean[HEIGHT][WIDTH];

    // 初始化地图
    private void initEnvironment(){
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
        super.paint(g);
        // 使用画笔画矩形   绘制背景
        for(int i = 0;i<HEIGHT;i++){
            for(int j = 0;j<WIDTH;j++){
                if(environment[i][j]){      // true 灰色
                    g.setColor(Color.GRAY);
                }else{                      // false 白色
                    g.setColor(Color.WHITE);
                }
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
        // 绘制食物
        g.setColor(Color.YELLOW);
        g.fill3DRect(food.x*CELLWIDTH,food.y*CELLHEIGHT,CELLWIDTH,CELLHEIGHT,true);
    }

    // 蛇
    private LinkedList<Point> snakes = new LinkedList<>();

    // 食物
    private Point food;

    // 生成食物
    public void createFood(){
        Random random = new Random();
        while(true){
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            if(!environment[y][x]){
                food = new Point(x,y);
                break;
            }
        }
    }

    // 吃食物
    private boolean eatFood(){
        // 获取蛇头位置
        Point head = snakes.getFirst();
        return head.equals(food);
    }

    // 当前方向
    private int currentDirection = 2;
    private static final int DIRECTION_UP = 1;
    private static final int DIRECTION_DOWN = -1;
    private static final int DIRECTION_LEFT = 2;
    private static final int DIRECTION_RIGHT = -2;

    // 初始化蛇节点
    private void initSnake(){
        int x = WIDTH/2;
        int y = HEIGHT/2;
        snakes.addFirst(new Point(x-1,y));
        snakes.addFirst(new Point(x,y));
        snakes.addFirst(new Point(x+1,y));
    }

    // 蛇移动根据当前方向移动
    private void move(){
        // 获取原始头位置
        Point head = snakes.getFirst();
        switch (currentDirection){
            case DIRECTION_UP:
                snakes.addFirst(new Point(head.x,head.y-1));
                break;
            case DIRECTION_DOWN:
                snakes.addFirst(new Point(head.x,head.y+1));
                break;
            case DIRECTION_LEFT:
                snakes.addFirst(new Point(head.x-1,head.y));
                break;
            case DIRECTION_RIGHT:
                snakes.addFirst(new Point(head.x+1,head.y));
                break;
        }
        if(eatFood()){
            createFood();
        }else{
            // 删除蛇尾
            snakes.removeLast();
        }
    }

    // 改变蛇方向
    private void changeDirection(int newDirection){
        if((newDirection + currentDirection) != 0){
            this.currentDirection = newDirection;
        }
    }


    // 刷新游戏
    private void refresh(){
        // todo
        // paint();
    }
    // 游戏结束
    private void GameOver(){
        // 撞墙
        Point head = snakes.getFirst();
        if(environment[head.y][head.x]){
            System.out.println("撞墙");
            isGameOver = true;
        }
        // 咬到自己
        for(int i = 1;i<snakes.size();i++){
            Point body = snakes.get(i);
            if(body.equals(head)){
                System.out.println("咬到自己");
                isGameOver = true;
            }
        }
    }

}
