package Io.FIleInformation;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

//获取文件信息
public class FIleInformation {
    //创建文件对象
    @Test
    public void info(){
        //先创立文件对象
        File file = new File("F:\\news1.txt");
        //调用相应的方法，得到相应信息
        System.out.println("文件名字="+file.getName());
        System.out.println("文件绝对路径="+file.getAbsolutePath());
        System.out.println("文件父级目录"+file.getParent());
        System.out.println("文件大小(字节)"+file.length());
        System.out.println("文件是否存在"+file.exists());//返回布尔值
        System.out.println("是不是一个文件"+file.isFile());//返回布尔值
        System.out.println("是不是一个目录"+file.isDirectory());//返回布尔值
    }
}
