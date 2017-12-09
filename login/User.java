package login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

class User {
    private String name;
    private String password;

    public User(String name,String password){
        super();
        this.name = name;
        this.password = password;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User user = (User)obj;
            return this.name.equals(user.name) && this.password.equals(user.password);
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        // return super.toString();
        return "name: "+this.name + "\npassword "+this.password;
    }
}

class LoginPage{
    private static Collection users = new ArrayList();
    // 创建集合对象用于存储用户数据
    private static Scanner scanner = new Scanner(System.in);
    static void index(){
        while (true){
            System.out.println("请选择 A(注册) B(登录)");
            String option = scanner.next();
            if("A".equalsIgnoreCase(option)){
                addUser();
            }else if("B".equalsIgnoreCase(option)){
                checkUser();
            }else {
                System.out.println("输入有误");
            }
        }
    }

    private static void checkUser() {
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();

        // collectionCheck(name,password);
        iteratorCheck(name, password);
    }

    private static void iteratorCheck(String name, String password) {
        Iterator it = users.iterator();     // 获取迭代器
        boolean isLogin = false;
        while(it.hasNext()){
            User user = (User)it.next();
            if(user.getName().equals(name) && user.getPassword().equals(password)) {
                isLogin = true;
                break;
            }
        }
        if(isLogin){
            System.out.println(" 登陆成功");
        }else{
            System.out.println("用户名不存在或密码错误");
        }
    }

    private static void collectionCheck(String name,String password) {
        User user = new User(name,password);
        if(users.contains(user)){
            System.out.println("登陆成功 "+user);
            System.exit(0);
        }else{
            System.out.println("用户名或密码错误");
        }
    }

    private static void addUser() {
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        // 创建用户信息
        User user = new User(name,password);
        System.out.println("注册成功 "+user);
        users.add(user);
    }

}
class LoginDriver{
    public static void main(String[] args) {
        LoginPage.index();
    }
}


