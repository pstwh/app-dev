package com.pstwh.contacts;

import android.widget.EditText;
import android.widget.RatingBar;

import com.pstwh.contacts.models.Contact;

/**
 * Created by pstwh on 27/02/2018.
 */

public class ContactsHelper {
    private EditText nameField;
    private EditText addressField;
    private EditText telephoneField;
    private EditText websiteField;
    private RatingBar ratingField;

    private Contact contact;

    public ContactsHelper(ContactsCreateActivity activity) {
        nameField = (EditText) activity.findViewById(R.id.contacts_create_name);
        addressField = (EditText) activity.findViewById(R.id.contacts_create_address);
        telephoneField = (EditText) activity.findViewById(R.id.contacts_create_telephone);
        websiteField = (EditText) activity.findViewById(R.id.contacts_create_website);
        ratingField = (RatingBar) activity.findViewById(R.id.contacts_create_ratingbar);
        contact = new Contact();
    }

    public Contact getContact() {
        contact.setName(nameField.getText().toString());
        contact.setAddress(addressField.getText().toString());
        contact.setTelephone(telephoneField.getText().toString());
        contact.setWebsite(websiteField.getText().toString());
        contact.setRating(Double.valueOf(ratingField.getProgress()));

        return contact;
    }

    public void fillContact(Contact contact) {
        nameField.setText(contact.getName());
        addressField.setText(contact.getAddress());
        telephoneField.setText(contact.getTelephone());
        websiteField.setText(contact.getWebsite());
        ratingField.setProgress(contact.getRating().intValue());
        this.contact = contact;
    }
}
