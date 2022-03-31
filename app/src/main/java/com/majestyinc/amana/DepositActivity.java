package com.majestyinc.amana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DepositActivity extends AppCompatActivity {

    Button deposit;
    EditText amount;
    protected String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        deposit = findViewById(R.id.deposit);

        amount = findViewById(R.id.amount_deposit);

        money = amount.getText().toString();


        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DepositActivity.this,cardActivity.class);
                intent.putExtra("amount",money);
                startActivity(intent);
            }
        });
    }
}
