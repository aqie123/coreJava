package aqie;
import java.util.*;

public class Demo21 {
    public static void main(String[] args) {
        Test21 t = new Test21();
        t.method();
        // t.method2();
        t.method3();
        t.method4();
    }
}

class Test21{
    // 增强for循环遍历set
    void method(){
        HashSet<String> set = new HashSet<>();
        set.add("张三");
        set.add("李四");
        set.add("王五");

        // 使用迭代器遍历 set
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            it.remove();            // 这个可以有

        }
        for(String ele : set){
            System.out.print(ele);
            // set.add("1");
        }
    }
    // 二进制转十进制
    void method2(){
        /*
        Scanner input = new Scanner( System.in );
        System.out.print("Enter a binary number: ");
        String binaryString =input.nextLine();
        */
        //String binaryString ="1001 0011 0100 1001 0010 0101 1100 1010 0010";
        String binaryString ="0011 0100 1001 0010 0101 11001010 0010";
        String str2 = binaryString.replaceAll(" ", "");

        System.out.println("Output: "+Long.toBinaryString(34));
    }

    // 增强for循环遍历数组
    void method3(){
        int[] arr = {1,2,3};
        for(int ele : arr){
            System.out.print(ele+"-");
        }
    }

    // 增强for循环遍历map    Map 没有实现Iterable接口
    void method4(){
        TreeMap<Integer,String> tree = new TreeMap<>();
        tree.put(1,"a");
        tree.put(2,"b");
        tree.put(3,"c");

        Set<Map.Entry<Integer,String>> entries =  tree.entrySet();  // 返回Set 集合

        for(Map.Entry<Integer,String> ele : entries){
            System.out.print("键"+ele.getKey() + "  值 "+ele.getValue());
        }
    }

}
