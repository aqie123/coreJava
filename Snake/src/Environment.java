public class Environment {
    // 地图宽
    public static final int WIDTH= 41;
    // 地图高
    public static final int HEIGHT = 42;
    // 地图二维数组
    public boolean[][] environment = new boolean[HEIGHT][WIDTH];

    // 格子宽
    public static final int CELLWIDTH = 20;

    // 格子高
    public static final int CELLHEIGHT = 20;


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

}
