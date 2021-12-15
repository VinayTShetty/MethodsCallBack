package com.example.androidmethods;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataPass extends AppCompatActivity {
    public static final String TAG = DataPass.class.getSimpleName();
    EditText setData_Edittext;
    Button sendData_button;
    public static final int REQUESST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pass);
        intializeView();
        onClicklistner();
    }

    private void intializeView(){
        sendData_button = (Button) findViewById(R.id.sendData_button_id);
        setData_Edittext = (EditText) findViewById(R.id.setData_Edittext_id);
    }

    private void onClicklistner(){
        sendData_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditTextData();
            }
        });
    }
    private final void  getEditTextData(){
     final String data= setData_Edittext.getText().toString();
        Intent intent=new Intent();
        intent.putExtra(String.valueOf(R.string.activity_data_pass_TAG),data);
        setResult(REQUESST_CODE,intent);
        /**
         * use eiether finish() or super.onBackPressed() to close the Activity.
         */
        finish();
    }
}