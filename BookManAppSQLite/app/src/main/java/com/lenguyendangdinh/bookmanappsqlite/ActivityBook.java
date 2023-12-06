package com.lenguyendangdinh.bookmanappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }
    public class BookNavi extends AppCompatActivity {
        SQLiteDatabase dbSACH;
        Cursor controBanGhi;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_book);
            // Mở CSDL
            dbSACH = openOrCreateDatabase("Sach.db", MODE_PRIVATE, null);
            // ĐỌc toàn bộ bảng book
            controBanGhi = dbSACH.rawQuery("Select * from BOOKS", null);
            // Chuyển con trỏ về bản ghi đầu tiên
            controBanGhi.moveToFirst();
            //Hiện bản ghi đầu tiên này lên màn hình
            // Lấy dữ liệu ở dòng hiện tại đang dc trỏ bởi controBanGhi
            int maSach = controBanGhi.getInt(0);
            String tenSach = controBanGhi.getString(1);
            int soTrang = controBanGhi.getInt(2);
            float gia = controBanGhi.getFloat(3);
            String mota = controBanGhi.getString(4);
            // đặt vào các điều khiển

        }
    }
}