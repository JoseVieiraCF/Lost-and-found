package activity;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import adapter.ViewPagerAdapter;
import br.com.unifacema.appestagio.lostfound.R;
import br.com.unifacema.appestagio.lostfound.R.layout;
import fragmentos.FragmentDelvolvidos;
import fragmentos.FragmentNaoDevolvidos;
import fragmentos.FragmentTodos;

public class TelaListaItensActivity extends AppCompatActivity {
    private MaterialSearchView searchView;

    //Codigo alternativo
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Object FragmentTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_itens);

        //Ainda do código altenativo
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adicionando fragmentos aqui
        adapter.adicionaFragmento(new FragmentTodos(), "Todos");
        adapter.adicionaFragmento(new FragmentDelvolvidos(), "Devolvidos");
        adapter.adicionaFragmento(new FragmentNaoDevolvidos(), "Não Devolvidos");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);

        //Configura metodos para SearchView
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                for(int i = 0; i < 100; i++){
                    System.out.println("DEUUUUUU CEEEEEERTO CARAAAAAAAAAAAAAAAI");
                }
                FragmentTodos fragmentTodos = new FragmentTodos();
                Bundle bundle = new Bundle();
                bundle.putString("query", query);
                fragmentTodos.setArguments(bundle);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                System.out.println("DEUUUUUU CEEEEEERTO CARAAAAAAAAAAAAAAAI");
            }

            @Override
            public void onSearchViewClosed() {

            }
        });

        Toolbar toolbar = findViewById(R.id.barra_pesquisar);
        toolbar.setTitle("Pesquisar");
        setSupportActionBar( toolbar );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.menu_search);
        searchView.setMenuItem( item );

        return true;
    }
}
