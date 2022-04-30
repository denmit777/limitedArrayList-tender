package homework8.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LimitedArrayList<Integer> list = new LimitedArrayList<>(4);
        try {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(2);
            //list.add(5); //OverflowingListException: Not enough place in list
            System.out.println(list); //[1, 2, 3, 2]
            System.out.println(list.size()); //4
            System.out.println(list.isEmpty()); //false
            System.out.println(list.contains(-1)); //false
            System.out.println(list.indexOf(5)); //-1
            System.out.println(list.lastIndexOf(2)); //3
            System.out.println(list.add(5)); //OverflowingListException: Not enough place in list
            System.out.println(list.get(0)); //1
            list.set(0, -15);
            System.out.println(list); //[-15, 2, 3, 2]
            System.out.println(list.get(4)); //OverflowingListException: Not enough such an index
            System.out.println(Arrays.toString(list.getArrWithoutRemovedElement(3))); //[-15, 2, 3]
            System.out.println(list.remove(0)); //-15
        } catch (OverflowingListException e) {
            e.printStackTrace();
        }
    }
}
