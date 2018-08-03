package com.jayanthan.joinapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.jayanthan.joinapp.R;
public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.join);
        ed1=(EditText)findViewById(R.id.fname);
        ed2=(EditText)findViewById(R.id.lname);
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            try{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 100; i++) {
                            try {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ed1.setText(ed1.getText().toString() + "1");
                                    }
                                });
                                Thread.sleep(1000);
                            } catch (Exception e) {
                            }
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 100; i++) {
                            try {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ed2.setText(ed2.getText().toString() + "2");
                                    }
                                });
                                Thread.sleep(1000);
                            } catch (Exception e) {
                            }
                        }
                    }
                }).start();
            }
                   catch(Exception e){
                   Toast.makeText(getBaseContext(),"Error"+e.toString(), Toast.LENGTH_LONG);
                }
            }
        });
}
}