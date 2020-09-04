package kata;

public class DiscountPriceThreeForADollar {

	//In this case the price is set at  1 $
	private final static Float discountPrice = 1f;
	
	/*
	 * Three For A Dollar
	 * @Param the product we want to apply a discount
	 * */
	 IDiscount iDiscount = (product) -> {
	
		int numbre  = product.getNumberOfArticles() / 3;
		Float  threeForADollar = discountPrice * numbre;
		Float price =  product.getNumberOfArticles() % 3 == 0 ? 
				threeForADollar  : 
					threeForADollar + product.getNumberOfArticles() % 3 * product.getPrice();
		
		product.setPrice(price);
		return product;
	};
	

}
