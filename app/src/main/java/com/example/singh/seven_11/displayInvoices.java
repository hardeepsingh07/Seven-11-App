package com.example.singh.seven_11;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;


public class displayInvoices extends Activity {
    DBAdapter db;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_display_invoices);
        back = (Button) findViewById(R.id.backButton);
        db = new DBAdapter(this);
        db.open();
        populateListView();
        db.close();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(displayInvoices.this, Results.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void populateListView() {
        Cursor cursor = db.getAllInvoices();
        startManagingCursor(cursor);
        String[] fromDatabase = new String[] {DBAdapter.KEY_NAME, DBAdapter.KEY_RETAIL, DBAdapter.KEY_COST};
        int[] toView = new int[] {R.id.textViewName, R.id.textViewRetail, R.id.textViewCost};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listinvoices, cursor, fromDatabase,
                toView,0);

        ListView myList = (ListView) findViewById(R.id.displayListView);
        myList.setAdapter(adapter);
    }

}
