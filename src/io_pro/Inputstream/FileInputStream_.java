package io_pro.Inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {


    }
    @Test
    public void de(){
        String filepath = "f:/a.txt";
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象用于读取文件
             fileInputStream = new FileInputStream(filepath);
            //创建一个变量接收file input stream返回的-1
            int da;
            //循环读取一个字节的书记
            //如果返回-1表示读取完毕
            while ((da = fileInputStream.read())!= -1){
                System.out.print((char)da);//转成char显示//如果中文会变成乱码
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭文件释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) { 
                throw new RuntimeException(e);
            }
        }
    }
}
