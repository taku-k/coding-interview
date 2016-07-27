package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by taku on 7/26/16.
 */
public class StackUsingQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (q2.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> tmp1 = q1, tmp2 = q2;
        if (q1.isEmpty()) {
            tmp1 = q2;
            tmp2 = q1;
        }

        while (tmp1.size() > 1) {
            Integer x = tmp1.poll();
            tmp2.add(x);
        }
        tmp1.poll();
    }

    // Get the top element.
    public int top() {
        Queue<Integer> tmp1 = q1, tmp2 = q2;
        if (q1.isEmpty()) {
            tmp1 = q2;
            tmp2 = q1;
        }
        int x = 0;
        while (tmp1.size() > 0) {
            x = tmp1.poll();
            tmp2.add(x);
        }
        return x;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
