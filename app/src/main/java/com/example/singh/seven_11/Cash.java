package com.example.singh.seven_11;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;


public class Cash extends Activity {
    EditText cash100, cash50, cash20, cash10, cash5, cash2, cash1,
            R100, R50, R20, R10, R5, R2, R1,
            cashSubtotal, cashChecks, cashTotal;
    Button done;
    int checks, subtotal, total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cash);
        cash100 = (EditText) findViewById(R.id.et100);
        cash50 = (EditText) findViewById(R.id.et50);
        cash20 = (EditText) findViewById(R.id.et20);
        cash10 = (EditText) findViewById(R.id.et10);
        cash5 = (EditText) findViewById(R.id.et5);
        cash2 = (EditText) findViewById(R.id.et2);
        cash1 = (EditText) findViewById(R.id.et1);
        R100 = (EditText) findViewById(R.id.etR100);
        R50 = (EditText) findViewById(R.id.etR50);
        R20 = (EditText) findViewById(R.id.etR20);
        R10 = (EditText) findViewById(R.id.etR10);
        R5 = (EditText) findViewById(R.id.etR5);
        R2 = (EditText) findViewById(R.id.etR2);
        R1 = (EditText) findViewById(R.id.etR1);
        cashSubtotal = (EditText) findViewById(R.id.etCSubtotal);
        cashChecks = (EditText) findViewById(R.id.etRChecks);
        cashTotal = (EditText) findViewById(R.id.cashTotal);
        done = (Button) findViewById(R.id.CashFinish);

        cash100.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cash100.getText().toString()).matches(""))    {
                        R100.setText("$0.00");
                        subtotal += 0;
                        cash50.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cash100.getText().toString())) * 100);
                        R100.setText("$" + x + ".00");
                        subtotal += x;
                        cash50.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        cash50.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cash50.getText().toString()).matches(""))    {
                        R50.setText("$0.00");
                        subtotal += 0;
                        cash20.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cash50.getText().toString())) * 50);
                        R50.setText("$" + x + ".00");
                        subtotal += x;
                        cash20.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        cash20.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cash20.getText().toString()).matches(""))    {
                        R20.setText("$0.00");
                        subtotal += 0;
                        cash10.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cash20.getText().toString())) * 20);
                        R20.setText("$" + x + ".00");
                        subtotal += x;
                        cash10.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        cash10.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cash10.getText().toString()).matches(""))    {
                        R10.setText("$0.00");
                        subtotal += 0;
                        cash5.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cash10.getText().toString())) * 10);
                        R10.setText("$" + x + ".00");
                        subtotal += x;
                        cash5.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        cash5.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cash5.getText().toString()).matches(""))    {
                        R5.setText("$0.00");
                        subtotal += 0;
                        cash2.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cash5.getText().toString())) * 5);
                        R5.setText("$" + x + ".00");
                        subtotal += x;
                        cash2.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        cash2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cash2.getText().toString()).matches(""))    {
                        R2.setText("$0.00");
                        subtotal += 0;
                        cash1.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cash2.getText().toString())) * 2);
                        R2.setText("$" + x + ".00");
                        subtotal += x;
                        cash1.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        cash1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cash1.getText().toString()).matches(""))    {
                        R1.setText("$0.00");
                        subtotal += 0;
                        cashChecks.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cash1.getText().toString())));
                        R1.setText("$" + x + ".00");
                        subtotal += x;
                        cashChecks.requestFocus();
                    }
                    cashSubtotal.setText("$" + subtotal + ".00");
                    return true;
                }
                return false;
            }
        });

        cashChecks.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT)) {
                    if((cashChecks.getText().toString()).matches(""))    {
                        cashChecks.setText("$0.00");
                        total = subtotal;
                        cashTotal.requestFocus();
                    }
                    else {
                        int x = ((Integer.parseInt(cashChecks.getText().toString())));
                        total = subtotal + x;
                        cashTotal.requestFocus();
                    }
                    cashTotal.setText("$" + total + ".00");
                    return true;
                }
                return false;
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cash.this, Results.class);
                i.putExtra("cash", total);
                startActivity(i);
                finish();
            }
        });
    }



}
