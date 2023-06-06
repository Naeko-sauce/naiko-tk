## 线程常用方法
* 用户线程和守护线程
  > 1. 用户线程：也叫工作线程，当线程的任务执行完成或者通知方式结束
  > 2. 守护线程：一般是为工作线程服务的，当所有的用户线程结束时，守护线程自动结束
  > 3. 常见的守护线程：垃圾回收机制
* 应用案例Thread Method03.java
* 下面我们将测试如何将一个线程设置成守护线程