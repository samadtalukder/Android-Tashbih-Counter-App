package com.samad.androidtasbihapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button plusBtn,minusBtn,resetBtn,saveBtn;
    private TextView displayCount;
    private int count = 0;
    private String stTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        /*stTotal = String.valueOf(count);
        stTotal = stTotal.replaceAll("0", "০").replaceAll("1","১").replaceAll("2", "২").replaceAll("3", "৩").replaceAll("4", "৪").replaceAll("5", "৫").replaceAll("6", "৬").replaceAll("7", "৭").replaceAll("8", "৮").replaceAll("9", "৯");
        displayCount.setText(stTotal);*/
        //
        Typeface typeface = Typeface.createFromAsset(getAssets(),"benSenHandwriting.ttf");
        displayCount = findViewById(R.id.tvCount);
        displayCount.setTypeface(typeface);
        //
        plusBtn = findViewById(R.id.plusBtn);
        plusBtn.setTypeface(typeface);
        //
        minusBtn = findViewById(R.id.minusBtn);
        minusBtn.setTypeface(typeface);
        //
        resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setTypeface(typeface);
        //
        saveBtn = findViewById(R.id.saveBtn);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;

                stTotal = String.valueOf(count);
                stTotal = stTotal.replaceAll("0", "০").replaceAll("1","১").replaceAll("2", "২").replaceAll("3", "৩").replaceAll("4", "৪").replaceAll("5", "৫").replaceAll("6", "৬").replaceAll("7", "৭").replaceAll("8", "৮").replaceAll("9", "৯");
                displayCount.setText(stTotal);
                //displayCount.setText(""+count);
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0){
                    /*displayCount.setText(""+count);*/
                    stTotal = String.valueOf(count);
                    stTotal = stTotal.replaceAll("0", "০").replaceAll("1","১").replaceAll("2", "২").replaceAll("3", "৩").replaceAll("4", "৪").replaceAll("5", "৫").replaceAll("6", "৬").replaceAll("7", "৭").replaceAll("8", "৮").replaceAll("9", "৯");
                    displayCount.setText(stTotal);
                }
                else {
                    count --;

                    stTotal = String.valueOf(count);
                    stTotal = stTotal.replaceAll("0", "০").replaceAll("1","১").replaceAll("2", "২").replaceAll("3", "৩").replaceAll("4", "৪").replaceAll("5", "৫").replaceAll("6", "৬").replaceAll("7", "৭").replaceAll("8", "৮").replaceAll("9", "৯");
                    displayCount.setText(stTotal);
                    /*count--;
                    displayCount.setText(""+count);*/
                }

            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                stTotal = String.valueOf(count);
                stTotal = stTotal.replaceAll("0", "০").replaceAll("1","১").replaceAll("2", "২").replaceAll("3", "৩").replaceAll("4", "৪").replaceAll("5", "৫").replaceAll("6", "৬").replaceAll("7", "৭").replaceAll("8", "৮").replaceAll("9", "৯");
                displayCount.setText(stTotal);
            }
        });
        //
        convertEnglishDigitToBangla();
    }

    private void convertEnglishDigitToBangla() {
        Character banDigit[] = {'০','১','২','৩','৪','৫','৬','৭','৮','৯'};
        Character engDigit[] = {'0','1','2','3','4','5','6','7','8','9'};
        //
        String value = "";
        char[] chars = toString().toCharArray();
        for (int i =0; i < chars.length; i++){
            Character character = ' ';
            for (int j = 0; j < engDigit.length;j++){
                if (chars[i] == engDigit[j]){
                    character = banDigit[j];
                    break;
                }
                else {
                    character = chars[i];
                }
            }
            value +=character;
        }
    }
}
