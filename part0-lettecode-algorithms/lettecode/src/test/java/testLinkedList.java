import java.util.LinkedList;

public class testLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (int i : list){
            System.out.println(i);
        }
    }
}
