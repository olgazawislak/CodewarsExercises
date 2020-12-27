import java.util.Deque;
import java.util.LinkedList;

public class BraceChecker {

    public boolean isValid(String braces) {
        if (braces.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : braces.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
            } else {
                if (!stack.isEmpty() && (
                        stack.peekFirst() == '{' && c == '}' || stack.peekFirst() == '[' && c == ']' || stack.peekFirst() == '(' && c == ')')) {
                    stack.removeFirst();
                }
                return false;
            }
        }
        return true;
    }
}