package itchihuahua.mitec.com.mitec;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ReticulaFragment extends Fragment {
    Button btn_uno,btn_dos,btn_tres,btn_cuatro,btn_cinco,btn_seis,btn_siete,btn_ocho,btn_nueve,btn_diez;
    String CARRERA="mitec.carrera";
    int clave=0, semestre=0;
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
        View view = inflater.inflate(R.layout.fragment_reticula, container, false);

        btn_uno=(Button)view.findViewById(R.id.btn_uno);
        btn_dos=(Button)view.findViewById(R.id.btn_dos);
        btn_tres=(Button)view.findViewById(R.id.btn_tres);
        btn_cuatro=(Button)view.findViewById(R.id.btn_cuatro);
        btn_cinco=(Button)view.findViewById(R.id.btn_cinco);
        btn_seis=(Button)view.findViewById(R.id.btn_seis);
        btn_siete=(Button)view.findViewById(R.id.btn_siete);
        btn_ocho=(Button)view.findViewById(R.id.btn_ocho);
        btn_nueve=(Button)view.findViewById(R.id.btn_nueve);
        btn_diez=(Button)view.findViewById(R.id.btn_diez);

        SharedPreferences preferencias= getContext().getSharedPreferences("CARRERA",Context.MODE_PRIVATE);
        clave=preferencias.getInt("CLAVE",0);
        semestre=preferencias.getInt("SEMESTRE",0);

        switch (semestre){
            case 0:
                Toast.makeText(getContext(),"ERROR AL CARGAR LOS DATOS",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                btn_uno.setBackgroundColor(Color.MAGENTA);
                break;
            case 2:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.MAGENTA);
                break;
            case 3:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.MAGENTA);
                break;
            case 4:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.GREEN);
                btn_cuatro.setBackgroundColor(Color.MAGENTA);
                break;
            case 5:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.GREEN);
                btn_cuatro.setBackgroundColor(Color.GREEN);
                btn_cinco.setBackgroundColor(Color.MAGENTA);
                break;
            case 6:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.GREEN);
                btn_cuatro.setBackgroundColor(Color.GREEN);
                btn_cinco.setBackgroundColor(Color.GREEN);
                btn_seis.setBackgroundColor(Color.MAGENTA);
                break;
            case 7:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.GREEN);
                btn_cuatro.setBackgroundColor(Color.GREEN);
                btn_cinco.setBackgroundColor(Color.GREEN);
                btn_seis.setBackgroundColor(Color.GREEN);
                btn_siete.setBackgroundColor(Color.MAGENTA);
                break;
            case 8:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.GREEN);
                btn_cuatro.setBackgroundColor(Color.GREEN);
                btn_cinco.setBackgroundColor(Color.GREEN);
                btn_seis.setBackgroundColor(Color.GREEN);
                btn_siete.setBackgroundColor(Color.GREEN);
                btn_ocho.setBackgroundColor(Color.MAGENTA);
                break;
            case 9:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.GREEN);
                btn_cuatro.setBackgroundColor(Color.GREEN);
                btn_cinco.setBackgroundColor(Color.GREEN);
                btn_seis.setBackgroundColor(Color.GREEN);
                btn_siete.setBackgroundColor(Color.GREEN);
                btn_ocho.setBackgroundColor(Color.GREEN);
                btn_nueve.setBackgroundColor(Color.MAGENTA);
                break;
            case 10:
                btn_uno.setBackgroundColor(Color.GREEN);
                btn_dos.setBackgroundColor(Color.GREEN);
                btn_tres.setBackgroundColor(Color.GREEN);
                btn_cuatro.setBackgroundColor(Color.GREEN);
                btn_cinco.setBackgroundColor(Color.GREEN);
                btn_seis.setBackgroundColor(Color.GREEN);
                btn_siete.setBackgroundColor(Color.GREEN);
                btn_ocho.setBackgroundColor(Color.GREEN);
                btn_nueve.setBackgroundColor(Color.GREEN);
                btn_diez.setBackgroundColor(Color.MAGENTA);
                break;
        }

        if (clave==0){
            btn_uno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscUno, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_dos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscDos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_tres.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscTres, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_cuatro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscCuatro, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_cinco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscCinco, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_diez.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscDiez, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_seis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscSeis, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_siete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscSiete, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_ocho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscOcho, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_nueve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(iscNueve, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });


        }else if (clave==1){
            btn_uno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempUno, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_dos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempDos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_tres.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempTres, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_cuatro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempCuatro, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_cinco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempCinco, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_diez.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempDiez, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_seis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempSeis, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_siete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempSiete, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_ocho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempOcho, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_nueve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(gempNueve, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });


        }else{
            btn_uno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infUno, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_dos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infDos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_tres.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infTres, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_cuatro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infCuatro, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_cinco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infCinco, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_diez.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infDiez, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_seis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infSeis, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_siete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infSiete, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_ocho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infOcho, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });

            btn_nueve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mensaseListaElementos = new AlertDialog.Builder(getContext());
                    mensaseListaElementos.setTitle("MATERIAS");
                    mensaseListaElementos.setItems(infNueve, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    mensaseListaElementos.show();
                }
            });


        }


        return view;
    }


}
