package itchihuahua.mitec.com.mitec;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CalifListAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] itemasig;
    int[] itemcalif;

    public CalifListAdapter(Activity context, String[] itemasig, int[] itemcalif) {
        super(context, R.layout.calif_modelo, itemasig);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemasig=itemasig;
        this.itemcalif=itemcalif;
    }

    public View getView(int posicion, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.calif_modelo, null, true);
        TextView txtV_a1=(TextView)rowView.findViewById(R.id.txtV_a1);
        TextView txtV_a2=(TextView)rowView.findViewById(R.id.txtV_a2);
        TextView txtV_asignatura = (TextView) rowView.findViewById(R.id.txtV_materia);
        TextView txtV_calif = (TextView) rowView.findViewById(R.id.txtV_calif);
        txtV_a1.setText("Asignatura");
        txtV_a2.setText("Calificación");
        txtV_asignatura.setText(itemasig[posicion]);
        txtV_calif.setText(String.valueOf(itemcalif[posicion]));
        return rowView;
    }
}
