package com.muffinapps.textyofriends;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by aakash on 8/30/15.
 */
public class BaseActivity extends AppCompatActivity {
    Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mRealm = Realm.getInstance(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
