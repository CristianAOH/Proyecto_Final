package itchihuahua.mitec.com.mitec;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class CalificacionesFragment extends Fragment {
    Spinner sp_calif;
    ListView lstV_boleta;
    String CARRERA="mitec.carrera";
    int clave=0, semestre=0;
    Context context=getContext();

    String iscUno[]={"Fundamentos de Programación","Cálculo Diferencial","Matemáticas Discretas","Fundamentos de Investigación","Taller de Ética","Taller de Investigación"};
    String iscDos[]={"Programación Orientada a Objetos","Cálculo Integral","Química","Algebra Lineal","Probabilidad y Estadística","Contabilidad Financiera"};
    String iscTres[]={"Estructura de Datos","Cálculo Vectorial","Desarrollo Sustentable","Física General","Investigación de Operaciones","Cultura Empresarial"};
    String iscCuatro[]={"Tópicos Avanzados de Programación","Ecuaciones Diferenciales","Métodos Numéricos","Principios Eléctricos y Aplicacioes Digitales","Simulación","Fundamentos de Base de Datos"};
    String iscCinco[]={"Fundamentos de Telecomunicaciones","Lenguajes y Automatas I","Sistemas Operativos","Arquitectura de Computadoras","Fundamentos de Ing en Software","Taller de Base de Datos","Programación Web"};
    String iscSeis[]={"Redes de Computadoras","Lenguajes y Autómatas II","Sistemas Programables","Lenguajes de Interfaz","Ing de Software","Administración de Base de Datos","Aplicaciones para Dispositivos Móviles I"};
    String iscSiete[]={"Conmutación y Enrutamiento en Redes de Datos","Taller de Sistemas Operativos","Taller de Investigación I","Programación Lógica y Funcional","Gestión de Proyectos de Software","Aplicaciones Híbridas para Dispositivos Móviles","Aplicaciones para Dispositivos Móviles II"};
    String iscOcho[]={"Administración de Redes","Graficación","Taller de Investigación II","Inteligencia Artificial","Aplicaciones para Dispositivos Móviles III","Temas Selectos"};
    String iscNueve[]={"Servicio Social","Actividades Complementarias"};
    String iscDiez[]={"Residencia Profesional"};

    String gempUno[]={"Fundamentos de Investigación","Cálculo Diferencial","Desarrollo Humano","Fundamentos de Gestión Empresarial","Fundamentos de Física","Fundamentos de Química"};
    String gempDos[]={"Software de Aplicación Ejecutivo","Cálculo Integral","Contabilidad Orientada a los Negocios","Dinámica Social","Taller de Ética","Legislación Laboral"};
    String gempTres[]={"Marco Legal de las Organizaciones","Probabilidad y Estadística Descriptiva","Costos Empresariales","Habilidades Directivas I","Economía Empresarial","Algebra Lineal"};
    String gempCuatro[]={"Ingenieria Económica","Estadistica Inferencial I","Instrumentos de Presupuestacion Empresarial","Habilidades Directivas II","Entorno Macroeconomico","Ivestigacion de Operaciones"};
    String gempCinco[]={"Ingenieria de Procesos","Estadistica Inferencial II","Finanzas en las Organizaciones","Gestion del Capital Humano","Taller de Investigacion I","Desarrollo Sustentable"};
    String gempSeis[]={"Administracion de la Salud y Seguridad Operacional","Entorno de la Innovacion","Gestion de la Produccion I","Diseño Organizacional","Taller de Investigacion II","Mercadotecnia"};
    String gempSiete[]={"Propiedad intelectual","El Emprendedor y la Innovacion","Gestion de la Produccion II","Gestion Estrategica","Analisis Estrategico de la Tecnologia","Gestion Financiera para Proyectos de Innovacion","Sistemas de Informacion de Mercadotecnia"};
    String gempOcho[]={"Transferencia y Comercializacion de Tecnologia","Plan de Negocios","Cadena de Suministros","Cadena de Suministros","Calidad Aplicada a la Gestion Empresarial","Habilidades Blandas en la Gestion de la Tecnologia","Mercadotecnia Electronica"};
    String gempNueve[]={"Servicio Social","Actividades Complementarias"};
    String gempDiez[]={"Residencia Profesional"};

    String infUno[]={"Fundamentos de Programacion","Fundamentos de Investigacion","Administracion para Informatica","Taller de Ética","Cálculo Diferencial","Matematicas Discretas"};
    String infDos[]={"Programación Orientada a Objetos","Administracion de los Recursos y Funcion Informatica","Contabilidad Financiera","Desarrollo Sustentable","Calculo Integral","Fisica para Informatica"};
    String infTres[]={"Estructura de Datos","Fundamentos de Sistemas de Informacion","Costos Empresariales","Probabilidad y Estadistica","Algebra Lineal","Sistemas Electricos para Informatica"};
    String infCuatro[]={"Administracion y Organizacion de Datos","Taller de Investigacion I","Sistemas Operativos I","Investigacion de Operaciones","Fundamentos de Telecomunicaciones","Arquitectura de Computadoras"};
    String infCinco[]={"Desarrollo de Aplicaciones Web","Analisis y Modelado de Sistemas de Informacion","Sistemas Operativos II","Fundamentos de Base de Datos","Redes de Computadoras","Tecnologia e Interfaces de Computadoras","Seguridad Informatica"};
    String infSeis[]={"Programacion en Ambiente Cliente-Servidor","Desarrollo e Implementacion de Sistemas de Informacion","Auditoria en Informatica","Taller de Base de Datos","Interconectividad en redes","Taller de Investigacion II","Programacion para Sistemas Embebidos"};
    String infSiete[]={"Desarrollo dde Aplicaciones para Dispositivos Moviles","Calidad de los Sistemas de Informacion","Fundamentos de Gestion de Servicios de TI","Topicos de Base de Datos","Administracion de Servidores","Sistemas de Desarrollo","Instrumentacion"};
    String infOcho[]={"Taller de Legislacion Informatica","Taller de Emprendedores","Estrategias de Gestion de Servicios de TI","Inteligencia de Negocios","Aplicaciones e Interconectividad de Sistemas Embebidos","Sistemas Operativos para Sistemas Embebidos"};
    String infNueve[]={"Servicio Social","Actividades Complementarias"};
    String infDiez[]={"Residencia Profesional"};

    int califi[]={10,9,5,8,2,5};
    int califi2[]={8,7,9,10,10,9,8};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calificaciones, container, false);

        sp_calif=(Spinner)view.findViewById(R.id.sp_calif);
        lstV_boleta=(ListView)view.findViewById(R.id.lstV_boleta);

        SharedPreferences preferencias= getContext().getSharedPreferences("CARRERA",Context.MODE_PRIVATE);
        clave=preferencias.getInt("CLAVE",0);
        semestre=preferencias.getInt("SEMESTRE",0);

        List<String> entrada = new ArrayList<String>();
        entrada.add("1ro");
        entrada.add("2do");
        entrada.add("3ro");
        entrada.add("4to");
        entrada.add("5to");
        entrada.add("6to");
        entrada.add("7mo");
        entrada.add("8vo");
        entrada.add("9no");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, entrada);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_calif.setAdapter(dataAdapter);

        sp_calif.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position+1>=semestre){
                    Toast.makeText(getContext(),"SEMESTRE SIN CALIFICACIONES",Toast.LENGTH_SHORT).show();
                    lstV_boleta.setVisibility(View.INVISIBLE);
                }else {
                    lstV_boleta.setVisibility(View.VISIBLE);
                    switch (position) {
                        case 0:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscUno,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempUno,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infUno,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 1:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscDos,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempDos,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infDos,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 2:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscTres,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempTres,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infTres,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 3:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscCuatro,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempCuatro,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infCuatro,califi);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 4:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscCinco,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempCinco,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infCinco,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 5:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscSeis,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempSeis,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infSeis,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 6:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscSiete,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempSiete,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infSiete,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 7:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscOcho,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempOcho,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infOcho,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                        case 8:
                            if (clave==0){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),iscNueve,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else if (clave==1){
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),gempNueve,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }else{
                                CalifListAdapter adaptador=new CalifListAdapter(getActivity(),infNueve,califi2);
                                lstV_boleta.setAdapter(adaptador);
                            }

                            break;
                    }
                }//AQUI TERMINA ELSE
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        return view;
    }

}
