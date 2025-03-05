import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.*;

public class StoneTest {
    @ParameterizedTest
    @MethodSource("stonesCombinations")
    void testVoiceOutput(int number, String timeOfDay, String currentWeather, String currentEnvironment) {
        Stone testStone = new Stone();
        testStone.setTimeOfDay(timeOfDay);
        testStone.setWeather(currentWeather);
        testStone.setEnvironment(currentEnvironment);
        
        testStone.talkTo("Hey, how are you doing?");
        assertNull("Stone's answer: " + number + "-" + timeOfDay + "-" + 
                  currentWeather + "-" + currentEnvironment, 
                  testStone.listenForReply());
    }

    static Stream<Arguments> stonesCombinations() {
        return combinations(
            new Integer[] {1, 2},
            new String[] {"NIGHT", "NOON", "TEATIME", "DINNERTIME"},
            new String[] {"RAINY", "FOGGY", "SUNNY", "SNOWY"},
            new String[] {"FLOOR", "MEADOW", "STREET"}
        );
    }

    static Stream<Arguments> combinations(Object[]... values) {
        Stream.Builder<Arguments> builder = Stream.builder();
        Object[] arguments = new Object[values.length];
        new Object() {
            void perm(int index) {
                if (index >= values.length) {
                    builder.add(Arguments.of(arguments.clone()));
                } else {
                    for (Object val : values[index]) {
                        arguments[index] = val;
                        perm(index + 1);
                    }
                }
            }
        }.perm(0);
        return builder.build();
    }
} 