
public class Outer {

    String name = "外部类";
    // 成员内部类
    static class Inner{
        //static int x = 10;
        String name = "内部类";
        public void print(){
            System.out.println(name+" print方法");
            //System.out.println(Outer.this.name+" print方法");
        }
    }
    public void newInstance(){
        Inner inner = new Inner();
        inner.print();
        //return inner;
    }
}

class OuterDriver{
    public static void main(String[] args){

        Outer outer = new Outer();
        //System.out.println(outer.name);
        // 创建内部类方法1
        // Outer.Inner inner =outer.new Inner();
        Outer.Inner inner =new Outer.Inner();


        // inner.print();

        // 创建内部类方法2
        //outer.newInstance().print();
        outer.newInstance();
        //System.out.println(outer.newInstance().name);
    }
}