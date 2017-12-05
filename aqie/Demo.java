package aqie;

public class Demo {
    public static void main(String[] args) {
        SumRuntime sumRuntime = new SumRuntime();
        // sumRuntime.getRunTime();
        Object o = new Object();
        System.out.println(o.toString());
        System.out.println(o); // 接收对象,调用 toString
    }
}

abstract class Runtime{
    public final void getRunTime(){
        // 运行前系统时间
        long startTime = System.currentTimeMillis();
        code();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间是: " + (endTime-startTime));
    }
    public abstract void code();
}

class SumRuntime extends Runtime{
    public void code(){
        long sum  = 0;
        for(int i = 0; i<1000000;++i){
            sum += i;
        }
        System.out.println(sum);
    }
}
