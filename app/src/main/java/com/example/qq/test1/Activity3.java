package com.example.qq.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    TextView tv, tv1;
    Button but;
    private int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        tv = (TextView) findViewById(R.id.textView3);
        tv1 = (TextView) findViewById(R.id.textView4);
        but = (Button) findViewById(R.id.but3);

        Intent intent = getIntent();
        result = intent.getIntExtra("result", 0);
        if (result % 2 == 0) {
            tv1.setText("Result = เลขคู่");
        } else {
            tv1.setText("Result = เลขคี่");
        }
        tv.setText("Result = " + Integer.toString(result));

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplication(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}
