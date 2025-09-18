import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AdvancedArrayListOpsTest {

    public AdvancedArrayListOps ops;

    @BeforeEach
    public void set() {
        ops = new AdvancedArrayListOps();
        ops.append("Apple");
        ops.append("Banana");
        ops.append("apricot");
        ops.append("Cherry");
        ops.append("banana");
    }

    @Test
    public void testInsertAndSearch() {
        ops.insert(2, "Mango");
        assertTrue(ops.search("Mango"));
        assertFalse(ops.search("Pineapple"));
    }

    @Test
    public void caseAndLetter() {
        ops.sortup();
        ArrayList<String> A = ops.letter("a");
        assertEquals(Arrays.asList("Apple", "apricot"), A);
    }
}