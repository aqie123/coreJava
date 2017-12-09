package aqie;

public class Demo2 {
    public static void main(String[] args) {
        User user = new User("aqie","123");
        User user2 = new User("aqie","123");
        System.out.println(user);
        System.out.println(user.equals(user2));
    }
}

class User{
    String name = "aqie";
    String password = "123";
    int age  = 10;
    public User(String name,String password){
        super();
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "userName: "+name + " age: "+age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User user = (User)obj;
            // 多态进行类型强转,用到子类信息
            return this.name.equals(user.name) && this.password.equals(user.password);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        return this.name.hashCode()+this.password.hashCode();
    }
}
