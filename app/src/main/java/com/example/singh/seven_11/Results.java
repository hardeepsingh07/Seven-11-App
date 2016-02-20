package com.example.singh.seven_11;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class Results extends Activity {
    public EditText ls, lw, ss, sw, fc, bc, a, tCash;
    public Button invoices, done;
    public int lottoSale, lottoWin, scratcherSale, scratcherWin, frontChange, backChange, adjustment,
        totalCash;
    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_results);
        ls = (EditText) findViewById(R.id.LottoSale);
        lw = (EditText) findViewById(R.id.LottoWin);
        ss = (EditText) findViewById(R.id.ScractcherSale);
        sw = (EditText) findViewById(R.id.ScratcherWin);
        fc = (EditText) findViewById(R.id.frontChange);
        bc = (EditText) findViewById(R.id.backChange);
        a = (EditText) findViewById(R.id.Adjustment);
        tCash = (EditText) findViewById(R.id.totalEndCash);
        invoices = (Button) findViewById(R.id.ListInvoices);
        done = (Button) findViewById(R.id.end);
        db = new DBAdapter(this);
        db.open();
        SharedPreferences myP = getSharedPreferences("com.example.singh.seven_11", MODE_PRIVATE);
        lottoSale = myP.getInt("LottoSale", 0);
        lottoWin = myP.getInt("LottoWin", 0);
        scratcherSale = myP.getInt("ScratcherSale", 0);
        scratcherWin = myP.getInt("ScractcherWin", 0);
        frontChange = myP.getInt("frontChange", 0);
        backChange = myP.getInt("backChange", 0);
        adjustment = myP.getInt("adjustment", 0);
        totalCash = getIntent().getIntExtra("cash", 0);

        ls.setText("" + lottoSale);
        lw.setText("" + lottoWin);
        ss.setText("" + scratcherSale);
        sw.setText("" + scratcherWin);
        fc.setText("$" + frontChange + ".00");
        bc.setText("$" + backChange + ".00");
        a.setText("$" + adjustment + ".00");
        tCash.setText("$" + totalCash + ".00");


        invoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Results.this, displayInvoices.class);
                startActivity(i);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteAll();
                db.close();
                Toast.makeText(Results.this, "Worksheet Finished", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }



}
