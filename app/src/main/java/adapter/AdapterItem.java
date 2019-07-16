package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.unifacema.appestagio.lostfound.ItemActivity;
import br.com.unifacema.appestagio.lostfound.R;
import modelo.Item;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.MyViewHolder> {
   private Context context;
   private List<Item> itemList;
   private Drawable drawable= null;

    public AdapterItem(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view =   LayoutInflater.from(context).inflate(R.layout.adapter_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {

        if (itemList.get(i).getNome().equals("Capacete")){
            drawable = context.getResources().getDrawable(R.drawable.capacete);
            myViewHolder.imageView.setImageDrawable(drawable);
        } else if (itemList.get(i).getNome().equals("Garrafa")) {
            drawable = context.getResources().getDrawable(R.drawable.garrafa_amarela);
            myViewHolder.imageView.setImageDrawable(drawable);
        }else if(itemList.get(i).getNome().equals("Garrafa Azul")){
            drawable = context.getResources().getDrawable(R.drawable.garrafa_azul);
            myViewHolder.imageView.setImageDrawable(drawable);
        }else if(itemList.get(i).getNome().equals("Iphone")){
            drawable = context.getResources().getDrawable(R.drawable.iphone_7);
            myViewHolder.imageView.setImageDrawable(drawable);
        }else if(itemList.get(i).getNome().equals("Caderno")){
            drawable = context.getResources().getDrawable(R.drawable.caderno_batman);
            myViewHolder.imageView.setImageDrawable(drawable);
        }else if (itemList.get(i).getNome().equals("Livro")){
            drawable = context.getResources().getDrawable(R.drawable.livro);
            myViewHolder.imageView.setImageDrawable(drawable);
        }



        myViewHolder.nome.setText(itemList.get(i).getNome());
        myViewHolder.descricao.setText(itemList.get(i).getDescricao());
        myViewHolder.vistoUltimo.setText(itemList.get(i).getVistoPorUltimo());
        if(itemList.get(i).isStatus()){
            myViewHolder.status.setText("Item devolvido");
        }else{
            myViewHolder.status.setText("Item não devolvido");
        }


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "posicao "+myViewHolder.getAdapterPosition(),Toast.LENGTH_SHORT).show();

                //Toast.makeText(context,cod,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra("codigo",itemList.get(i).getCodigo());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView descricao;
        TextView vistoUltimo;
        TextView status;
        ImageView  imageView;

        public MyViewHolder( View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewList);
            nome = itemView.findViewById(R.id.textNome);
            descricao = itemView.findViewById(R.id.textDescricao);
            vistoUltimo = itemView.findViewById(R.id.textVistoUltimo);
            status = itemView.findViewById(R.id.textStatus);
        }
    }


}
