import java.io.*;

class mathOperations{
    public int sum(int a, int b){
        System.out.println("2 ints sum");
        return (a+b);
    }
    public double sum(double a, double b, double c){
        System.out.println("3 double sum");
        return (a+b+c);
    }
    public int sum(int... nums){
        System.out.println("variaible sum");
        int sum=0;
        for (int n:nums){
            sum+=n;
        }
        return (sum);
    }
}

public class math {
    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("mlog.txt", true);
        PrintWriter log = new PrintWriter(fw, true);
        PrintStream og = System.out;
        PrintStream both = new PrintStream(new OutputStream() {
            public void write(int b) {
                og.write(b);
                log.write(b);
                og.flush();
                log.flush();
            }
        }, true);
        System.setOut(both);

        mathOperations m=new mathOperations();
        System.out.println(m.sum(1, 2));
        System.out.println(m.sum(1.1, 2.2, 3.3));
        System.out.println(m.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
