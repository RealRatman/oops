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
        //just because
    }
}
