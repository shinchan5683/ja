import java.util.*;

class S23A2{
    public static void main(String[] args){
        List<String> students = new ArrayList<>();
        for(int i=0;i<args.length;i++){
            students.add(args[i]);
        }

        System.out.println("All Student names using Iterator");
        Iterator<String> itr = students.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("All student names using ListIterator");
        ListIterator<String> litr = students.listIterator();
        while(litr.hasNext()){
            System.out.println(litr.next());
        }
    }
}
