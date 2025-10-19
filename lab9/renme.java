import java.io.*;

public class renme {
    public static void main(String[] args){
        File oldn =new File("D:\\cgoods\\java\\lab9\\name.txt");
        File newn= new File("D:\\cgoods\\java\\lab9\\rename.txt");
        boolean tf= oldn.renameTo(newn);
        if (tf){
            System.out.println("renamin was successful");
        } else{
            System.out.println("renaming failed");
        }
    }
}
