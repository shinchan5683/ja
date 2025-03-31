import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class S21A1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<String> subjects = new LinkedList<>();

        System.out.println("Enter the number of subjects:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the subject names:");
        for(int i=0;i<n;i++){
            subjects.add(sc.nextLine());
        }

        System.out.println("Subjects:");
        Iterator<String> iterator = subjects.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        sc.close();
    }
}


