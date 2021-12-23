package com.example.android.convert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String selector = intent.getStringExtra(MainActivity.SELECT);

        String message_out = "initial";
        if (selector.equals("kg_to_lbs")){
            float val = Float.parseFloat(message);
            float long_val = (float)2.20462*val;
            String new_val = String.format("%.2f", long_val);
            message_out = message + " kg = " + new_val + " lbs";
        }
        else if(selector.equals("lbs_to_kg")){
            float val = Float.parseFloat(message);
            float long_val = (float)0.453592*val;
            String new_val = String.format("%.2f", long_val);
            message_out = message + " lbs = " + new_val + " kg";
        }
        else if(selector.equals("inches_to_cm")){
            float val = Float.parseFloat(message);
            float long_val = (float)2.54*val;
            String new_val = String.format("%.2f", long_val);
            message_out = message + " inches = " + new_val + " cm";
        }
        else if(selector.equals("cm_to_inches")){
            float val = Float.parseFloat(message);
            float long_val = (float)0.393701*val;
            String new_val = String.format("%.2f", long_val);
            message_out = message + " cm = " + new_val + " inches";
        }
        else if(selector.equals("C_to_F")){
            float val = Float.parseFloat(message);
            float long_val = (float)1.8*val + (float)32.0;
            String new_val = String.format("%.2f", long_val);
            message_out = message + " deg Celsius = " + new_val + " deg Fahrenheit";
        }
        else if(selector.equals("F_to_C")){
            float val = Float.parseFloat(message);
            float long_val = (float)0.5556*(val - (float)32.0);
            String new_val = String.format("%.2f", long_val);
            message_out = message + " deg Fahrenheit = " + new_val + " deg Celsius";
        }
        else{
            message_out = "ERROR! Improper Entry! Only enter numeric values ... ";
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message_out);
    }
}
