package com.lenguyendangdinh.foodapp_63133714.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.lenguyendangdinh.foodapp_63133714.Domain.Foods;
import com.lenguyendangdinh.foodapp_63133714.Helper.ManagmentCart;
import com.lenguyendangdinh.foodapp_63133714.R;
import com.lenguyendangdinh.foodapp_63133714.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
ActivityDetailBinding binding;
private Foods object;
private int num=1;
private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        }

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart=new ManagmentCart(this);

        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText("$"+object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar()+"Rating");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText(num*object.getPrice()+"$");

        binding.plusBtn.setOnClickListener(v -> {
            num=num+1;
            binding.numTxt.setText(num+"");
            binding.totalTxt.setText("$"+(num*object.getPrice()));
        });

        binding.minusBtn.setOnClickListener(v -> {
            if (num>1){
                num=num-1;
                binding.numTxt.setText(num+"");
                binding.totalTxt.setText("$"+(num*object.getPrice()));
            }
        });

        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertFood(object);
        });
    }

    private void getIntentExtra() {
        object= (Foods) getIntent().getSerializableExtra("object");
    }
}