package kata;


import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Product {
	
	@NonNull
	private String name;
	
	@NonNull
	private Float price;

	@NonNull
	private Integer numberOfArticles;
	
	private Float pound;

	private Float discountPrice;
	
	public Product discount(IDiscount iDiscount){
		return iDiscount.applyDicount(this);
	}

}
