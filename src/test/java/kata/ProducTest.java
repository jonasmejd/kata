package kata;


import static org.junit.Assert.*;


import org.junit.Test;

import kata.Product;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProducTest {

	
		  
	 @Test
	public void  shouldBeReturnFromToStringMethod(){ 
		 // given
		Product product = Product.builder().name("product A").numberOfArticles(1).price(0.65f)
				.build();
		// when
		// then
		assertThat("product A", is(equalTo(product.getName().toString())));
	}
	 @Test(expected = Exception.class)
	 public void shouldRetourErrorNonNullName (){
		 //given
		 
		 float Simpleprice = 0.65f;
		 int numberOfArticles = 2;
		 Product product = Product.builder().price(Simpleprice).numberOfArticles(numberOfArticles)
				 .build();
		 //when
		 //then
		 assertThat(Simpleprice, is(equalTo(product.getPrice())));

	 }
	 
	 @Test(expected = Exception.class)
	 public void shouldRetourErrorNonNullNumberOfArticles (){
		 //given
		 
		 float Simpleprice = 0.65f;
		 Product product = Product.builder().price(Simpleprice).name("product A")
				 .build();
		 //when
		 //then
		 assertThat(Simpleprice, is(equalTo(product.getPrice())));

	 }
	 
	  
}
