package kata;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import kata.DiscountPriceBuyTwoGetOneFree;
import kata.Product;

public class DiscountPriceBuyTwoGetOneFreeTest {
	
	private Float simplePrice = 0.65f;
	
	@Test
	public void shouldApplyDiscount(){
		//given
		Product product =Product.builder().name("Beans").numberOfArticles(2).price(simplePrice)
				.build();
		
		DiscountPriceBuyTwoGetOneFree discountPriceBuyTwoGetOneFree = new DiscountPriceBuyTwoGetOneFree();
		
		//when
		product = product.discount(discountPriceBuyTwoGetOneFree.iDiscount);
		//then
		assertNotEquals(new Integer(1),product.getNumberOfArticles());
		assertNotEquals(simplePrice* product.getNumberOfArticles(),product.getPrice(),0.00002);
		
	}

}
