package br.ulbra.sistemaautentica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_registrar extends AppCompatActivity {
    EditText edNome, edUser, edPas1, edPas2;
    Button btSalvar;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        db = new DBHelper(this);

        edNome = (EditText)findViewById(R.id.edNome);
        edUser = (EditText)findViewById(R.id.edUser);
        edPas1 = (EditText)findViewById(R.id.edPass1);
        edPas2 = (EditText)findViewById(R.id.edPass2);


        btSalvar = (Button)findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUser.getText().toString();
                String pas1 = edPas1.getText().toString();
                String pas2 = edPas2.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(activity_registrar.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (pas1.equals("") || pas2.equals("")){
                    Toast.makeText(activity_registrar.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }else if(!pas1.equals(pas2)){
                    Toast.makeText(activity_registrar.this, "As senhas não correspondem ao login do usuário", Toast.LENGTH_SHORT).show();
                }else{
                    long res = db.criarUtilizador(userName,pas1);
                    if(res>0){
//nesta parte você poderá chamar a tela principal do sistema autenticado
                        Toast.makeText(activity_registrar.this, "Resgistro OK", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(activity_registrar.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}