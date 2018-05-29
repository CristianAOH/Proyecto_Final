package itchihuahua.mitec.com.mitec;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Mensaje extends AppCompatActivity {
    Spinner sp_contacto;
    String profesores[]={" Gilberto Perez","Alberto Medrano","Cesar Burciaga","Monica Flores","Ramon Lopez","Valeria Gallardo","Enrique Salazar","Karla Villa","Lucia Jaime","Leonardo Moreno"
    ,"Walter Torres","Sol Becerra","Flor Perez","Alejandra Quintana","Armando Mondragon","Ilse Chacon","Ana Vega","Luis Rodriguez","Jaqueline Roacho"
    ,"Joaquin Estrada","Gilberto Marin","Horacio Nava"};
    String numero[]={"6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081"
            ,"6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081","6141863081"};
    Intent inMandarSms;
    EditText edtxt_cuerpo;
    String num,mensa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setTheme(R.style.itchTheme);
        setContentView(R.layout.activity_mensaje);

        sp_contacto=(Spinner) findViewById(R.id.sp_contacto);
        edtxt_cuerpo=(EditText)findViewById(R.id.edtxt_cuerpo);

        checkSMSStatePermission();


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, profesores);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_contacto.setAdapter(dataAdapter);

        sp_contacto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                num=String.valueOf(numero[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void send(View v){
        mensa=edtxt_cuerpo.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num, null, mensa, null, null);
        Toast.makeText(this,"Enviado",Toast.LENGTH_SHORT).show();
        edtxt_cuerpo.setText("");
    }

    private void checkSMSStatePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para enviar SMS.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para enviar SMS!");
        }
    }
}
