package cl.inacap.veterinarialaselva;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.sql.Date;
import java.util.ArrayList;

import cl.inacap.veterinarialaselva.controller.MascotaAdapter;
import cl.inacap.veterinarialaselva.model.dao.MascotaDAO;
import cl.inacap.veterinarialaselva.model.dto.Mascota;
import cl.inacap.veterinarialaselva.model.dto.Usuario;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsuarioFragment extends Fragment {
    Usuario usuario;
    ListView listViewMascotas;
    ArrayList<Mascota> listaMascotas;
    MascotaDAO mDao = new MascotaDAO();

    public UsuarioFragment() {
        // Required empty public constructor
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_usuario, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listViewMascotas = getView().findViewById(R.id.lista_animales);
        listaMascotas = new ArrayList();

        listaMascotas = mDao.obtenerMascotasUsuario(this.usuario);//TODO: IMPLEMENTAR ESTE METODO EN MascotaDAO.java

        Mascota[] data = new Mascota[listaMascotas.size()];
        data = listaMascotas.toArray(data);
        MascotaAdapter adapter = new MascotaAdapter(this.getContext(),R.layout.item_animal, data);

        listViewMascotas.setAdapter(adapter);
    }
}
