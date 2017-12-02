public class DaoDriver {
    public static void main(String[] args){
        // 接口实现关系下  多态
        Dao userDao = new UserDao();
        userDao.add(1);
    }
}

interface Dao{
    public void add(int user_id);
}
class UserDao implements Dao{
    public void add(int user_id){
        System.out.println("添加用户"+user_id);
    }
}