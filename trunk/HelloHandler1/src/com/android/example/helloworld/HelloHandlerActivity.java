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
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

/**
 * An Activity demonstrating how to use Handler to communicate back to main
 * application thread from a thread that you created.
 */
public class HelloHandlerActivity extends Activity {
    // Defining message handler
    private DemoHandler mMsgHandler;
    
    // Define message
    public static final int MSG_DEMO = 100;
    
    TextView textView;
    
    Thread mDemoThread = null;
    
    public static final String TAG = "HelloHandlerActivity";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	// set the layout.
        setContentView(R.layout.main);
        textView = (TextView)findViewById(R.id.text);
        mMsgHandler = new DemoHandler(this);        
    }
    

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        mDemoThread = new Thread(new DemoRunnable());
        mDemoThread.start();
        super.onResume();
    }


    /**
     * A Thread that communicates back to main thread
     * through Handler.
     */
    class DemoRunnable implements Runnable{
        public void run() {
            Looper.prepare();
            // Get Message object from factory method obtainMessage()
            Message msg = mMsgHandler.obtainMessage(MSG_DEMO);
            // This is the data sent with our message.
            msg.getData().putString("hellostr", "Hello World!");
            // Send message to the thread in which Handler was created.
            // ( its the main thread here)
            mMsgHandler.sendMessage(msg);
            synchronized (this) {
                Log.d(TAG, "end of thread");
            }
        }// end run
    }
    
    class DemoHandler extends Handler {
        Context mContext;
        public DemoHandler(HelloHandlerActivity activity) {
            // TODO Auto-generated constructor stub
            mContext = activity.getApplicationContext();
        }

        @Override
        public void handleMessage(Message msg) {
            // Note this code is executed in the main thread, because
            // our DemoHandler is instantiated in the main thread.
            switch (msg.what) {
                case MSG_DEMO:
                    // Retrieve the data sent from DemoRunnable. 
                    String hellostr = msg.getData().getString("hellostr");
                    textView.setText(hellostr);                    
                    break;
                default:
                    super.handleMessage(msg);
             }
         }
    }
}
