// Write a Java program to accept ‘n’ integers from the user and store them in a collection. Display them in the sorted order.
//The collection should not accept duplicate elements. (Use a suitable collection). Search for a particular element using predefined search 
//method in the Collection framework. 

import java.util.*;

public class S6A1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Integer> numbers = new TreeSet<Integer>();

        System.out.println("Enter the number of integers you want to enter:");
        int n = sc.nextInt();

        System.out.println("Enter the integers:");
        for(int i=0;i<n;i++){
            numbers.add(sc.nextInt());
        }

        System.out.println("Sorted Integers (no duplicates):"+numbers);

        System.out.println("Enter the number you want to search:");
        int searchElement = sc.nextInt();
        if(numbers.contains(searchElement)){
            System.out.println(searchElement+"\tElement Found!");
        }
        else{
            System.out.println(searchElement+"\tElement not Found!");
        }
        sc.close();
    }
}