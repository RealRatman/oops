import java.io.*;
import java.util.*;


class one implements Runnable{
    int times;
    one(int times){
        this.times=times;
        
    }
    @Override 
    public void run(){
        Random random = new Random();
        for (int i=0;i<times;i++){
            int num=random.nextInt(100);
            if (num%2!=0){
                Thread c=new Thread(new thr(num));
                c.start();
                
            }
            else {
                Thread s =new Thread(new two(num));
                s.start();
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("error");
            }
        }
    }

}
class two implements Runnable{
    int num;
    two(int num){
        this.num=num;
    }
    @Override
    public void run(){
        int sq =num*num;
        System.out.println("thread two: num is even so square of "+num+" is "+sq);
    }
}
class thr implements Runnable{
    int num;
    thr(int num) {
        this.num=num;
    }
    @Override
    public void run(){
        int cube= num*num;
        System.out.println("thread three: num is odd so the cube of "+num+" is "+cube);
    }
}

public class mthread {
    public static void main(String[] args){
        System.out.println("Hello");
        int times=5;
        Thread first=new Thread(new one(times));
        first.start();
        try{
            first.join();
        } catch (InterruptedException e){
            System.out.println("error");
        }
    }
    
}
