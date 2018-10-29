package cl.inacap.veterinarialaselva.controller;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.model.dto.Animal;

public class AnimalAdapter extends ArrayAdapter<Animal>{
    private Context context;
    private int layoutResourceId;
    private Animal[] data = null;

    public AnimalAdapter(Context context, int layoutResourceId,Animal[] data)
    {
        super(context,layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        AnimalHolder holder = null;

        if(row == null)
        {
            holder = new AnimalHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId,parent,false);


            holder.foto = (ImageView)row.findViewById(R.id.fotoAnimal);
            holder.edad = (TextView)row.findViewById(R.id.edadAnimal);
            holder.nombre = (TextView)row.findViewById(R.id.nombreAnimal);
            holder.id = (TextView)row.findViewById(R.id.idAnimal);
            row.setTag(holder);
        }
        else{
            holder = (AnimalHolder)row.getTag();
        }

        Animal animal = data[position];
        holder.edad.setText(animal.getRaza());
        holder.nombre.setText(animal.getNombre());
        holder.foto.setImageResource(animal.getFoto());
        holder.id.setText(String.valueOf(animal.getId()));
        return row;
    }



    static class AnimalHolder
    {
        ImageView foto;
        TextView nombre;
        TextView edad;
        TextView id;
    }
}
