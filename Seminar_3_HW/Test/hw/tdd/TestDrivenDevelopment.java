package hw.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDrivenDevelopment {

    //3.5. Red-Green-Refactor
    @Test
    void testMoodAnalysis() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("Это грустное сообщение");

        assertThat(mood).isEqualTo("SAD");
        assertThat(moodAnalyser.analyseMood("Это обычное сообщение")).isEqualTo("HAPPY");
    }
}