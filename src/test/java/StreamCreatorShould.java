import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamCreatorShould {

    @Test
    void create_an_empty_stream() {
        Stream<String> emptyStream = Stream.empty();    // Avoid null

        assertThat(emptyStream).isEmpty();
    }

    @Test
    void create_a_stream() {
        Stream<Boolean> aStream = Stream.of(true, false);

        assertThat(aStream).containsExactly(true, false);
    }

    @Test
    void create_a_stream_from_a_collection() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);    // Collection : List, Set, Map, etc.
        Stream<Integer> collectionStream = collection.stream();

        assertThat(collectionStream).contains(1, 2, 3);
    }

    @Test
    void create_a_stream_from_an_array() {
        String[] stringArray = new String[] {"a", "b", "c"};
        Stream<String> fullArrayStream = Arrays.stream(stringArray);
        Stream<String> partialArrayStream = Arrays.stream(stringArray, 1, 3);

        assertThat(fullArrayStream).containsOnly("a", "b", "c");
        assertThat(partialArrayStream).containsOnly("b", "c");
    }

    @Test
    void be_created_with_a_builder() {
        Stream<Integer> streamBuilder =     // Without <Integer> before builder() we get a stream of Object
                Stream.<Integer>builder().add(1).add(2).add(3).build();

        assertThat(streamBuilder).contains(1, 2, 3);
    }

    @Test
    void be_created_with_iteration() {
        Stream<Integer> oddNumbersUntilFour = Stream.iterate(0, n -> n + 2).limit(3);

        assertThat(oddNumbersUntilFour).contains(0, 2, 4);
    }

    @Test
    void create_primitive_streams() {
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        assertThat(intStream).contains(1, 2);
        assertThat(longStream).contains(1L, 2L, 3L);
        assertThat(doubleStream).hasSize(3);
    }
}
