import java.io.*;

public class newdir {
    public static void main(String[] args){
        File path = new File("D:\\cgoods\\java\\lab9\\newfolder");
        boolean check = path.mkdir();
        if (check){
            System.out.println("directory was made");
        } else{
            System.out.println("failed");
        }
    }
}
