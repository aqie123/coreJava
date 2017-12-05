package aqie;

import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        Test test = new Test();
        // test.compare();
        // test.construct();
        // test.method2();
        // test.method3();
        // test.method4();
        test.method5();
        // System.out.println(Test.method6(" He ll o  "));
        // Test.fileName();
        // Test.reversal();
    }
}
class Test{
    void compare(){
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);   // true

        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println(str2 == str3);  // false
        System.out.println(str2.equals(str3));  // true  比较内容
        System.out.println(str3 == str4);  // false   堆内存不一致
        System.out.println(str3.equals(str4));  // true
    }

    void construct(){
        String str = new String(); // 创建空字符串对象

        byte[] buf = {97,98,99};   // 存储的字符对应ASC 码值
        str = new String(buf);
        System.out.println(str);

        str = new String(buf,1,2);
        System.out.println(str);

        char[] arr = {'a','q','i','e'};   // 传入字符串
        str = new String(arr);
        System.out.println(str);

        str = new String("字符串");
        System.out.println(str);
    }

    void method(){
        // 获取
        String str = "abc啊切abc";        // 中英文都是一个字符
        System.out.println(str.length());
        System.out.println(str.charAt(3)); // 啊
        System.out.println(str.indexOf('a')); // 0
        System.out.println(str.lastIndexOf('a')); // 5

    }

    void method2(){
        // 判断
        String str = "abc啊切abc hello ";
        String str2 = "Demo.java";
        String str3 = " ";          // false
        System.out.println(str2.endsWith("java")); // true

        // str3 = null; // 变量没指向任何变量,但使用对象方法 会报错
        System.out.println(str3.isEmpty()); // 5

        System.out.println(str.contains("hello")); // 5

        System.out.println("Demo.java".equals(str2));  // 常量在前永远不会报错

        System.out.println("Demo.Java".equalsIgnoreCase(str2));  // 验证码忽略大小写
    }

    // 字符数组 字节数组可以转换为字符串，反之亦可
    void  method3(){
        String str = "Somebody that i used to know";
        char [] arr = str.toCharArray(); // 字符串转换成一个字符数组
        System.out.println("字符数组元素为"+ Arrays.toString(arr));

        byte[] buff = str.getBytes();
        System.out.println("字节数组元素为 "+Arrays.toString(buff)); // ASC 码
    }

    void method4(){
        String str = " Hello World";
        // String str2 = str.replace('o','i');
        String str2 = str.replace("World","aqie");
        System.out.println(str2);

        String str3 = str.toLowerCase();
        System.out.println(str3);

        String str4 = str.trim();
        System.out.println(str4);

        String str6 = "Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday";
        String data[] = str6.split(",",4); // 字符串数组
        System.out.println(Arrays.toString(data));

        String str5 = str.substring(7,8);
        System.out.println(str5);
    }

    // 定义变量,记录两个字符串索引值,取出对应字符进行比较
    void method5(){
        // 类内部维护了字符数组,存储字符存储在字符数组,
        // 初始容量为16个字符,容量不够自动增长一倍 + 2
        StringBuffer str = new StringBuffer();
        str.append("java");
        str.append(true);
        str.insert(4,false);
        str.delete(4,9);
        str.append("!");  // 可以添加任意类型数据
        System.out.println(str.length());
        str.replace(0,4,"php");
        str.setCharAt(3,'T');
        System.out.println(str);
        System.out.println(str.substring(4,8));
    }

    // 实现trim
    static String method6(String str){
        // String str = " He ll o  ";
        System.out.println(str);
        int startIndex = 0;
        int endIndex = str.length() - 1;
        while(str.charAt(startIndex) == ' '){
            startIndex++;
        }
        while(str.charAt(endIndex) == ' '){
            endIndex--;
        }
        String result = str.substring(startIndex,endIndex+1);
        return result;
    }

    // 获取文件名
    static void fileName(){
        String path = "D:\\coreJava\\coreJava\\aqie.java";
        int index = path.lastIndexOf("\\");
        String result = path.substring(index+1); // 考虑本身长度
        System.out.println(result);
    }
    //字符串中对象反转
    static void reversal(){
        String str = "aqie";
        // 字符串转换为字符数组
        char[] arr = str.toCharArray();
        // 定义两个交换位置索引值
        int startIndex = 0;
        int endIndex = arr.length-1;
        while(startIndex < endIndex){
            char tmp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
        // 字节数组转换为字符串
        String result = new String(arr);
        System.out.println(result);
    }
}
