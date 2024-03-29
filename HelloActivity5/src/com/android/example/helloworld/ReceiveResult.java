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

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

/**
 * Shows how an activity can send data to its launching activity when done.
 */
public class ReceiveResult extends Activity {
    /**
     * Initialization of the Activity after it is first created.  Must at least
     * call {@link android.app.Activity#setContentView setContentView()} to
     * describe what is to be displayed in the screen.
     */
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        // Be sure to call the super class.
        super.onCreate(savedInstanceState);

        // See assets/res/any/layout/hello_world.xml for this
        // view layout definition, which is being set here as
        // the content of our screen.
        setContentView(R.layout.receive_result);

        // Retrieve the TextView widget that will display results.
        mResults = (TextView)findViewById(R.id.results);

        // This allows us to later extend the text buffer.
        mResults.setText(mResults.getText(), TextView.BufferType.EDITABLE);

        // Watch for button clicks.
        Button getButton = (Button)findViewById(R.id.get);
        getButton.setOnClickListener(mGetListener);
    }

    /**
     * This method is called when the sending activity has finished, with the
     * result it supplied.
     * 
     * @param requestCode The original request code as given to
     *                    startActivity().
     * @param resultCode From sending activity as per setResult().
     * @param data From sending activity as per setResult().
     */
    @Override
	protected void onActivityResult(int requestCode, int resultCode,
		Intent data) {
        // You can use the requestCode to select between multiple child
        // activities you may have started.  Here there is only one thing
        // we launch.
        if (requestCode == GET_CODE) {

            // We will be adding to our text.
            Editable text = (Editable)mResults.getText();

            // This is a standard resultCode that is sent back if the
            // activity doesn't supply an explicit result.  It will also
            // be returned if the activity failed to launch.
            if (resultCode == RESULT_CANCELED) {
                text.append("(cancelled)");

            // Our protocol with the sending activity is that it will send
            // text in 'data' as its result.
            } else {
                text.append("(okay ");
                text.append(Integer.toString(resultCode));
                text.append(") ");
                if (data != null) {
                    text.append(data.getAction());
                }
            }

            text.append("\n");
        }
    }

    // Definition of the one requestCode we use for receiving resuls.
    static final private int GET_CODE = 0;

    private OnClickListener mGetListener = new OnClickListener() {
        public void onClick(View v) {
            // Start the activity whose result we want to retrieve.  The
            // result will come back with request code GET_CODE.
            Intent intent = new Intent(ReceiveResult.this, SendResult.class);
            startActivityForResult(intent, GET_CODE);
        }
    };

    private TextView mResults;
}

