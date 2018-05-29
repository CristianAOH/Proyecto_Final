package itchihuahua.mitec.com.mitec;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Notas extends AppCompatActivity {
    FragmentManager fm=getSupportFragmentManager();
    FloatingActionButton fabtn_agregar;
    ListView lstV_notas;
    String ARCHIVO_NOTA="mitec.notas";
    String ID_TITULO="mitec.notas.n1";
    String ID_CUERPO="mitec.notas.c1";
    String ID_VALOR="mitec.notas.v1";
    int ID_CODIGO=0;
    private ArrayList<String> ponerNota;
    private ArrayAdapter<String> adaptador1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setTheme(R.style.itchTheme);
        setContentView(R.layout.activity_notas);

        //CREA LOS ARREGLOS DE LISTA Y ADAPTADOR PARA COLOCAR LAS NOTAS
        ponerNota=new ArrayList<String>();
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ponerNota);

        //BUSCA EN LOS ARCHIVOS DE LA APLICACION CUANTAS NOTAS HAY GUARDADAS Y LAS COMIENZA A COLOCAR EN LA LISTA
        SharedPreferences prefs = this.getSharedPreferences(ARCHIVO_NOTA, MODE_PRIVATE);
        ID_CODIGO= prefs.getInt("ID_NUMERO",1);
        //Toast.makeText(this,String.valueOf(ID_CODIGO),Toast.LENGTH_SHORT).show();
        for (int i=1; i<=ID_CODIGO; i++){
            SharedPreferences prefes = getSharedPreferences(ARCHIVO_NOTA,MODE_PRIVATE);
            String titulo = prefes.getString(ID_TITULO+i, "");
            String cuerpo = prefes.getString(ID_CUERPO+i, "");
            String valor = prefes.getString(ID_VALOR+i, "");
            if (titulo.equals("")){

            }else{
                ponerNota.add(titulo+"\n"+cuerpo);
                adaptador1.notifyDataSetChanged();
            }

        }



        //VINCULACION DE COMPONENETE FLOTANTE Y LISTA
        fabtn_agregar=(FloatingActionButton)findViewById(R.id.fabtn_agregar);
        lstV_notas=(ListView)findViewById(R.id.lstV_notas);

        lstV_notas.setAdapter(adaptador1);
        //ACCION AL PRESIONAR EL BOTON DE AGREGAR
        fabtn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.contenido_notas,new NotaFragment()).commit();
                fabtn_agregar.setVisibility(View.GONE);
                lstV_notas.setVisibility(View.GONE);
            }
        });

        //ACCION PARA BORRAR LA NOTA AL DEJAR PRESIONADO SOBRE ELLA
        lstV_notas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int posicion=position;
                final int posDel=position+1;

                AlertDialog.Builder dialogo=new AlertDialog.Builder(Notas.this);
                dialogo.setTitle("Confirmación");
                dialogo.setMessage("¿Eleminar elemento seleccionado?");
                dialogo.setCancelable(false);
                dialogo.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefs = getSharedPreferences(ARCHIVO_NOTA, MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString(ID_TITULO+posDel,"");
                        editor.putString(ID_CUERPO+posDel,"");
                        editor.commit();
                        ponerNota.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialogo.show();
                return false;
            }
        });
    }

}
