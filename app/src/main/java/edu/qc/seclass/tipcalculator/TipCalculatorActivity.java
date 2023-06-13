package edu.qc.seclass.tipcalculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TipCalculatorActivity extends AppCompatActivity {
    // declaring the variable
    Button btnCompute;
    EditText tip15;
    EditText tip20;
    EditText tip25;
    EditText total15;
    EditText total20;
    EditText total25;

    EditText checkAmount;
    EditText partySize;

    float amountValue;
    int tip_15,tip_20,tip_25,total_15,total_20,total_25;
    int party_size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_calculator_design);

        //getting the Id
        if((EditText)findViewById(R.id.checkAmountValue) != null && (EditText)findViewById(R.id.partySizeValue) != null) {
            checkAmount = (EditText) findViewById(R.id.checkAmountValue);
            partySize=(EditText)findViewById(R.id.partySizeValue);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Empty or incorrect value(s)!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        tip15=(EditText)findViewById(R.id.fifteenPercentTipValue);
        tip20=(EditText)findViewById(R.id.twentyPercentTipValue);
        tip25=(EditText)findViewById(R.id.twentyfivePercentTipValue);
        total15=(EditText)findViewById(R.id.fifteenPercentTotalValue);
        total20=(EditText)findViewById(R.id.twentyPercentTotalValue);
        total25=(EditText)findViewById(R.id.twentyfivePercentTotalValue);
        btnCompute=(Button)findViewById(R.id.buttonCompute);


        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // parsing
                amountValue=Float.parseFloat(checkAmount.getText().toString());
                party_size  =Integer.parseInt(partySize.getText().toString());

                // caculating the tip amount with formula
                tip_15=(int)(((amountValue/party_size)*15)/100)+1;
                tip_20=(int)((amountValue/party_size)*20)/100;
                tip_25=(int)(((amountValue/party_size)*25)/100)+1;
                // adding the tip value for total
                total_15=(int)((amountValue/party_size)+tip_15);
                total_20=(int)((amountValue/party_size)+tip_20);
                total_25=(int)((amountValue/party_size)+tip_25);
                // setting the value

                tip15.setText(""+tip_15);
                tip20.setText(""+tip_20);
                tip25.setText(""+tip_25);

                total15.setText(""+total_15);
                total20.setText(""+total_20);
                total25.setText(""+total_25);

            }
        }
        );



    }
}
