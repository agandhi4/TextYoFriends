package com.muffinapps.textyofriends.dialogs;

import android.os.Bundle;
import android.widget.EditText;

import com.muffinapps.textyofriends.BaseActivity;
import com.muffinapps.textyofriends.R;
import com.muffinapps.textyofriends.models.Contact;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

/**
 * Created by aakash on 8/29/15.
 */
public class NewContactActivity extends BaseActivity {
    @Bind(R.id.add_contact_input) EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        ButterKnife.bind(this);

        setTitle(R.string.new_contact_name_add);
        setFinishOnTouchOutside(false);
    }

    @OnClick(R.id.add_contact_button)
    public void addContact() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Contact contact = realm.createObject(Contact.class);
                contact.setName(mEditText.getText().toString());
            }
        });
        finish();
    }
}
