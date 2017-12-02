import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Demo3 {
    public static void main(String[] args){
        // Java8用流的方式读文件，更加高效
        try {
            Files.lines(Paths.get("D:\\coreJava\\coreJava\\static\\a.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
        }catch (IOException e){
            System.out.println("读取文件失败");
        }finally {
            System.out.println("关闭文件资源占用");
        }

    }
}
