package android.lab.discountpolicy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText count;
    private EditText itemCost;
    private EditText min;
    private EditText percent;
    private EditText numToDiscount;
    private TextView bulkDiscount;
    private TextView freeItems;
    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = findViewById(R.id.count);
        itemCost = findViewById(R.id.cost);
        min = findViewById(R.id.min);
        percent = findViewById(R.id.per);
        numToDiscount = findViewById(R.id.numToDiscount);
        bulkDiscount = findViewById(R.id.totalBulk);
        freeItems = findViewById(R.id.totalSavings);
        Button calculateBtn = findViewById(R.id.calculateBtn);



        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parseCount = Integer.parseInt(count.getText().toString());
                float parseCost = Float.parseFloat(itemCost.getText().toString());
                int parseMin = Integer.parseInt(min.getText().toString());
                float parsePer = Float.parseFloat(percent.getText().toString());
                int parseNumToDisc = Integer.parseInt(numToDiscount.getText().toString());
                DiscountPolicy bulkDisc = new BulkDiscount(parseMin, parsePer);
                DiscountPolicy freeBuy = new BuyNItemsGetOneFree(parseNumToDisc);

                double bulkFinal = bulkDisc.ComputeDiscount(parseCount, parseCost);
                String bulkString = Double.toString(bulkFinal);

                double finalSavings = (int)(freeBuy.ComputeDiscount(parseCount, parseCost));
                String savingsString = Double.toString(finalSavings);

                bulkDiscount.setText(bulkString);
                freeItems.setText(savingsString);

            }
        });

    }
}
