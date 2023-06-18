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