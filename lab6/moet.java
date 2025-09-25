import java.io.*;
import java.util.*;

class Employee{
    protected String name;
    protected double bSalary;
    Employee(String name, double bSalary){
        if (bSalary<0){
            throw new IllegalArgumentException("salary cant be negative");
        }
        this.name=name;
        this.bSalary=bSalary;
    }
    double calcSalary(){
        return bSalary;
    }
    public void dispSalary() {
        System.out.println(name + " salary: " + calcSalary());
    }
}

class Manager extends Employee{
    private double bonus;
    Manager(String name, double bSalary, double bonus){
        super(name, bSalary);
        if (bonus<0){
            throw new IllegalArgumentException("bonus cant be negative");
        }
        this.bonus=bonus;
    }
    @Override
    public double calcSalary(){
        return (super.calcSalary()+bonus);
    }
}

public class moet {
    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("slog.txt", true);
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
        try{
            System.out.print("enter employee name:");
            String ename=sc.next();
            log.println(ename);
            System.out.print("enter salary:");
            double esal=sc.nextDouble();
            log.println(esal);
            System.out.print("enter manager name:");
            String mname=sc.next();
            log.println(mname);
            System.out.print("enter salary:");
            double msal=sc.nextDouble();
            log.println(msal);
            System.out.print("enter bonus:");
            double bonus=sc.nextDouble();
            log.println(bonus);
            Employee e=new Employee(ename,esal);
            Manager m=new Manager(mname,msal,bonus);
            e.dispSalary();
            m.dispSalary();
        }
        catch(InputMismatchException ex){
            System.out.println("invalid input");
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}