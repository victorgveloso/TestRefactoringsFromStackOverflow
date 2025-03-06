import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.function.*;

//P is the type of the Permutation object, T is the type of the parameter
class Parameter<P, T> {
    private final List<T> values;
    private final BiConsumer<P, T> setter;              
    private Parameter<P, ?> next;
    
    private int valueIndex = 0;
    private boolean indexReset = false;
    
    //first in line
    //pass the setter first and the values as varargs for convenience
    public Parameter(BiConsumer<P, T> setter, T... vals) {
        this(null, setter, vals);
    }

    //next chain elements
    //pass the previous element and the setter first and the values as varargs for convenience
    public Parameter(Parameter<P, ?> prev, BiConsumer<P, T> setter, T... vals) {            
        this.values = Arrays.stream(vals).collect(Collectors.toList());
        this.setter = setter;
        
        if( prev != null ) {
            prev.next = this;
        }
    }
    
    //add the next parameter in the chain
    public void setNext(Parameter<P, ?> next) {
        this.next = next;
    }

    //creates the permutations and uses the supplier to create a new instance at the end of the chain
    public List<P> createPermutations(Supplier<P> instanceSupplier) {
        //we don't know the number of permutations so use a linked list here
        List<P> permutations = new LinkedList<>();
        
        //run as long as the index didn't get reset to 0 (reached the end of 1 complete iteration)
        while( !indexReset ) {
            permutations.add(build(instanceSupplier));
        }
        
        return permutations;
    }

    //builds a single permutation by passing the command along the chain
    private P build(Supplier<P> instanceSupplier) {
        P permutation;
        
        //at the end of the chain build the permutation first, otherwise follow the chain
        if( next == null ) {
            permutation = instanceSupplier.get();
        } else {        
            permutation = next.build(instanceSupplier);             
        }
        
        //at this point we're unwinding, i.e. follow the chain tail to head

        //set the value, the index is basically the permutation index so we need to get it into range
        setter.accept(permutation, values.get(valueIndex));

        //assume the index has not reset, we'll check this next
        indexReset = false; 

        //increment the index if there is no next parameter or it has reset in this chain of calls
        if( next == null || next.indexReset ) {
            
            //increment
            valueIndex++;
            
            //reset if needed
            if( valueIndex >= values.size() ) {
                valueIndex = 0;
                indexReset = true;
            }
        }
        
        return permutation;
    }   
}

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
        Parameter<Stone, String> timeParam = new Parameter<>(Stone::setTimeOfDay, 
            "NIGHT", "NOON", "TEATIME", "DINNERTIME");
        Parameter<Stone, String> weatherParam = new Parameter<>(timeParam, Stone::setWeather, 
            "RAINY", "FOGGY", "SUNNY", "SNOWY");
        Parameter<Stone, String> envParam = new Parameter<>(weatherParam, Stone::setEnvironment, 
            "FLOOR", "MEADOW", "STREET");
            
        List<Stone> permutations = timeParam.createPermutations(Stone::new);
        
        for (Stone stone : permutations) {
            stone.talkTo("Hey, how are you doing?");
            assertNull("Stone's answer: " + stone.getState(), stone.listenForReply());
        }
    }
} 