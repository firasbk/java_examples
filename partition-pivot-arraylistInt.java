 import java.util.*;
 public class Main {
	 static public List<Integer> partitionList(int pivot, List<Integer> lst) {

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < lst.size();i++){
            if (lst.get(i) < pivot)
                list1.add(lst.get(i));
            else if (lst.get(i) == pivot)
                list2.add(lst.get(i));
            else
                list3.add(lst.get(i));
        }
        result.addAll(list1);
        result.addAll(list2);
        result.addAll(list3);
        return result;
    }
    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<Integer>();
        myList.add(9);
        myList.add(12);
        myList.add(3);
        myList.add(5);
        myList.add(14);
        myList.add(10);
        myList.add(10);
        System.out.println("My List is:  "+myList.toString());
        List<Integer> myListParts = new ArrayList<Integer>();
        myListParts = partitionList(10, myList);
        System.out.println("My List Parts is:  "+myListParts.toString());

	}
 }