package task3.entity;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.shoutEvent.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrisonerTest {

    @Test
    void testFearFormula() {
        Prisoner prisoner = new Prisoner("Arthur", new EmotionState("neutral",0));
        prisoner.receiveShout(10);
        double expected = Math.pow(10,2)/10.0;
        assertEquals(expected, prisoner.getFearLevel(),0.001);
    }

    @Test
    void testFearAccumulation() {
        Prisoner prisoner = new Prisoner("Arthur", new EmotionState("neutral",0));
        prisoner.receiveShout(5);
        prisoner.receiveShout(5);
        double expected = (25/10.0)+(25/10.0);
        assertEquals(expected, prisoner.getFearLevel(),0.001);
    }

    @Test
    void testReactToEvent() {
        Prisoner prisoner = new Prisoner("Ford", new EmotionState("neutral",0));
        Event event = target -> target.setEmotion(new EmotionState("scared",5));
        prisoner.reactToEvent(event);
        assertEquals("scared", prisoner.getEmotion().getValue());
    }
}
