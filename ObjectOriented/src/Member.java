public class Member {
    String userName;
    private String sex;
    int salary;

    public void meet(){
        System.out.println("name："+userName+"\tsex: "+sex+"\tsalary: "+salary);
    }

    public void setSex(String sex){
        if(sex.equals("男") || sex.equals("女")){
            this.sex = sex;
        }else{
            this.sex = "男";
        }
    }
}
