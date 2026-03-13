package task3.emotion;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.emotion.MuscleSequence;
import com.github.sidimekov.task3.emotion.Smile;
import com.github.sidimekov.task3.entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmileTest {

    @Test
    void testSmileCreation() {
        Vogon v = new Vogon("V", new EmotionState("neutral",0), 0.5, 10);
        MuscleSequence seq = new MuscleSequence(true,20);
        Smile smile = new Smile(v,0.5,seq);
        assertEquals(0.5, smile.getSpeed());
        assertEquals(seq, smile.getSequence());
    }
}
