package com.santillanj.tipcalculator.tip_calculator;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText bill, num_of_people;
    private TextView percent, tip, total;
    private SeekBar seekbar;
    double value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bill = (EditText) findViewById(R.id.mEditTextBill);
        num_of_people = (EditText) findViewById(R.id.mEditTextNumOfPeople);
        percent = (TextView) findViewById(R.id.mTxtViewPercent);
        tip = (TextView) findViewById(R.id.mTxtViewTip);
        total = (TextView) findViewById(R.id.mTxtViewTotal);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        value = 0;


            bill.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    calculate(value);
                }
            });


            num_of_people.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    calculate(value);

                }
            });

            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    value = seekBar.getProgress();
                    percent.setText(value + "%");
                    calculate(value);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });



    }

    public void calculate(double value) {

        try {
            double num_bill = Double.parseDouble(String.valueOf(bill.getText()));
            double num_people = Double.parseDouble(String.valueOf(num_of_people.getText()));

            double num_tip = num_bill * (value/100) / num_people;
            double num_total = num_bill / num_people + num_tip;

            this.tip.setText("Php " + String.format("%.2f", num_tip));
            this.total.setText("Php " +  String.format("%.2f", num_total));

        } catch (Exception e) {

        }
    }


}
