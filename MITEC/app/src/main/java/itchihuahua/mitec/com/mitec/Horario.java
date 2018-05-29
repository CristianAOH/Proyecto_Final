package itchihuahua.mitec.com.mitec;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Horario extends AppCompatActivity {
    String mat1,mat2,mat3,mat4,mat5,mat6,mat7;
    TextView m1l,m1m,m1mm,m1j,m1v;
    TextView m2l,m2m,m2mm,m2j,m2v;
    TextView m3l,m3m,m3mm,m3j,m3v;
    TextView m4l,m4m,m4mm,m4j,m4v;
    TextView m5l,m5m,m5mm,m5j,m5v;
    TextView m6l,m6m,m6mm,m6j,m6v;
    TextView m7l,m7m,m7mm,m7j,m7v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setTheme(R.style.itchTheme);
        setContentView(R.layout.activity_horario);

        m1l=(TextView)findViewById(R.id.txtV_m1l);
        m1m=(TextView)findViewById(R.id.txtV_m1m);
        m1mm=(TextView)findViewById(R.id.txtV_m1mm);
        m1j=(TextView)findViewById(R.id.txtV_m1j);
        m1v=(TextView)findViewById(R.id.txtV_m1v);

        m2l=(TextView)findViewById(R.id.txtV_m2l);
        m2m=(TextView)findViewById(R.id.txtV_m2m);
        m2mm=(TextView)findViewById(R.id.txtV_m2mm);
        m2j=(TextView)findViewById(R.id.txtV_m2j);
        m2v=(TextView)findViewById(R.id.txtV_m2v);

        m3l=(TextView)findViewById(R.id.txtV_m3l);
        m3m=(TextView)findViewById(R.id.txtV_m3m);
        m3mm=(TextView)findViewById(R.id.txtV_m3mm);
        m3j=(TextView)findViewById(R.id.txtV_m3j);
        m3v=(TextView)findViewById(R.id.txtV_m3v);

        m4l=(TextView)findViewById(R.id.txtV_m4l);
        m4m=(TextView)findViewById(R.id.txtV_m4m);
        m4mm=(TextView)findViewById(R.id.txtV_m4mm);
        m4j=(TextView)findViewById(R.id.txtV_m4j);
        m4v=(TextView)findViewById(R.id.txtV_m4v);

        m5l=(TextView)findViewById(R.id.txtV_m5l);
        m5m=(TextView)findViewById(R.id.txtV_m5m);
        m5mm=(TextView)findViewById(R.id.txtV_m5mm);
        m5j=(TextView)findViewById(R.id.txtV_m5j);
        m5v=(TextView)findViewById(R.id.txtV_m5v);

        m6l=(TextView)findViewById(R.id.txtV_m6l);
        m6m=(TextView)findViewById(R.id.txtV_m6m);
        m6mm=(TextView)findViewById(R.id.txtV_m6mm);
        m6j=(TextView)findViewById(R.id.txtV_m6j);
        m6v=(TextView)findViewById(R.id.txtV_m6v);

        m7l=(TextView)findViewById(R.id.txtV_m7l);
        m7m=(TextView)findViewById(R.id.txtV_m7m);
        m7mm=(TextView)findViewById(R.id.txtV_m7mm);
        m7j=(TextView)findViewById(R.id.txtV_m7j);
        m7v=(TextView)findViewById(R.id.txtV_m7v);

        SharedPreferences preferencias= getSharedPreferences("CARRERA", Context.MODE_PRIVATE);
        int horario=preferencias.getInt("HORARIO",0);

        if (horario==1){
            mat1=preferencias.getString("MATERIA1","");
            mat2=preferencias.getString("MATERIA2","");
            mat3=preferencias.getString("MATERIA3","");
            mat4=preferencias.getString("MATERIA4","");
            mat5=preferencias.getString("MATERIA5","");
            mat6=preferencias.getString("MATERIA6","");
            mat7=preferencias.getString("MATERIA7","");
            ponerMaterias();
        }else{
            android.app.AlertDialog.Builder alertSinHorario = new android.app.AlertDialog.Builder(this);
            alertSinHorario.setTitle("ERROR");
            alertSinHorario.setMessage("Aún no cuenta con materias seleccionadas");
            alertSinHorario.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertSinHorario.show();
        }
    }

    public void ponerMaterias(){
        m1l.setText(mat1);
        m1m.setText(mat1);
        m1mm.setText(mat1);
        m1j.setText(mat1);
        m1v.setText(mat1);

        m2l.setText(mat2);
        m2m.setText(mat2);
        m2mm.setText(mat2);
        m2j.setText(mat2);
        m2v.setText(mat2);

        m3l.setText(mat3);
        m3m.setText(mat3);
        m3mm.setText(mat3);
        m3j.setText(mat3);
        m3v.setText(mat3);

        m4l.setText(mat4);
        m4m.setText(mat4);
        m4mm.setText(mat4);
        m4j.setText(mat4);
        m4v.setText(mat4);

        m5l.setText(mat5);
        m5m.setText(mat5);
        m5mm.setText(mat5);
        m5j.setText(mat5);
        m5v.setText(mat5);

        m6l.setText(mat6);
        m6m.setText(mat6);
        m6mm.setText(mat6);
        m6j.setText(mat6);
        m6v.setText(mat6);

        m7l.setText(mat7);
        m7m.setText(mat7);
        m7mm.setText(mat7);
        m7j.setText(mat7);
        m7v.setText(mat7);
    }
}
