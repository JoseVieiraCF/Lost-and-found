package activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.unifacema.appestagio.lostfound.R;
import modelo.Usuario;

public class LoginActivity extends AppCompatActivity {
    EditText campoUsuario;
    EditText campoSenha;
    Button entrar;
    Usuario usuario;
    private TextWatcher loginTextWacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        campoUsuario = findViewById(R.id.editTextUsuario);
        campoSenha = findViewById(R.id.editTextSenha);
        entrar = findViewById(R.id.buttonLogar);

        this.verificaCampos();
        campoUsuario.addTextChangedListener(loginTextWacher);
        campoSenha.addTextChangedListener(loginTextWacher);

        usuario = new Usuario("Unifacema", "12345");

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario();
            }
        });
    }
    private void verificaCampos() {
        loginTextWacher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usuarioTextoInput = campoUsuario.getText().toString().trim();
                String senhaTextoInput = campoSenha.getText().toString().trim();

                entrar.setEnabled(!usuarioTextoInput.isEmpty() && !senhaTextoInput.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }
    private void validarUsuario(){
        if(campoUsuario.getText().toString().equalsIgnoreCase(usuario.getUsuario()) && campoSenha.getText().toString().equalsIgnoreCase(usuario.getSenha())){

            Intent intent = new Intent(getApplicationContext(), TelaBuscarActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
