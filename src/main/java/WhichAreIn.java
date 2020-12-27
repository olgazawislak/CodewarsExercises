import java.util.Arrays;

public class WhichAreIn {
    /**
     *
     * @param array1 array of strings
     * @param array2 array of strings
     * @return a sorted array in lexicographical order of the strings of a1 which are substrings of strings of a2
     */

    public String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(str -> isSubstringInArray(str, array2))
                .sorted()
                .toArray(String[]::new);
    }

    private boolean isSubstringInArray(String word, String[] array) {
        return Arrays.stream(array)
                .anyMatch(str -> str.contains(word));
    }
}