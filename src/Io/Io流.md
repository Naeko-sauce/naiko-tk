## 文件
* 文件流
  >文件在程序中是以流的形式来操作的
  > Java程序内存 《—————输出流 文件(磁盘)
  > Java程序内存 输出流————》文件(磁盘)
  > 流：数据在数据源(文件)和程序(内存)之间经历的路径
  > 输入流：数据从数据源(文件)到程序(内存)的路径
  > 输出流：数据从程序(内存)到数据源(文件)的路径
## 常用的文件操作
* 创建文件对象相关构造器和方法
> new File(String pathname) //根据路径构建一个File对象
> new File(File parent,String child) //根据父目录文件+子路径构建
> new file(String parent,String child) //根据父目录+子路径构建
> create New File创建新文件
* 案列，在f盘下创建三个文件，用三个方式，案例File Create
* 常用文件操作FIleInformation
 >getName、 getAbsolutePath、 getParent、 length、 exists、isFile
isDirectory
 *目录的操作和文件删除Directory_
 > makdir创建一级目录、makdirs创建多级目录、delete删除空目录或文件
 ## Io流体系图，常用类
* input Stream：字节输入流
* Input Stream抽象类是所有字节输入流的超类
* Input Steam类的常用子类
  > File input Steam：文件输入流
  > BufferedInputStream: 缓冲字节输入流
  > ObjectInputStream: 对象字节输入流
## File Output Stream
* 使用File Output Stream在a.txt中写入，如果文件不存在，先创建文件
* 代码在IoFile Output Stream_