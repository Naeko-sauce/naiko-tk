package Io.Directory_;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory_ {
    //文件删除
    @Test
    public void m1(){
        String a = "F:\\news1.txt";
        File file = new File(a);
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("该文件不存在");
        }
    }
    //判断文件是否存在如果不存在就创建，否则提示文件存在
    @Test
    public void m2(){
        String a = "F:\\a\\b\\c";
        File file = new File(a);
        if (file.exists()){
            System.out.println("该目录存在");
        }else {
            if (file.mkdirs()){
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
        }
    }
}
