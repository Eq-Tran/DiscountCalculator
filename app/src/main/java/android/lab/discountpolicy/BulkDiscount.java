package android.lab.discountpolicy;

import android.widget.EditText;

public class BulkDiscount extends  DiscountPolicy {

    public int min;
    public float per;

    BulkDiscount(int minimum, float percent){
        min = minimum;
        per = percent;
    }



    @Override
    public float ComputeDiscount(int count, float itemCost) {
        float discount;

        if(min > count){
            discount = per / 100;
            return discount;
        }else{
            discount = count * itemCost / per;
            return discount;
        }

    }
}
