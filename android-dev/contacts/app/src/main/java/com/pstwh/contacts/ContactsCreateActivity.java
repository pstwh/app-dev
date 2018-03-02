package com.pstwh.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.pstwh.contacts.dao.ContactDAO;
import com.pstwh.contacts.models.Contact;

public class ContactsCreateActivity extends AppCompatActivity {

    private ContactsHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_form);

        helper = new ContactsHelper(this);

        Intent intent = getIntent();
        Contact contact = (Contact) intent.getSerializableExtra("contact");
        if (contact != null) {
            helper.fillContact(contact);
        }
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

                if(contact.getId() != null) {
                    contactDAO.update(contact);
                } else {
                    contactDAO.create(contact);
                }
                contactDAO.close();

                Toast.makeText(ContactsCreateActivity.this, "Contact saved", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
