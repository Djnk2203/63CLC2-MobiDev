package com.lenguyendangdinh.a63133714_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Button goToCau1 = findViewById(R.id.Bai1);
    Button goToCau2 = findViewById(R.id.Bai2);
    Button goToCau4 = findViewById(R.id.Bai4);

        goToCau1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,Bai1.class);
            startActivity(intent);
        }
    });
        goToCau2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Bai2.class);
            startActivity(intent);
        }
    });
        goToCau4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Bai4.class);
            startActivity(intent);
        }
    });

}
}