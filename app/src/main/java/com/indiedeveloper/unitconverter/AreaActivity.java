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

public class AreaActivity extends AppCompatActivity {
    private Spinner area_spinner;
    private EditText area_editText;
    private TextView sqCm_textView;
    private TextView sqM_textView;
    private TextView sqKm_textView;
    private Button convert_button;
    private Button clear_button;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        area_spinner = findViewById(R.id.area_spinner);
        area_editText = findViewById(R.id.area_editText);
        sqCm_textView = findViewById(R.id.sqCm_textView);
        sqM_textView = findViewById(R.id.sqM_textView);
        sqKm_textView = findViewById(R.id.sqKm_textView);
        convert_button = findViewById(R.id.convert_button);
        clear_button = findViewById(R.id.clear_button);

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                area_editText.setText("");
                sqCm_textView.setText("0.0");
                sqM_textView.setText("0.0");
                sqKm_textView.setText("0.0");
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.area_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        area_spinner.setAdapter(adapter);

        area_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (adapterView.getSelectedItemPosition()) {
                    case 0:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double SQUARE_INCH_CENTIMETER = 6.4516;
                                final double SQUARE_INCH_METER = 0.00064516;
                                final double SQUARE_INCH_KILOMETER = 0.00000000064516;

                                final String PATTERN_CM = "#,##0.0000";
                                final String PATTERN_M = "#,##0.0000";
                                final String PATTERN_KM = "#,##0.0000000000";

                                imperialToMetric(SQUARE_INCH_CENTIMETER, SQUARE_INCH_METER, SQUARE_INCH_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
                            }
                        });
                        break;
                    case 1:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double SQUARE_FEET_CENTIMETER = 929.03;
                                final double SQUARE_FEET_METER = 0.092903;
                                final double SQUARE_FEET_KILOMETER = 0.000000092903;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.00000000";

                                imperialToMetric(SQUARE_FEET_CENTIMETER, SQUARE_FEET_METER, SQUARE_FEET_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
                            }
                        });
                        break;
                    case 2:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double SQUARE_YARD_CENTIMETER = 8361.27;
                                final double SQUARE_YARD_METER = 0.836127;
                                final double SQUARE_YARD_KILOMETER = 0.000000836127;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.0000000";

                                imperialToMetric(SQUARE_YARD_CENTIMETER, SQUARE_YARD_METER, SQUARE_YARD_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
                            }
                        });
                        break;
                    case 3:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double SQUARE_MILE_CENTIMETER = 25899881103.36;
                                final double SQUARE_MILE_METER = 2589988.110336;
                                final double SQUARE_MILE_KILOMETER = 2.589988;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.00";

                                imperialToMetric(SQUARE_MILE_CENTIMETER, SQUARE_MILE_METER, SQUARE_MILE_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
                            }
                        });
                        break;
                    case 4:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double ACRE_SQUARE_CENTIMETER = 40468564.224;
                                final double ACRE_SQUARE_METER = 4046.856422;
                                final double ACRE_SQUARE_KILOMETER = 0.00404686;

                                final String PATTERN_CM = "#,##0.000";
                                final String PATTERN_M = "#,##0.000";
                                final String PATTERN_KM = "#,##0.000";

                                imperialToMetric(ACRE_SQUARE_CENTIMETER, ACRE_SQUARE_METER, ACRE_SQUARE_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);

                            }
                        });
                        break;
                    default:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double HECTARE_SQUARE_CENTIMETER = 100000000;
                                final double HECTARE_SQUARE_METER = 10000;
                                final double HECTARE_SQUARE_KILOMETER = 0.01;

                                final String PATTERN_CM = "#,##0.00";
                                final String PATTERN_M = "#,##0.00";
                                final String PATTERN_KM = "#,##0.00";

                                imperialToMetric(HECTARE_SQUARE_CENTIMETER, HECTARE_SQUARE_METER, HECTARE_SQUARE_KILOMETER, PATTERN_CM, PATTERN_M, PATTERN_KM);
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
     * @param sqCentimeter imperial unit to convert to square centimeter(metric)
     * @param sqMeter imperial unit to convert to square meter(metric)
     * @param sqKilometer imperial unit to convert to square kilometer(metric)
     * @param patternSqCm pattern used to format square centimeter(Ex: #,###.##)
     * @param patternSqM pattern used to format square meter(Ex: #,###.##)
     * @param patternSqKm pattern used to format square kilometer(Ex: #,###.##)*/
    private void imperialToMetric(double sqCentimeter, double sqMeter, double sqKilometer, String patternSqCm, String patternSqM, String patternSqKm) {
        String area_str = area_editText.getText().toString();

        if(TextUtils.isEmpty(area_str)) {
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }else {
            double area_double = Double.parseDouble(area_str);

            double result_sqCentimeter = area_double * sqCentimeter;
            double result_sqMeter = area_double * sqMeter;
            double result_sqKilometer = area_double * sqKilometer;

            String format_result_sqCentimeter = formatDecimalNumber(result_sqCentimeter, patternSqCm);
            String format_result_sqMeter = formatDecimalNumber(result_sqMeter, patternSqM);
            String format_result_sqKilometer = formatDecimalNumber(result_sqKilometer, patternSqKm);

            sqCm_textView.setText(format_result_sqCentimeter);
            sqM_textView.setText(format_result_sqMeter);
            sqKm_textView.setText(format_result_sqKilometer);
        }
    }
}
