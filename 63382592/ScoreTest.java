import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScoreTest {
    int[][] games = {
        {0,0,0,0,0,0,0,0,0,0},
        {10,10,10,10,10,10,10,10,10,10,10,10}
    };
    int[] scores = {0, 300};
    
    @Test
    public void testScore() {
        for(int i=0; i<games.length; i++) {
            int[] game = games[i];
            int expectedScore = scores[i];
            Score score = new Score();
            score.roll(game);
            int actualScore = score.total();
            assertEquals(expectedScore, actualScore);
        }
    }
} 