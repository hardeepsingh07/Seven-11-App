package com.example.singh.seven_11;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.text.Editable;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class Lotteries extends Activity {
	public EditText tAmount;
	public EditText tStart;
	public EditText tEnd;
	private Button bAdd;
	private Button bFinish;
	private ListView lvLotteries;
	private ArrayAdapter<lotto> adapter;
	private int tA;
	private int tS;
	private int tE;
	private int tSo;
	private int tV;
	private int total = 0;
	private List<lotto> myLotto = new ArrayList<lotto>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_lotteries);
		tAmount = (EditText)findViewById(R.id.tAmount);
		tStart = (EditText)findViewById(R.id.tStar);
		tEnd = (EditText)findViewById(R.id.tEn);
		bAdd = (Button)findViewById(R.id.bAdd);
		bFinish = (Button)findViewById(R.id.bFinish);
		lvLotteries = (ListView)findViewById(R.id.lvLotteries);
		adapter = new MyLottoAdapter();
		lvLotteries.setAdapter(adapter);
		tEnd.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
						|| (actionId == EditorInfo.IME_ACTION_DONE)) {
                    if( ((tAmount.getText().toString()).matches("")) ||
                            ((tStart.getText().toString()).matches("")) ||
                            ((tEnd.getText().toString()).matches("")) ) {
                        Toast.makeText(Lotteries.this, "Please provide all the information", Toast.LENGTH_SHORT).show();
                        tAmount.setText("");
                        tStart.setText("");
                        tEnd.setText("");
                        tAmount.requestFocus();
                    }
                    else {
                        tA = Integer.parseInt(tAmount.getText().toString());
                        tS = Integer.parseInt(tStart.getText().toString());
                        tE = Integer.parseInt(tEnd.getText().toString());
                        addData(tA, tS, tE);
                    }
				}
				return false;
			}
		});
		bAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                if( ((tAmount.getText().toString()).matches("")) ||
                        ((tStart.getText().toString()).matches("")) ||
                        ((tEnd.getText().toString()).matches("")) ) {
                    Toast.makeText(Lotteries.this, "Please provide all the information", Toast.LENGTH_SHORT).show();
                    tAmount.setText("");
                    tStart.setText("");
                    tEnd.setText("");
                    tAmount.requestFocus();
                }
                else {
                    tA = Integer.parseInt(tAmount.getText().toString());
                    tS = Integer.parseInt(tStart.getText().toString());
                    tE = Integer.parseInt(tEnd.getText().toString());
                    addData(tA, tS, tE);
                }
			}
		});
		bFinish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Lotteries.this, LottoReport.class);
				i.putExtra("totalValue", total);
				startActivity(i);
                finish();
				
			}
		});
	}
	protected void addData(int tA2, int tS2, int tE2) {
		switch(tA)
		{	
			case 1: {
				if(tE < tS)	{ tSo = (250 - tS) + tE;} 
				else {	tSo = tE - tS;}
				break;
			}
			case 2: {
				if(tE < tS)	{ tSo = (100 - tS) + tE;} 
				else {	tSo = tE - tS;}
				break;
			}
			case 3: {
				if(tE < tS)	{ tSo = (100 - tS) + tE;} 
				else {	tSo = tE - tS;}
				break;
			}
			case 5: {
				if(tE < tS)	{ tSo = (80 - tS) + tE;} 
				else {	tSo = tE - tS;}
				break;
			}
			case 10: {
				if(tE < tS)	{ tSo = (50 - tS) + tE;} 
				else {	tSo = tE - tS;}
				break;
			}
			case 20: {
				if(tE < tS)	{ tSo = (30 - tS) + tE;} 
				else {	tSo = tE - tS;}
				break;
			}
		}
		tV	= tSo * tA;
		myLotto.add(new lotto(tA, tS, tE, tSo, tV));
		adapter.notifyDataSetChanged();
		tAmount.setText("");
		tStart.setText("");
		tEnd.setText("");
		tAmount.requestFocus();
		total += tV;
		
	}
	private class MyLottoAdapter extends ArrayAdapter<lotto> {

		public MyLottoAdapter() {
			super(Lotteries.this, R.layout.view_lotteries, myLotto);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View lottoView = convertView;
			if(lottoView == null)	{
				lottoView = getLayoutInflater().inflate(R.layout.view_lotteries, parent, false);
			}
			lotto currentLotto = myLotto.get(position);
			
			TextView fAmount = (TextView) lottoView.findViewById(R.id.fAmount);
			TextView fStart = (TextView) lottoView.findViewById(R.id.fStart);
			TextView fEnd = (TextView) lottoView.findViewById(R.id.fEnd);
			TextView fSold = (TextView) lottoView.findViewById(R.id.fSold);
			TextView fValue = (TextView) lottoView.findViewById(R.id.fValue);

			fAmount.setText("" + currentLotto.getAmount());
			fStart.setText("" + currentLotto.getStart());
			fEnd.setText("" + currentLotto.getEnd());
			fSold.setText("" + currentLotto.getSold());
			fValue.setText("" + currentLotto.getValue());
			
			return lottoView;
		}
	}
}
