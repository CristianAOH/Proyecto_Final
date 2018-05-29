package itchihuahua.mitec.com.mitec;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class HorarioFragment extends Fragment {
    String CARRERA="mitec.carrera";
    int clave=0, semestre=0, horario=0;
    Spinner sp_selec1,sp_selec2,sp_selec3,sp_selec4,sp_selec5,sp_selec6,sp_selec7;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horario, container, false);

        sp_selec1=(Spinner)view.findViewById(R.id.sp_selec1);
        sp_selec2=(Spinner)view.findViewById(R.id.sp_selec2);
        sp_selec3=(Spinner)view.findViewById(R.id.sp_selec3);
        sp_selec4=(Spinner)view.findViewById(R.id.sp_selec4);
        sp_selec5=(Spinner)view.findViewById(R.id.sp_selec5);
        sp_selec6=(Spinner)view.findViewById(R.id.sp_selec6);
        sp_selec7=(Spinner)view.findViewById(R.id.sp_selec7);

        SharedPreferences preferencias= getContext().getSharedPreferences("CARRERA",Context.MODE_PRIVATE);
        clave=preferencias.getInt("CLAVE",1);
        semestre=preferencias.getInt("SEMESTRE",1);
        horario=preferencias.getInt("HORARIO",0);

        if (horario==0){

        }else{
            sp_selec1.setEnabled(false);
            sp_selec2.setEnabled(false);
            sp_selec3.setEnabled(false);
            sp_selec4.setEnabled(false);
            sp_selec5.setEnabled(false);
            sp_selec6.setEnabled(false);
            sp_selec7.setEnabled(false);
        }



        String[] datos1;
        String[] datos2;
        String[] datos3;
        String[] datos4;
        String[] datos5;
        String[] datos6;
        String[] datos7;
        ArrayAdapter<String> adapter;
        ArrayAdapter<String> adapter2;
        ArrayAdapter<String> adapter3;
        ArrayAdapter<String> adapter4;
        ArrayAdapter<String> adapter5;
        ArrayAdapter<String> adapter6;
        ArrayAdapter<String> adapter7;
        if (clave==0){
            switch (semestre){
                case 1:
                    datos1 = new String[] {iscUno[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscUno[1],iscDos[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscUno[2],iscDos[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscUno[3],iscDos[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscUno[4],iscDos[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscUno[5],iscDos[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;


                case 2:
                    datos1 = new String[] {iscDos[0],iscTres[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscDos[1],iscTres[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscDos[2],iscTres[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscDos[3],iscTres[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscDos[4],iscTres[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscDos[5],iscTres[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;


                case 3:
                    datos1 = new String[] {iscTres[0],iscCuatro[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscTres[1],iscCuatro[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscTres[2],iscCuatro[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscTres[3],iscCuatro[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscTres[4],iscCuatro[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscTres[5],iscCuatro[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 4:
                    datos1 = new String[] {iscCuatro[0],iscCinco[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscCuatro[1],iscCinco[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscCuatro[2],iscCinco[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscCuatro[3],iscCinco[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscCuatro[4],iscCinco[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscCuatro[5],iscCinco[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 5:
                    datos1 = new String[] {iscCinco[0],iscSeis[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscCinco[1],iscSeis[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscCinco[2],iscSeis[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscCinco[3],iscSeis[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscCinco[4],iscSeis[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscCinco[5],iscSeis[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 6:
                    datos1 = new String[] {iscSeis[0],iscSiete[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscSeis[1],iscSiete[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscSeis[2],iscSiete[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscSeis[3],iscSiete[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscSeis[4],iscSiete[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscSeis[5],iscSiete[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 7:
                    datos1 = new String[] {iscCuatro[0],iscCinco[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscCuatro[1],iscCinco[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscCuatro[2],iscCinco[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscCuatro[3],iscCinco[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscCuatro[4],iscCinco[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscCuatro[5],iscCinco[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 8:
                    /*datos1 = new String[] {iscCuatro[0],iscCinco[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscCuatro[1],iscCinco[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscCuatro[2],iscCinco[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscCuatro[3],iscCinco[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscCuatro[4],iscCinco[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscCuatro[5],iscCinco[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {iscCuatro[6],iscCinco[6]};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);*/
                    break;
            }

        }else if (clave==1){

            switch (semestre){
                case 1:
                    datos1 = new String[] {gempUno[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {gempUno[1],gempDos[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {gempUno[2],gempDos[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {gempUno[3],gempDos[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {gempUno[4],gempDos[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {gempUno[5],gempDos[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;


                case 2:
                    datos1 = new String[] {gempDos[0],gempTres[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {gempDos[1],gempTres[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {gempDos[2],gempTres[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {gempDos[3],gempTres[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {gempDos[4],gempTres[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {gempDos[5],gempTres[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;


                case 3:
                    datos1 = new String[] {gempTres[0],gempCuatro[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {gempTres[1],gempCuatro[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {gempTres[2],gempCuatro[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {gempTres[3],gempCuatro[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {gempTres[4],gempCuatro[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {gempTres[5],gempCuatro[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 4:
                    datos1 = new String[] {gempCuatro[0],gempCinco[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {gempCuatro[1],gempCinco[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {gempCuatro[2],gempCinco[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {gempCuatro[3],gempCinco[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {gempCuatro[4],gempCinco[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {gempCuatro[5],gempCinco[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 5:
                    datos1 = new String[] {gempCinco[0],gempSeis[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {gempCinco[1],gempSeis[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {gempCinco[2],gempSeis[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {gempCinco[3],gempSeis[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {gempCinco[4],gempSeis[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {gempCinco[5],gempSeis[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 6:
                    datos1 = new String[] {gempSeis[0],gempSiete[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {gempSeis[1],gempSiete[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {gempSeis[2],gempSiete[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {gempSeis[3],gempSiete[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {gempSeis[4],gempSiete[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {gempSeis[5],gempSiete[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 7:
                    datos1 = new String[] {gempSiete[0],gempOcho[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {gempSiete[1],gempOcho[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {gempSiete[2],gempOcho[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {gempSiete[3],gempOcho[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {gempSiete[4],gempOcho[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {gempSiete[5],iscCinco[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);
                    break;
                case 8:
                    /*datos1 = new String[] {iscCuatro[0],iscCinco[0]};
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos1);
                    sp_selec1.setAdapter(adapter);

                    datos2 = new String[] {iscCuatro[1],iscCinco[1]};
                    adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos2);
                    sp_selec2.setAdapter(adapter2);

                    datos3 = new String[] {iscCuatro[2],iscCinco[2]};
                    adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos3);
                    sp_selec3.setAdapter(adapter3);

                    datos4 = new String[] {iscCuatro[3],iscCinco[3]};
                    adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos4);
                    sp_selec4.setAdapter(adapter4);

                    datos5 = new String[] {iscCuatro[4],iscCinco[4]};
                    adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos5);
                    sp_selec5.setAdapter(adapter5);

                    datos6 = new String[] {iscCuatro[5],iscCinco[5]};
                    adapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos6);
                    sp_selec6.setAdapter(adapter6);

                    datos7 = new String[] {iscCuatro[6],iscCinco[6]};
                    adapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, datos7);
                    sp_selec7.setAdapter(adapter7);*/
                    break;
            }




        }else{

        }

        return view;
    }

}
