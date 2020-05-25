package kata.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiscountTest {
	
//	@Before
//	public void setUp()
//	{
//		float simplePrice = 0.65f;
//	}
	private float simplePrice = 0.65f;
	private float discountprice = 1f;
	
	@Test
	public void shouldNotApplyDiscount(){
		//given
		
		Product product =Product.builder().name("Beans").numberOfArticles(1).price(simplePrice)
				.build();
		Discount discount = Discount.builder().product(product).
				build();
		
		//when
		discount = discount.checkDiscount(discount);
		//then
		assertEquals(new Integer(1),product.getNumberOfArticles());
		assertEquals(simplePrice * product.getNumberOfArticles(),discount.getProduct().getPrice(),0.0002);
		
	}
	@Test
	public void shouldApplyDiscount(){
		//given
		Product product =Product.builder().name("Beans").numberOfArticles(2).price(simplePrice)
				.build();
		Discount discount = Discount.builder().product(product).
				build();
		
		//when
		discount = discount.checkDiscount(discount);
		//then
		assertNotEquals(new Integer(1),product.getNumberOfArticles());
		assertNotEquals(simplePrice* product.getNumberOfArticles(),discount.getProduct().getPrice(),0.00002);
		
	}
	@Test
	public void shouldApplyDiscountPriceBuyTwoGetOneFree(){
		//given
		int numberOfArticles = 2; 
		Product product =Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice)
				.build();
		Discount discount = Discount.builder().product(product).
				build();
		
		//when
		discount.setProduct(discount.discountPriceBuyTwoGetOneFree(product)); 
		//then
		assertEquals(simplePrice * numberOfArticles ,discount.getProduct().getPrice(),0.0002);
		assertEquals( new Integer(numberOfArticles + numberOfArticles /2) ,discount.getProduct().getNumberOfArticles());
		
	}
	@Test
	public void shouldApplyDiscountPriceThreeForADollar(){
		//given
		int numberOfArticles = 3; 
		Product product =Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice)
				.build();
		Discount discount = Discount.builder().product(product).
				build();
		
		//when
		discount.setProduct(discount.discountPriceThreeForADollar(product));
		//then
		assertEquals(discountprice ,discount.getProduct().getPrice(),0.0002);
		assertEquals(  new Integer(numberOfArticles)  ,discount.getProduct().getNumberOfArticles());
		
	}
	@Test
	public void shouldApplyreducedPrice(){
		// given
		int numberOfArticles = 7;
		Product product = Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice).build();
		Discount discount = Discount.builder().product(product).build();

		// when
		discount.setProduct(discount.reducedPriceOrNumberOfArticles(product));
		// then
		float expectPrice =  discountprice * (numberOfArticles / 3) + simplePrice;
		assertEquals(expectPrice, discount.getProduct().getPrice(), 0.0002);
		assertEquals(new Integer(numberOfArticles), discount.getProduct().getNumberOfArticles());
	}
	@Test
	public void shouldApplyMoreNumberOfArticles(){
		// given
		int numberOfArticles = 17;
		Product product = Product.builder().name("Beans").numberOfArticles(numberOfArticles).price(simplePrice).build();
		Discount discount = Discount.builder().product(product).build();

		// when
		discount.setProduct(discount.reducedPriceOrNumberOfArticles(product));
		// then
		float expectPrice =  discountprice * (numberOfArticles / 3) + simplePrice * (numberOfArticles % 3);
		assertEquals(expectPrice, discount.getProduct().getPrice(), 0.0002);
		assertEquals(new Integer(numberOfArticles + 1),discount.getProduct().getNumberOfArticles());
	}

}
