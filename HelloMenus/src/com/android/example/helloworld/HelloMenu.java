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
 * An Activity demonstrating how to create Menu.
 */
public class HelloMenu extends Activity {
  
    private static String TAG = "HelloMenus";
    
    private static final int ITEM1_ID = Menu.FIRST;
    
    private static final int ITEM2_ID = Menu.FIRST + 1;

    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // Set content layout
        setContentView(R.layout.main);      
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, ITEM1_ID, 0, R.string.menu_item1);
        menu.add(0, ITEM2_ID, 0, R.string.menu_item2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case ITEM1_ID:
                Toast.makeText(this, 
                    "Menu Item1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case ITEM2_ID:
                Toast.makeText(this, 
                    "Menu Item2 selected", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
}
