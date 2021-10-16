import com.salpreh.searchalgorithms.BinarySearchService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchServiceTest extends BaseSearchTest {

    @Test
    public void searchTest() {
        BinarySearchService searchService = new BinarySearchService();
        List<Integer> list = getSortedList(10, 80);
        Integer pos = searchService.search(list, 45); // pos: 35

        assertEquals(35, pos);
    }
}
