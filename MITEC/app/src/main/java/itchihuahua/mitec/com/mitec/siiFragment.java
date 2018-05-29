package itchihuahua.mitec.com.mitec;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;


public class siiFragment extends Fragment {
    ConstraintLayout clay;
    ImageView imgV_datoFoto;
    EditText edtxt_datoNombre, edtxt_datoApellido, edtxt_datoDireccion, edtxt_datoTelefono,
            edtxt_datoCarrera, edtxt_datoSemestre;
    String CARRERA="mitec.carrera";
    int clave=0, semestre=0;
    String nom,snom,appat,apmat,direccion,tel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_sii2, container, false);

        imgV_datoFoto=(ImageView)view.findViewById(R.id.imgV_datoFoto);
        edtxt_datoNombre=(EditText)view.findViewById(R.id.edtxt_datoNombre);
        edtxt_datoApellido=(EditText)view.findViewById(R.id.edtxt_datoApellido);
        edtxt_datoDireccion=(EditText)view.findViewById(R.id.edtxt_datoDireccion);
        edtxt_datoTelefono=(EditText)view.findViewById(R.id.edtxt_datoTelefono);
        edtxt_datoCarrera=(EditText)view.findViewById(R.id.edtxt_datoCarrera);
        edtxt_datoSemestre=(EditText)view.findViewById(R.id.edtxt_datoSemestre);

        SharedPreferences preferencias= getContext().getSharedPreferences("CARRERA",Context.MODE_PRIVATE);
        clave=preferencias.getInt("CLAVE",0);
        semestre=preferencias.getInt("SEMESTRE",0);
        nom=preferencias.getString("NOMBRE","");
        snom=preferencias.getString("SNOMBRE","");
        appat=preferencias.getString("APPATERNO","");
        apmat=preferencias.getString("APMATERNO","");
        direccion=preferencias.getString("DIRECCION","");
        tel=preferencias.getString("TELEFONO","");

        edtxt_datoNombre.setText(nom+" "+snom);
        edtxt_datoApellido.setText(appat+" "+apmat);
        edtxt_datoDireccion.setText(direccion);
        edtxt_datoTelefono.setText(tel);
        if (clave==0){
            edtxt_datoCarrera.setText("Ingenieria en Sistemas Computacionales");
        }else if (clave==1){
            edtxt_datoCarrera.setText("Gestion Empresarial");
        }else{
            edtxt_datoCarrera.setText("Ingenieria Informatica");
        }
        edtxt_datoSemestre.setText(String.valueOf(semestre));




        return view;
    }

}
