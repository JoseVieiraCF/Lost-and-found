package fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import activity.TelaBuscarActivity;
import adapter.AdapterItem;
import api.RetrofitConfig;
import br.com.unifacema.appestagio.lostfound.R;
import modelo.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTodos extends Fragment {
    View view;
    private RecyclerView myRecyclerView;
    private List<Item> itemList = new ArrayList<>();

    public FragmentTodos() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.todos_fragment, container, false);
        myRecyclerView = view.findViewById(R.id.todos_recyclerview);

        if (TelaBuscarActivity.VISTO_POR_ULTIMO.trim().isEmpty() ){
            System.out.println("isso"+TelaBuscarActivity.VISTO_POR_ULTIMO+"i");
            Call<List<Item>> listCall = new RetrofitConfig().getHttpService().buscarTodoItem(TelaBuscarActivity.NOME_DO_ITEM);
            listCall.enqueue(new Callback<List<Item>>() {
                @Override
                public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                    if(response.isSuccessful()){
                        itemList = response.body();

                        AdapterItem adapterItem = new AdapterItem(getContext(), itemList);
                        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        myRecyclerView.setAdapter(adapterItem);
                    }
                }

                @Override
                public void onFailure(Call<List<Item>> call, Throwable t) {
                    System.out.println(t.getMessage());
                    System.out.println(t.getMessage());
                    System.out.println(t.getMessage());
                }
            });
        }else if(TelaBuscarActivity.VISTO_POR_ULTIMO != "" && TelaBuscarActivity.NOME_DO_ITEM != ""){
            Call<List<Item>> listCall = new RetrofitConfig().getHttpService().buscarVistoPorUltimo(TelaBuscarActivity.NOME_DO_ITEM,TelaBuscarActivity.VISTO_POR_ULTIMO);
            listCall.enqueue(new Callback<List<Item>>() {
                @Override
                public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                    if(response.isSuccessful()){
                        itemList = response.body();

                        AdapterItem adapterItem = new AdapterItem(getContext(), itemList);
                        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        myRecyclerView.setAdapter(adapterItem);
                    }
                }

                @Override
                public void onFailure(Call<List<Item>> call, Throwable t) {
                    System.out.println(t.getMessage());
                    System.out.println(t.getMessage());
                    System.out.println(t.getMessage());
                }
            });
        }else{
            Toast.makeText(getContext(),"Nenhum item foi encontrado",Toast.LENGTH_SHORT).show();
        }


        return view;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}
