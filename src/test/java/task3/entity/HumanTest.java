package task3.entity;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.entity.Human;
import com.github.sidimekov.task3.shoutEvent.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    private static class TestHuman extends Human {
        public TestHuman(String name, EmotionState emotion) {
            super(name, emotion);
        }
        @Override
        public void reactToEvent(Event event) {
            event.execute(this);
        }
    }

    @Test
    void testGetName() {
        Human human = new TestHuman("Arthur", new EmotionState("neutral",0));
        assertEquals("Arthur", human.getName());
    }

    @Test
    void testGetEmotion() {
        EmotionState state = new EmotionState("happy",3);
        Human human = new TestHuman("Ford",state);
        assertEquals(state, human.getEmotion());
    }

    @Test
    void testSetEmotion() {
        Human human = new TestHuman("Arthur", new EmotionState("neutral",0));
        EmotionState newState = new EmotionState("scared",5);
        human.setEmotion(newState);
        assertEquals(newState, human.getEmotion());
    }

    @Test
    void testReactToEvent() {
        Human human = new TestHuman("Arthur", new EmotionState("neutral",0));
        Event event = target -> target.setEmotion(new EmotionState("panic",10));
        human.reactToEvent(event);
        assertEquals("panic", human.getEmotion().getValue());
    }

    @Test
    void testEmotionIntensityChangeThroughEvent() {
        Human human = new TestHuman("Arthur", new EmotionState("neutral",0));
        Event event = target -> target.getEmotion().increaseIntensity(9);
        human.reactToEvent(event);
        double expected = Math.log1p(9);
        assertEquals(expected, human.getEmotion().getIntensity(), 0.0001);
    }
}