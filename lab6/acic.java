import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

abstract class Shape{
    protected int dim1;
    protected int dim2;
    abstract double area();
    String name;
    Shape(int dim1, int dim2){
        if (dim1<0 || dim2<0){
            throw new IllegalArgumentException("dimensions must be positive");
        } 
        this.dim1=dim1;
        this.dim2=dim2;
    }
    final void displayInfo(){
        System.out.println("shape: "+ name +"\narea: "+ area());
    }
}

interface Colorable{
    String colorDescription();
}

class Rectangle extends Shape implements Colorable{
    String desc;
    Rectangle(int dim1, int dim2, String desc){
        super(dim1, dim2);
        this.desc=desc;
        this.name="rectangle";
    }
    public String colorDescription(){
        return ("description: "+desc);
    }
    @Override
    double area(){
        return (dim1*dim2);
    }
}

class Triangle extends Shape implements Colorable{
    String desc;
    Triangle(int dim1, int dim2, String desc){
        super(dim1, dim2);
        this.desc=desc;
        this.name="triangle";
    }
    public String colorDescription(){
        return ("traingle color description: "+desc);
    }
    @Override
    double area(){
        return (dim1*dim2*0.5);
    }
}

class Circle extends Shape implements Colorable{
    String desc;
    Circle(int dim1, String desc){
        super(dim1, dim1);
        this.desc=desc;
        this.name="circle";
    }
    public String colorDescription(){
        return ("circle color description: "+desc);
    }
    @Override
    double area(){
        return (dim1*dim2*3.14);
    }
}
public class acic {
    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("log.txt", true);
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
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Shape[] shape = new Shape[3];
        String[] colors = {"white", "black", "red", "yellow", "blue", "green", "brown", "purple"};
        try{
            System.out.print("Enter side 1 for rectangle: ");
            int r1=sc.nextInt();
            log.println(r1);
            System.out.print("Enter side 2 for rectangle: ");
            int r2=sc.nextInt();
            log.println(r2);
            System.out.print("Enter height of triangle: ");
            int t1=sc.nextInt();
            log.println(t1);
            System.out.print("Enter length of triangle: ");
            int t2=sc.nextInt();
            log.println(t2);
            System.out.print("Enter the radius of circle: ");
            int c1=sc.nextInt();
            log.println(c1);
            shape[0]=new Rectangle(r1, r2, colors[rand.nextInt(colors.length)]);
            shape[1]=new Triangle(t1, t2, colors[rand.nextInt(colors.length)]);
            shape[2]=new Circle(c1, colors[rand.nextInt(colors.length)]);
            System.out.println("details of the shapes:");
            for(int i=0;i<shape.length;i++){
                shape[i].displayInfo();
                System.out.println(((Colorable)shape[i]).colorDescription());
            }
        }catch(InputMismatchException e){
            System.out.println("only numbers");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
            log.close();
            fw.close();
        }
    }
}
