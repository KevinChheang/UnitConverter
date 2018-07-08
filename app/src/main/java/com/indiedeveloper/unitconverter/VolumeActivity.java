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

public class VolumeActivity extends AppCompatActivity {
    private EditText volume_editText;
    private Spinner volume_spinner;
    private Button convert_button;
    private Button clear_button;
    private TextView milliliter_textView;
    private TextView liter_textView;
    private TextView cubic_meter_textView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        volume_editText = findViewById(R.id.volume_editText);
        volume_spinner = findViewById(R.id.volume_spinner);
        convert_button = findViewById(R.id.convert_button);
        clear_button = findViewById(R.id.clear_button);
        milliliter_textView = findViewById(R.id.milliliter_textView);
        liter_textView = findViewById(R.id.liter_textView);
        cubic_meter_textView = findViewById(R.id.cubic_meter_textView);

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volume_editText.setText("");
                milliliter_textView.setText("0.0");
                liter_textView.setText("0.0");
                cubic_meter_textView.setText("0.0");
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> volumeAdapter = ArrayAdapter.createFromResource(this, R.array.volume_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        volumeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        volume_spinner.setAdapter(volumeAdapter);

        volume_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getSelectedItemPosition()) {
                    case 0:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double CUBIC_INCH_MILLILITER = 16.3871;
                                final double CUBIC_INCH_LITER = 0.0163871;
                                final double CUBIC_INCH_CUBIC_METER = 0.0000163871;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.00";
                                final String PATTERN_CUBIC_METER = "#,##0.000000";

                                imperialToMetric(CUBIC_INCH_MILLILITER, CUBIC_INCH_LITER, CUBIC_INCH_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    case 1:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double CUBIC_FOOT_MILLILITER = 28316.846592;
                                final double CUBIC_FOOT_LITER = 28.316847;
                                final double CUBIC_FOOT_CUBIC_METER = 0.0283168;

                                final String PATTERN_ML = "#,##0.000";
                                final String PATTERN_L = "#,##0.000";
                                final String PATTERN_CUBIC_METER = "#,##0.000";

                                imperialToMetric(CUBIC_FOOT_MILLILITER, CUBIC_FOOT_LITER, CUBIC_FOOT_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    case 2:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double US_TEASPOON_MILLILITER = 4.92892;
                                final double US_TEASPOON_LITER = 0.00492892;
                                final double US_TEASPOON_CUBIC_METER = 0.00000492892;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.0000";
                                final String PATTERN_CUBIC_METER = "#,##0.0000000";

                                imperialToMetric(US_TEASPOON_MILLILITER, US_TEASPOON_LITER, US_TEASPOON_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    case 3:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double US_TABLESPOON_MILLILITER = 14.7868;
                                final double US_TABLESPOON_LITER = 0.0147868;
                                final double US_TABLESPOON_CUBIC_METER = 0.0000147868;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.000";
                                final String PATTERN_CUBIC_METER = "#,##0.000000";

                                imperialToMetric(US_TABLESPOON_MILLILITER, US_TABLESPOON_LITER, US_TABLESPOON_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    case 4:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double US_OUNCE_MILLILITER = 29.57353;
                                final double US_OUNCE_LITER = 0.0295735;
                                final double US_OUNCE_CUBIC_METER = 0.0000295735;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.000";
                                final String PATTERN_CUBIC_METER = "#,##0.000000";

                                imperialToMetric(US_OUNCE_MILLILITER, US_OUNCE_LITER, US_OUNCE_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    case 5:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double US_CUP_MILLILITER = 236.588237;
                                final double US_CUP_LITER = 0.236588;
                                final double US_CUP_CUBIC_METER = 0.000236588;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.00";
                                final String PATTERN_CUBIC_METER = "#,##0.00000";

                                imperialToMetric(US_CUP_MILLILITER, US_CUP_LITER, US_CUP_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    case 6:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                usPintToMilliliter();
//                                usPintToLiter();
//                                usPintToCubicMeter();
                                final double US_PINT_MILLILITER = 473.176473;
                                final double US_PINT_LITER = 0.473176;
                                final double US_PINT_CUBIC_METER = 0.000473176;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.00";
                                final String PATTERN_CUBIC_METER = "#,##0.00000";

                                imperialToMetric(US_PINT_MILLILITER, US_PINT_LITER, US_PINT_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    case 7:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double US_QUART_MILLILITER = 946.352946;
                                final double US_QUART_LITER = 0.946353;
                                final double US_QUART_CUBIC_METER = 0.000946353;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.00";
                                final String PATTERN_CUBIC_METER = "#,##0.00000";

                                imperialToMetric(US_QUART_MILLILITER, US_QUART_LITER, US_QUART_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
                            }
                        });
                        break;
                    default:
                        convert_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final double US_GALLON_MILLILITER = 3785.411784;
                                final double US_GALLON_LITER = 3.785412;
                                final double US_GALLON_CUBIC_METER = 0.00378541;

                                final String PATTERN_ML = "#,##0.00";
                                final String PATTERN_L = "#,##0.00";
                                final String PATTERN_CUBIC_METER = "#,##0.0000";

                                imperialToMetric(US_GALLON_MILLILITER, US_GALLON_LITER, US_GALLON_CUBIC_METER, PATTERN_ML, PATTERN_L, PATTERN_CUBIC_METER);
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
     * @param milliliter imperial unit to convert to milliliter(metric)
     * @param liter imperial unit to convert to liter(metric)
     * @param cubicMeter imperial unit to convert to cubic meter(metric)
     * @param patternMl pattern used to format milliliter(Ex: #,###.##)
     * @param patternL pattern used to format liter(Ex: #,###.##)
     * @param patternCubicM pattern used to format cubic meter(Ex: #,###.##)*/
    private void imperialToMetric(double milliliter, double liter, double cubicMeter, String patternMl, String patternL, String patternCubicM) {
        String volume_str = volume_editText.getText().toString();

        if(TextUtils.isEmpty(volume_str)) {
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }else {
            double area_double = Double.parseDouble(volume_str);

            double result_milliliter = area_double * milliliter;
            double result_liter = area_double * liter;
            double result_cubicMeter = area_double * cubicMeter;

            String format_result_milliliter = formatDecimalNumber(result_milliliter, patternMl);
            String format_result_liter = formatDecimalNumber(result_liter, patternL);
            String format_result_cubicMeter = formatDecimalNumber(result_cubicMeter, patternCubicM);

            milliliter_textView.setText(format_result_milliliter);
            liter_textView.setText(format_result_liter);
            cubic_meter_textView.setText(format_result_cubicMeter);
        }
    }
}
