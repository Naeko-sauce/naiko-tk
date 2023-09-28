package io_pro.FileCreate;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
        //先创建一个文件路径
        String filepath = "e:\\naiko1.txt";
        File file = new File(filepath);//这里还没创建起来
        try {
            file.createNewFile();//这里就是创建
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //创建方式2
    @Test
    public void c2(){
        File file  = new File("e:\\");
        String fileName = "naiko2.md";
        //这里的file在Java程序中，只是一个对象
        File file1 = new File(file,fileName);
        try {
            //只有执行了createNew file才会创建文件
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void c3(){
        //parent的中文意思是 "父亲" 或 "父母"。在编程的上下文中，"parent" 通常用来表示上一级对象或元素，例如 "parent directory" 表示上一级目录，或 "parent class" 表示父类。这个词可以用来表示层次关系中的上一级。
        String parentfile = "e:/";
        String FileName = "naiko4.txt";
        File file = new File(parentfile,FileName);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}