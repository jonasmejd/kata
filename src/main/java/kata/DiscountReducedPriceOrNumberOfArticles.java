package kata;

public class DiscountReducedPriceOrNumberOfArticles {

	/*
	 * ReducedPrice if (NOA %3 == 1) else add  new Article
	 * @Param the product we want to apply a discount
	 * */
	IDiscount iDiscount = (product) -> {
		if(product.getNumberOfArticles() % 3 == 1) {
			product.setPrice(product.getDiscountPrice() * (product.getNumberOfArticles() / 3) + product.getPrice());
		}
		else {
			product.setPrice(product.getDiscountPrice() * (product.getNumberOfArticles() / 3) + product.getPrice() * (product.getNumberOfArticles() % 3) );
			product.setNumberOfArticles( product.getNumberOfArticles() + 1);
		}
		return product;
	};
	
	

}
