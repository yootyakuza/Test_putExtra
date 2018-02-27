package com.example.qq.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv = (TextView)findViewById(R.id.textView2);

        Intent intent = getIntent();

        int num1 = intent.getIntExtra("num1",0);
        int num2 = intent.getIntExtra("num2",0);

        int result = num1 + num2;

        Boolean returnResult = false;

        if(result % 2 ==0){
            returnResult = true;
        }
        else if(result % 2 == 1)
        {
            returnResult = false;
        }
        intent.putExtra("result",returnResult);
        intent.putExtra("resultForActivity3",result);
        setResult(1234,intent);
        finish();
    }
}
