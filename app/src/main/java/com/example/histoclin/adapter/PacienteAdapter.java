package com.example.histoclin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.histoclin.R;
import com.example.histoclin.entity.Paciente;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PacienteAdapter extends BaseAdapter {

    private final LayoutInflater inflater;

    private final List<Paciente> pacientes;

    public PacienteAdapter(Context context, List<Paciente> pacientes) {
        this.inflater = LayoutInflater.from(context);
        this.pacientes = pacientes;
    }


    @Override
    public int getCount() {
        return pacientes.size();
    }

    @Override
    public Paciente getItem(int position) {
        return pacientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pacientes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView != null){
            holder= (ViewHolder) convertView.getTag();
        }else{
            convertView=inflater.inflate(R.layout.item_paciente,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        }
        holder.documentoPaciente.setText(pacientes.get(position).getDocumento());
        holder.nombrePaciente.setText(pacientes.get(position).getNombre());
        holder.apellidoPaciente.setText(pacientes.get(position).getApellido());
        holder.fechaNacimiento.setText(pacientes.get(position).getFechaNacimiento().toString());
        holder.edad.setText(String.valueOf(pacientes.get(position).getEdad()));

        return convertView;
    }

    class  ViewHolder{
        @BindView(R.id.documento_item_paciente)
        TextView documentoPaciente;

        @BindView(R.id.nombre_paciente_item)
        TextView nombrePaciente;

        @BindView(R.id.apellido_paciente_item)
        TextView apellidoPaciente;

        @BindView(R.id.fecha_nacimiento_item)
        TextView fechaNacimiento;

        @BindView(R.id.edad_item_paciente)
        TextView edad;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

    }
}
