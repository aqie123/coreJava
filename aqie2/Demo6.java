package aqie2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

// 定义工厂方法可以产生任何类型的对象
public class Demo6 {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Test6 t = new Test6();
        t.method();
    }

}

class Test6{
    void method() throws NoSuchMethodException, IOException, InstantiationException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Person p = (Person) newInstance();
        System.out.println(p);
        System.out.println(p.id);
        System.out.println(p.name);
    }
    public static Object newInstance() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        String fileName = "D:\\coreJava\\coreJava\\static\\config\\car.config";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        // 读取完整类名
        String className = bufferedReader.readLine();
        // 根据类名获取class对象
        Class clazz = Class.forName(className);
        // clazz.newInstance();             // 创建无参对象
        // 获取无参构造函数
        Constructor constructor = clazz.getConstructor(null);
        // 创建对象
        Object o = constructor.newInstance(null);
        // 读取配置文件 然后将对象属性数据 封装到对象中
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            String[] datas = line.split("=");
            Field field = clazz.getDeclaredField(datas[0]);
            field.setAccessible(true);
            if(field.getType() == int.class){
                // Integer.parseInt(String)就是将String字符类型数据转换为Integer整型数据
                field.set(o,Integer.parseInt(datas[1]));
            }else{
                field.set(o,datas[1]);
            }
        }
        return o;
    }
}