package itchihuahua.mitec.com.mitec;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Perfil extends AppCompatActivity {
    final static int REQUEST_IMAGEN=12;
    ImageButton imbtn_foto;
    Intent inDatos;
    EditText edtxt_nombre;
    Uri imageUri;
    private static final String NOMBRE_PREFERENCES="mitec.nombre";
    String CARRERA="mitec.carrera";
    private static final String CAMBIO_NOMBRE_PREFERENCE="mitec.usuario.nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setTheme(R.style.itchTheme);
        setContentView(R.layout.activity_perfil);
        SharedPreferences prefs= getSharedPreferences("CARRERA", Context.MODE_PRIVATE);
        String updateNom = prefs.getString("NOMBRE","");
        String updateSNom = prefs.getString("SNOMBRE","");
        edtxt_nombre=(EditText)findViewById(R.id.edtxt_nombre);
        imbtn_foto=(ImageButton)findViewById(R.id.imbtn_foto);
        edtxt_nombre.setHint(updateNom+" "+updateSNom);
        inDatos=getIntent();
        //REGISTRAR CONTROLES PARA MENÚ CONTEXTUAL
        registerForContextMenu(imbtn_foto);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //IDENTIFICAR EL COMPONENTE
        int id=v.getId();
        MenuInflater menuInflater=getMenuInflater();
        switch (id){
            case R.id.imbtn_foto:
                menuInflater.inflate(R.menu.menu_foto,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       // AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.action_cargar:
                Toast.makeText(this,"Cargue imagen de la galeria",Toast.LENGTH_SHORT).show();
                seleccionarImagen();
                break;
            case R.id.action_eliminar:
                Toast.makeText(this,"Eliminar imagen del perfil",Toast.LENGTH_SHORT).show();
                eliminarImagen();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void Mandar(View view){
        SharedPreferences preferences=this.getSharedPreferences("CARRERA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        if(!edtxt_nombre.getText().toString().isEmpty()){
            Bitmap image= imbtn_foto.getDrawingCache();
            String nomb=edtxt_nombre.getText().toString();
            editor=preferences.edit();
            editor.putString("APODO",nomb);
            editor.commit();
            setResult(Activity.RESULT_OK,inDatos);
            finish();
        }else{
            Bitmap image= imbtn_foto.getDrawingCache();
            String nomb=edtxt_nombre.getHint().toString();
            editor=preferences.edit();
            editor.putString("APODO",nomb);
            editor.commit();
            setResult(Activity.RESULT_OK,inDatos);
            finish();
        }

    }

    public void seleccionarImagen(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_IMAGEN);
    }

    public void eliminarImagen(){
        imbtn_foto.setImageResource(R.drawable.ic_menu_gallery);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGEN) {
            imageUri = data.getData();
            imbtn_foto.setImageURI(imageUri);
        }
    }
}
