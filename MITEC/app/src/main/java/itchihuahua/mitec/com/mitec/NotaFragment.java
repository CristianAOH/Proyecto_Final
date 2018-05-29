package itchihuahua.mitec.com.mitec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class NotaFragment extends Fragment {
    Intent inRegresar;
    Button btn_guardar;
    EditText edtxt_titulo,edtxt_nota;
    String ARCHIVO_NOTA="mitec.notas";
    String ID_TITULO="mitec.notas.n1";
    String ID_CUERPO="mitec.notas.c1";
    int ID_CODIGO=1,proc=0;
    String ID_VALOR="mitec.notas.v1";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_nota, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences(ARCHIVO_NOTA, MODE_PRIVATE);
        int valorPrin = prefs.getInt("ID_NUMERO",0);
        if (valorPrin==0){
            ID_CODIGO=1;
        }else{
            ID_CODIGO=valorPrin+1;
        }

        edtxt_titulo=(EditText)view.findViewById(R.id.edtxt_titulo);
        edtxt_nota=(EditText)view.findViewById(R.id.edtxt_nota);
        btn_guardar=(Button)view.findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getContext().getSharedPreferences(ARCHIVO_NOTA, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(ID_TITULO+ID_CODIGO,edtxt_titulo.getText().toString());
                editor.putString(ID_CUERPO+ID_CODIGO,edtxt_nota.getText().toString());
                editor.putString(ID_VALOR+ID_CODIGO,String.valueOf(ID_CODIGO));
                editor.putInt("ID_NUMERO",ID_CODIGO);
                editor.commit();
                /*ID_CODIGO++;
                String concate=String.valueOf(ID_CODIGO);
                ARCHIVO_NOTA=ARCHIVO_NOTA+concate;
                Toast.makeText(getContext(),"NUMERO"+ID_TITULO,Toast.LENGTH_SHORT).show(); */
                getActivity().finish();
                inRegresar=new Intent(getContext(),Notas.class);
                startActivity(inRegresar);
            }
        });

        return view;
    }
}
