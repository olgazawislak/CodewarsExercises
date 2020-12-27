import java.util.Queue;
import java.util.Stack;

public class QueueExercise {
    public static boolean ascendingQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;
        if (queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()) {
            int element = queue.peek();
            queue.poll();

            if (element == expected) {
                expected++;
            } else {
                if (stack.empty() || element < stack.firstElement()) {
                    stack.add(element);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
