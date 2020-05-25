package kata.kata;


import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString(of="name")
@Getter
@Setter
public class Product {
	
	@NonNull
	private String name;

	private float price;

	@NonNull
	private Integer numberOfArticles;

}
