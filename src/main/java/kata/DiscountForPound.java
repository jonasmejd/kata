package kata;

public class DiscountForPound {

	/*priceDiscount
	 * $1.99/pound 
	 * @Param the product we want to apply a discount
	 * */
	IDiscount iDiscount = (product) -> {
		Float price = product.getDiscountPrice() * product.getPound();
		product.setPrice(price);
		return product;
	};

}
