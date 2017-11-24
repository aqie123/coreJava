import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class BaseLearn {
    // 声明int数组变量

    // 创建大小为7数组,并赋值
    void learn(){

        char[] helloArray = {'h','e','l','l','o'};
        // string类实例化
        String helloString = new String(helloArray);
        System.out.println(helloString);
        int[] nums = new int[] {1,2,3,4,5};
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i] + " ");
        }

        // foreach
        double[] myList = {5,4,3,2,1};
        for(double emelent:myList){
            System.out.println(emelent);
        }

        // 多维数组
        // 先创建一个一维数组,存储另一个数组的地址
        String str[][] = new String[2][3];
        str[0][0] = "Good";
        str[0][1] = "luck";
        str[1][0] = "to";
        str[1][1] = "you";
        str[1][2] = "!";
        System.out.println(str.length);
        System.out.println(str[0].length);
        // 00 01 02  10 11 12
        for (int x=0; x<str.length;x++){
            for(int y = 0;y<str[x].length;y++){
                System.out.println(str[x][y]);
            }
        }
    }

    void learn1(){
        int a = 3;
        byte b = 3;
        if(a == b){
            System.out.println("相等");
        }
        Foo c = new Foo();
        Foo d = new Foo();
        if(c == d){  // false
            System.out.println("c d相等");
        }
        if(c.equals(d)){  // false
            System.out.println("c d 对象相等");
        }
    }

    int learn3(int arg){
        arg = arg * 2;
        return arg;
    }

    void learn4(){
        int y = 7;
        for(int x = 1; x < 8; x++){
            y++;
            if(x > 4){
                System.out.println(++y );
            }
            if (y>14){
                System.out.println("x= " + x);
                break;
            }
        }
    }

    // 进制转换
    void learn5(){
        System.out.println(false);
        System.out.println('a');

        // 十进制转二进制
        System.out.println(Integer.toBinaryString(-11));
        // ob开头就是二进制
        System.out.println(0b1011); // 11
        // 0开头就是八进制
        System.out.println(013); // 11
        // 0x开头是16进制
        System.out.println(0x19);  // 25

        char c = 'a';
        System.out.println((int)c);  // 97
        System.out.println(c+1);  // 98
        byte a = 7;
        System.out.println(a);
        System.out.println("Hello \r world");


    }

    void learn6() throws IOException{
        // 文件写入文字
         File file = new File("D:\\coreJava\\coreJava\\note\\test.md");
         // 建立数据输出通道
        FileWriter out = new FileWriter(file);
        // 编写数据
        out.write("文件写入文字");
        out.close();
    }

    void learn7(){
        // 取模结果正负取决于被除数
        System.out.println(10%3); // 取余 1
        System.out.println(10%-3); // 取余 1
        System.out.println(-10%3); // 取余 -1
        System.out.println(-10%-3); // 取余 -1

    }
    void learn8(){
        System.out.println(6&3); // 2 与
        System.out.println(6|3); // 7
        System.out.println(6^3); // 5
        System.out.println(63); // 2
    }

    // 交换两个数值,不能使用变量
    void learn9(){

        int a = 3;
        int b = 4;
        // 1.方法一 (相加, 缺陷:int相加超出int标识范围)
        a = a + b;
        b = a - b;
        a = a - b;
        // 方法二 (异或)
        a = a ^b;  // 3^4
        b = a^b;   // 3^4^4   = 3
        a = a^b;   // 3^4^3   = 4
    }


    void learn10(){
        // 取出下面二进制数据低四位数据
       //  00000000-00010000-00110000-11000111 和 00001111 & 运算

        // 最高效率求出2*8的结果
        System.out.println(2<<3);
    }

    // 键盘输入数字,输出响应星期
    void learn11(){
        // 创建扫描器对象
        Scanner scanner = new Scanner(System.in);
        // 扫描是否输入数据
        int num = scanner.nextInt();
        System.out.println("用户输入数据:" + num);

        String line = scanner.next();
        System.out.println("abc" == line);
        System.out.println("abc".equals(line));
    }

    // 输入月份判断季节
    void learn12(){
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch(option){
            case 12:
            case 1:
            case 2:
                System.out.println("冬天");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春天");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏天");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋天");
                break;
            default:
                System.out.println("您的选择有误");
                break;
        }
        if(option == 3){
            System.out.println("you got it");
        }
    }

    // while 计算1-100总和
    void learn13(){
        int count = 0,sum = 0;
        while(count < 100){
            count++;
            sum = sum + count;
        }
        System.out.println(sum);
    }

    //while 计算  1-100 7的倍数总和
    void learn14(){
        int count = 0,sum = 0;
        while(count < 100){
            count++;
            if(count %7 == 0){
                sum = sum + count;
            }
        }
        System.out.println(sum);
    }

    // simulate guess number game
    void learn15(){
        Random random = new Random();
        int number = random.nextInt(11); // [0,n-1)
        System.out.println("random number:"+ number);
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(true){
            count++;
            if(count>3){
                System.out.println("run out of your numbers");
                break;
            }
            System.out.println("please input your number!");
            int guessNum = scanner.nextInt();
            // compare two number
            if(guessNum > number){
                System.out.println("The number you guessed is bigger " +
                        "than the predetermined number");
            }else if(guessNum < number){
                System.out.println("The number you guessed is smaller " +
                        "than the predetermined number");
            }else{
                System.out.println("you got it!");
                break;
            }

        }





    }

    void learn16(){
        int num = -1;
        do{
            System.out.println(num);
            num--;
        }while(num>0);
    }

    // do while 计算 1-100 所有奇数和
    void learn17(){
        int i = 100,sum = 0;
        do{
            i--;
            if(i%2 == 1){
                sum = sum + i;
            }

        }while(i>=1);
        System.out.println(sum);
    }

    // for 计算1-100和
    void learn18(){
        int sum = 0;
        for(int i = 0;i<=100;i++){
            sum = sum + i;
        }
        System.out.println(sum);
    }

    // for 打印 四行六列
    void learn19(){
        for(int i = 0;i<4;i++){
            for(int j = 0;j<6;j++){
                System.out.print('*');
            }
            System.out.println();
        }

    }

    // for 打印正立三角形
    void learn20(){
        for(int i = 0;i<5;i++){  // 行数
            for(int j = 0; j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

    // for (continue print multiplication)
    void learn21(){
        for(int i = 1;i<=9;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+" " );
            }
            System.out.println();
        }
    }

    // reverse print 9*9
    void learn22(){
        for(int i = 9;i>=0;i--){
            for(int j = i;j>=1;j--){
                System.out.print(i+"*"+j+"="+i*j+" " );
            }
            System.out.println();
        }
    }

    // wrong print 9*9
    void learn23(){
        for(int i = 0;i<=9;i++){
            for(int j = 9;j>9-i;j--){
                System.out.print(i+"*"+j+"="+i*j+"\t" );
            }
            System.out.println();
        }
    }

    void learn24(){
        AAA:for(int i=0; i<3;i++){
            BBB:for(int j=0; j<5;j++){
                System.out.println("hello world");
                break AAA;
            }
        }
    }

    void learn25(){
        AAA:for(int i=0; i<3;i++){
            BBB:for(int j=0; j<2;j++){
                /*
                if(i==1){     // j=1  3*1; i=1 2*2
                    continue;
                }
                */

                System.out.println("hello world");
                continue AAA;  // 默认跳过当前所在循环语句
            }
        }
    }

    // 接收数组对象,将最大值返回
     void learn26(){
        int[] arr = {5,7,2,8,1,9,3};
        int tmp = 0;
        for(int element:arr){
            if(tmp < element){
                tmp = element;
            }
        }
        // return tmp;
         System.out.println(tmp);
    }

    // 接收数组对象,将最大值放到首位
    void learn27(){
        int[] arr = {5,7,2,8,1,9,3};
        for(int i=0;i<arr.length;i++){
            if(arr[0] < arr[i]){
                int tmp = arr[i];
                arr[i] = arr[0];
                arr[0] = tmp;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    // 选择排序
    void learn28(){
        int[] arr = {5,7,2,8,1,9,3};
        for(int j=0;j<arr.length-1;j++){
            // 最大值放在0号位置
            for(int i = j+1;i<arr.length;i++){
                if(arr[j]<arr[i]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 冒泡排序
    void learn29(){
        int[] arr = {5,7,2,8,1,9,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr){
        w:for(int i=0;i<arr.length-1;i++){
            boolean flag = false;
            m:for(int j = 0; j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break w;
            }
        }
    }


    void learn30(){
        int[] arr = {5,7,2,8,1,9,3};
        System.out.println(binaryFind(arr,81,0,6));
    }

    // 二分查找
    public int binaryFind(int[] arr,int val,int begin,int end){
        if(begin > end){
            return -1;
        }
        int mid = (begin + end)/2;
        int mid_value = arr[mid];
        if(mid_value == val){
            return mid;
        }else if(mid_value > val){
            return this.binaryFind( arr,val,begin,mid-1);
        }else{
            return this.binaryFind( arr,val,mid+1,end);
        }
    }

    // 数组反转
    void learn31(){
        char[] arr = {'绿','企','创','业'};
        reverseArr(arr);
        System.out.println(arr);
    }

    public char[] reverseArr(char[] arr){
        for(int startIndex = 0,endIndex=arr.length-1;startIndex<endIndex;startIndex++,endIndex--){
            char tmp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = tmp;
        }
        return arr;
    }

    // int 数组必须转换为字符串
    void learn32(){
        int[] arr = {5,7,2,8,1,9,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 清除数组中元素0，非零数组存储到新数组中
    void learn33(){
        int oldArr[] = {1,3,5,6,0,1,0,2,0,2};
        int newArr[] = clearZero(oldArr);
        System.out.println(Arrays.toString(newArr));
    }
    public int[] clearZero(int[] arr){
        // 统计0个数
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                count++;
            }
        }
        int newArr[] = new int[arr.length-count];
        int index = 0;
        // 遍历旧的数组，将非零数据存储到新数组中
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                continue;
            }
            // 非零数据存储到新数组中
            newArr[index++] = arr[i];
        }
        return newArr;


    }

    // 清除重复元素,不重复元素保存到新数组,且不能浪费长度
    void learn34(){
        int oldArr[] = {1,1,2,2,3,3,3,4};
        int newArr[] = clearDuplicate(oldArr);
        System.out.println(Arrays.toString(newArr));
    }

    public int[] clearDuplicate(int arr[]){
        // 选择排序
        int count = 0;
        // 新数组索引值
        int index = 0;
        // 计算出重复元素个数
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    count++;
                    break; // Marrow
                }
            }
        }

        int newArr[] = new int[arr.length-count];
        // 遍历旧数组,判断新数组是否存在
        for(int k=0;k<arr.length;k++){
            // 用于标识取出元素是否存在新数组
            boolean flag = false;
            int tmp = arr[k];
            for(int j=0;j<newArr.length;j++){
                if(newArr[j] == tmp){
                    flag = true;
                    break;  // Marrow
                }
            }
            // 该元素不存在新数组中
            if(!flag){
                newArr[index++] = arr[k];
            }
        }
        return newArr;
    }

    // 用户输入班级人数,依次输入每个同学成绩,输入完毕，如果及格率没有达到
    // 60%,则为每个不及格同学加2分,知道及格率达到60%
    void learn35(){
        int[] arr = readyData();
        double rate = getRate(arr);
        while(true){
            if(rate<0.6){
                for(int i=0;i<arr.length;i++){
                    if(arr[i]<60){
                        arr[i] = arr[i] +2;
                    }
                }
                // 重新计算及格率
                rate = getRate(arr);
            }else {
                break;
            }
        }

        System.out.println("及格率："+rate+"数组元素是："+Arrays.toString(arr));
    }

    // 准备数据
    public int[] readyData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入班级人数:");
        int count = scanner.nextInt();

        // 创建一个数组对象
        int[] arr = new int[count];

        // 录入学生成绩
        for(int i = 0;i<count;i++){
            System.out.println("请输入学生成绩:");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // 计算及格率
    public double getRate(int[] arr){
        // 定义及格人数
        double count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=60){
                count++;
            }
        }
        double rate =  count/arr.length;
        return rate;
    }

}
