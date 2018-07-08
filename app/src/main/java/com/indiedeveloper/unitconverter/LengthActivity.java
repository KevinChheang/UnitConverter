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

public class LengthActivity extends AppCompatActivity {
    private EditText length_editText;
    private Spinner length_spinner;
    private Button convert_button;
    private Button clear_button;
    private TextView cm_textView;
    private TextView m_textView;
    private TextView km_textView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        length_editText = findViewById(R.id.length_editText);
        length_spinner = findViewById(R.id.length_spinner);
        convert_button = findViewById(R.id.convert_button);
        clear_button = findViewById(R.id.clear_button);
        cm_textView = findViewById(R.id.cm_textView);
        m_textView = findViewById(R.id.m_textView);
        km_textView = findViewById(R.id.km_textView);

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length_editText.setText("");
                cm_textView.setText("0.0");
                m_textView.setText("0.0");
                km_textView.setText("0.0");
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.length_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        length_spinner.setAdapter(adapter);

        length_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getSelectedItemPosition()) {
                    case 0:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double INCH_CENTIMETER = 2.54;
                                final double INCH_METER = 0.0254;
                                final double INCH_KILOMETER = 0.0000254;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.00000";

                                imperialToMetric(INCH_CENTIMETER, INCH_METER, INCH_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
                            }
                        });
                        break;
                    case 1:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double FEET_CENTIMETER = 30.48;
                                final double FEET_METER = 0.3048;
                                final double FEET_KILOMETER = 0.0003048;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.0000";

                                imperialToMetric(FEET_CENTIMETER, FEET_METER, FEET_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);

                            }
                        });
                        break;
                    case 2:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double YARD_CENTIMETER = 91.44;
                                final double YARD_METER = 0.9144;
                                final double YARD_KILOMETER = 0.0009144;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.0000";

                                imperialToMetric(YARD_CENTIMETER, YARD_METER, YARD_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
                            }
                        });
                        break;
                    default:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double MILE_CENTIMETER = 160934;
                                final double MILE_METER = 1609.34;
                                final double MILE_KILOMETER = 1.60934;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.0000";

                                imperialToMetric(MILE_CENTIMETER, MILE_METER, MILE_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
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
     * @param centimeter imperial unit to convert to centimeter(metric)
     * @param meter imperial unit to convert to meter(metric)
     * @param kilometer imperial unit to convert to kilometer(metric)
     * @param patternCm pattern used to format centimeter(Ex: #,###.##)
     * @param patternM pattern used to format meter(Ex: #,###.##)
     * @param patternKm pattern used to format kilometer(Ex: #,###.##)*/
    private void imperialToMetric(double centimeter, double meter, double kilometer, String patternCm, String patternM, String patternKm) {
        String length_str = length_editText.getText().toString();

        if(TextUtils.isEmpty(length_str)) {
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }else {
            double area_double = Double.parseDouble(length_str);

            double result_centimeter = area_double * centimeter;
            double result_meter = area_double * meter;
            double result_kilometer = area_double * kilometer;

            String format_result_centimeter = formatDecimalNumber(result_centimeter, patternCm);
            String format_result_meter = formatDecimalNumber(result_meter, patternM);
            String format_result_kilometer = formatDecimalNumber(result_kilometer, patternKm);

            cm_textView.setText(format_result_centimeter);
            m_textView.setText(format_result_meter);
            km_textView.setText(format_result_kilometer);
        }
    }
}
