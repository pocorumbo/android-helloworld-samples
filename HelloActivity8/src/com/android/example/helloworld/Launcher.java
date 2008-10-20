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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * An Activity to launch the HelloActivityWithStateSaved and HelloActivityWithoutStateSaved.
 */
public class Launcher extends Activity {
  
    private static String TAG = "HelloActivity";
    
    private Button mButton1;
    
    private Button mButton2;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // Set content layout
        setContentView(R.layout.launcher);
        
        mButton1 = (Button)findViewById(R.id.btn1); 
        mButton2 = (Button)findViewById(R.id.btn2);
        
        mButton1.setOnClickListener(new OnClickListener(){
          public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent mIntent = new Intent();
            mIntent.setClass(Launcher.this, StateNotSaved.class);
            startActivity(mIntent);            
          }          
        });
        
        mButton2.setOnClickListener(new OnClickListener(){
          public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent mIntent = new Intent();
            mIntent.setClass(Launcher.this, StateSaved.class);
            startActivity(mIntent);            
          }          
        });
        
    }

    
}
