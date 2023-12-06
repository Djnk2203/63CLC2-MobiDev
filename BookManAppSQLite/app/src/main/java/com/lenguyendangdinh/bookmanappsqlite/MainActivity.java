package com.lenguyendangdinh.bookmanappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DataDemo();
        //Tao co so du lieu
        SQLiteDatabase dbSach;
        dbSach= openOrCreateDatabase("QuanLySach.db",MODE_PRIVATE,null);

        // Tao bang BOOKS
            //*chu y xoa bang neu ton tai
        dbSach.execSQL("DROP TABLE IF EXISTS BOOKS;");
        String sqlTaoBangBook="CREATE TABLE BOOKS(BookID integer PRIMARY KEY,"+
                                                            " BookName text," +
                                                            "Page integer,"+
                                                            "Price Float,"+
                                                            "Description text)";
        dbSach.execSQL(sqlTaoBangBook);
        //Chen 1 ban ghi
        String sqlThem ="INSERT INTO BOOKS VALUES(1," +
                "'Lập trình Java'," +
                "100, " +
                "9.99, " +
                "'Lập trình Java của NXB ABC'"+
                ")";
        dbSach.execSQL(sqlThem);

        String sqlThem1 ="INSERT INTO BOOKS VALUES(2," +
                "'Lập trình Android'," +
                "108, " +
                "12.09, " +
                "'Giao trinh Android toan tap'"+
                ")";
        dbSach.execSQL(sqlThem1);

        String sqlThem2 ="INSERT INTO BOOKS VALUES(3," +
                "'Mau Thiet ke'," +
                "78, " +
                "8.5, " +
                "'Tai lieu hoc Mau thiet ke phan mem'"+
                ")";
        dbSach.execSQL(sqlThem2);

        dbSach.close();
    }// het Oncreate
    public void sangManHinhDuyet(View v){
        Intent intent = new Intent(getBaseContext(),ActivityBook.class);
        startActivity(intent);
    }
    public void sangManHinhThem(View v){

    }

}