import java.util.stream.IntStream;

public class Palindrome {
    /**
     *
     * @return true if word is a palindrome, otherwise false
     */
    public boolean isPalindromeFirstMethod(String word) {
        int startIndex = 0;
        int endIndex = word.length()-1;
        while (startIndex<endIndex) {
            if(word.indexOf(startIndex) != word.indexOf(endIndex)) {
                return false;
            }
            ++startIndex;
            --endIndex;
        }
        return true;
    }

    public boolean isPalindromeSecondMethod(String word) {
        return IntStream.range(0, word.length()/2).noneMatch(i -> word.indexOf(i) != word.indexOf(word.length()-i-1));

    }
}