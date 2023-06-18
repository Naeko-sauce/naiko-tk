package Io.FileCreate;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/*
* 演示创建文件
*
* */
public class FileCreate {
    public static void main(String[] args) {

    }
@Test
//方式一 new File(String pathname)
    public void create01() throws IOException {
        //创建要放入的文件路径
        String f = "F:\\news1.txt";
        //把创建好的文件路径对象放入file
        File file = new File(f);
        //创建文件
        file.createNewFile();
        System.out.println("文件创建成功");
    }

//方式二 new File(File parent,String child) 根据父目录文件+子路径构建
    @Test
    public void create02() throws IOException {
        //这里是创建文件对象
        File parentfile = new File("F:\\");
        String fileName = "news2.txt";
        //这里是把创建好的文件对象放入file
        File file = new File(parentfile, fileName);
        //这里才是创建文件
        file.createNewFile();
        System.out.println("创建成功");
    }
    //第三种方式 new file(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03() throws IOException {
        File file = new File("F:\\");
        String file1 = "news3.txt";
        File file2 = new File(file, file1);
        file2.createNewFile();
        System.out.println("创建成功");
    }
}
