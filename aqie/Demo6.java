package aqie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Demo6 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        // test4.method();
        try {
            test4.method2();
        }catch (ParseException e){}

    }
}
class Test4{
    void method(){
        // 获取当前系统时间类的对象
        // Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

    }

    void method2() throws ParseException{
        // 日期格式化类  日期->时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));

        // 字符串转时间 (字符串格式必须要与SimpleDateFormat指定格式一致)
        String birthday = "1993年01月16日 12:30:45";
        System.out.println(dateFormat.parse(birthday));
    }
}
