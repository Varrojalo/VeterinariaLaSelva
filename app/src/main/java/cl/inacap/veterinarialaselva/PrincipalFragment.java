package cl.inacap.veterinarialaselva;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {


    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_principal, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listaServicios = (ListView)getView().findViewById(R.id.lista_servicios);

        ArrayAdapter<CharSequence> adaptador= new ArrayAdapter<CharSequence>(getContext(),R.layout.item_mascota);
        adaptador = ArrayAdapter.createFromResource(getContext(),R.array.lista_Servicios,android.R.layout.simple_list_item_1);
        listaServicios.setAdapter(adaptador);
    }
}
