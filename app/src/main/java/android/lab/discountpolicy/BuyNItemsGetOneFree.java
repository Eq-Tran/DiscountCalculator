package android.lab.discountpolicy;

public class BuyNItemsGetOneFree extends DiscountPolicy {

    int n;

    // Constructor
    BuyNItemsGetOneFree(int n){

        this.n = n;

    }

    @Override
    public float ComputeDiscount(int count, float itemCost) {

        float discount;
        discount = (count/n) * itemCost;

        return discount;
    }
}
