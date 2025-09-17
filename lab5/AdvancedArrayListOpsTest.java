import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.*;

public class AdvancedArrayListOpsTest {

    private AdvancedArrayListOps ops;

    @BeforeEach
    public void setup() {
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
    public void testSortAndLetterFilter() {
        ops.sortup();
        ArrayList<String> startsWithA = ops.letter("a");
        assertEquals(Arrays.asList("Apple", "apricot"), startsWithA);
    }

    @Test
