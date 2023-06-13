package game;

//自己的坦克
public class ziji extends tk {
    //定义一个SHot对象，用于发射子弹,表示一个射击线程
    Shot shot = null;
    public ziji(int x, int y) {
        super(x, y);
    }
    //射击
    public void  Shotziji(){
        //创建Shot对象，根据当前坦克ziji对象的位置和方向来创建Shot
        switch (getDirect()){
            case 0://向上
                //这个二十是坦克轮子到炮筒的位置
                shot = new Shot(getX()+20,getY(),0);
                break;
                case 1:
                //向右
                shot = new Shot(getX()+20,getY()+20,1);
                break;
                 case 2:
                //向下
                shot = new Shot(getX()+20,getY()+60,2);
                break;
                 case 3:
                //向下
                shot = new Shot(getX(),getY()+60,3);
                break;
        }
        //启动Shot线程
        new Thread(shot).start();
    }
}
