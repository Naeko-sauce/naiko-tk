package Io.outputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filecopy {
    public static void main(String[] args) {


//    文件拷贝，将f盘的文件拷贝到e盘
//    1.创建文件的输入流，将文件读入到程序
//    2.创建文件的输出流， 将读取到的文件数据，写入到指定的文件
        String filepath = "f:\\a.png";//源文件路径
        String destFilepath ="e:\\a.png";//拷贝到的路径
        FileInputStream fileInputStream = null;//从文件读取字节流
        FileOutputStream fileOutputStream = null;//像文件写入字节流
        try {
            fileInputStream = new FileInputStream(filepath);
            fileOutputStream = new FileOutputStream(destFilepath);
            //定义一个字节数组，提高读取效果
            byte[] buf = new byte[100];
            int re = 0;
            while ((re = fileInputStream.read(buf)) != -1){
                //读取到后就写入到文件
                //即是边读边写
                fileOutputStream.write(buf,0,re);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fileOutputStream!= null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}