import static org.junit.jupiter.api.Assertions.*;

public class StoneTest {
    
    // Basic test from question/0.java
    @Test
    public void testVoiceOutput() {
        Stone testStone = new Stone();
        testStone.talkTo("Hey, how are you doing?");
        assertNull("Stone's answer", testStone.listenForReply());
    }

    // Environment loop from question/1.java
    @Test
    public void testVoiceOutput() {
        Stone testStone = new Stone();
        for (String currentEnvironment : new String[]{"FLOOR", "MEADOW", "STREET"}) {
            testStone.setEnvironment(currentEnvironment);
            testStone.talkTo("Hey, how are you doing?");
            assertNull("Stone's answer, environment=" + currentEnvironment, testStone.listenForReply());
        }
    }

    // Full parameter combination from question/2.java
    @Test
    public void testVoiceOutput() {
        Stone testStone = new Stone();
        for (String timeOfDay : new String[]{"NIGHT", "NOON", "TEATIME", "DINNERTIME"}) {
            for (String currentWeather : new String[]{"RAINY", "FOGGY", "SUNNY", "SNOWY"}) {
                for (String currentEnvironment : new String[]{"FLOOR", "MEADOW", "STREET"}) {
                    testStone.setTimeOfDay(timeOfDay);
                    testStone.setWeather(currentWeather);
                    testStone.setEnvironment(currentEnvironment);
                    testStone.talkTo("Hey, how are you doing?");
                    assertNull("Stone's answer, environment=" + currentEnvironment + 
                             ", weather=" + currentWeather + ", time=" + timeOfDay, 
                             testStone.listenForReply());
                }
            }
        }
    }
} 