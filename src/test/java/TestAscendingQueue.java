import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAscendingQueue {

    @Test
    public void ascendingQueueFalseTest(){
        Queue<Integer> testQueue = new LinkedList<>();
        testQueue.add(5);
        testQueue.add(1);
        testQueue.add(2);
        testQueue.add(6);
        testQueue.add(3);
        testQueue.add(4);
        assertFalse(QueueExercise.ascendingQueue(testQueue));
    }

    @Test
    public void ascendingQueueTrueTest(){
        Queue<Integer> testQueue = new LinkedList<>();
        testQueue.add(1);
        testQueue.add(5);
        testQueue.add(2);
        testQueue.add(3);
        testQueue.add(4);
        assertTrue(QueueExercise.ascendingQueue(testQueue));
    }

    @Test
    public void emptyQueueTest(){
        Queue<Integer> emptyQueue = new LinkedList<>();
        assertFalse(QueueExercise.ascendingQueue(emptyQueue));
    }




}
