package com.example.singh.seven_11;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Invoices extends Activity {
    double rTotal = 0;
    double cTotal = 0;
    private String name;
    private Double retail;
    private Double cost;
	public EditText invName;
	public EditText invRetail;
	public EditText invCost;
	public ListView invListView;
	public Button invButton;
	private ArrayAdapter<LInvoice> adapter;
	public List<LInvoice> myInvoices = new ArrayList<LInvoice>();
    public int check;
    DBAdapter db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_invoices);
        check = getIntent().getIntExtra("activity", 0);
        invName = (EditText)findViewById(R.id.invName);
		invRetail = (EditText)findViewById(R.id.invRetail);
		invCost = (EditText)findViewById(R.id.invCost);
		invListView = (ListView)findViewById(R.id.invListView);
		invButton = (Button)findViewById(R.id.invButton);
        db = new DBAdapter(this);
        db.open();
        adapter = new myInvoiceAdapter();
        invName.requestFocus();


		invCost.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
                        || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    if( ((invName.getText().toString()).matches("")) ||
                            ((invRetail.getText().toString()).matches("")) ||
                            ((invCost.getText().toString()).matches("")) ) {
                        Toast.makeText(Invoices.this, "Please provide all the information", Toast.LENGTH_SHORT).show();
                        invName.setText("");
                        invCost.setText("");
                        invRetail.setText("");
                        invName.requestFocus();


                    }
                    else {
                        name = invName.getText().toString();
                        retail = Double.parseDouble(invRetail.getText().toString());
                        cost = Double.parseDouble(invCost.getText().toString());
                        myInvoices.add(new LInvoice(name, retail, cost));
                        db.addInvoice(name, retail, cost);
                        invListView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        invName.setText("");
                        invRetail.setText("");
                        invCost.setText("");
                        invName.requestFocus();

                        rTotal += retail;
                        cTotal += cost;
                    }
                }
                return false;
            }
        });

        invButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.close();
                Intent i = new Intent(Invoices.this, FrontChange.class);
                startActivity(i);
                finish();
            }
        });
}
	
	private class myInvoiceAdapter extends ArrayAdapter<LInvoice>	{
		
		public myInvoiceAdapter()	{
			super(Invoices.this, R.layout.listinvoices, myInvoices);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View invoiceView = convertView;
			if(invoiceView == null)	{
				invoiceView = getLayoutInflater().inflate(R.layout.listinvoices, parent, false);
			}
			LInvoice currentInvoice = myInvoices.get(position);

            TextView iName = (TextView)invoiceView.findViewById(R.id.textViewName);
            TextView iRetail = (TextView) invoiceView.findViewById(R.id.textViewRetail);
            TextView iCost = (TextView) invoiceView.findViewById(R.id.textViewCost);

            iName.setText(currentInvoice.getName());
            iRetail.setText("" +currentInvoice.getRetail());
            iCost.setText("" + currentInvoice.getCost());
			
			return invoiceView;
		}
		
	}
}
