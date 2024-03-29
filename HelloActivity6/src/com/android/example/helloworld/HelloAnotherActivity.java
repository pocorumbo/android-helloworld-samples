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
import android.widget.TextView;

/**
 * The Activity being launched by HelloActivity.
 */
public class HelloAnotherActivity extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      // Set this Activity's layout.
      setContentView(R.layout.main);
      
      // Retrieve the data sent from its launching Activity.
      Bundle extras = this.getIntent().getExtras();
      String helloStr = extras.getString("com.android.example.helloworld.hellostr");
      
      // Get the TextView and set its text.
      TextView tx = (TextView)findViewById(R.id.hellotxt);
      tx.setText(helloStr);
  }
}
