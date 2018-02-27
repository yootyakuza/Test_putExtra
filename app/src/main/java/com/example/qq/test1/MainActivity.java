package com.example.qq.test1;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    NumberPicker np1, np2;
    Button b1Sum, b2Go3;
    TextView tvResult;
    private int num1 = 0, num2 = 0, result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        np1 = (NumberPicker) findViewById(R.id.numberPicker1);
        np1.setMinValue(0);
        np1.setMaxValue(9);
        np1.setWrapSelectorWheel(true);

        np2 = (NumberPicker) findViewById(R.id.numberPicker2);
        np2.setMinValue(0);
        np2.setMaxValue(9);
        np2.setWrapSelectorWheel(true);

        b1Sum = (Button) findViewById(R.id.but1);
        b2Go3 = (Button) findViewById(R.id.but2);
        b2Go3.setEnabled(false);

        tvResult = (TextView) findViewById(R.id.textView1);

        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                num1 = np1.getValue();
            }
        });
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                num2 = np2.getValue();
            }
        });
        b1Sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (num1 == 0 && num2 == 0) {
                    Toast t = Toast.makeText(getApplicationContext(), "Please try again !!", Toast.LENGTH_SHORT);
                    tvResult.setText("");
                    t.show();
                    b2Go3.setEnabled(false);
                    b2Go3.setBackgroundColor(Color.LTGRAY);
                } else {
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
                    intent.putExtra("num1", num1);
                    intent.putExtra("num2", num2);
                    startActivityForResult(intent, 1234);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234) {
            boolean message = data.getBooleanExtra("result", true);
            result = data.getIntExtra("resultForActivity3", 0);
            tvResult.setText("Result = " + Boolean.toString(message));

            if (result > 0) {
                if (message == true) {
                    b2Go3.setBackgroundColor(Color.GREEN);
                    b2Go3.setEnabled(true);
                    b2Go3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), Activity3.class);
                            intent.putExtra("result", result);
                            startActivity(intent);
                        }
                    });
                } else {
                    b2Go3.setBackgroundColor(Color.RED);
                    b2Go3.setEnabled(true);
                    b2Go3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), Activity3.class);
                            intent.putExtra("result", result);
                            startActivity(intent);
                        }
                    });
                }
            }
        }
    }
}
