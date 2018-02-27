package com.pstwh.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pstwh.contacts.dao.ContactDAO;
import com.pstwh.contacts.models.Contact;

public class ContactsCreateActivity extends AppCompatActivity {

    private ContactsHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_create);

        this.helper = new ContactsHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contacts_create, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_contacts_create_save:
                Contact contact = helper.getContact();
                ContactDAO contactDAO = new ContactDAO(this);

                contactDAO.create(contact);
                contactDAO.close();

                Toast.makeText(ContactsCreateActivity.this, "Contact saved", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
