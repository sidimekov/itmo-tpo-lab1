package task3.emotion;

import com.github.sidimekov.task3.emotion.MuscleSequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MuscleSequenceTest {

    @Test
    void testProbabilityFormula() {
        MuscleSequence seq = new MuscleSequence(false,25);
        assertEquals(0.25, seq.getErrorProbability(), 0.0001);
    }

    @Test
    void testRememberedFlag() {
        MuscleSequence seq = new MuscleSequence(true,10);
        assertTrue(seq.isRemembered());
    }
}
