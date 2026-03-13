package task3.event;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.entity.Vogon;
import com.github.sidimekov.task3.shoutEvent.ShoutEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoutEventTest {

    @Test
    void testExecuteOnPrisoner() {
        Vogon vogon = new Vogon("Jeltz", new EmotionState("angry",1), 0.5, 10);
        Prisoner prisoner = new Prisoner("Ford", new EmotionState("neutral",0));
        ShoutEvent event = new ShoutEvent(vogon,10);
        event.execute(prisoner);
        double expected = Math.pow(10,2)/10.0;
        assertEquals(expected, prisoner.getFearLevel(), 0.001);
    }

    @Test
    void testExecuteOnNonPrisoner() {
        Vogon vogon = new Vogon("Jeltz", new EmotionState("angry",1), 0.5, 10);
        ShoutEvent event = new ShoutEvent(vogon,10);
        assertDoesNotThrow(() -> event.execute(vogon));
    }
}
