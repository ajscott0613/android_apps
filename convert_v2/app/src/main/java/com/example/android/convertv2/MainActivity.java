package com.example.android.convertv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "test";
    public static final String SELECT = "test1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateList(View view) {

        final Spinner spinner_select=findViewById(R.id.spinner);
        final String selector = spinner_select.getSelectedItem().toString();

        // initialize array
        String[] values = new String[]{
                "empty"
        };


        // Initializing a String Array
        if (selector.equals("weight")){
            values = new String[]{
                    "kg",
                    "lbs"
            };


        }
        else if(selector.equals("temperature")){
            values = new String[]{
                    "C",
                    "F",
                    "Kelvin"
            };


        }
        else if(selector.equals("length")){
            values = new String[]{
                    "cm",
                    "inches"
            };

        }
        else if(selector.equals("volume")){
            values = new String[]{
                    "Liter",
                    "fluid ounce"
            };

        }


        final List<String> selectedList = new ArrayList<>(Arrays.asList(values));
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, selectedList);

        Spinner spinner6_select=findViewById(R.id.spinner6);
        spinner6_select.setEnabled(true);

        spinner6_select.setAdapter(spinnerArrayAdapter);

        Spinner spinner7_select=findViewById(R.id.spinner7);
        spinner7_select.setEnabled(true);

        spinner7_select.setAdapter(spinnerArrayAdapter);
    }


    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

//        Spinner spinner_select=findViewById(R.id.spinner);
//        String selector = spinner_select.getSelectedItem().toString();
//
//        intent.putExtra(SELECT, selector);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);

        Spinner spinner6_select=findViewById(R.id.spinner6);
        String selector_in = spinner6_select.getSelectedItem().toString();

        Spinner spinner7_select=findViewById(R.id.spinner7);
        String selector_out = spinner7_select.getSelectedItem().toString();

        String message_out = "initial";


//        HashMap<String, Float> map = new HashMap<>();
//        map.put("kglbs", (float)2.20462);

        // weights section
        if (selector_in.equals("kg")){
            if (selector_out.equals("lbs")){
                float val = Float.parseFloat(message);
                float long_val = (float)2.20462*val;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " kg = " + new_val + " lbs";
            }
            if (selector_out.equals("kg")){
                message_out = message + " kg = " + message + " kg";
            }

        }
        else if (selector_in.equals("lbs")){
            if (selector_out.equals("kg")){
                float val = Float.parseFloat(message);
                float long_val = (float)0.453592*val;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " lbs = " + new_val + " kg";
            }
            if (selector_out.equals("lbs")){
                message_out = message + " lbs = " + message + " lbs";
            }

        }

        // temperature section
        else if (selector_in.equals("C")){
            if (selector_out.equals("F")){
                float val = Float.parseFloat(message);
                float long_val = (float)1.8*val + (float)32.0;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " deg Celsius = " + new_val + " deg Fahrenheit";
            }
            if (selector_out.equals("Kelvin")){
                float val = Float.parseFloat(message);
                float long_val = val + (float)273.15;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " deg Celsius = " + new_val + " Kelvin";
            }
            if (selector_out.equals("C")){
                message_out = message + " deg Celsius = " + message + " deg Celsius";
            }

        }
        else if (selector_in.equals("F")){
            if (selector_out.equals("C")){
                float val = Float.parseFloat(message);
                float long_val = (float)0.5556*(val - (float)32.0);
                String new_val = String.format("%.2f", long_val);
                message_out = message + " deg Fahrenheit = " + new_val + " deg Celsius";
            }
            if (selector_out.equals("Kelvin")){
                float val = Float.parseFloat(message);
                float long_val = (float)0.5556*(val - (float)32.0) + (float)273.15;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " deg Fahrenheit = " + new_val + " Kelvin";
            }
            if (selector_out.equals("F")){
                message_out = message + " deg Fahrenheit = " + message + " deg Fahrenheit";
            }

        }
        else if (selector_in.equals("Kelvin")){
            if (selector_out.equals("C")){
                float val = Float.parseFloat(message);
                float long_val = val - (float)273.15;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " Kelvin = " + new_val + " deg Celsius";
            }
            if (selector_out.equals("F")){
                float val = Float.parseFloat(message);
                float long_val = (float)1.8*(val - (float)273.15) + (float)32.0;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " Kelvin = " + new_val + " deg Fahrenheit";
            }
            if (selector_out.equals("Kelvin")){
                message_out = message + " Kelvin = " + message + " Kelvin";
            }

        }

        // length section
        else if (selector_in.equals("cm")){
            if (selector_out.equals("inches")){
                float val = Float.parseFloat(message);
                float long_val = (float)0.393701*val;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " cm = " + new_val + " inches";
            }
            if (selector_out.equals("cm")){
                message_out = message + " cm = " + message + " cm";
            }

        }
        else if (selector_in.equals("inches")){
            if (selector_out.equals("cm")){
                float val = Float.parseFloat(message);
                float long_val = (float)2.54*val;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " inches = " + new_val + " cm";
            }
            if (selector_out.equals("inches")){
                message_out = message + " inches = " + message + " inches";
            }

        }

        // volume section
        else if (selector_in.equals("Liter")){
            if (selector_out.equals("fluid ounce")){
                float val = Float.parseFloat(message);
                float long_val = (float)33.814*val;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " Liter(s) = " + new_val + " fluid ounce(s)";
            }
            if (selector_out.equals("lbs")){
                message_out = message + " Liter(s = " + message + " Liter(s";
            }

        }
        else if (selector_in.equals("fluid ounces")){
            if (selector_out.equals("Liter")){
                float val = Float.parseFloat(message);
                float long_val = (float)0.0295735*val;
                String new_val = String.format("%.2f", long_val);
                message_out = message + " fluid ounce(s) = " + new_val + " Liter(s)";
            }
            if (selector_out.equals("fluid ounce")){
                message_out = message + " fluid ounce(s) = " + message + " fluid ounce(s)";
            }

        }



//        if (selector_in.equals("kg")){
//            if (selector_out.equals("lbs")){
//                float val = Float.parseFloat(message);
//                float long_val = (float)2.20462*val;
//                String new_val = String.format("%.2f", long_val);
//                message_out = message + " kg = " + new_val + " lbs";
//            }
//            if (selector_out.equals("kg")){
//                message_out = message + " kg = " + message + " kg";
//            }
//
//        }
//        else if(selector.equals("lbs_to_kg")){
//            float val = Float.parseFloat(message);
//            float long_val = (float)0.453592*val;
//            String new_val = String.format("%.2f", long_val);
//            message_out = message + " lbs = " + new_val + " kg";
//        }
//        else if(selector.equals("inches_to_cm")){
//            float val = Float.parseFloat(message);
//            float long_val = (float)2.54*val;
//            String new_val = String.format("%.2f", long_val);
//            message_out = message + " inches = " + new_val + " cm";
//        }
//        else if(selector.equals("cm_to_inches")){
//            float val = Float.parseFloat(message);
//            float long_val = (float)0.393701*val;
//            String new_val = String.format("%.2f", long_val);
//            message_out = message + " cm = " + new_val + " inches";
//        }
//        else if(selector.equals("C_to_F")){
//            float val = Float.parseFloat(message);
//            float long_val = (float)1.8*val + (float)32.0;
//            String new_val = String.format("%.2f", long_val);
//            message_out = message + " deg Celsius = " + new_val + " deg Fahrenheit";
//        }
//        else if(selector.equals("F_to_C")){
//            float val = Float.parseFloat(message);
//            float long_val = (float)0.5556*(val - (float)32.0);
//            String new_val = String.format("%.2f", long_val);
//            message_out = message + " deg Fahrenheit = " + new_val + " deg Celsius";
//        }
        else{
            message_out = "ERROR! Improper Entry! Only enter numeric values ... ";
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView3);
        textView.setText(message_out);


    }
}

