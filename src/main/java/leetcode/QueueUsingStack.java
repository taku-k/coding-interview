package leetcode;

import java.util.Stack;

/**
 * Created by taku on 7/26/16.
 */
public class QueueUsingStack {
    Stack<Integer> s1, s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (s1.size() > 1) {
            Integer x = s1.pop();
            s2.push(x);
        }
        s1.pop();
        while (!s2.isEmpty()) {
            Integer x = s2.pop();
            s1.push(x);
        }
    }

    // Get the front element.
    public int peek() {
        Integer ret = 0;
        while (s1.size() > 1) {
            Integer x = s1.pop();
            s2.push(x);
        }
        ret = s1.pop();
        s2.push(ret);
        while (!s2.isEmpty()) {
            Integer x = s2.pop();
            s1.push(x);
        }
        return ret;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}
