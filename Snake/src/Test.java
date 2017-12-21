import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Test {
    // 宽
    public static final int WIDTH= 20;
    // 高
    public static final int HEIGHT = 12;

    // 地图
    char[][] environment = new char[HEIGHT][WIDTH];

    public static void main(String[] args) {
        BackGround bg = new BackGround();
        //bg.method();
        bg.method2();
        Test t = new Test();

        t.initEnvironment();
        t.initSnake();
        t.showSnake();

        t.createFood();
        t.showFood();
        // 打印地图
        t.showEnvironment();

    }

    // 蛇
    LinkedList<Point> snakes = new LinkedList<>();
    // 初始化蛇节点
    public void initSnake(){
        int x = WIDTH/2;
        int y = HEIGHT/2;
        snakes.addFirst(new Point(x-1,y));
        snakes.addFirst(new Point(x,y));
        snakes.addFirst(new Point(x+1,y));
    }

    // 显示蛇 (蛇坐标显示到地图上)
    public void showSnake(){
        // 蛇头
        Point head = snakes.getFirst();
        environment[head.y][head.x] = '$';
        // 蛇身
        for(int i = 1;i<snakes.size();i++){
            Point body = snakes.get(i);
            environment[body.y][body.x] = '#';
        }
    }

    // 初始化地图
    public void initEnvironment(){
        for(int rows = 0;rows < HEIGHT;rows++){
            for(int column = 0;column<WIDTH;column++){
                if(rows == 0 || rows == (HEIGHT-1) || column == 0 || column == (WIDTH-1)){
                    // System.out.print('*');
                    environment[rows][column] = '*';
                }
            }
        }
    }

    // 显示地图
    public void showEnvironment(){
        for(int rows = 0;rows<HEIGHT;rows++){
            for(int cols = 0;cols<WIDTH;cols++){
                System.out.print(environment[rows][cols]);
            }
            System.out.println();
        }
    }

    // 食物
    Point food;

    // 生成食物
    public void createFood(){
        Random random = new Random();
        while(true){
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            if(environment[y][x] != '*'){
                food = new Point(x,y);
                break;
            }
        }

    }

    // 显示食物
    public void showFood(){
        environment[food.y][food.x] = '@';
    }
}

class BackGround{
    // 打印二维数组
    void method(){
        // 数组的数组，堆内存创建三个格子,分别记录三个内存地址
        // int[][] arr = new int[3][4];
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    void method2(){
        JFrame frame = new JFrame("画笔");
        Draw d = new Draw();
        frame.add(d);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}

class Draw extends JPanel{
    // Graphics 是一个画笔,可以画图形,也可以写文字
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 设置画笔颜色
        g.setColor(Color.GRAY);
        // 使用画笔画矩形
        g.fill3DRect(0,0,20,20,true);
        g.fill3DRect(20,0,20,20,true);

        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑",Font.BOLD,36));
        g.drawString("GAME OVER!",300,300);
    }
}
