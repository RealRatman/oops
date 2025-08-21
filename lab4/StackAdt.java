import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;
import java.text.*;

public class StackAdt {

    public static int readInt(Scanner s) {
        while (true) {
            if (s.hasNextInt()) {
                int val = s.nextInt();
                s.nextLine(); 
                return val;
            } 
            else {
                System.out.println("ts not an int");
                s.nextLine(); 
            }
        }
    }

    public static void main(String[] args) throws Exception{
        
        FileWriter fw = new FileWriter("slog.txt", true);	
		PrintWriter log = new PrintWriter(fw, true);
		PrintStream og = System.out;
        Scanner sc = new Scanner(System.in);
        PrintStream b = new PrintStream ( new OutputStream() {
			public void write(int b) {
				log.write(b);
				log.flush();
				og.write(b);
				og.flush();
			}
		}, true);
		System.setOut(b);
        
        System.out.print("enter start size: ");
        int init = readInt(sc);
        StackArray<String> st = new StackArray<>(init);
        int ch=0;
        while (ch != 4){
            System.out.println("\n-- menu --");
            System.out.println("1 push  2 pop  3 show  4 exit");
            System.out.print("ur pick: ");
            ch = readInt(sc);
            log.println(ch);
            log.flush();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("val to push: ");
                        String val = sc.nextLine();
                        log.println(val);
                        log.flush();
                        st.push(val);
                        break;
                    case 2:
                        String popped = st.pop();
                        System.out.println(popped + " popped");
                        break;
                    case 3:
                        st.display();
                        break;
                    case 4:
                        System.out.println("bye");
                        break;
                    default:
                        System.out.println("nah invalid");
                }
            } catch (StackOverflowException | StackUnderflowException e) {
                System.out.println("oops: " + e.getMessage());
            }
        }

        sc.close();
        log.close();
    }
}
