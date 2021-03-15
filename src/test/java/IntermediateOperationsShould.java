import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntermediateOperationsShould {

    @Test
    void filter_a_stream() {
        IntStream greaterThanThree = IntStream.range(1, 5)
                .filter(value -> value > 3);

        assertThat(greaterThanThree).contains(4);

        Stream<String> fruits = Stream.of("Apple", "Jack Fruit", "Water Melon", "Apple");
        Stream<String> distinctFruits = fruits.distinct();

        assertThat(distinctFruits).containsExactly("Apple", "Jack Fruit", "Water Melon");

        String[] richestPeople =
                new String[] {"Elon Musk", "Jeff Bezos", "Bill Gates", "Bernard Arnault", "Mark Zuckerberg"};

        Stream<String> TwoRichestPeople = Arrays.stream(richestPeople).limit(2);

        assertThat(TwoRichestPeople).containsExactly(richestPeople[0], richestPeople[1]);

        Stream<String> lastRichestPerson = Arrays.stream(richestPeople).skip(richestPeople.length - 1);

        assertThat(lastRichestPerson).containsExactly(richestPeople[4]);
    }

    @Test
    void map_a_stream() {
        IntStream doubleNumbers = IntStream.range(1, 5)
                .map(i -> i * 2);

        assertThat(doubleNumbers).contains(2, 4, 6, 8);

        List<List<String>> listOfList = Arrays.asList(
                Collections.singletonList("a"),
                Collections.singletonList("b"));

        Stream<String> upperCase = listOfList.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase);

        assertThat(upperCase).contains("A", "B");
    }

    @Test
    void sort_a_stream() {
        Stream<String> vegetables = Stream.of("tomato", "Green Chilli", "Potato", "Beet root");
        Stream<String> sortedVegetables = vegetables.sorted();

        assertThat(sortedVegetables).containsOnly("Beet root", "Green Chilli", "Potato", "tomato");
    }

    @Test
    void be_debuggable() {
        String[] stringArray = new String[] {"a", "b", "c"};
        Stream<String> arrayStream = Arrays.stream(stringArray)
                .peek(System.out::println);

        assertThat(arrayStream).containsExactly(stringArray);

        Stream<String> numbers = Stream.of("one", "two", "three", "four")
                .filter(number -> number.length() > 3)
                .peek(value -> System.out.println("Filtered value: " + value))
                .map(String::toUpperCase)
                .peek(value -> System.out.println("Mapped value: " + value));

        assertThat(numbers).containsOnly("THREE", "FOUR");
    }
}
