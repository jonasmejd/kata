package kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiscountPriceThreeForADollarTest {
	
	private Float simplePrice = 0.65f;

	private Float discountprice = 1f;
	
	@Test
	public void shouldApplyDiscountPriceThreeForADollar(){
		//given
		int numberOfArticles = 8; 
		Product product =Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice)
				.build();
		DiscountPriceThreeForADollar discount =  new DiscountPriceThreeForADollar();
		
		//when
		product = product.discount(discount.iDiscount);
		//then
		int numbre  = product.getNumberOfArticles() / 3;
		Float  threeForADollar = discountprice * numbre;
		assertEquals(threeForADollar + product.getNumberOfArticles() % 3 * simplePrice ,product.getPrice(),0.0002);
		assertEquals(  new Integer(numberOfArticles)  ,product.getNumberOfArticles());
		
	}
}
