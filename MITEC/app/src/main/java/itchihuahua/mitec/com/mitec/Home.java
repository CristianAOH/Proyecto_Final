package itchihuahua.mitec.com.mitec;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm=getSupportFragmentManager();
    Intent inEmail,inPerfil,inInicio;
    TextView txtV_nombre,tx_nombre;
    ImageView imV_perfil;
    private static final String NOMBRE_PREFERENCES="mitec.nombre";
    private static final String CAMBIO_NOMBRE_PREFERENCE="mitec.usuario.nombre";
    final static int REQUEST_PERFIL=1;
    String CARRERA="mitec.carrera";
    int clave=0, semestre=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setTheme(R.style.itchTheme);
        setContentView(R.layout.activity_home);

        fm.beginTransaction().replace(R.id.contenido,new Inicio_Fragment()).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView = navigationView.getHeaderView(0);
        txtV_nombre=(TextView)hView.findViewById(R.id.txtV_ml_nombre);
        SharedPreferences preferencias= getSharedPreferences("CARRERA", Context.MODE_PRIVATE);
        String nmbre=preferencias.getString("NOMBRE","");
        String apellido=preferencias.getString("APPATERNO","");
        txtV_nombre.setText(nmbre+" "+apellido);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_PERFIL){
            if(resultCode==Activity.RESULT_OK){
                /*txtV_nombre=(TextView)findViewById(R.id.txtV_ml_nombre);
                imV_perfil=(ImageView)findViewById(R.id.imgV_perfil);
                Bundle bundle=data.getExtras();
                String nomb=bundle.getString("NOMBRE");
                Bitmap img=(Bitmap)bundle.getParcelable("IMAGEN");
                imV_perfil.setImageBitmap(img);*/

                SharedPreferences prefs = getSharedPreferences("CARRERA", MODE_PRIVATE);
                String updateNom = prefs.getString("APODO","");
                txtV_nombre.setText(updateNom);
            }else {
                //Toast.makeText(this,"El usuario retrocedio",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            fm.beginTransaction().replace(R.id.contenido,new Inicio_Fragment()).commit();
        } else if (id == R.id.nav_perfil) {
            inPerfil=new Intent(this,Perfil.class);
            startActivityForResult(inPerfil,REQUEST_PERFIL);
        } else if (id == R.id.nav_sesion) {
            inInicio=new Intent(this,Principal.class);
            startActivity(inInicio);
            finish();
        }
        if (id == R.id.nav_correo) {
            inEmail= new Intent(Intent.ACTION_SEND);
            inEmail.setType("text/plain");
            inEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"soporte@mitec.com"});
            inEmail.putExtra(Intent.EXTRA_SUBJECT, "Informe de errores");
            try {
                startActivity(Intent.createChooser(inEmail, "Con cual app desea enviar?"));
            } catch (android.content.ActivityNotFoundException ex) {
                //do something else
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ponerN(){
        SharedPreferences prefs = getSharedPreferences(NOMBRE_PREFERENCES, MODE_PRIVATE);
        String updateNom = prefs.getString(CAMBIO_NOMBRE_PREFERENCE,"Manten presionado");
        tx_nombre=(TextView)findViewById(R.id.txtV_ml_nombre);
        tx_nombre.setText(updateNom);
    }


}
