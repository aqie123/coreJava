package aqie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo25 {
    public static void main(String[] args) {
        Test25 t = new Test25();
        // t.method();
        t.method2();
        t.method3();
        t.method4();
        t.method5();
        t.method6();
        t.method7();
        t.method8();
    }
}

class Test25{
    // 校验 QQ

    /**
     * 首位不能为0，
     * 4-12
     * 全是数字
     */
    void method(){
        String qq= "1344,so2";
        String qq2= "2924811900";
        // 字符串开头
        System.out.println("字符串以0开头"+qq.startsWith("0"));
        // 字符串长度 str.length()   arr.length  list.size()
        System.out.println("字符串长度 "+qq.length());

        // 通过try catch 将字符串转数字  long.parseLong(qq);

        System.out.println(qq2.matches("[1-9]\\d{3,12}") ? "合法qq" : "非法QQ");
    }

    // 根据空格对字符串切割
    void method2(){
        String str = "aa.bb.cc";
        str = "-1     99    4    23";
        String[] arr = str.split(" +");
        for(String ele : arr){
            System.out.print(ele);
        }
    }

    // 根据重叠词进行分割
    void method3(){
        String str = "sdqqfgkkkhjppppkl";
        String[] arr = str.split("(.)\\1+");
        for(String s : arr)
        {
            System.out.println(s);
        }
    }

    // 重叠词 替换成某个单词
    void method4(){
        String str = "sdaaafghcccjkqqqqqql";
        //$ 可以获取到该方法中正则实际参数中的某一个存在的组 $组编号即可。
        // 编号从1开始
        String s = str.replaceAll("(.)\\1+","$1");
        System.out.println(str+":"+s);
        String nums = "wser127372tyuiopd6226178909876789fghjk";
        String s1 = nums.replaceAll("\\d+","*");
        System.out.println(nums+":"+s1);

    }

    // 需求：获取由3个字母组成的单词。
    void method5(){
        String str = "da jia zhu yi le,ming tian bu fang jia,xie xie!";
        //想要获取由3个字母组成的单词。
        //刚才的功能返回的都是一个结果，只有split返回的是数组，但是它是把规则作为分隔符，不会获取符合规则的内容。
        //这时我们要用到一些正则对象。
        String reg = "\\b[a-z]{3}\\b";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while(m.find())
        {
            System.out.println(m.start()+"...."+m.end());
            System.out.println("sub:"+str.substring(m.start(),m.end()));
            System.out.println(m.group());
        }
//		System.out.println(m.find());//将规则对字符串进行匹配查找。
//		System.out.println(m.find());//将规则对字符串进行匹配查找。
//		System.out.println(m.group());//在使用group方法之前，必须要先找，找到了才可以取。

    }

    // 我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
    void method6(){
        String str = " 我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
        // 去掉.
        str = str.replaceAll("\\.+","");
        System.out.println(str);
        str = str.replaceAll("(.)\\1+","$1");
        System.out.println(str);
    }

    // 校验邮件
    void method7(){
        String mail = "abc123@sina.com.cn";
        mail = "1@1.1";
        String reg = "[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        reg = "\\w+@\\w+(\\.\\w+)+";//简化的规则。笼统的匹配。
        boolean b = mail.matches(reg);
        System.out.println(mail+":"+b);
    }


    /** 提取字符串中邮件
     *  邮件规则
     *      1.不能0开头
     *      2.字母与数字_
     *      3. 2-12
     *      4. @
     *      5.[a-zA-Z0-9]{2,}
     *      6. .com .cn .net  .com.cn
     */
    void method8(){
        String str = " 请联系：2924811900@qq.com 请联系：2924811900@qq.com " +
                "请联系：2924811900@qq.com";
        String reg = "[a-zA-Z1-9]\\w{1,11}@[a-zA-Z0-9]{2,}(\\.[a-z]{2,3}){1,2}";
        // 字符串正则编译成Pattern
        Pattern p = Pattern.compile(reg);
        // 正则对象匹配字符串对象得到一个匹配器
        Matcher m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }
    }

}
