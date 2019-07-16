package br.com.unifacema.appestagio.lostfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import api.RetrofitConfig;
import modelo.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView nomeItem;
    private TextView descItem;
    private TextView vistoPorUltimo;
    private Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        nomeItem = findViewById(R.id.textNomeItem);
        descItem = findViewById(R.id.textDescricaoItem);
        vistoPorUltimo = findViewById(R.id.textVistoPorUltimo);
        imageView = findViewById(R.id.imageItem);


        if(getIntent().hasExtra("codigo")){
            final Call<Item> itemCall = new RetrofitConfig().getHttpService().buscarPorId(getIntent().getLongExtra("codigo",1));
            itemCall.enqueue(new Callback<Item>() {
                @Override
                public void onResponse(Call<Item> call, Response<Item> response) {
                    if (response.isSuccessful()){
                        Drawable drawable = null;
                        item = response.body();
                        if (item.getNome().equals("Capacete")){
                            //drawable= getResources().getDrawable(R.drawable.capacete);
                            Picasso.get().load(R.drawable.capacete).into(imageView);
                        } else if (item.getNome().equals("Garrafa")) {
                            Picasso.get().load(R.drawable.garrafa_amarela).into(imageView);
                        }else if(item.getNome().equals("Garrafa Azul")){
                            Picasso.get().load(R.drawable.garrafa_azul).into(imageView);
                        }else if(item.getNome().equals("Iphone")){
                            Picasso.get().load(R.drawable.iphone_7).into(imageView);
                        }else if(item.getNome().equals("Caderno")){
                            Picasso.get().load(R.drawable.caderno_batman).into(imageView);
                        }else if (item.getNome().equals("Livro")){
                            Picasso.get().load(R.drawable.livro).into(imageView);
                        }
                        //imageView.setImageDrawable(drawable);

                        nomeItem.setText(item.getNome());
                        descItem.setText(item.getDescricao());
                        vistoPorUltimo.setText("Encontrado "+item.getVistoPorUltimo());
                    }
                }

                @Override
                public void onFailure(Call<Item> call, Throwable t) {

                }
            });
        }
    }


}
