import java.util.*;
public class S2A1{
public static void main(String[] args) {
        Scanner s1= new Scanner(System.in);
        TreeSet<String> names = new TreeSet<>();
        System.out.println("Enter names (type 'exit' to stop):");
        while (s1.hasNext()) 
        {
            String name = s1.next();
            if (name.equalsIgnoreCase("exit")) break;
            names.add(name);
        }
        names.forEach(System.out::println);
    }
}
