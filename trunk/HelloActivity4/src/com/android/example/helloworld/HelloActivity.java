package com.android.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class HelloActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mIntent = new Intent();
        mIntent.setClass(this,HelloAnotherActivity.class);
        startActivity(mIntent);
    }
}