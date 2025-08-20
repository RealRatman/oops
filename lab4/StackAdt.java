import java.util.Scanner;

public class StackAdt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter start size: ");
        int init = sc.nextInt();
        sc.nextLine();

        StackArray<String> st = new StackArray<>(init);

        int ch;
        do {
            System.out.println("\n-- menu --");
            System.out.println("1 push  2 pop  3 show  4 exit");
            System.out.print("ur pick: ");
            ch = sc.nextInt();
            sc.nextLine();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("val to push: ");
                        String val = sc.nextLine();
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
                        System.out.println("bye bye");
                        break;
                    default:
                        System.out.println("nah invalid");
                }
            } catch (StackOverflowException | StackUnderflowException e) {
                System.out.println("oops: " + e.getMessage());
            }
        } while (ch != 4);

        sc.close();
    }
}
