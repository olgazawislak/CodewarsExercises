package BinaryTreeTest;

import BinaryTree.Kata;
import BinaryTree.Node;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class KataTest {

    Kata kata = new Kata();

    @Test
    public void treeByLevelTest() {
        Node leftNode = new Node(null, null, 5);
        Node rightNode = new Node(null, null, 12);
        Node rootNode = new Node(leftNode,rightNode, 3);

        List<Integer> valueList = Arrays.asList(3, 5, 12);

        assertThat(kata.treeByLevels(rootNode)).isEqualTo(valueList);
    }

}
