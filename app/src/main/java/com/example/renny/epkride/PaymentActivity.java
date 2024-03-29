package com.example.renny.epkride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        CardForm cardForm=(CardForm)findViewById(R.id.cardform);
        TextView textDes=(TextView)findViewById(R.id.payment_amount);
        Button btnpay=(Button)findViewById(R.id.btn_pay);

        textDes.setText("$1999");
        btnpay.setText(String.format("Payer %s",textDes.getText()));

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                Toast.makeText(PaymentActivity.this, "Name : "+card.getName() + " | Last 4 digits: "+card.getLast4()  , Toast.LENGTH_SHORT ).show();

            }
        });
    }
}
