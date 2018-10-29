package cl.inacap.veterinarialaselva;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;

import cl.inacap.veterinarialaselva.controller.AnimalAdapter;
import cl.inacap.veterinarialaselva.model.dto.Animal;
import cl.inacap.veterinarialaselva.view.VistaAnimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogoFragment extends Fragment {
    ListView listViewAnimales;
    ArrayList<Animal> listaAnimales;

    public CatalogoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        listViewAnimales = container.findViewById(R.id.lista_animales);
        listaAnimales = new ArrayList();
        listaAnimales.add(new Animal(1,"Misha",R.drawable.ic_user_black_24dp,"Gato","Desconocido",new Date(2018-1900,4-1,20),true));
        listaAnimales.add(new Animal(2,"Jacinta",R.drawable.ic_user_black_24dp,"Perro","Maltes",new Date(2007-1900,5-1,1),true));
        listaAnimales.add(new Animal(3,"Frank",R.mipmap.frank,"Perro","Pug",new Date(1920-1900,1-1,20),false));

        Animal[] data = new Animal[listaAnimales.size()];
        data = listaAnimales.toArray(data);
        AnimalAdapter adapter = new AnimalAdapter(this.getActivity().getApplicationContext(),R.layout.item_animal, data);

        listViewAnimales.setAdapter(adapter);

        listViewAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView)view.findViewById(R.id.idAnimal);
                Toast.makeText(getActivity().getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
                int idAnimal = Integer.parseInt(v.getText().toString());
                Intent intent = new Intent(getActivity().getBaseContext(), VistaAnimal.class);
                intent.putExtra("ANIMAL_ID", idAnimal);
                intent.putExtra("LISTA_ANIMALES", listaAnimales);
                startActivity(intent);
            }
        });

        return inflater.inflate(R.layout.fragment_catalogo, container, false);
    }

}
