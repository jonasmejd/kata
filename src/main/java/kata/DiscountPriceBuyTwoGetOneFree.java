package kata;

public class DiscountPriceBuyTwoGetOneFree {

	/*
	 * Buy Two Get One Free
	 * @Param the product we want to apply a discount
	 * */
	 IDiscount iDiscount =(product) -> {
		Float price = product.getPrice() * product.getNumberOfArticles();
		int canOfBeans = product.getNumberOfArticles() + product.getNumberOfArticles() / 2; 
		product.setPrice(price);
		product.setNumberOfArticles(canOfBeans);
		return product;
	};
	

}
