package itchihuahua.mitec.com.mitec;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Edificios extends AppCompatActivity {
    Button btn_g, btn_d, btn_f, btn_b;
    boolean ocult_papas=false, ocult_sodas=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setTheme(R.style.itchTheme);
        setContentView(R.layout.activity_edificios);

        btn_g=(Button)findViewById(R.id.btn_g);
        btn_d=(Button)findViewById(R.id.btn_d);
        btn_f=(Button)findViewById(R.id.btn_f);
        btn_b=(Button)findViewById(R.id.btn_b);
    }

    public void admin(View v){
        Toast.makeText(this,"Administrativo",Toast.LENGTH_SHORT).show();
    }

    public void maestros(View v){
        Toast.makeText(this,"Sala de maestros/ Ingles",Toast.LENGTH_SHORT).show();
    }

    public void edi_g(View v){
        Toast.makeText(this,"Edificio de Industrial",Toast.LENGTH_SHORT).show();
    }

    public void edi_p(View v){
        Toast.makeText(this,"Area de Sistemas",Toast.LENGTH_SHORT).show();
    }

    public void edi_d(View v){
        Toast.makeText(this,"Edificio de Informatica",Toast.LENGTH_SHORT).show();
    }

    public void biblio(View v){
        Toast.makeText(this,"Biblioteca",Toast.LENGTH_SHORT).show();
    }

    public void edi_f(View v){
        Toast.makeText(this,"Edificio de Sistemas",Toast.LENGTH_SHORT).show();
    }

    public void edi_b(View v){
        Toast.makeText(this,"Edificio de Diseño Industrial",Toast.LENGTH_SHORT).show();
    }

    public void edi_h(View v){
        Toast.makeText(this,"Edificio de Gestión Empresarial",Toast.LENGTH_SHORT).show();
    }

    public void metodos(View v){
        Toast.makeText(this,"Edificio de Métodos",Toast.LENGTH_SHORT).show();
    }

    public void centro(View v){
        Toast.makeText(this,"Centro de Computo",Toast.LENGTH_SHORT).show();
    }

    public void cafe(View v){
        Toast.makeText(this,"Cafeteria",Toast.LENGTH_SHORT).show();
    }

    public void papas(View v){
        clear();
        ocult_sodas=false;
        if (ocult_papas==false){
            ocult_papas=true;
        } else if (ocult_papas==true){
            ocult_papas=false;
        }

        if (ocult_papas){
            btn_d.setText("°");
            btn_f.setText("°");
            btn_g.setText("°");
            btn_b.setText("°");
        }else{
            clear();
        }

    }

    public void sodas(View v){
        clear();
        ocult_papas=false;
        if (ocult_sodas==false){
            ocult_sodas=true;
        } else if (ocult_sodas==true){
            ocult_sodas=false;
        }

        if (ocult_sodas){
            btn_f.setText("°");
            btn_g.setText("°");
        }else{
            clear();
        }
    }

    public void clear(){
        btn_d.setText("");
        btn_f.setText("");
        btn_g.setText("");
        btn_b.setText("");
    }
}
