import java.io.*;

public class filefound {
    public static void main(String[] args) {
        String path ="D:\\cgoods\\java\\lab9\\hitwn.txt";
        try {
            FileReader f = new FileReader(path);
            System.out.println("file was found at "+path);
        } catch (FileNotFoundException e){
            System.out.println("file was not found "+ e.getMessage());
        }
    }
}
