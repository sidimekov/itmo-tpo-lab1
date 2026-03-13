package task3.entity;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaptiveGroupTest {

    @Test
    void testAddPrisoner() {
        CaptiveGroup group = new CaptiveGroup();
        Prisoner p = new Prisoner("A", new EmotionState("n",0));
        group.addPrisoner(p);
        assertEquals(1, group.getPrisoners().size());
    }

    @Test
    void testTotalFear() {
        Prisoner p1 = new Prisoner("A", new EmotionState("n",0));
        Prisoner p2 = new Prisoner("B", new EmotionState("n",0));

        p1.receiveShout(10);
        p2.receiveShout(10);

        CaptiveGroup group = new CaptiveGroup();
        group.addPrisoner(p1);
        group.addPrisoner(p2);

        double fear = Math.pow(10,2)/10.0;
        assertEquals((int)(fear*2), group.totalFear());
    }
}
