package com.example.androidmethods;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    Button getDataButton;
    TextView getDataTextVeiw;
    private final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeView();
        onClicListner();
    }

    private final void intializeView() {
        getDataButton = (Button) findViewById(R.id.getData_button_id);
        getDataTextVeiw = (TextView) findViewById(R.id.getData_textView_id);
    }

    private final void onClicListner() {
        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataPass.class);
                activityResultLauncher.launch(intent);
            }
        });
    }

    //Create a instance for Activity Launcher
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    /**
                     * onclick of back Button of ParentActivity of onActivityResult will be executed.
                     */
                    Log.d(TAG, "onActivityResult: ");
                    if (result.getResultCode() == REQUEST_CODE) {
                        if (result.getData() != null) {
                            Intent intent = result.getData();
                            String data = intent.getStringExtra(String.valueOf(R.string.activity_data_pass_TAG));
                            getDataTextVeiw.setText(data);
                        }
                    }
                }
            }
    );
}