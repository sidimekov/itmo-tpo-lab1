package task3.entity;

import com.github.sidimekov.task3.entity.Prisoner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrisonerTest {

    @Test
    void testReceiveShoutSingle() {
        Prisoner prisoner = new Prisoner("Charlie", "neutral");
        prisoner.receiveShout(5);
        assertEquals(5, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }

    @Test
    void testReceiveShoutMultiple() {
        Prisoner prisoner = new Prisoner("Dana", "neutral");
        prisoner.receiveShout(3);
        prisoner.receiveShout(7);
        assertEquals(10, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }

    @Test
    void testMultiplePrisonersScenario() {
        Prisoner p1 = new Prisoner("P1", "neutral");
        Prisoner p2 = new Prisoner("P2", "happy");

        p1.receiveShout(2);
        p2.receiveShout(4);

        assertEquals(2, p1.getFearLevel());
        assertEquals(4, p2.getFearLevel());
        assertEquals("scared", p1.getMood());
        assertEquals("scared", p2.getMood());
    }
}
