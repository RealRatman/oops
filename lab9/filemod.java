import java.io.*;
import java.util.*;

public class filemod {
    public static void main(String[] args) throws Exception{
        String path= "D:\\cgoods\\java\\lab9\\hitwn.txt";
        File f = new File(path);
        long d= f.lastModified();
        Date date = new Date(d);
        System.out.println(date);
    }
}
