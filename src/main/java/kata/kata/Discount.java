package kata.kata;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/*
 * 
 * this Discount is only for beans 
 * Simple price 0.65$ 
 * three for a dollar$
 * buy two, get one free 
 * */

@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Discount {
	
	private Product product;
	
	public Discount checkDiscount(@NonNull Discount discount){
		if(discount.getProduct().getNumberOfArticles() != 1 ){
			return applyDiscount(discount);
		}
		discount.getProduct().setPrice(0.65f);
		return discount;
		
	}
	
	public Discount applyDiscount(@NonNull Discount discount) {
		if(discount.getProduct().getNumberOfArticles() % 2 == 0 )
		{
			discount.setProduct(discountPriceBuyTwoGetOneFree(discount.getProduct()));
		}
		else if (discount.getProduct().getNumberOfArticles() % 3 == 0)
		{
			discount.setProduct(discountPriceThreeForADollar(discount.getProduct()));
		}
		else{
			discount.setProduct(reducedPriceOrNumberOfArticles(discount.getProduct()));
		}
		return discount;
	}
	public Product discountPriceBuyTwoGetOneFree(@NonNull Product product){
		float price = 0.65f * product.getNumberOfArticles();
		int canOfBeans = product.getNumberOfArticles() + product.getNumberOfArticles() / 2; 
		product.setPrice(price);
		product.setNumberOfArticles(canOfBeans);
		
		
		return product;
	}
	public Product  discountPriceThreeForADollar(@NonNull Product product){
		float price = 1f;
		product.setPrice(price);
		
		
		return product;
	} 
	public Product  reducedPriceOrNumberOfArticles(@NonNull Product product){
		float simpleprice = 0.65f;
		float discountprice = 1f;
		if(product.getNumberOfArticles() % 3 == 1) {
			product.setPrice(discountprice * (product.getNumberOfArticles() / 3) + simpleprice);
		}
		else {
			product.setPrice(discountprice * (product.getNumberOfArticles() / 3) + simpleprice * (product.getNumberOfArticles() % 3) );
			product.setNumberOfArticles( product.getNumberOfArticles() + 1);
		}
		return product;
	} 
}
