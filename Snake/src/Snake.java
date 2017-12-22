import java.awt.*;
import java.util.LinkedList;

public class Snake {

    public Snake(){
        super();
        initSnake();
    }
    private static Snake snake = null;

    // 提供一个公共方法(必须和类名一致)
    public static Snake getInstance(){
        if(snake == null){
            synchronized ("锁"){
                if(snake == null){
                    snake = new Snake();
                }
            }
        }
        return snake;
    }
    Environment e = new Environment();
    Food f = new Food();
    DrawPicture dp = new DrawPicture();

    // snake
    public LinkedList<Point> snakes = new LinkedList<>();

    // 当前方向
    public int currentDirection = 2;
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_DOWN = -1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = -2;

    // 游戏是否结束
    public boolean isGameOver = false;

    // 初始化snake节点
    public void initSnake(){
        int x = e.WIDTH/2;
        int y = e.HEIGHT/2;
        snakes.addFirst(new Point(x-1,y));
        snakes.addFirst(new Point(x,y));
        snakes.addFirst(new Point(x+1,y));
    }
    // eat food
    public boolean eatFood(){
        // 获取snake 位置
        Point head = snakes.getFirst();
        return head.equals(f.food);
    }
    // snake移动根据当前方向移动
    public void move(){
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
            f.instance();
        }else{
            // 删除蛇尾
            snakes.removeLast();
        }
    }

    // 改变snake方向
    public void changeDirection(int newDirection){
        if((newDirection + currentDirection) != 0){
            this.currentDirection = newDirection;
        }
    }

    // 游戏结束
    public void GameOver(){
        // 撞墙
        Point head = snakes.getFirst();
        if(e.environment[head.y][head.x]){
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

    // 刷新游戏
    public void refresh(){
        // dp.repaint();
    }
}
