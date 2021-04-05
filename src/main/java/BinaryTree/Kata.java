package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kata {

    public List<Integer> treeByLevels(Node node) {

        List<Integer> nodeList = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

//        while (!nodeQueue.isEmpty()) {
//            Node visitedNode = nodeQueue.remove();
//            if (visitedNode == null) {
//                continue;
//            }
//            nodeList.add(visitedNode.value);
//            nodeQueue.add(visitedNode.left);
//            nodeQueue.add(visitedNode.right);
//        }

        while (!nodeQueue.isEmpty()) {
            Node visitedNode = nodeQueue.remove();
            nodeList.add(visitedNode.value);
            if (visitedNode.left != null) {
                nodeQueue.add(visitedNode.left);
            }
            if (visitedNode.right != null) {
                nodeQueue.add(visitedNode.right);
            }
        }
        return nodeList;
    }
}
