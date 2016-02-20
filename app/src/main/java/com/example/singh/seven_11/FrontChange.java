package com.example.singh.seven_11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FrontChange extends Activity {
    public EditText penny, dimes, nickel, quarter, quarter2, dollar, five, five2,
            pennyR, dimesR, nickelR, quarterR, quarter2R, dollarR, fiveR, five2R,
            subtotal, changeMargin, extraChange, total;
    public Button finish;
    int GrandTotal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_front_change);
        penny = (EditText) findViewById(R.id.eT1);
        nickel = (EditText) findViewById(R.id.eT5);
        dimes = (EditText) findViewById(R.id.eT10);
        quarter = (EditText) findViewById(R.id.eT25);
        quarter2 = (EditText) findViewById(R.id.eT26);
        dollar = (EditText) findViewById(R.id.eT01);
        five = (EditText) findViewById(R.id.eT05);
        five2 = (EditText) findViewById(R.id.eT06);
        pennyR = (EditText) findViewById(R.id.eTR1);
        nickelR = (EditText) findViewById(R.id.eTR5);
        dimesR = (EditText) findViewById(R.id.eTR10);
        quarterR = (EditText) findViewById(R.id.eTR25);
        quarter2R = (EditText) findViewById(R.id.eTR26);
        dollarR = (EditText) findViewById(R.id.eTR01);
        fiveR = (EditText) findViewById(R.id.eTR05);
        five2R = (EditText) findViewById(R.id.eTR06);
        subtotal = (EditText) findViewById(R.id.etSubtotal);
        changeMargin = (EditText) findViewById(R.id.etC);
        extraChange = (EditText) findViewById(R.id.eTChange);
        total = (EditText) findViewById(R.id.eTTotal);
        finish = (Button) findViewById(R.id.fcFinish);

        penny.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                    || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((penny.getText().toString()).matches(""))    {
                        pennyR.setText("$0.00");
                        nickel.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(penny.getText().toString())) / 2);
                        pennyR.setText("$" + x + ".00");
                        GrandTotal += x;
                        nickel.requestFocus();
                    }
                    return true;

                }
                return false;
            }
        });

        nickel.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((nickel.getText().toString()).matches(""))    {
                        nickelR.setText("$0.00");
                        dimes.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(nickel.getText().toString())) * 2);
                        nickelR.setText("$" + x + ".00");
                        GrandTotal += x;
                        dimes.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        dimes.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((dimes.getText().toString()).matches(""))    {
                        dimesR.setText("$0.00");
                        quarter.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(dimes.getText().toString())) * 5);
                        dimesR.setText("$" + x + ".00");
                        GrandTotal += x;
                        quarter.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        quarter.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((quarter.getText().toString()).matches(""))    {
                        quarterR.setText("$0.00");
                        quarter2.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(quarter.getText().toString())) * 10);
                        quarterR.setText("$" + x + ".00");
                        GrandTotal += x;
                        quarter2.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        quarter2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((quarter2.getText().toString()).matches(""))    {
                        quarter2R.setText("$0.00");
                        dollar.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(quarter2.getText().toString())) * 10);
                        quarter2R.setText("$" + x + ".00");
                        GrandTotal += x;
                        dollar.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        dollar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((dollar.getText().toString()).matches(""))    {
                        dollarR.setText("$0.00");
                        five.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(dollar.getText().toString())) * 10);
                        dollarR.setText("$" + x + ".00");
                        GrandTotal += x;
                        five.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        five.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((five.getText().toString()).matches(""))    {
                        fiveR.setText("$0.00");
                        five2.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(five.getText().toString())) * 50);
                        fiveR.setText("$" + x + ".00");
                        GrandTotal += x;
                        five2.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        five2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((five2.getText().toString()).matches(""))    {
                        five2R.setText("$0.00");
                        extraChange.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(five2.getText().toString())) * 50);
                        five2R.setText("$" + x + ".00");
                        GrandTotal += x;
                        subtotal.setText("$" + GrandTotal + ".00");
                        changeMargin.setText("$" + 100 + ".00");
                        extraChange.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        extraChange.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((extraChange.getText().toString()).matches(""))    {
                        extraChange.setText("$0.00");
                        total.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(extraChange.getText().toString())));
                        GrandTotal += x + 100;
                        total.setText("$" + GrandTotal + ".00");
                        total.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontChange.this, BackChange.class);
                i.putExtra("change", GrandTotal);
                startActivity(i);
                finish();
            }
        });

    }
}
