package kata;

public class DiscountPriceThreeForADollar {

	//In this case the price is set at  1 $
	private final static float discountPrice = 1f;
	
	/*
	 * Three For A Dollar
	 * @Param the product we want to apply a discount
	 * */
	 IDiscount iDiscount = (product) -> {
		
		float price = discountPrice * product.getNumberOfArticles() / 3;
		product.setPrice(price);
		return product;
	};
	

}
