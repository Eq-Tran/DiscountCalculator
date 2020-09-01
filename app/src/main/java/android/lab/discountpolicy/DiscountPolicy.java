package android.lab.discountpolicy;

public abstract class DiscountPolicy {

    //Constructor
    DiscountPolicy(){

    }
    public abstract float ComputeDiscount(int count, float itemCost);


}
