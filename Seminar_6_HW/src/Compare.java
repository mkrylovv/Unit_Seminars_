public class Compare {

    public String compareAverageValue(double val1, double val2) {
        if (val1 > val2) {
            return "Первый список имеет большее среднее значение";
        } else if (val1 < val2) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
