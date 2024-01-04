package com.lenguyendangdinh.foodapp_63133714.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.lenguyendangdinh.foodapp_63133714.Adapter.CartAdapter;
import com.lenguyendangdinh.foodapp_63133714.Helper.ChangeNumberItemsListener;
import com.lenguyendangdinh.foodapp_63133714.Helper.ManagmentCart;
import com.lenguyendangdinh.foodapp_63133714.R;
import com.lenguyendangdinh.foodapp_63133714.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity {
private ActivityCartBinding binding;
private RecyclerView.Adapter   adapter;
private ManagmentCart managmentCart;
private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart =new ManagmentCart(this);

        setVariable();
        calculateCart();
        initlist();
    }

    private void initlist() {
        if (managmentCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        }else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.cartView.setLayoutManager(linearLayoutManager);
        adapter=new CartAdapter(managmentCart.getListCart(), this, () -> calculateCart());
        binding.cartView.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentTax=0.02; //percent 2% tax
        double delivery=10; //10 Dollar

        tax=Math.round(managmentCart.getTotalFee()*percentTax*100.0)/100;

        double total=Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managmentCart.getTotalFee()*100)/100;

        binding.totalFeeTxt.setText("$"+itemTotal);
        binding.taxTxt.setText("$"+tax);
        binding.deliveryTxt.setText("$"+delivery);
        binding.totalTxt.setText("$"+total);
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}