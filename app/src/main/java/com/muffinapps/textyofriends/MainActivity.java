package com.muffinapps.textyofriends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muffinapps.textyofriends.dialogs.NewContactActivity;
import com.muffinapps.textyofriends.models.Contact;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    MainRecyclerAdapter adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RealmResults<Contact> contacts = realm.where(Contact.class).findAll();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapater = new MainRecyclerAdapter(contacts);
        mRecyclerView.setAdapter(adapater);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab_add)
    public void addContact() {
        Intent intent = new Intent(this, NewContactActivity.class);
        startActivity(intent);
    }

    private class ContactHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;;

        public ContactHolder(View v) {
            super(v);
            mTitleTextView = (TextView) v.findViewById(R.id.txt2);
        }
    }

    public class MainRecyclerAdapter extends RecyclerView.Adapter<ContactHolder> {

        private RealmResults<Contact> mContacts;
        public MainRecyclerAdapter(RealmResults<Contact> contacts) {
            mContacts = contacts;
        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.
                    from(parent.getContext()).
                    inflate(R.layout.contact_row, parent, false);

            return new ContactHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            holder.mTitleTextView.setText(mContacts.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }
}