import java.io.*;
import java.util.*;

public class filesum {

    public static void main(String[] args) {
        String filename = "numbers.txt";
        int sum = 0;
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            try {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    try {
                        int num = Integer.parseInt(line.trim());
                        sum += num;
                    } catch (NumberFormatException e) {
                        System.out.println("invalid number in file: " + line);
                    }
                }
                System.out.println("sum of numbers: " + sum);
            } finally {
                fileScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + filename);
        }
    }
}
