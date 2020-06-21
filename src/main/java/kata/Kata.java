package kata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kata {
	
	/*
	 * main function 
	 * to have idea of all discounts 
	 * and we can compare between them
	 *
	 **/
	public static void main( String[] args )
    {
        
        
        List<Product> products=  new ArrayList<>();
        
        Product product = Product.builder().price(2.50f).name("beans").numberOfArticles(8)
        		.build();
		DiscountPriceBuyTwoGetOneFree discountPriceBuyTwoGetOneFree = new DiscountPriceBuyTwoGetOneFree();
		product = product.discount(discountPriceBuyTwoGetOneFree.iDiscount);
        products.add(product);
        
        Product product_1 = Product.builder().price(3.70f).name("java bean").numberOfArticles(8)
        		.build(); DiscountPriceThreeForADollar discountPriceThreeForADollar = new DiscountPriceThreeForADollar();
        product_1 = product_1.discount(discountPriceThreeForADollar.iDiscount); 
        products.add(product_1);
       
        Product product_2 = Product.builder().price(4.80f).name("cucumber").numberOfArticles(8)
        		.build();
        DiscountReducedPriceOrNumberOfArticles discountReducedPriceOrNumberOfArticles=  new DiscountReducedPriceOrNumberOfArticles(); 
        product_2 = product_2.discount(discountReducedPriceOrNumberOfArticles.iDiscount); 
        products.add(product_2);
        
        Product product_3 = Product.builder().price(4.80f).name("java bean").numberOfArticles(8).pound(10f)
        		.build();
        DiscountForPound discountForPound=  new DiscountForPound(); 
        product_3 = product_3.discount(discountForPound.iDiscount); 
        products.add(product_3);
        
        products.stream()
        .sorted(Comparator.comparing(Product::getPrice))
        .forEach( System.out::println );
        
    }
}
