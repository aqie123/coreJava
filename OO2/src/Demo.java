import java.util.Arrays;

public class Demo {
    int x;
    public Demo(int x){
        this.x = x;
    }
    public static void  exchange(int a, int b){
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
        myPrint(a,b);
    }

    static void  myPrint(int a, int b){
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args){
        // 定义方法交换两个基本变量值
        int a = 3;
        int b = 4;
        Demo.exchange(a,b);
        //Demo.myPrint(a,b);

        // 定义函数交换数组元素位置
        int [] arr = {10,20,30};
        changeArr(arr,0,2);
        System.out.println(Arrays.toString(arr));

        Demo demo = new Demo(10);
        changeProperty(demo,20);
        System.out.println(demo.x);
    }
    public static void changeArr(int arr[],int index1,int index2){
        int tmp;
        tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    // 定义函数改变对象属性
    public static void changeProperty(Demo demo,int x){
        int tmp;
        tmp = x;
        x = demo.x;
        demo.x = tmp;
    }
}
