import java.util.*;
import java.util.regex.*;

public class AdvancedArrayListOps{

    public ArrayList<String> strl;

    public AdvancedArrayListOps(){
        strl = new ArrayList<String>();
    }

    public void append(String value){
        strl.add(value);
    }

    public void insert(int index, String value){
        try{
            strl.add(index, value);
        }
        catch (IndexOutOfBoundsException e){
            System.err.println("index out of range");
        }
    }

    public boolean search(String value){
        return strl.contains(value);
    }

    public ArrayList<String> letter(String value){
        ArrayList<String> temp = new ArrayList<String>();
        for (String s : strl){
            if (s.toLowerCase().startsWith(value.toLowerCase())){
                temp.add(s);
            }
        }
        Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);
        return temp;
    }

    public void sortup(){
        Collections.sort(strl, String.CASE_INSENSITIVE_ORDER);
    }

    public void sortdown(){
        Collections.sort(strl, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    }

    public void dupe(){
        LinkedHashSet<String> temp = new LinkedHashSet<>(strl);
        strl = new ArrayList<>(temp);
    }

    //partial match search
    public ArrayList<String> partialMatch(String sub){
        ArrayList<String> res = new ArrayList<>();
        for (String s : strl){
            if (s.toLowerCase().contains(sub.toLowerCase())){
                res.add(s);
            }
        }
        return res;
    }

    //regex search
    public ArrayList<String> regexSearch(String pattern){
        ArrayList<String> res = new ArrayList<>();
        try{
            Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            for (String s : strl){
                Matcher m = p.matcher(s);
                if (m.find()){
                    res.add(s);
                }
            }
        }
        catch (PatternSyntaxException e){
            System.err.println("Invalid regex: " + e.getDescription());
        }
        return res;
    }


    public void display(){
        System.out.println(strl);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        AdvancedArrayListOps op = new AdvancedArrayListOps();
        int choice;
        while (true) {
            System.out.print("\n1. append\n2. insert\n3. search\n4. starts with a letter\n5. sort alphabetically upwards\n6. sort alphabetically downwards\n7. remove dupes\n8. partial search\n9. regex case insensitive\n10. display\n11. exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1){
                String temp;
                System.out.print("Enter the value to be appended: ");
                temp=sc.next();
                op.append(temp);
            }
            else if (choice == 2){
                String temp;
                System.out.print("Enter the value to be inserted: ");
                temp=sc.next();
                int pos;
                System.out.print("Enter the position: ");
                pos=sc.nextInt();
                op.insert(pos, temp);
            }
            else if (choice == 3){
                String temp;
                System.out.print("Enter the value to be searched for: ");
                temp=sc.next();
                System.out.println(op.search(temp));
            }
            else if (choice == 4){
                String temp;
                System.out.print("Enter the letter: ");
                temp=sc.next();
                System.out.print(op.letter(temp));
            }
            else if (choice == 5){
                op.sortup();
                System.out.println("sorted upwards alphabetically");
            }
            else if (choice == 6){
                op.sortdown();
                System.out.println("sorted downards alphabetically");
            }
            else if (choice == 7){
                op.dupe();
                System.out.println("dupes have been deleted");  
            }
            else if (choice == 8){
                String temp;
                System.out.print("Enter the string to be searched for: ");
                temp=sc.next();
                System.out.println(op.partialMatch(temp));
            }
            else if (choice == 9){
                String temp;
                System.out.print("Enter the string to be searched for: ");
                temp=sc.next();
                System.out.println(op.regexSearch(temp));
            }
            else if (choice == 10){
                op.display();
            }
            else if (choice == 11){
                break;
            }
            else{
                System.out.println("invalid choice");
            }
            System.out.println();
        }
    }
}