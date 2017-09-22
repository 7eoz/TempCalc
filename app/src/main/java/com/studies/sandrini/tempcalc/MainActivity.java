package com.studies.sandrini.tempcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void convert(View view) {
        RadioButton toCelsius = (RadioButton) findViewById(R.id.to_celsius);
        RadioButton toFahrenheit = (RadioButton) findViewById(R.id.to_fahrenheit);
        EditText tempInput = (EditText) findViewById(R.id.temp_input);
        TextView tempResult = (TextView) findViewById(R.id.temp_result);

        if(tempInput.length() == 0){
            Toast.makeText(getApplicationContext(), "Forneça uma temperatura para ser convertida", Toast.LENGTH_SHORT).show();
        }

        float input = Float.parseFloat(tempInput.getText().toString());
        if(toCelsius.isChecked()){
            tempResult.setText("Result: " + String.valueOf(F2C(input))+ "C");
        }else{
            tempResult.setText("Result: " + String.valueOf(C2F(input))+ "F");
        }
    }

    private float F2C(Float fahr) {
        return ((fahr - 32) * 5 / 9);
    }

    private float C2F(Float celsius){
        return ((celsius * 9 / 5) + 32);
    }
}
