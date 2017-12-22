import java.awt.*;
import java.util.Random;

public class Food {
    Environment e = new Environment();
    // food
    public Point food;
    // 生成food
    public Food(){
        Random random = new Random();
        while(true){
            int x = random.nextInt(e.WIDTH);
            int y = random.nextInt(e.HEIGHT);
            if(!e.environment[y][x]){
                food = new Point(x,y);
                break;
            }
        }
    }

    public Food instance(){
        // food 类
        return new Food();
    }

}
