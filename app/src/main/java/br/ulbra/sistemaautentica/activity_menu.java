package br.ulbra.sistemaautentica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class activity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
    }
}