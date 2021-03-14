import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ReferenceStreamShould {

    @Test
    void be_inaccessible_when_a_terminal_operation_is_executed() {
        DoubleStream doubleStream = DoubleStream.iterate(0, i -> i).limit(3);

        assertThat(doubleStream.count()).isEqualTo(3);
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(doubleStream::findFirst);
    }

    @Test
    void works_with_collectors() {  // Prefer this solution
        DoubleStream doubleStream = DoubleStream.iterate(0, i -> i).limit(3);
        List<Double> doubleList = doubleStream.boxed().collect(toList());

        assertThat(doubleList.stream().count()).isEqualTo(3);
        assertThat(doubleList.stream().findFirst().get()).isEqualTo(0);
    }

    @Test
    void works_with_supplier() {
        Supplier<DoubleStream> streamSupplier = () -> DoubleStream.iterate(0, i -> i).limit(3);

        assertThat(streamSupplier.get().count()).isEqualTo(3);
        assertThat(streamSupplier.get().findFirst().getAsDouble()).isEqualTo(0);
    }
}
