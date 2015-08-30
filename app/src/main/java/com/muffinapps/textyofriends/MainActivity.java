package com.muffinapps.textyofriends;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MainRecyclerAdapter());
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

    private class ContactHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;;

        public ContactHolder(View v) {
            super(v);
            mTitleTextView = (TextView) v.findViewById(R.id.txt2);
        }
    }

    public class MainRecyclerAdapter extends RecyclerView.Adapter<ContactHolder> {

//        private MessageRepository mMessageRepository;
//        public MainRecyclerAdapter(MessageRepository repository) {
//            mMessageRepository = repository;
//        }
//
        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.
                    from(parent.getContext()).
                    inflate(R.layout.contact_row, parent, false);

            return new ContactHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            holder.mTitleTextView.setText("Hello World");
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }
}