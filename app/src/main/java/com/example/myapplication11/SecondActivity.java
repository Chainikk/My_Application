package com.example.myapplication11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    public final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seconf_file);
        getArgs();
    }
    private void getArgs(){
        Bundle arg = getIntent().getExtras();
        assert arg != null;
        String name = Objects.requireNonNull(arg.get("key")).toString();
        Log.i(MainActivity.TAG, name);
    }
    public void onClick1(View view) {
        Intent intent = new Intent();
        intent.putExtra(KEY, "It's time to wake up");
        setResult(RESULT_OK, intent);
        finish();
    }
}