package kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiscountReducedPriceOrNumberOfArticlesTest {

	private Float simplePrice = 0.65f;

	private Float discountprice = 1f;
	@Test
	public void shouldApplyreducedPrice(){
		// given
		int numberOfArticles = 7;
		Product product = Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice).discountPrice(discountprice)
				.build();
		DiscountReducedPriceOrNumberOfArticles discount = new DiscountReducedPriceOrNumberOfArticles();

		// when
		product = product.discount(discount.iDiscount);
		// then
		float expectPrice =  discountprice * (numberOfArticles / 3) + simplePrice;
		assertEquals(expectPrice, product.getPrice(), 0.0002);
		assertEquals(new Integer(numberOfArticles), product.getNumberOfArticles());
	}
	@Test
	public void shouldApplyMoreNumberOfArticles(){
		// given
		int numberOfArticles = 17;
		Product product = Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice).discountPrice(discountprice)
				.build();
		DiscountReducedPriceOrNumberOfArticles discount = new DiscountReducedPriceOrNumberOfArticles();

		// when
		product = product.discount(discount.iDiscount);
		// then
		float expectPrice =  discountprice * (numberOfArticles / 3) + simplePrice * (numberOfArticles % 3);
		assertEquals(expectPrice, product.getPrice(), 0.0002);
		assertEquals(new Integer(numberOfArticles + 1),product.getNumberOfArticles());
	}
}
