package cl.inacap.veterinarialaselva.controller;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.model.dto.Animal;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Animal> listaAnimales;

    public AdapterDatos(ArrayList<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_catalogo,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        holder.etiNombre.setText(listaAnimales.get(position).getNombre());
        holder.etiEdad.setText((CharSequence) listaAnimales.get(position).getNacimiento());
        //holder.foto.setImageResource(listaAnimales.get(position).getFoto());
        //holder.foto.setText(listaAnimales.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaAnimales.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView etiNombre, etiEdad;
        ImageView foto2;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            etiNombre = (TextView) itemView.findViewById(R.id.nombreAnimal);
            etiEdad = (TextView) itemView.findViewById(R.id.edadAnimal);
            foto2 = (ImageView)itemView.findViewById(R.id.fotoAnimal);
        }
    }
}
