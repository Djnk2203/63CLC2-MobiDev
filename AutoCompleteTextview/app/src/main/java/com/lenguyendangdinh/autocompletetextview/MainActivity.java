package com.lenguyendangdinh.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsQuocGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b0
        findControls();
        //b1 chuan bi nguon du lieu, cat vao bien
        dsQuocGia = new ArrayList<String>();
        dsQuocGia.add("VietNam");
        dsQuocGia.add("England");
        dsQuocGia.add("America");
        //b2 Tao adapter
        ArrayAdapter<String> adapterQG;
        adapterQG = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,//bo cuc
                dsQuocGia// nguon du lieu
        );
        //b3 gan adapter

        autoQUOCGIA.setadapter(adapterQG);


    }
    public void findControls(){
        autoQUOCGIA = findViewById(R.id.autocompleteQUOCGIA);
    }
}