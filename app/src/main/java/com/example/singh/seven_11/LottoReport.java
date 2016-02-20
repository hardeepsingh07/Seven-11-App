package com.example.singh.seven_11;

import java.util.HashMap;
import java.util.Hashtable;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class LottoReport extends Activity {

	EditText eLottoSale;
	EditText eLottoWin;
	EditText eScratcherSale;
	EditText eScratcherWin;
	Button finish;
	int eLSale;
	int eLWin;
	int eSSale;
	int eSWin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_lotto_report);
		eLottoSale = (EditText)findViewById(R.id.eLottoSale);
		eLottoWin = (EditText)findViewById(R.id.eLottoWin);
		eScratcherSale = (EditText)findViewById(R.id.eScratcherSale);
		eScratcherWin = (EditText)findViewById(R.id.eScratcherWin);
		eSSale = getIntent().getIntExtra("totalValue", 0);
		eScratcherSale.setText("$" + eSSale + ".00");
		finish = (Button)findViewById(R.id.lrButton);
        eLottoSale.requestFocus();
		
		eLottoSale.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
						|| (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE)) {
                    if((eLottoSale.getText().toString()).matches(""))   {
                        eLSale = 0;
                        eLottoSale.setText("$" + eLSale + ".00");
                    }
                    else
                    {
                        eLSale = Integer.parseInt(eLottoSale.getText().toString());
                        eLottoSale.setText("$" + eLSale + ".00");
                    }
				}
				return false;
			}
		});
		
		eLottoWin.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
						|| (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE)) {
                    if((eLottoWin.getText().toString()).matches(""))   {
                        eLWin = 0;
                        eLottoWin.setText("$" + eLWin + ".00");
                    }
                    else
                    {
                        eLWin = Integer.parseInt(eLottoWin.getText().toString());
                        eLottoWin.setText("$" + eLWin + ".00");
                    }
				}
				return false;
			}
		});
		
		eScratcherWin.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
						|| (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE)) {
                    if((eScratcherWin.getText().toString()).matches(""))   {
                        eSWin = 0;
                        eScratcherWin.setText("$" + eSWin + ".00");
                    }
                    else
                    {
                        eSWin = Integer.parseInt(eScratcherWin.getText().toString());
                        eScratcherWin.setText("$" + eSWin + ".00");
                    }

				}
				return false;
			}
		});	
		finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                SharedPreferences myP = LottoReport.this.getSharedPreferences("com.example.singh.seven_11", MODE_PRIVATE);
                myP.edit().putInt("LottoSale", eLSale).commit();
                myP.edit().putInt("LottoWin", eLWin).commit();
                myP.edit().putInt("ScratcherSale", eSSale).commit();
                myP.edit().putInt("ScratcherWin", eSWin).commit();
				Intent i  = new Intent(LottoReport.this, Invoices.class);
                startActivity(i);
                finish();

			}
		});

	}


}
