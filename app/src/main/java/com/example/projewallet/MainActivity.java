package com.example.projewallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.projewallet.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btIsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSaveSpend = new Intent(MainActivity.this, BayarIsi.class);
                Boolean apakahMenyimpan = true;
                intentSaveSpend.putExtra("KEY_SAVE_SPEND", apakahMenyimpan);

                startActivity(intentSaveSpend);
            }
        });

        binding.btBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSaveSpend = new Intent(MainActivity.this, BayarIsi.class);
                Boolean apakahMenyimpan = false;
                intentSaveSpend.putExtra("KEY_SAVE_SPEND", apakahMenyimpan);

                startActivity(intentSaveSpend);
            }
        });

        binding.btPulsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKodeBayar = new Intent(MainActivity.this, KodeBayar.class);

                startActivity(intentKodeBayar);
            }
        });

        binding.btListrik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKodeBayar = new Intent(MainActivity.this, KodeBayar.class);

                startActivity(intentKodeBayar);
            }
        });

        binding.btVa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKodeBayar = new Intent(MainActivity.this, KodeBayar.class);

                startActivity(intentKodeBayar);
            }
        });

        binding.btSedekah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSaveSpend = new Intent(MainActivity.this, BayarIsi.class);
                Boolean apakahMenyimpan = false;
                intentSaveSpend.putExtra("KEY_SAVE_SPEND", apakahMenyimpan);

                startActivity(intentSaveSpend);
            }
        });

        binding.btProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(MainActivity.this, Profile.class);
                Boolean simpanNama = true;
                intentProfile.putExtra("NAMA", simpanNama);
                startActivity(intentProfile);
            }
        });

        ambilDataSaldo();
        ambilNama();

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ambilDataSaldo();
                binding.swipeRefresh.setRefreshing(false);
            }
        });

    }

    void ambilDataSaldo(){
        SharedPreferences database = getSharedPreferences("db_uang", Context.MODE_PRIVATE);

        int saldo = database.getInt("SALDO", 0);

        binding.tvNominal.setText("Rp " + saldo);
    }

    void ambilNama(){
        SharedPreferences database = getSharedPreferences("db_nama", Context.MODE_PRIVATE);

        String nama = database.getString("NAMA", "");

        binding.tvNama.setText("Halo! " + nama + ".");
    }
}