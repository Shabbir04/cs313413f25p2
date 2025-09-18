package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

    // Run test with SIZE = 10, 100, 1000, 10000 to observe performance trends
    // Choose REPS to get measurable running times (tens of seconds for larger sizes)
    private final int SIZE = 10000;
    private final int REPS = 100000;

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList<Integer>(SIZE);
        linkedList = new LinkedList<Integer>();
        for (var i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @After
    public void tearDown() throws Exception {
        arrayList = null;
        linkedList = null;
    }

    @Test
    public void testLinkedListAddRemove() {
        for (var r = 0; r < REPS; r++) {
            linkedList.add(0, 77);
            linkedList.remove(0);
        }
    }

    @Test
    public void testArrayListAddRemove() {
        for (var r = 0; r < REPS; r++) {
            arrayList.add(0, 77);
            arrayList.remove(0);
        }
    }

    @Test
    public void testLinkedListAccess() {
        var sum = 0L;
        for (var r = 0; r < REPS; r++) {
            sum += linkedList.get(r % SIZE);
        }
    }

    @Test
    public void testArrayListAccess() {
        var sum = 0L;
        for (var r = 0; r < REPS; r++) {
            sum += arrayList.get(r % SIZE);
        }
    }
}