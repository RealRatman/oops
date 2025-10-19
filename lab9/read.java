import java.io.*;

public class read {
    public static void main(String[] args){
        File re=new File("D:\\cgoods\\java\\lab9\\hitwn.txt");
        boolean readable= re.canRead();
        if (readable){
            System.out.println("The file was readable");

        } else {
            System.out.println("not readable");
        }
    }
}
