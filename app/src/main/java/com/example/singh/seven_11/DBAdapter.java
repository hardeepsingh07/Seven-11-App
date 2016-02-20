package com.example.singh.seven_11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Singh on 12/27/2014.
 */
public class DBAdapter {
    private static final String TAG = "DBAdapter";
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "invoiceManager";
    public static final String TABLE_INVOICES = "mainTable";
    public static final String KEY_ID = "_id";
    public static final int COL_ID = 0;
    public static final String KEY_NAME = "name";
    public static final String KEY_RETAIL = "retail";
    public static final String KEY_COST = "cost";
    public static final int COL_NAME = 1;
    public static final int COL_RETAIL = 2;
    public static final int COL_COST = 3;
    public static final String[] ALL_KEYS = new String[]
            {KEY_ID, KEY_NAME, KEY_RETAIL, KEY_COST};
    private static final String CREATE_INVOICES_TABLE = "CREATE TABLE " + TABLE_INVOICES
            + " (" + KEY_ID + " integer primary key autoincrement not null, " + KEY_NAME + " text not null,"
            + KEY_RETAIL + " double not null, " + KEY_COST + " double not null" + ");";
    private final Context context;
    private DatabaseHandler myDBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context context) {
        this.context = context;
        myDBHelper = new DatabaseHandler(context);
    }
     public DBAdapter open()    {
         db = myDBHelper.getWritableDatabase();
         return this;
     }

     public void close() {
         myDBHelper.close();
     }

     public long addInvoice(String name, double retail, double cost) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_RETAIL, retail);
        values.put(KEY_COST, cost);
        return db.insert(TABLE_INVOICES, null, values);
     }

     public boolean deleteInvoice(long rowId)   {
         String x = KEY_ID + "=" + rowId;
         return db.delete(TABLE_INVOICES, x, null) != 0;
     }

     public void deleteAll()    {
         Cursor c = getAllInvoices();
         long rowId = c.getColumnIndexOrThrow(KEY_ID);
         if(c.moveToFirst())    {
             do{
                 deleteInvoice(c.getLong((int) rowId));
              } while(c.moveToFirst());
         }
         c.close();
     }

    public Cursor getAllInvoices()  {
        String where = null;
        Cursor c = db.query(true, TABLE_INVOICES, ALL_KEYS, where, null, null, null, null, null);
        if(c != null)   {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getInvoice(long rowID)    {
        String x = KEY_ID + "=" + rowID;
        Cursor c = db.query(true, TABLE_INVOICES, ALL_KEYS, x, null, null, null, null, null);
        if(c != null)   {
            c.moveToFirst();
        }
        return c;
    }

    public boolean updateInvoice(long rowId, String name, double retail, double cost)   {
        String x = KEY_ID + "=" + rowId;
        ContentValues values =  new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_RETAIL, retail);
        values.put(KEY_COST, cost);

        return db.update(TABLE_INVOICES, values, x, null) != 0;
    }




    class DatabaseHandler extends SQLiteOpenHelper {
        public DatabaseHandler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
                _db.execSQL(CREATE_INVOICES_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            _db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVOICES);
            onCreate(_db);
        }
    }
}
