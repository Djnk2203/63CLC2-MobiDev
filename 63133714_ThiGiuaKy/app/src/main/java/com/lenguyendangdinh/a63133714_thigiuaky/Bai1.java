package com.lenguyendangdinh.a63133714_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class Bai1 extends AppCompatActivity {
    EditText chieucao, cannang;
    Button BMI,ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
    }
    BMI.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View ) {
            calculateBMI();
        }
    });


    private void calculateBMI() {
        String cannang = cannang.getText().toString();
        String chieucao = chieucao.getText().toString();

        if (!cannang.isEmpty() && !cannang.isEmpty()) {
            float cannang = Float.parseFloat(cannang);
            float chieucao = Float.parseFloat(chieucao);

            float BMI = cannang / (chieucao * chieucao);

            result.setText("Your BMI: " + String.format("%.2f", BMI));
        } else {
            result.setText("Vui lòng nhập lại chiều cao và cân nặng ");
        }
    }
}