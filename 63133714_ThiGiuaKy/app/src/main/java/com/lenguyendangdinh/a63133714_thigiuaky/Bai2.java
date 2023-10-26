package com.lenguyendangdinh.a63133714_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Bai2<baiHat_Adapter> extends AppCompatActivity {
    ArrayList<String> dsBaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        findControls();
        dsBaiHat = new ArrayList<String>();
        dsBaiHat.add("Chú đại bi remix");
        dsBaiHat.add("Đời anh xe ôm");
        dsBaiHat.add("Hayahaya");
        dsBaiHat.add("Đại ca lớp 12 A");
        dsBaiHat.add("Giấc mộng ca sĩ");
        ArrayAdapter<String> adapterBH;
        adapterBH = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dsBaiHat
        );

        listViewBaiHat.setAdapter(adapterBH);
    }
    public void findControls() {
        listViewBaiHat = findViewById(R.id.List);
    }
    ListView listViewBaiHat;
}