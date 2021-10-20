package br.ulbra.sistemaautentica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarUsuario extends AppCompatActivity {
   private EditText edNome, edUser, edPass1, edPass2;
   private Button btSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        inicializarComponentes();
        DBHelper db = new DBHelper(this);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edUser.getText().toString();
                String pas1 = edPass1.getText().toString();
                String pas2 = edPass2.getText().toString();
                if(userName.equals("")){
                    Toast.makeText(CadastrarUsuario.this,"Insira o login",Toast.LENGTH_SHORT).show();
                }else if(pas1.equals("")){
                    Toast.makeText(CadastrarUsuario.this,"Insira a senha",Toast.LENGTH_SHORT).show();
                }else if(pas2.equals("")){
                    Toast.makeText(CadastrarUsuario.this,"Insira o repetir senha",Toast.LENGTH_SHORT).show();
                }else if(!pas1.equals(pas2)){
                    Toast.makeText(CadastrarUsuario.this,"A senha não são iguais",Toast.LENGTH_SHORT).show();
                }else{
                    long res = db.criarUtilizador(userName,pas1);
                    if(res>0){
                        Toast.makeText(CadastrarUsuario.this,"Login efetuado com sucesso",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(CadastrarUsuario.this,"Login ou senha Inválidos",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void inicializarComponentes() {
        edNome = findViewById(R.id.edtNome);
        edUser = findViewById(R.id.edtEmail);
        edPass1 = findViewById(R.id.edtSenha);
        edPass2 = findViewById(R.id.edtSenhaR);
        btSalvar = findViewById(R.id.btnCad);


    }
}