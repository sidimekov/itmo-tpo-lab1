package task3.entity;

import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.entity.Vogon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VogonTest {

    @Test
    void testRefresh() {
        Vogon vogon = new Vogon("Vogon Jeltz", "angry", 0.1, 3);
        vogon.refresh();
        assertEquals("refreshed", vogon.getMood());
    }

    @Test
    void testShoutAtPrisonerSingle() {
        Vogon vogon = new Vogon("Vogon Jeltz", "angry", 0.2, 3);
        Prisoner prisoner = new Prisoner("Alice", "neutral");

        vogon.shoutAt(prisoner);

        assertEquals(3, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }

    @Test
    void testShoutAtPrisonerMultiple() {
        Vogon vogon = new Vogon("Vogon", "angry", 0.1, 2);
        Prisoner prisoner = new Prisoner("Bob", "neutral");

        vogon.shoutAt(prisoner);
        vogon.shoutAt(prisoner);
        vogon.shoutAt(prisoner);

        assertEquals(6, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }

    @Test
    void testSmileSpeedAndShoutPower() {
        Vogon vogon = new Vogon("Vogon", "neutral", 0.25, 4);
        assertEquals(0.25, vogon.getSmileSpeed());
        assertEquals(4, vogon.getShoutPower());
    }

    @Test
    void testShoutAtNullPrisonerThrows() {
        Vogon vogon = new Vogon("Vogon", "angry", 0.1, 3);
        assertThrows(NullPointerException.class, () -> vogon.shoutAt(null));
    }

    @Test
    void testExtremeShoutPower() {
        Vogon vogon = new Vogon("Vogon", "neutral", 0.1, Integer.MAX_VALUE);
        Prisoner prisoner = new Prisoner("Extreme", "neutral");

        vogon.shoutAt(prisoner);
        assertEquals(Integer.MAX_VALUE, prisoner.getFearLevel());
        assertEquals("scared", prisoner.getMood());
    }

    @Test
    void testExtremeSmileSpeed() {
        Vogon vogon1 = new Vogon("V1", "neutral", 0.0, 1);
        Vogon vogon2 = new Vogon("V2", "neutral", Double.MAX_VALUE, 1);

        assertEquals(0.0, vogon1.getSmileSpeed());
        assertEquals(Double.MAX_VALUE, vogon2.getSmileSpeed());
    }
}
