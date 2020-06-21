package kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiscountPriceThreeForADollarTest {
	
	private Float simplePrice = 0.65f;

	private Float discountprice = 1f;
	
	@Test
	public void shouldApplyDiscountPriceThreeForADollar(){
		//given
		int numberOfArticles = 3; 
		Product product =Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice)
				.build();
		DiscountPriceThreeForADollar discount =  new DiscountPriceThreeForADollar();
		
		//when
		product = product.discount(discount.iDiscount);
		//then
		assertEquals(discountprice * numberOfArticles / 3,product.getPrice(),0.0002);
		assertEquals(  new Integer(numberOfArticles)  ,product.getNumberOfArticles());
		
	}
}
