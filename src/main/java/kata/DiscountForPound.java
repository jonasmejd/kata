package kata;

public class DiscountForPound {
	
	private final static float discountPrice = 1.99f;
	
	/*
	 * $1.99/pound 
	 * @Param the product we want to apply a discount
	 * */
	IDiscount iDiscount = (product) -> {
		Float price = discountPrice * product.getPound();
		product.setPrice(price);
		return product;
	};

}
