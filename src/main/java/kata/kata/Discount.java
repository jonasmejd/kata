package kata.kata;


import java.util.stream.Stream;

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
	
	@NonNull
	private Product product;
	private final static float simplePrice = 0.65f;
	private final static float discountPrice = 1f;
	
	 private final DiscountInterface discountInterface  = (discount) -> {
		 if(discount.getProduct().getNumberOfArticles() != 1 ){
				return applyDiscount(discount);
			}
			discount.getProduct().setPrice(simplePrice);
			return discount;
	 };
	
	
	public Discount verifyDiscount(@NonNull Discount discount){

		return discountInterface.checkDiscount(discount);
		
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
		float price = simplePrice * product.getNumberOfArticles();
		int canOfBeans = product.getNumberOfArticles() + product.getNumberOfArticles() / 2; 
		product.setPrice(price);
		product.setNumberOfArticles(canOfBeans);
		
		
		return product;
	}
	public Product  discountPriceThreeForADollar(@NonNull Product product){
		float price = discountPrice * product.getNumberOfArticles();
		product.setPrice(price);
		
		
		return product;
	} 
	public Product  reducedPriceOrNumberOfArticles(@NonNull Product product){
		
		if(product.getNumberOfArticles() % 3 == 1) {
			product.setPrice(discountPrice * (product.getNumberOfArticles() / 3) + simplePrice);
		}
		else {
			product.setPrice(discountPrice * (product.getNumberOfArticles() / 3) + simplePrice * (product.getNumberOfArticles() % 3) );
			product.setNumberOfArticles( product.getNumberOfArticles() + 1);
		}
		return product;
	} 
}

