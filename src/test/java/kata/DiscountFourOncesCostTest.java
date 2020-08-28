package kata;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DiscountFourOncesCostTest {
    private Float simplePrice = 4.80f;

    private Float discountprice = 1.99f;
    @Test
    public void shouldApplyDiscount(){
        //given
        int numberOfArticles = 3;
        Float pound = 10f;
        Product product =Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice).pound(pound).discountPrice(discountprice)
                .build();
        DiscountFourOncesCost discount =  new DiscountFourOncesCost();

        //when
        product = product.discount(discount.iDiscount);
        //then
        assertEquals(discountprice * 4 / (pound * 16),product.getPrice(),0.0002);
        assertEquals(  new Integer(numberOfArticles)  ,product.getNumberOfArticles());

    }
}
