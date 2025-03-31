import java.util.*;

public class S5A1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Hashtable<String,String> StudentDeatils = new Hashtable<>();
        
        StudentDeatils.put("laxman","9878743126");
        StudentDeatils.put("Suhani","9872346756");
        StudentDeatils.put("Sanika","7864785632");
        StudentDeatils.put("Saee","8982734876");

        Enumeration<String> keys = StudentDeatils.keys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println("Student Name:\t"+key+"\tMobile Number:\t"+StudentDeatils.get(key));
        }
    }
}
