public class Test {
    public static final int WIDTH= 20;
    public static final int HEIGHT = 12;
    char[][] environment = new char[HEIGHT][WIDTH];
    public static void main(String[] args) {
        BackGround bg = new BackGround();
        // bg.method();
        // bg.method2();
        Test t = new Test();
        t.initEnvironment();
    }

    public void initEnvironment(){
        for(int rows = 0;rows < HEIGHT;rows++){
            for(int column = 0;column<WIDTH;column++){
                if(rows == 0 || rows == (HEIGHT-1) || column == 0 || column == (WIDTH-1)){
                    System.out.print('*');
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
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

    }
}
