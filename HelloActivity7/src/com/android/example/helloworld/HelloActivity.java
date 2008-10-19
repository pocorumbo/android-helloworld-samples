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
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A "Hello, World!" application demonstrating how to start other Activities
 * from an Activity.
 */
public class HelloActivity extends Activity {
  
    private static String TAG = "HelloActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set content layout
        setContentView(R.layout.main);
        
        TextView tx = (TextView)findViewById(R.id.hellotxt);
        tx.setText("1) Press the back button then launch this application." +
        		"2)Press the home button then launch this application. " +
        		"3)Change the orientation." +
        		" Check Logs to see the sequence of lifecycle callbacks " +
        		"trigerred by these actions.");
    }

    @Override
    protected void onDestroy() {
      // TODO Auto-generated method stub
      Log.i(TAG, "onDestroy() called. Final call " +
      		"before your activity is destroyed.");
      super.onDestroy();
      
    }

    @Override
    protected void onPause() {
      // TODO Auto-generated method stub
      Log.i(TAG, "onPause() called. Activity is going into the background, " +
      		"but has not (yet) been destroyed. " );

      super.onPause();
    }

    @Override
    protected void onRestart() {
      // TODO Auto-generated method stub
      Log.i(TAG,"onRestart() called. Activity is re-displayed again after being stopped.");
      super.onRestart();
    }
    
    @Override
    protected void onResume() {
      // TODO Auto-generated method stub
      Log.i(TAG,"onResume() called. Activity will start " +
      		"interacting with the user..");     
      super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
      // TODO Auto-generated method stub
      Log.i(TAG,"onSaveInstanceState() called. Before placing the activity in " +
      		"a background state.");       

      super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
      // TODO Auto-generated method stub
      Log.i(TAG, "onStart() called. Activity is now being displayed to the user."); 
  
      super.onStart();
    }

    @Override
    protected void onStop() {
      // TODO Auto-generated method stub
      Log.i(TAG, "onStop() called. Activity is no longer visible to the user."); 
  
      super.onStop();
    }
    
    
}
