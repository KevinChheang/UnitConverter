package com.indiedeveloper.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;

public class TemperatureActivity extends AppCompatActivity {
    private EditText temperature_editText;
    private Spinner temperature_spinner;
    private Button convert_button;
    private Button clear_button;
    private TextView celsius_textView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        temperature_editText = findViewById(R.id.temperature_editText);
        temperature_spinner = findViewById(R.id.temperature_spinner);
        convert_button = findViewById(R.id.convert_button);
        clear_button = findViewById(R.id.clear_button);
        celsius_textView = findViewById(R.id.celsius_textView);

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temperature_editText.setText("");
                celsius_textView.setText("0.0");
            }
        });

        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fahrenheitToCelsius();
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> massAdapter = ArrayAdapter.createFromResource(this, R.array.temperature_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        massAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        temperature_spinner.setAdapter(massAdapter);
    }

    /**
     * Method that convert temperature from fahrenheit to celsius
     */
    private void fahrenheitToCelsius() {
        String temperature_str = temperature_editText.getText().toString();
        String pattern = "#,##0.00";

        if(TextUtils.isEmpty(temperature_str)) {
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }else {
            double temperature_double = Double.parseDouble(temperature_str);

            double result = (temperature_double - 32) / 1.8;

            String formatResult = formatDecimalNumber(result, pattern);

            celsius_textView.setText(formatResult);
        }
    }

    /**
     * Method that format number to any given pattern (Ex: #,##0.00)
     * @param num number to be formatted
     * @param pattern pattern to use for the format
     * @return String the formated number
     */
    private String formatDecimalNumber(double num, String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        String format = decimalFormat.format(num);

        return format;
    }
}
