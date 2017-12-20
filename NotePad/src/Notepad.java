import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/** 记事本
 *  1. 基本布局
 *  2. 添加点击事件
 *  3. 保存文件
 */
public class Notepad {

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.init();
    }
    // 菜单组件(jFrame->(bar area)->JMenu->JMenuItem)
    JFrame jFrame = new JFrame("啊切文本编辑器");

    // 菜单条
    JMenuBar bar = new JMenuBar();
    // 菜单
    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");
    JButton aqie = new JButton("Aqie");

    // 菜单项
    JMenu helpMenu = new JMenu("Help");
    JMenuItem copy = new JMenuItem("复制");
    JMenuItem save = new JMenuItem("保存");
    JMenuItem open = new JMenuItem("打开");

    // 二级菜单
    JMenuItem about = new JMenuItem("About");
    JMenuItem version = new JMenuItem("Version");
    // 文本域
    JTextArea area = new JTextArea(12,15);
    // TextArea area = new TextArea(12,15);

    private void init(){
        initializeFrame();

        frameLayout();
    }

    private void frameLayout() {
        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(aqie);

        // 设置TextArea字体和颜色
        area.setFont(new Font("微软雅黑", 1, 13));
        area.setForeground(new Color(189, 91, 19));
        area.setBackground(new Color(7, 82, 12));

        // 菜单项添加菜单
        fileMenu.add(open);
        fileMenu.add(save);

        // 打开菜单添加事件
        openEvent();
        // 保存菜单添加事件
        saveEvent();
        // 按钮点击事件
        buttonEvent();

        editMenu.add(copy);

        // 多级导航
        editMenu.add(helpMenu);
        helpMenu.add(about);
        helpMenu.add(version);
        // 菜单添加到窗体
        jFrame.add(bar, BorderLayout.NORTH);
        jFrame.add(area);
    }

    private void buttonEvent() {
        aqie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aqie");
                // JButton button1 = (JButton) e.getSource();  // 获取事件源对象
                String content = aqie.getText();
                if("Aqie".equals(content)){
                    aqie.setText("啊切");
                }else{
                    aqie.setText("Aqie");
                }
            }
        });
    }

    private void openEvent() {
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog openFile = new FileDialog(jFrame,"选择要打开文件",FileDialog.LOAD);
                openFile.setVisible(true);
                // 获取文件名
                String path = openFile.getDirectory();    // 获取保存文件路径
                String fileName = openFile.getFile();     // 获取保存文件名
                // 缓冲输入字符流写入数据
                bufferedReader(path,fileName,area);
            }
        });
    }

    private void saveEvent() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出对话框
                FileDialog fileDialog = new FileDialog(jFrame,"请输入文件名",FileDialog.SAVE);
                fileDialog.setVisible(true);
                String path = fileDialog.getDirectory();    // 获取保存文件路径
                String fileName = fileDialog.getFile();     // 获取保存文件名
                // 获取文本域内容(getText()遇到\r\n )
                String content = area.getText().replaceAll("\n","\r\n");
                // bufferedWriter(path,fileName,content,true);
                bufferedWriter(path,fileName,content,false);
            }
        });
    }

    // 初始化Frame
    private void initializeFrame() {
        // 获取屏幕分辨率
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 获取屏幕分辨率
        Dimension dimension = toolkit.getScreenSize();
        int x = (int)dimension.getWidth();
        int y = (int)dimension.getHeight();
        jFrame.setBounds((x-600)/2,(y-800)/2,600,800);
        jFrame.setVisible(true);
        // 设置窗体的关闭事件
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // 缓冲输出字符流写入数据
    private void bufferedWriter(String path,String fileName,String data,boolean append){
        BufferedWriter bufferedWriter = null;
        try {
            // 1 . 找到目标文件.
            File file = new File(path,fileName);
            // 2. 建立数据的输出通道
            FileWriter fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            // 3. 写入数据
            // bufferedWriter.newLine(); // bufferedWriter.write("\r\n");
            bufferedWriter.write(data);
        }catch (IOException e){
            System.out.println("读取文件失败");
            throw new RuntimeException(e);
        }finally {
            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                    System.out.println("\n缓冲输入字符流资源关闭成功");
                    System.exit(0);
                }
            }catch (IOException e){
                System.out.println("缓冲输入字符流资源关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 缓冲输入字符流 分行读取文件
    public void bufferedReader(String path,String fileName,JTextArea area){
        BufferedReader bufferedReader = null;
        try{
            // 1.找到目标文件.
            File file = new File(path,fileName);
            // 2.建立数据输入通道
            FileReader fileReader = new FileReader(file);
            // 3.建立缓冲输入字符流
            bufferedReader = new BufferedReader(fileReader);
            LineNumReader lineNumReader = new LineNumReader(bufferedReader);

            // 4, 读取文件内容 分行读取
            String line = null;
            while((line = lineNumReader.readLine()) != null){
                // area.setText(line);
                // line.replaceAll("\n","\r\n");
                area.append(line+"\n");
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("\r\n文件读取失败");
            throw new RuntimeException(e);
        }finally {
            // 5.关闭资源
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                    System.out.println("\r\n缓冲字符流资源关闭成功");
                }
            }catch(IOException e){
                System.out.println("文件关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 带行号的缓冲输入字符流
    class LineNumReader extends BufferedReader {
        BufferedReader bufferedReader;
        int count = 1;
        public LineNumReader(BufferedReader bufferedReader){
            super(bufferedReader);      // 父类没有无参构造函数
            this.bufferedReader = bufferedReader;
        }
        public String readLine(){
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(line == null){
                return null;
            }
            line = count + ": " + line;
            count++;
            return line;
        }
    }

    // 带行号的缓冲输出字符流
    class LineNumWriter extends BufferedWriter{
        BufferedWriter bufferedWriter;
        public LineNumWriter(BufferedWriter bufferedWriter){
            super(bufferedWriter);
            this.bufferedWriter = bufferedWriter;
        }
    }
}
