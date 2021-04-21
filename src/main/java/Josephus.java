import java.util.ArrayList;
import java.util.List;

public class Josephus {

    /**
     *
     * @param items list to be permuted
     * @param k length of step
     * @return list of elements after josephus permutation
     */
    public <T> List<T> josephusPermutation(final List<T> items, final int k) {
        if (k == 1) {
            return items;
        }
        List<T> copyItems = new ArrayList<>(items);
        List<T> executionList = new ArrayList<>();
        int index = -1;
        while(!copyItems.isEmpty()) {
            int deletedIndex = (k+index) % copyItems.size();
            executionList.add(copyItems.get(deletedIndex));
            copyItems.remove(deletedIndex);
            index = deletedIndex - 1;
        }
        return executionList;
    }
}
