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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * An Activity demonstrating how to start and stop a Service.
 * Services are typically used to perform background operations.
 */
public class HelloActivity extends Activity {
  
    private static String TAG = "HelloService";
    private Intent intent;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set content layout
        setContentView(R.layout.main);      
        
        intent = new Intent();
        intent.setClass(this,HelloService.class);
        intent.putExtra("helloStr", getResources().getString(R.string.hellostr));
        startService(intent);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        stopService(intent);
        super.onPause();
    }
    
    
   
}
