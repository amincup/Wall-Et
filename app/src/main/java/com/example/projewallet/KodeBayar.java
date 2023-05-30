package com.example.projewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projewallet.databinding.ActivityKodeBayarBinding;

public class KodeBayar extends AppCompatActivity {

    private ActivityKodeBayarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKodeBayarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSaveKode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSaveSpend = new Intent(KodeBayar.this, BayarIsi.class);
                startActivity(intentSaveSpend);
            }
        });
    }
}