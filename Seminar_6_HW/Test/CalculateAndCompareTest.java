import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateAndCompareTest {

    private Calculate calculate;
    private Compare compare;

    @BeforeEach
    void setUp() {
        calculate = new Calculate();
        compare = new Compare();
    }

    @Test
    public void testCalculateAverageValue() {

        assertThatThrownBy(() ->
                calculate.calculateAverageValue(Arrays.asList())
        ).isInstanceOf(RuntimeException.class).hasMessage("Список чисел не должен быть пустым");

        assertEquals(1, calculate.calculateAverageValue(Arrays.asList(1)));
        assertEquals(0, calculate.calculateAverageValue(Arrays.asList(1, -1)));
        assertEquals(-7.5, calculate.calculateAverageValue(Arrays.asList(-5, -10)));

    }

    @Test
    public void testCompareAverageValue() {

        assertThat(compare.compareAverageValue(1.1, 1)).isEqualTo("Первый список имеет большее среднее значение");
        assertThat(compare.compareAverageValue(1, 1.1)).isEqualTo("Второй список имеет большее среднее значение");
        assertThat(compare.compareAverageValue(10, 10)).isEqualTo("Средние значения равны");
        assertThat(compare.compareAverageValue(1, -1)).isEqualTo("Первый список имеет большее среднее значение");
        assertThat(compare.compareAverageValue(-1, 1)).isEqualTo("Второй список имеет большее среднее значение");
        assertThat(compare.compareAverageValue(-1, -5)).isEqualTo("Первый список имеет большее среднее значение");
        assertThat(compare.compareAverageValue(-5, -1)).isEqualTo("Второй список имеет большее среднее значение");
        assertThat(compare.compareAverageValue(-1, -1)).isEqualTo("Средние значения равны");
    }

    @Test
    public void testCalculateAndCompareAverageValue() {
        double average1 = calculate.calculateAverageValue(Arrays.asList(1, 10, 15));
        double average2 = calculate.calculateAverageValue(Arrays.asList(5, -33, -48));
        assertEquals("Первый список имеет большее среднее значение", compare.compareAverageValue(average1, average2));
    }
}
