package com.example.projewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projewallet.databinding.ActivityProfileBinding;

public class Profile extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intentRecieve = getIntent();
        Boolean simpanNama = intentRecieve.getBooleanExtra("NAMA", false);

        binding.btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentHome = new Intent(Profile.this, MainActivity.class);
                startActivity(intentHome);

                nama(binding.inputNama.getText().toString());

            }
        });

        binding.btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(Profile.this, MainActivity.class);
                startActivity(intentHome);
            }
        });

    }

    void nama(String namaKita) {
        SharedPreferences database = getSharedPreferences("db_nama", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDatabaseNama = database.edit();

        String namaProfile = database.getString("NAMA", "Masukkan Nama");
        namaProfile = namaKita;

        editorDatabaseNama.putString("NAMA", namaProfile);
        editorDatabaseNama.apply();
    }

}