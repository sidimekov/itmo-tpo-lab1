package task3.entity;

import com.github.sidimekov.task3.entity.Human;
import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.entity.Vogon;
import com.github.sidimekov.task3.event.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    @Test
    void testGetSetMoodAndName() {
        Human prisoner = new Prisoner("Alice", "neutral");
        assertEquals("Alice", prisoner.getName());
        assertEquals("neutral", prisoner.getMood());

        prisoner.setMood("happy");
        assertEquals("happy", prisoner.getMood());

        Human vogon = new Vogon("Vogon Jeltz", "angry", 0.5, 3);
        assertEquals("Vogon Jeltz", vogon.getName());
        assertEquals("angry", vogon.getMood());
        vogon.setMood("calm");
        assertEquals("calm", vogon.getMood());
    }

    @Test
    void testReactToEventChangesMood() {
        Human prisoner = new Prisoner("Bob", "neutral");
        Event event = target -> target.setMood("scared");

        prisoner.reactToEvent(event);
        assertEquals("scared", prisoner.getMood());

        Human vogon = new Vogon("Vogon", "angry", 0.1, 5);
        vogon.reactToEvent(event);
        assertEquals("scared", vogon.getMood());
    }

    @Test
    void testReactToMultipleEvents() {
        Prisoner prisoner = new Prisoner("P1", "neutral");

        Event event1 = target -> target.setMood("happy");
        Event event2 = target -> target.setMood("scared");
        Event event3 = target -> target.setMood("bored");

        prisoner.reactToEvent(event1);
        prisoner.reactToEvent(event2);
        prisoner.reactToEvent(event3);

        assertEquals("bored", prisoner.getMood());
    }

    @Test
    void testReactToEventNullThrows() {
        Prisoner prisoner = new Prisoner("P2", "neutral");
        assertThrows(NullPointerException.class, () -> prisoner.reactToEvent(null));
    }
}
