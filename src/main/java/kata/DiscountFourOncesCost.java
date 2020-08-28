package kata;

public class DiscountFourOncesCost {

    /* priceDiscount
     * 1 Pound = 16 Onces
     * what does 4 ounces cost
     * @Param the product we want to apply a discount
     * */
    IDiscount iDiscount = (product) -> {
        Float onces = product.getPound() * 16;
        Float price = product.getDiscountPrice() * 4 /  onces;
        product.setPrice(price);
        return product;
    };
}
