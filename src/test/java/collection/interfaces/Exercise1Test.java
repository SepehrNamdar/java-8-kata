package collection.interfaces;

import common.tool.dataset.ClassicOnlineStore;
import common.tool.entity.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise1Test extends ClassicOnlineStore {

    @Test
    public void iterateByForEach() {
        Iterable<Customer> customerIterable = this.mall.getCustomerList();
        List<String> nameList = new ArrayList<>();

        /**
         * Create a {@link Consumer} which represents an operation to add customer's name to {@link nameList} list.
         * Iterate {@link customerIterable} with {@link Iterable#forEach} and use the {@link Consumer}
         * to finish creating the name list.
         */
        Consumer<Customer> consumer = null;
        // customerIterable.

        assertThat(nameList.toString(), is("[Joe, Steven, Patrick, Diana, Chris, Kathy, Alice, Andrew, Martin, Amy]"));
    }

    @Test
    public void whoHaveNoEInYourName() {
        Collection<String> nameCollection =
                new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link Predicate} which predicates if the input string contains "e".
         * Remove elements from {@link nameCollection} which contains "e" using {@link Collection#removeIf}.
         */
        Predicate<String> predicate = null;
        // nameCollection.

        assertThat(nameCollection.toString(), is("[Patrick, Chris]"));
    }
}
