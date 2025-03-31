import java.util.LinkedList;
import java.util.Scanner;

public class S19A1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> numbers = new LinkedList<>();

        System.out.println("Enter the number of integers:");
        int n = scanner.nextInt();

        System.out.println("Enter the integers:");
        for(int i=0;i<n;i++){
            numbers.add(scanner.nextInt());
        }

        System.out.println("Negtive integers:");
        for(int number : numbers){
            if(number < 0){
                System.out.println(number);
            }
        }
        scanner.close();
    }
}
