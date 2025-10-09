import java.io.*;
import java.util.*;

class MathOperations {
    public int sum(int a, int b) {
        System.out.println("2 ints sum");
        return a + b;
    }

    public double sum(double a, double b, double c) {
        System.out.println("3 doubles sum");
        return a + b + c;
    }

    public int sum(int... nums) {
        System.out.println("varargs int sum");
        int s = 0;
        for (int n : nums) {
            s += n;
        }
        return s;
    }
}

public class trialmath {
    public static void main(String[] args) throws Exception {
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

        Scanner sc = new Scanner(System.in);
        MathOperations m = new MathOperations();
        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' to finish):");
        while (true) {
            String val = sc.next();
            if (val.equalsIgnoreCase("done")) break;
            inputs.add(val);
        }

        try {
            if (inputs.size() == 2 && !inputs.get(0).contains(".") && !inputs.get(1).contains(".")) {
                int a = Integer.parseInt(inputs.get(0));
                int b = Integer.parseInt(inputs.get(1));
                System.out.println("Sum = " + m.sum(a, b));
            } 
            else if (inputs.size() == 3 && (inputs.get(0).contains(".") || inputs.get(1).contains(".") || inputs.get(2).contains("."))) {
                double a = Double.parseDouble(inputs.get(0));
                double b = Double.parseDouble(inputs.get(1));
                double c = Double.parseDouble(inputs.get(2));
                System.out.println("Sum = " + m.sum(a, b, c));
            } 
            else {
                int[] nums = new int[inputs.size()];
                for (int i = 0; i < inputs.size(); i++) {
                    nums[i] = Integer.parseInt(inputs.get(i));
                }
                System.out.println("Sum = " + m.sum(nums));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        }
    }
}
