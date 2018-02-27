package com.pstwh.contacts.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pstwh.contacts.models.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pstwh on 27/02/2018.
 */

public class ContactDAO extends SQLiteOpenHelper {

    public ContactDAO(Context context) {
        super(context, "contacts", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE contacts (id INTEGER PRIMARY KEY, name TEXT NOT NULL, address TEXT, telephone, TEXT, website TEXT, rating REAL)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS contacts";
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public void create(Contact contact) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put("name", contact.getName());
        data.put("address", contact.getAddress());
        data.put("telephone", contact.getTelephone());
        data.put("website", contact.getWebsite());
        data.put("rating", contact.getRating());

        sqLiteDatabase.insert("contacts", null, data);
    }

    public List<Contact> getContacts() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM contacts;", null);

        List<Contact> contacts = new ArrayList<Contact>();
        while(c.moveToNext()) {
            Contact contact = new Contact();
            contact.setId(c.getLong(c.getColumnIndex("id")));
            contact.setName(c.getString(c.getColumnIndex("name")));
            contact.setAddress(c.getString(c.getColumnIndex("address")));
            contact.setTelephone(c.getString(c.getColumnIndex("telephone")));
            contact.setWebsite(c.getString(c.getColumnIndex("website")));
            contact.setRating(c.getDouble(c.getColumnIndex("rating")));
            contacts.add(contact);
        }
        c.close();
        return contacts;
    }
}
