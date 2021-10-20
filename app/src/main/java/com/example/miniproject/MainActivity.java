package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    TextView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        ed1 = findViewById(R.id.txtamt);
        b1 = findViewById(R.id.btn1);
        c = findViewById(R.id.converted);


        String[] from = {"USD","GBP","EUR","INR"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"USD","GBP","EUR","INR"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);


        b1 = findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double tot;

                Double amt = Double.parseDouble(ed1.getText().toString());

                if(sp1.getSelectedItem().toString() == "USD") {
                    double a = 1;
                    switch (sp2.getSelectedItem().toString()) {
                        case "INR":
                            a=75.05;
                            break;
                        case "GBP":
                            a=0.73;
                            break;
                        case "EUR":
                            a=0.86;
                            break;
                    }
                    tot = amt *a;
                    c.setText(tot.toString());
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "INR") {
                    double a = 1;
                    switch (sp2.getSelectedItem().toString()) {
                        case "USD":
                            a=0.013;
                            break;
                        case "GBP":
                            a=0.0097;
                            break;
                        case "EUR":
                            a=0.011;
                            break;
                    }
                    tot = amt *a;
                    c.setText(tot.toString());
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "EUR") {
                    double a = 1;
                    switch (sp2.getSelectedItem().toString()) {
                        case "INR":
                            a=87.29;
                            break;
                        case "GBP":
                            a=0.84;
                            break;
                        case "USD":
                            a=1.16;
                            break;
                    }
                    tot = amt *a;
                    c.setText(tot.toString());
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "GBP") {
                    double a = 1;
                    switch (sp2.getSelectedItem().toString()) {
                        case "INR":
                            a=103.35;
                            break;
                        case "USD":
                            a=1.38;
                            break;
                        case "EUR":
                            a=1.18;
                            break;
                    }
                    tot = amt *a;
                    c.setText(tot.toString());
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}