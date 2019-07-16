package activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import api.RetrofitConfig;
import br.com.unifacema.appestagio.lostfound.R;
import modelo.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaBuscarActivity extends AppCompatActivity {
    public static String NOME_DO_ITEM;
    public static String VISTO_POR_ULTIMO;
    EditText nomeDoItem;
    EditText vistoPorUltimo;
    Button botaoBuscar;
    List<Item> listaResultado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_buscar);

        nomeDoItem = findViewById(R.id.editTextNomeItem);
        vistoPorUltimo = findViewById(R.id.editTextVistoPorUltimo);
        botaoBuscar = findViewById(R.id.buttonBuscar);



        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NOME_DO_ITEM = nomeDoItem.getText().toString();
                VISTO_POR_ULTIMO = vistoPorUltimo.getText().toString();

                Intent intent = new Intent(getApplicationContext(), TelaListaItensActivity.class);
                startActivity(intent);
                // TelaListaItensActivity.dados = listaResultado;

            }
        });
    }
}
