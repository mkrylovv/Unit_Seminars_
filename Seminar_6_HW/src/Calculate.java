import java.util.List;

public class Calculate {

    public double calculateAverageValue(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new RuntimeException("Список чисел не должен быть пустым");
        }
        double averageValue = 0;
        for (int number : numbers) {
            averageValue += number;
        }
        return averageValue / numbers.size();
    }
}
