package com.indiedeveloper.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;

public class MassActivity extends AppCompatActivity {
    private EditText mass_editText;
    private Spinner mass_spinner;
    private Button convert_button;
    private Button clear_button;
    private TextView milligram_textView;
    private TextView gram_textView;
    private TextView kilogram_textView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mass_editText = findViewById(R.id.mass_editText);
        mass_spinner = findViewById(R.id.mass_spinner);
        convert_button = findViewById(R.id.convert_button);
        clear_button = findViewById(R.id.clear_button);
        milligram_textView = findViewById(R.id.milligram_textView);
        gram_textView = findViewById(R.id.gram_textView);
        kilogram_textView = findViewById(R.id.kilogram_textView);

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mass_editText.setText("");
                milligram_textView.setText("0.0");
                gram_textView.setText("0.0");
                kilogram_textView.setText("0.0");
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> massAdapter = ArrayAdapter.createFromResource(this, R.array.mass_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        massAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        mass_spinner.setAdapter(massAdapter);

        mass_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getSelectedItemPosition()) {
                    case 0:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double OUNCE_MILLIGRAM = 28349.5;
                                final double OUNCE_GRAM = 28.3495;
                                final double OUNCE_KILOGRAM = 0.0283495;

                                final String PATTERN_MG = "#,##0.00";
                                final String PATTERN_G = "#,##0.00";
                                final String PATTERN_KG = "#,##0.00";

                                imperialToMetric(OUNCE_MILLIGRAM, OUNCE_GRAM, OUNCE_KILOGRAM, PATTERN_MG, PATTERN_G, PATTERN_KG);
                            }
                        });
                        break;
                    case 1:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double POUND_MILLIGRAM = 453592;
                                final double POUND_GRAM = 453.592;
                                final double POUND_KILOGRAM = 0.453592;

                                final String PATTERN_MG = "#,##0.00";
                                final String PATTERN_G = "#,##0.00";
                                final String PATTERN_KG = "#,##0.00";

                                imperialToMetric(POUND_MILLIGRAM, POUND_GRAM, POUND_KILOGRAM, PATTERN_MG, PATTERN_G, PATTERN_KG);

                            }
                        });
                        break;
                    default:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double IMPERIAL_TON_MILLIGRAM = 1016046908.8;
                                final double IMPERIAL_TON_GRAM = 1016046.9088;
                                final double IMPERIAL_TON_KILOGRAM = 1016.046909;

                                final String PATTERN_MG = "#,##0.00";
                                final String PATTERN_G = "#,##0.00";
                                final String PATTERN_KG = "#,##0.00";

                                imperialToMetric(IMPERIAL_TON_MILLIGRAM, IMPERIAL_TON_GRAM, IMPERIAL_TON_KILOGRAM, PATTERN_MG, PATTERN_G, PATTERN_KG);

                            }
                        });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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

    /**
     * Method that convert imperial units to metric units
     * @param milligram imperial unit to convert to milligram(metric)
     * @param gram imperial unit to convert to gram(metric)
     * @param kilogram imperial unit to convert to kilogram(metric)
     * @param patternMl pattern used to format milligram(Ex: #,###.##)
     * @param patternG pattern used to format gram(Ex: #,###.##)
     * @param patternKg pattern used to format kilogram(Ex: #,###.##)*/
    private void imperialToMetric(double milligram, double gram, double kilogram, String patternMl, String patternG, String patternKg) {
        String mass_str = mass_editText.getText().toString();

        if(TextUtils.isEmpty(mass_str)) {
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }else {
            double area_double = Double.parseDouble(mass_str);

            double result_milligram = area_double * milligram;
            double result_gram = area_double * gram;
            double result_kilogram = area_double * kilogram;

            String format_result_milligram = formatDecimalNumber(result_milligram, patternMl);
            String format_result_gram = formatDecimalNumber(result_gram, patternG);
            String format_result_kilogram = formatDecimalNumber(result_kilogram, patternKg);

            milligram_textView.setText(format_result_milligram);
            gram_textView.setText(format_result_gram);
            kilogram_textView.setText(format_result_kilogram);
        }
    }
}
