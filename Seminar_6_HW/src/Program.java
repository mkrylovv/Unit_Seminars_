import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Calculate calculate = new Calculate();
        Compare compare = new Compare();
        List<Integer> list1 = Arrays.asList(1, 10, 15, 23, 7);
        List<Integer> list2 = Arrays.asList(1, 100, 250);
        double average1 = calculate.calculateAverageValue(list1);
        double average2 = calculate.calculateAverageValue(list2);
        System.out.println(compare.compareAverageValue(average1, average2));

    }
}
