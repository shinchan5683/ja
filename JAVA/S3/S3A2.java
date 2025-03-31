import java.util.*;
public class S3A2 {
 public static void main(String[] args) {
  LinkedList<String> list=new LinkedList<>();
  list.add("sanika");
  list.add("Swaraj");
  list.add("sunhai");
  list.add("vaishnavi");
  list.removeFirst();
  
  Iterator<String> itr= list.descendingIterator();
  System.out.println("contents of list in reverse order:");
  while(itr.hasNext())
  {
   System.out.println(itr.next());
  }
 }
}
