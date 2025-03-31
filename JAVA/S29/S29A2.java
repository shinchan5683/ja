import java.util.*;
class S29A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("Enter elements (type -1 to stop):");
        for (int num; (num = sc.nextInt()) != -1; ) 
            list.add(num);

        System.out.print("Add at first: ");
        list.addFirst(sc.nextInt());
        list.removeLast();

        System.out.println("List: " + list + "\nSize: " + list.size());
        sc.close();
    }
}


