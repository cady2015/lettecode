import D_common.Node;

public class testPrintList {
    public static void main(String[] args) {
        Node node = new Node(2,new Node(4,new Node(3)));

        node.printList(node);
    }
}
