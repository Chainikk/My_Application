package com.example.myapplication11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication11.fragments.SecondFragment;

public class SecondActivity extends AppCompatActivity {
    public SecondActivity(){
        super(R.layout.seconf_file);
    }

    public final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view1, SecondFragment.class, null)
                    .commit();
        }
        //getArgs();
    }
    /*Bundle bundle = new Bundle();
                String result = "Данные, переданные из StartFragment в RecyclerFragment";
                bundle.putString("recyclerKey", result);*/

    /*private void getArgs(){
        Bundle arg = getIntent().getExtras();
        assert arg != null;
        String name = Objects.requireNonNull(arg.get("key")).toString();
        Log.i("aaa", name);
    }
    public void onClick1(View view) {
        Intent intent = new Intent();
        intent.putExtra(KEY, "It's time to wake up");
        setResult(RESULT_OK, intent);
        finish();
    }*/
}