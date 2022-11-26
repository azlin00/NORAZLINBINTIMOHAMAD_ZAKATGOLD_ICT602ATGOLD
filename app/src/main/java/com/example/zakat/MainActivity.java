package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView weight, types, values, totalvalue, payables, totals;
    EditText editweight;
    EditText editvalue;
    Spinner spin;
    Button btns, resets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spin = findViewById(R.id.spinner);

        editweight = findViewById(R.id.editweight);
        editvalue = findViewById(R.id.editvalue);

        weight = findViewById(R.id.displayweight);
        types = findViewById(R.id.type);
        values = findViewById(R.id.value);
        btns = findViewById(R.id.btn);
        resets = findViewById(R.id.reset);
        totalvalue = findViewById(R.id.valuegold);
        payables = findViewById(R.id.payable);
        totals = findViewById(R.id.total);

        String[] typewear = {"Select type of wear", "keep", "wear"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, typewear);
        spin.setAdapter(arrayAdapter);

        btns.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if (spin.getSelectedItem().equals("Select type of wear")) {

                } else if (spin.getSelectedItem().equals("keep")) {

                    double weights = Double.parseDouble(editweight.getText().toString());
                    double values = Double.parseDouble(editvalue.getText().toString());

                    double totvalue = 0;
                    double Fweight = 0;
                    double payablez = 0;
                    double totalz = 0;

                    Fweight = weights - 85;
                    totvalue = weights * values;
                    payablez = Fweight * values;
                    totalz = payablez * 0.025;

                    totalvalue.setText("Total Gold value: RM" + String.valueOf(totvalue));
                    payables.setText("Zakat Payable: RM" + String.valueOf(payablez));
                    totals.setText("Total Zakat: RM" + String.valueOf(totalz));

                } else if (spin.getSelectedItem().equals("wear")) {
                    double weights = Double.parseDouble(editweight.getText().toString());
                    double values = Double.parseDouble(editvalue.getText().toString());

                    double totvalue = 0;
                    double Fweight = 0;
                    double payablez = 0;
                    double totalz = 0;

                    Fweight = weights - 200;
                    totvalue = weights * values;
                    payablez = Fweight * values;
                    totalz = payablez * 0.025;


                    totalvalue.setText("Total Gold value: RM" + String.valueOf(totvalue));
                    payables.setText("Zakat Payable: RM" + String.valueOf(payablez));
                    totals.setText("Total Zakat: RM" + String.valueOf(totalz));

                }
            }


        });

        resets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                editweight.getText().clear();
                editvalue.getText().clear();
            }
        });
    }
            //menu
            @Override
            public boolean onCreateOptionsMenu(Menu menu){
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu, menu);
                return true;
            }
            @Override
            public boolean onOptionsItemSelected(MenuItem item){
                switch (item.getItemId()){
                    case R.id.about_us:
                        Intent intent = new Intent(MainActivity.this, activity_about.class);
                        startActivity(intent);
                    return true;
                    default:
                    return super.onOptionsItemSelected(item);
                }
            }
        }


