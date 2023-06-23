package Io.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//演示File Input String的使用(字节输入流 文件--> 程序)

public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void readFile01() throws IOException {
//        要读取电脑里的文件首先要创建一个对象
        String filepath = "F:\\news3.txt";
        int red = 0;
        //创建fileInputStream对象用于读取文件
        FileInputStream fileInputStream = new FileInputStream(filepath);
        //从该输入流读取一个字节的数据,如果没有输入可用,此方法将阻止,
        //如果返回-1,表示读取完毕
        //每次只能读取一个字节所以让他循环读取完毕时就退出while循环,效率会比较低
      while ((red = fileInputStream.read()) != -1){
          System.out.print((char) red);//显示的时候转成char


      }
       //关闭文件流,释放资源
      fileInputStream.close();
    }
    // 使用read(byte[] b)优化,提高文件的读取效率
       @Test
    public void readFile02() throws IOException {
//        要读取电脑里的文件首先要创建一个对象
        String filepath = "F:\\news3.txt";
        int red = 0;
        //字节数组
           byte[] buf = new  byte[8];//一次读取8个字节
        //创建fileInputStream对象用于读取文件
        FileInputStream fileInputStream = new FileInputStream(filepath);
        //从该输入流读取最多b.length字节的数据到字节数组，此方法将阻塞，，直到某些输入可用
        //如果返回-1,表示读取完毕
        //每次只能读取一个字节所以让他循环读取完毕时就退出while循环,效率会比较低
           //如果读取正常，返回实际读取的字节数
      while ((red = fileInputStream.read(buf)) != -1){
          System.out.print(new String(buf,0,red));//显示的时候转成char


      }
       //关闭文件流,释放资源
      fileInputStream.close();
    }
}
