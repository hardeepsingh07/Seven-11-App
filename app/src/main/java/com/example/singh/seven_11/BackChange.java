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


public class BackChange extends Activity {
    public EditText subtotal, backChange, requiredChange, account;
    public Button finish;
    int inSubtotal, change;
    int totalChange, accountMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_back_change);
        subtotal = (EditText)findViewById(R.id.et2Subttotal);
        backChange = (EditText) findViewById(R.id.etBackChange);
        requiredChange = (EditText) findViewById(R.id.etRequiredChange);
        account = (EditText) findViewById(R.id.eTTotalAccount);
        finish = (Button) findViewById(R.id.bcFinish);
        inSubtotal = getIntent().getIntExtra("change", 0);
        subtotal.setText("$" + inSubtotal + ".00");
        requiredChange.setText("$" + 3000 + ".00");
        backChange.requestFocus();

        backChange.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE)) {
                    change = Integer.parseInt(backChange.getText().toString());
                    backChange.setText("$" + change + ".00");
                    totalChange = inSubtotal + change;
                    accountMargin = totalChange - 3000;
                    account.setText("$" + accountMargin + ".00");
                }
                return false;
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myP = BackChange.this.getSharedPreferences("com.example.singh.seven_11", MODE_PRIVATE);
                myP.edit().putInt("backChange", change).commit();
                myP.edit().putInt("frontChange", inSubtotal).commit();
                myP.edit().putInt("adjustment", accountMargin).commit();
                Intent i = new Intent(BackChange.this, Cash.class);
                startActivity(i);
                finish();
            }
        });



    }



}
