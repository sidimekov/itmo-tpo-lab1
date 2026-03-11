package task3.event;

import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.entity.Vogon;
import com.github.sidimekov.task3.event.ShoutEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoutEventTest {

    @Test
    void testExecuteOnPrisoner() {
        Vogon vogon = new Vogon("Vogon Jeltz", "angry", 0.1, 5);
        Prisoner prisoner = new Prisoner("Charlie", "neutral");

        ShoutEvent event = new ShoutEvent(vogon, vogon.getShoutPower());
        event.execute(prisoner);

        assertEquals(5, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }

    @Test
    void testExecuteMultipleTimes() {
        Vogon vogon = new Vogon("Vogon", "angry", 0.1, 3);
        Prisoner prisoner = new Prisoner("Dana", "neutral");

        ShoutEvent event = new ShoutEvent(vogon, vogon.getShoutPower());
        event.execute(prisoner);
        event.execute(prisoner);
        event.execute(prisoner);

        assertEquals(9, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }

    @Test
    void testExecuteOnNonPrisonerDoesNothing() {
        Vogon vogon = new Vogon("Vogon", "angry", 0.1, 3);
        ShoutEvent event = new ShoutEvent(vogon, vogon.getShoutPower());

        assertDoesNotThrow(() -> event.execute(vogon));
    }

    @Test
    void testExecuteNullThrows() {
        Vogon vogon = new Vogon("Vogon", "angry", 0.1, 3);
        ShoutEvent event = new ShoutEvent(vogon, vogon.getShoutPower());

        assertThrows(NullPointerException.class, () -> event.execute(null));
    }

    @Test
    void testMultipleShoutEventsOnSamePrisoner() {
        Vogon vogon = new Vogon("Vogon", "angry", 0.1, 2);
        Prisoner prisoner = new Prisoner("P", "neutral");

        ShoutEvent event = new ShoutEvent(vogon, vogon.getShoutPower());
        for (int i = 0; i < 5; i++) {
            event.execute(prisoner);
        }

        assertEquals(10, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }
}
