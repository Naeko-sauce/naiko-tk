package Io.FileOutputStream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    /**
     * 演示使用File Output Stream 将数据写入到文件中
     * 如果该文件不存在，则创建该文件
     * */
    @Test
    public void we() throws IOException {
        //创建File Output Stream对象
        String fi = "F:\\a.txt";
        //创建方式，当与内容是要追加到文件后面就要写上true
        FileOutputStream fileOutputStream = new FileOutputStream(fi,true);
        //写入一个字节
        fileOutputStream.write('A');
        //写入字符串
        String f = "Hllo";
        //.getBttes()可以把字符串转成一个字节数组
        fileOutputStream.write(f.getBytes());
        fileOutputStream.close();
    }
}
