import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScoreTest {
    private static class BowlingTestGame {
        final String name;
        final int[] rolls;
        final int expected;

        BowlingTestGame(String name, int[] rolls, int expected) {
            this.name = name;
            this.rolls = rolls;
            this.expected = expected;
        }
    }

    BowlingTestGame[] testCases = {
        new BowlingTestGame("Gutter Game", 
            new int[]{0,0,0,0,0,0,0,0,0,0}, 0),
        new BowlingTestGame("Perfect Game", 
            new int[]{10,10,10,10,10,10,10,10,10,10,10,10}, 300)
    };

    @Test
    public void testAllCases() {
        for (BowlingTestGame tc : testCases) {
            Score score = new Score();
            score.roll(tc.rolls);
            assertEquals(tc.name, tc.expected, score.total());
        }
    }
} 