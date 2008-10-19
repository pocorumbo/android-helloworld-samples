/* 
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * An application demonstrating how to save per instance state before the
 * Activity is destroyed.
 */
public class HelloActivityWithStateSaved extends Activity {
  
    private static String TAG = "HelloActivity";
    
    private EditText mText;
    
    private String mZip;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // Set content layout
        setContentView(R.layout.main);
        
        mText = (EditText)findViewById(R.id.zip);        
        
        // If the Activity was destroyed and restarted, restore its state saved
        // using onSaveInstaceState() earlier. This state can also be restored in
        // onRestoreInstanceState() instead of here in onCreate().
        mZip=  savedInstanceState != null ? savedInstanceState.getString("zip") : null;
        
        mText.setText(mZip);       
        
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        // Store state which persists even if this Activity gets destroyed.
        outState.putString("zip", mText.getText().toString());
       
    }
    
}
