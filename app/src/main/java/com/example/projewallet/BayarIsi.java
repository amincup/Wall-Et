package com.example.projewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projewallet.databinding.ActivityBayarIsiBinding;

public class BayarIsi extends AppCompatActivity {

    private ActivityBayarIsiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBayarIsiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intentRecieved = getIntent();
        Boolean apakahMenyimpan = intentRecieved.getBooleanExtra("KEY_SAVE_SPEND", false);

        binding.btnSaveNominal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentHome = new Intent(BayarIsi.this, MainActivity.class);
                startActivity(intentHome);

                if(binding.etNominal.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "TOLONG ISI NOMINAL", Toast.LENGTH_LONG).show();
                }
                else{

                    if(apakahMenyimpan == true){
                        String nominalStr = binding.etNominal.getText().toString(); //conv str to int
                        int nominal = Integer.parseInt(nominalStr);

                        simpanUang(nominal);
                    }
                    else{
                        gunakanUang(Integer.parseInt(binding.etNominal.getText().toString()));
                    }

                }

            }
        });

    }

    void simpanUang(int nominal){
        SharedPreferences database = getSharedPreferences("db_uang", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDatabase = database.edit();

        int nominalTersimpan = database.getInt("SALDO", 0);
        nominalTersimpan = nominalTersimpan + nominal;

        editorDatabase.putInt("SALDO", nominalTersimpan);

        editorDatabase.apply();
    }

    void gunakanUang(int nominal){
        SharedPreferences database = getSharedPreferences("db_uang", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDatabase = database.edit();

        int nominalTersimpan = database.getInt("SALDO", 0);
        nominalTersimpan = nominalTersimpan - nominal;

        editorDatabase.putInt("SALDO", nominalTersimpan);

        editorDatabase.apply();
    }

}