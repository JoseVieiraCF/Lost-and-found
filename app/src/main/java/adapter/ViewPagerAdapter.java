package adapter;



import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList  = new ArrayList<>();
    private final List<String> titulosList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titulosList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titulosList.get(position);
    }

    public void adicionaFragmento(Fragment fragment, String titulo){
        fragmentList.add(fragment);
        titulosList.add(titulo);
    }
}
