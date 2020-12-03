package jballs;
import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
public class Dron extends Thread{
    private MiX x;
    private MiY y;
    private JPanel panel;
    private int a = 1;
    private int b = 1;
    private int MX,MY,mx,my;
    private Lock mutex,VCondition;
    private Semaphore s;
    private String nAlg;
    private Condition condition;
    
    Dron(){}
    Dron(MiX x,MiY y, DibujaDrones panel,String nAlg){
        this.x=x;
        this.y=y;
        this.panel=panel;
        this.nAlg=nAlg;
        mutex = new ReentrantLock();
        s = new Semaphore(1);
        VCondition=new ReentrantLock();
        condition=VCondition.newCondition();
    }
    public synchronized void run(){
        while(true){
            try{
                switch(nAlg){
                    case "Semaforos":
                        s.acquire();
                        y.setY(y.getY()+b);
                        x.setX(x.getX()+a);
                        if (y.getY()>=MY-20){
                            b=-1;
                        }
                        if (y.getY()<=my){
                            b=1;
                        }
                        if (x.getX()>=MX-20){
                            a=-1;
                        }
                        if (x.getX()<=mx){
                            a=1;
                        }
                        panel.repaint();
                        s.release();
                        break;
                    case "Mutex":
                        mutex.lock();
                        y.setY(y.getY()+b);
                        x.setX(x.getX()+a);
                        if (y.getY()>=MY-20){
                            b=-1;
                        }
                        if (y.getY()<=my){
                            b=1;
                        }
                        if (x.getX()>=MX-20){
                            a=-1;
                        }
                        if (x.getX()<=mx){
                            a=1;
                        }
                        panel.repaint();
                        mutex.unlock();
                        break;
                    case "VC":
                        try{
                        mutex.lock();
                        condition.awaitUninterruptibly();
                        }catch(Exception e){}
                        finally{
                            mutex.unlock();
                        }
                        y.setY(y.getY()+b);
                        x.setX(x.getX()+a);
                        if (y.getY()>=MY-20){
                            b=-1;
                        }
                        if (y.getY()<=my){
                            b=1;
                        }
                        if (x.getX()>=MX-20){
                            a=-1;
                        }
                        if (x.getX()<=mx){
                            a=1;
                        }
                        panel.repaint();
                        break;
                    case "Monitores":
                        synchronized(this){
                            y.setY(y.getY()+b);
                            x.setX(x.getX()+a);
                            if (y.getY()>=MY-20){
                                b=-1;
                            }
                            if (y.getY()<=my){
                                b=1;
                            }
                            if (x.getX()>=MX-20){
                                a=-1;
                            }
                            if (x.getX()<=mx){
                                a=1;
                            }
                            panel.repaint();
                        }
                        break;
                }
                //Thread.sleep(5);
                Thread.sleep((int) (Math.random()*10));
            }catch(Exception e){e.printStackTrace();}
        }
    }
    public int getX(){
        return x.getX();
    }
    public int getY(){
        return y.getY();
    }
    public void limites(int mx, int my, int MX, int MY){
        this.mx=mx;
        this.my=my;
        this.MX=MX;
        this.MY=MY;
    }
    public void reset(){
        x.setX(mx);
        y.setY(my);
    }
    public void setalgoritmo(String bAlgoritmo){
        nAlg=bAlgoritmo;
    }
    public String getAlgoritmo(){
        return nAlg;
    }
}
