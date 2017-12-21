package aqie2;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

public class Demo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Test4 t = new Test4();
        // t.method();
        // t.method2();
        // t.method3();
        t.method4();
    }
}

class Test4{
    void method() throws ClassNotFoundException {
        // 方式一
        Class clazz = Class.forName("aqie2.Person");
        System.out.println("类名 "+ clazz.getSimpleName());
        // 方式二
        Class clazz1 = Person.class;
        System.out.println("同一个对象 "+(clazz1 == clazz));

        // 方式三
        Class clazz2 = new Person(2,"aqie").getClass();
        System.out.println("同一个对象 "+(clazz1 == clazz2));
    }

    // 通过class对象找到所有构造方法
    void method2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取对象
        Class clazz = Class.forName("aqie2.Person");
        // 只能获取到公共的构造函数
        // Constructor[] constructors  = clazz.getConstructors();
        // 获取到所有构造函数
        Constructor[] constructors  = clazz.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            // System.out.println(constructor);
        }
        // 获取到单个构造函数
        Constructor constructor = clazz.getConstructor(int.class,String.class);
        System.out.println(constructor);
        // 通过constructor创建对象
        Person p = (Person) constructor.newInstance(1,"aqie");
        System.out.println(p);

        // 获取单个私有构造函数
        Constructor constructor2 = clazz.getDeclaredConstructor(String.class);
        // 设置构造函数访问权限 (暴力反射)
        constructor2.setAccessible(true);
        Person p2 = (Person)constructor2.newInstance("啊切");
        System.out.println(p2);
    }

    void method3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("aqie2.Person");
        // 获取所有公共的方法,包括继承下来的方法
        // Method[] methods = clazz.getMethods();                  // 12
        // 获取所有的方法,但是不包括继承下来的方法
        Method[] methods = clazz.getDeclaredMethods();      // 8
        for (Method method : methods){
            // System.out.println(method);
        }

        // 获取单个方法 (参数方法名,形参列表)
        Method method = clazz.getMethod("eat",int.class);
        // 执行方法(方法调用者对象,方法执行所需要参数)
        Person p = new Person(1,"ming");
        method.invoke(p,5);

        // 再次获取同名方法
        Method method1 = clazz.getMethod("eat",int.class,String[].class);
        method1.invoke(p,3,new String []{"a","b"});

        // 获取静态方法
        Method method2 = clazz.getMethod("sleep",int.class);
        method2.invoke(null,8);

        // 获取私有方法
        Method method3 = clazz.getDeclaredMethod("study",null);
        // 设置方法访问权限
        method3.setAccessible(true);
        method3.invoke(p,null);
    }

    void method4() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("aqie2.Person");
        // 只获取public该类public成员变量
        // Field [] fields = clazz.getFields();
        // 获取该类所有成员变量
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            // System.out.println(field);
        }
        Person p = new Person(1,"aqie");
        // 获取指定成员变量
        Field nameField = clazz.getDeclaredField("name");
        // 第一个参数：对象  第二个参数：成变员量的值
        nameField.set(p,"aqie123");
        System.out.println(p);
    }
}
