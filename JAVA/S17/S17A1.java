import java.util.Scanner;
import java.util.TreeSet;
public class S17A1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> numbers = new TreeSet<>();

        System.out.println("Enter the number of integers");
        int n = sc.nextInt();

        System.out.println("Enter the Integers");
        for(int i=0;i<n;i++){
            numbers.add(sc.nextInt());
        }

        System.out.println("Integers in sorted order(no duplicates):"+numbers);
        sc.close();
    }
}


