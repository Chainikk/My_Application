package com.example.myapplication11;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "sleepMonitor";
    public static final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(KEY, "It's time to sleep");
                mStartForResult.launch(intent);
            }
        });
    }

    public void logClick(View view) {
        Log.i(TAG, "Вывод Log по нажатию");
    }
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == AppCompatActivity.RESULT_OK) {
                        Intent data = result.getData();
                        String returnedData = data.getStringExtra("key");
                        Log.i(TAG, "Returned data from SecondActivity: " + returnedData);
                    }
                    else {
                        Log.i(TAG, "No data returned from SecondActivity");
                    }
                }
            }
    );

    /*public void onCLick(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }*/
}