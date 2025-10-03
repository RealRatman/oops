import java.util.*;


class InvalidSizeException extends Exception {
    public InvalidSizeException(String msg) {
        super(msg);
    }
}

public class dynamicarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        try {
            System.out.print("Enter sizse: ");
            size = sc.nextInt();
            if (size <=0) {
                throw new InvalidSizeException("size must be bigger than 0");
            }
            int[] arr = new int[size];
            System.out.println("success");
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        
        } catch (InputMismatchException e) {
            System.out.println("invalid, enter integer");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}