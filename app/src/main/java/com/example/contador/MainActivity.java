package com.example.contador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userNameText;
    private TextView textView;
    private int numClics = 0;

    private static final String TAG = "MainActivity";
    private final String TEXT_VIEW_CONTENT ="TextViewContent";
    private final String NUM_CLICKS = "NumClicks";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: start");

        userNameText = (EditText) findViewById(R.id.userNameText);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText("");

        if (userNameText != null){
            userNameText.setText("");
        }

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClics++;

                String username = userNameText.getText().toString();
                String result = "\n" + username + " ha pulsado " + numClics + " veces";

                if (numClics == 1){
                    result ="la primera vez que pulsa el boton";
                }

                if (textView != null){
                textView.append(result); }

                if (userNameText != null){
                    userNameText.setText("");
                }
            }
        };
        if (button != null){
            button.setOnClickListener(clickListener);
        }

        Log.d(TAG, "onCreate: end");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: start");
        super.onRestoreInstanceState(savedInstanceState);
        String saveStringContent = savedInstanceState.getString(TEXT_VIEW_CONTENT);
        textView.setText(saveStringContent);
        numClics = savedInstanceState.getInt(NUM_CLICKS);
        Log.d(TAG, "onRestoreInstanceState: end");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: start");
        super.onStart();
        Log.d(TAG, "onStart: end");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: start");
        super.onResume();
        Log.d(TAG, "onResume: end");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: start");
        super.onPause();
        Log.d(TAG, "onPause: end");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: start");
        super.onStop();
        Log.d(TAG, "onStop: end");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: start");
        outState.putString(TEXT_VIEW_CONTENT,textView.getText().toString());
        outState.putInt(NUM_CLICKS, numClics);
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: end");
        
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: start");
        super.onDestroy();
        Log.d(TAG, "onDestroy: end");
    }
}