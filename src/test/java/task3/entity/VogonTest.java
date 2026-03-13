package task3.entity;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.emotion.MuscleSequence;
import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.entity.Vogon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VogonTest {

    @Test
    void testSmileTimeFormula() {
        Vogon vogon = new Vogon("Jeltz", new EmotionState("angry",1), 0.5, 10);
        MuscleSequence seq = new MuscleSequence(false,20);
        double time = vogon.calculateSmileTime(seq);
        assertEquals(40,time);
    }

    @Test
    void testShoutAt() {
        Vogon v = new Vogon("V", new EmotionState("angry",1), 0.5, 10);
        Prisoner p = new Prisoner("P", new EmotionState("neutral",0));
        v.shoutAt(p);
        double expected = Math.pow(10,2)/10.0;
        assertEquals(expected,p.getFearLevel(),0.001);
    }

    @Test
    void testRefresh() {
        Vogon v = new Vogon("V", new EmotionState("angry",5), 0.5, 10);
        v.refresh();
        assertEquals("refreshed", v.getEmotion().getValue());
    }

    @Test
    void testReactToEvent() {
        Vogon v = new Vogon("V", new EmotionState("neutral",0), 0.5, 10);
        v.reactToEvent(target -> target.setEmotion(new EmotionState("happy",10)));
        assertEquals("happy", v.getEmotion().getValue());
    }
}
