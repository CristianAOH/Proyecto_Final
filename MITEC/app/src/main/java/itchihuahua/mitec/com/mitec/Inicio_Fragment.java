package itchihuahua.mitec.com.mitec;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Inicio_Fragment extends Fragment {
    Button btn_nota,btn_sii,btn_edificio,btn_horario,btn_mensaje;
    Intent inLanzarNota,inLanzarSii,inLanzarEdificio,inLanzarHorario,inLanzarMensajeNuevo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_inicio_, container, false);
        btn_nota=(Button)view.findViewById(R.id.btn_nota);
        inLanzarNota=new Intent(getContext(),Notas.class);
        btn_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inLanzarNota);
            }
        });

        btn_sii=(Button)view.findViewById(R.id.btn_sii);
        inLanzarSii=new Intent(getContext(),Sii.class);
        btn_sii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inLanzarSii);
            }
        });

        btn_edificio=(Button)view.findViewById(R.id.btn_edificios);
        inLanzarEdificio=new Intent(getContext(),Edificios.class);
        btn_edificio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inLanzarEdificio);
            }
        });

        btn_horario=(Button)view.findViewById(R.id.btn_horario);
        inLanzarHorario=new Intent(getContext(),Horario.class);
        btn_horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inLanzarHorario);
            }
        });

        btn_mensaje=(Button)view.findViewById(R.id.btn_mensaje);
        inLanzarMensajeNuevo=new Intent(getContext(),Mensaje.class);
        btn_mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inLanzarMensajeNuevo);
            }
        });
        return view;
    }
}
