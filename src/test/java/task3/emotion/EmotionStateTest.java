package task3.emotion;

import com.github.sidimekov.task3.emotion.EmotionState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmotionStateTest {

    @Test
    void testInitialState() {
        EmotionState state = new EmotionState("fear", 5);
        assertEquals("fear", state.getValue());
        assertEquals(5, state.getIntensity());
    }

    @Test
    void testIntensityGrowthLogFormula() {
        EmotionState state = new EmotionState("fear",0);
        state.increaseIntensity(9);
        double expected = Math.log1p(9);
        assertEquals(expected, state.getIntensity(),0.0001);
    }

    @Test
    void testMultipleGrowth() {
        EmotionState state = new EmotionState("fear",0);
        state.increaseIntensity(4);
        state.increaseIntensity(4);
        double expected = Math.log1p(4) + Math.log1p(4);
        assertEquals(expected,state.getIntensity(),0.0001);
    }
}
