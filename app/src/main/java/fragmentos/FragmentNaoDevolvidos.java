package fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class FragmentNaoDevolvidos extends Fragment {
    View view;
    private RecyclerView myRecyclerView;
    private List<Item> itemList = new ArrayList<>();

    public FragmentNaoDevolvidos() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.nao_devolvidos_fragment, container, false);

        Call<List<Item>> listCall = new RetrofitConfig().getHttpService().buscarItemNaoDelvolvido(TelaBuscarActivity.NOME_DO_ITEM,"false");
        listCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(response.isSuccessful()){
                    itemList = response.body();
                    myRecyclerView = view.findViewById(R.id.nao_devolvidos_recyclerview);
                    AdapterItem adapterItem = new AdapterItem(getContext(), itemList);
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    myRecyclerView.setAdapter(adapterItem);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });


        return view;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
