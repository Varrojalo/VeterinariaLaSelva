package cl.inacap.veterinarialaselva.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.model.dto.Mascota;

public class MascotaAdapter extends ArrayAdapter<Mascota> {
    private Context context;
    private int layoutResourceId;
    private Mascota[] data = null;

    public MascotaAdapter(Context context, int layoutResourceId,Mascota[] data)
    {
        super(context,layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        MascotaHolder holder = null;

        if(row == null)
        {
            holder = new MascotaHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId,parent,false);


            holder.foto = (ImageView)row.findViewById(R.id.fotoMascota);
            holder.fechaAdopcion = (TextView)row.findViewById(R.id.fechaAdopcionMascota);
            holder.nombre = (TextView)row.findViewById(R.id.nombreMascota);
            holder.id = (TextView)row.findViewById(R.id.idMascota);
            row.setTag(holder);
        }
        else{
            holder = (MascotaHolder) row.getTag();
        }

        Mascota mascota = data[position];
        holder.fechaAdopcion.setText(mascota.getFechaAdopcion().toString());
        holder.nombre.setText(mascota.getAnimal().getNombre());
        holder.foto.setImageResource(mascota.getAnimal().getFoto());
        holder.id.setText(String.valueOf(mascota.getAnimal().getId()));
        return row;
    }



    static class MascotaHolder
    {
        ImageView foto;
        TextView nombre;
        TextView fechaAdopcion;
        TextView id;
    }
}
