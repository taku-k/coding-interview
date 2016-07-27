package cracking_the_coding_interview;

/**
 * Created by taku on 2016/05/07.
 */
public class Node {

    static Node createNodes(int... ary) {
        Node h = new Node(ary[0]);
        for (int i = 1; i < ary.length; i++) {
            h.appendToTail(ary[i]);
        }
        return h;
    }

    static boolean checkData(Node n, int... ary) {
        int index = 0;
        do {
            if (n.data != ary[index])
                return false;
            n = n.next;
            index++;
        } while(n != null);
        if (index != ary.length)
            return false;
        return true;
    }

    public Node next = null;
    public int data;

    Node(int d) {
        this.data = d;
    }

    public Node addArray(int... ary) {
        if (ary.length == 0) {
            return this;
        }


        Node h = new Node(ary[0]);
        this.next = h;
        Node prev = h;
        for (int i = 1; i < ary.length; i++) {
            Node n = new Node(ary[i]);
            prev.next = n;
            prev = n;
        }
        return this;
    }

    public void printAll() {
        Node n = this;
        while (n.next != null) {
            System.out.printf("%d ", n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    public Node appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
        return this;
    }
}