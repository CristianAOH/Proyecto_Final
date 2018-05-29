package itchihuahua.mitec.com.mitec;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Principal extends AppCompatActivity {
    Intent inLanzarInicio;
    String usuario,password;
    EditText edtxt_usuario,edtxt_pass;
    Button btn_ingresar;
    ProgressDialog progressDialog;
    String perfiles[]={"Cristian","Karla","Arturo","Edgar"};
    String CARRERA="mitec.carrera";
    int clave=0, semestre=0;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.itchTheme);
        setContentView(R.layout.activity_principal);
        getSupportActionBar().hide();
        edtxt_usuario=(EditText)findViewById(R.id.edtxt_usuario);
        edtxt_pass=(EditText)findViewById(R.id.edtxt_pass);
        btn_ingresar=(Button)findViewById(R.id.btn_ingresar);
        progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Autenticando");
        inLanzarInicio=new Intent(this,Home.class);

        preferences=this.getSharedPreferences("CARRERA",Context.MODE_PRIVATE);
    }

    public void onClick(View v){
        usuario=edtxt_usuario.getText().toString();
        password=edtxt_pass.getText().toString();
        if(usuario.equals("15551085")&&password.equals("1234")||usuario.equals("15551079")&&password.equals("1234")||usuario.equals("14550320")&&password.equals("1234")||usuario.equals("15551089")&&password.equals("1234")){
            startActivity(inLanzarInicio);
        }else{
            new ConsultarDatos().execute("http://192.168.100.60:8080/tecnologico/consulta.php?id_alumno="+edtxt_usuario.getText().toString());
            progressDialog.show();
        }
    }

    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), "CARGA REALIZADA SATISFACTORIAMENTE", Toast.LENGTH_LONG).show();

        }
    }


    private class ConsultarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "FAIL";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if(result!="FAIL"){
                JSONArray consulta = null;
                try {
                    consulta = new JSONArray(result);
                    String connomb=consulta.getString(1);
                    String conpw=consulta.getString(7);
                    if(password.equals(conpw)){
                        progressDialog.dismiss();
                        inLanzarInicio.putExtra("CNOMBRE",connomb);
                        startActivity(inLanzarInicio);
                        finish();
                    }else{
                        errorDeUsuario();
                        //Toast.makeText(Principal.this,"Usuario/Contraseña invalidos",Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }else{
                //NO HAY COMUNICACION CON EL SERVIDOR
                errorServer();

            }
        }
    }



    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);//milisegundos
            conn.setConnectTimeout(5000);//milisegundos
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }

    public void errorServer(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_mensaje).setTitle(R.string.dialog_titulo);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        progressDialog.dismiss();
    }

    public void errorDeUsuario(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_userMensaje).setTitle(R.string.dialog_userTitulo);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        progressDialog.dismiss();
    }

    public void perfil(View v){
        android.app.AlertDialog.Builder mensaseListaElementos = new android.app.AlertDialog.Builder(this);
        mensaseListaElementos.setTitle("Seleccionar Perfil");
        mensaseListaElementos.setItems(perfiles, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editor;
                editor=preferences.edit();
                switch (which){
                    case 0:
                        edtxt_usuario.setText("15551085");
                        edtxt_pass.setText("1234");
                        editor.putInt("CLAVE",0);
                        editor.putInt("SEMESTRE",7);
                        editor.putString("NOMBRE","Cristian");
                        editor.putString("SNOMBRE","Antonio");
                        editor.putString("APPATERNO","Ornelas");
                        editor.putString("APMATERNO","Hernandez");
                        editor.putString("DIRECCION","Av. Nueva Vizcaya #8428");
                        editor.putString("TELEFONO","6141863081");
                        editor.putInt("HORARIO",1);
                        editor.putString("MATERIA1","Conmutación y Enrutamiento en Redes de Datos");
                        editor.putString("MATERIA2","Taller de Sistemas Operativos");
                        editor.putString("MATERIA3","Taller de Investigación I");
                        editor.putString("MATERIA4","Programación Lógica y Funcional");
                        editor.putString("MATERIA5","Gestión de Proyectos de Software");
                        editor.putString("MATERIA6","Aplicaciones Híbridas para Dispositivos Móviles");
                        editor.putString("MATERIA7","Aplicaciones para Dispositivos Móviles II");
                        editor.commit();
                        //Toast.makeText(getApplicationContext(),"Cris",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        edtxt_usuario.setText("14550320");
                        edtxt_pass.setText("1234");
                        editor.putInt("CLAVE",0);
                        editor.putInt("SEMESTRE",1);
                        editor.putString("NOMBRE","Karla");
                        editor.putString("SNOMBRE","Vannesa");
                        editor.putString("APPATERNO","Trevizo");
                        editor.putString("APMATERNO","Torres");
                        editor.putString("DIRECCION","Calle #8428");
                        editor.putString("TELEFONO","6141593714");
                        editor.putInt("HORARIO",0);
                        editor.putString("MATERIA1","");
                        editor.putString("MATERIA2","");
                        editor.putString("MATERIA3","");
                        editor.putString("MATERIA4","");
                        editor.putString("MATERIA5","");
                        editor.putString("MATERIA6","");
                        editor.putString("MATERIA7","");
                        editor.commit();
                        //Toast.makeText(getApplicationContext(),"Karla",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        edtxt_usuario.setText("15551079");
                        edtxt_pass.setText("1234");
                        editor.putInt("CLAVE",2);
                        editor.putInt("SEMESTRE",8);
                        editor.putString("NOMBRE","Bernardo");
                        editor.putString("SNOMBRE","Arturo");
                        editor.putString("APPATERNO","Renteria");
                        editor.putString("APMATERNO","Silva");
                        editor.putString("DIRECCION","Por aqui #8428");
                        editor.putString("TELEFONO","6145840114");
                        editor.putInt("HORARIO",1);
                        editor.putString("MATERIA1","Taller de Legislacion Informatica");
                        editor.putString("MATERIA2","Taller de Emprendedores");
                        editor.putString("MATERIA3","Estrategias de Gestión de Servicios de TI");
                        editor.putString("MATERIA4","Inteligencía de Negocios");
                        editor.putString("MATERIA5","Aplicaciones e Interconectividad de Sistemas Embebidos");
                        editor.putString("MATERIA6","Sistemas Operativos para Sistemas Embebidos");
                        editor.putString("MATERIA7","Aplicaciones para Dispositivos Móviles II");
                        editor.commit();
                        //Toast.makeText(getApplicationContext(),"Arturo",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        edtxt_usuario.setText("15551089");
                        edtxt_pass.setText("1234");
                        editor.putInt("CLAVE",1);
                        editor.putInt("SEMESTRE",5);
                        editor.putString("NOMBRE","Edgar");
                        editor.putString("SNOMBRE","Ivan");
                        editor.putString("APPATERNO","Villalobos");
                        editor.putString("APMATERNO","Reza");
                        editor.putString("DIRECCION","Ocampo #8428");
                        editor.putString("TELEFONO","6148523365");
                        editor.putInt("HORARIO",1);
                        editor.putString("MATERIA1","Ingenieria de Procesos");
                        editor.putString("MATERIA2","Estadística Inferencial II");
                        editor.putString("MATERIA3","Finanzas en las Organizaciones");
                        editor.putString("MATERIA4","Gestión del Capital Humano");
                        editor.putString("MATERIA5","Taller de Investigación I");
                        editor.putString("MATERIA6","Desarrollo Sustentable");
                        editor.putString("MATERIA7","");
                        editor.commit();
                        //Toast.makeText(getApplicationContext(),"Edgar",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mensaseListaElementos.show();
    }
}
