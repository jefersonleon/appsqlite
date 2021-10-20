package br.ulbra.sistemaautentica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {
    EditText edLogin, edPass;
    Button btLogin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBHelper(this);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        edLogin = findViewById(R.id.edtLogin);
        edPass = findViewById(R.id.edtSenha);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edLogin.getText().toString();
                String password = edPass.getText().toString();
                if (username.equals("")) {
                    Toast.makeText(Activity_Login.this, "Insira o Login", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(Activity_Login.this, "Insira a senha", Toast.LENGTH_SHORT).show();
                } else {
                    String res = db.validarLogin(username, password);
                    if (res.equals("OK")) {
                        Toast.makeText(Activity_Login.this, "Login OK", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Activity_Login.this, "Login ou Senha inválida", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}