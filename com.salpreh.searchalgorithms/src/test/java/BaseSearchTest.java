import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BaseSearchTest {

    protected List<Integer> getSortedList(int start, int end) {
        return IntStream.range(start, end + 1)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
