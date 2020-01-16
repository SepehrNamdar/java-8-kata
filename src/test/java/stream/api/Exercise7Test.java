package stream.api;

import common.tool.dataset.ClassicOnlineStore;
import common.tool.entity.Customer;
import common.tool.entity.Item;
import common.tool.entity.Shop;
import org.junit.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Exercise7Test extends ClassicOnlineStore {

    @Test
    public void averageAge() {
        List<Customer> customerList = this.mall.getCustomerList();

        /*
         * Create {@link IntStream} with customer ages by using {@link Stream#mapToInt}
         * Then calculate the average of ages by using {@link IntStream#average}
         */
        IntStream ageStream = customerList.stream().mapToInt(Customer::getAge);
        OptionalDouble average = ageStream.average();

        assertThat(average.getAsDouble(), is(28.7));
    }

    @Test
    public void howMuchToBuyAllItems() {
        List<Shop> shopList = this.mall.getShopList();

        /*
         * Create {@link LongStream} with all items' prices using {@link Stream#mapToLong}
         * Then calculate the sum of prices using {@link LongStream#sum}
         */
        LongStream priceStream = shopList.stream()
                .flatMap(shop -> shop.getItemList().stream()).mapToLong(Item::getPrice);
        long priceSum = priceStream.sum();

        assertThat(priceSum, is(60930L));
    }
}
