import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
/**
* @author Brigada 4
*/
public class trabajadores{
  private int contadorg=0;
  private int numTrabajadores=300;//numero de trabajadores
  private ArrayList<Integer> edadTrabajador = new ArrayList<Integer>();
  private ArrayList<String> nombreTrabajador = new ArrayList<String>();
  private ArrayList<String> aPaternoTrabajador = new ArrayList<String>();
  private ArrayList<String> aMaternoTrabajador = new ArrayList<String>();
  private ArrayList<String> direccionTrabajador = new ArrayList<String>();
  private ArrayList<String> alcaldia = new ArrayList<String>();
  private ArrayList<String> codigopostal= new ArrayList<String>();
  private ArrayList<String> colonia = new ArrayList<String>();
  private ArrayList<String> calle = new ArrayList<String>();
  private String[] historicos = {"Calidad de vida","Caras Inocentes","Apoyo comunitario","Conciencia Colectiva","Sembrando Oportunidades","Teletón","Aprendizaje Dinamico","Pureza","Vuelo al desarrollo","Hazlo Posible","ProTierra","Alimentemos al mundo","Saber más","Ciencia T","Convivencia Internacional","Mundo Tecnologico","Rápido y Eficaz","Cerebros Exploradores","Anticorrupcion","viendo hacia el futuro","CEMEX","TerraMar","Luciernaga","La Raza Cósmica","Paperclip","Laguna","Metro","Orbia","Viaje en el tiempo","Langosta","Tecnologia para todos","Sputnik","Revolucion Tecnologica","Don Gato","Unidad","MAGA","Clonación","Integración Familiar","Reconstruccion","Club Inclusivo"};
  private String[] vigentes = {"Internacional","ONG","Vista hacia el futuro","Nuevo Rumbo","Mundo Educa","Escuela Global","Cometa","Flora","Fauna","Nuevo Amanecer"};
  private ArrayList<String> Proyectoshistoricos = new ArrayList<String>();
  private ArrayList<String> Proyectosvigentes = new ArrayList<String>();
  private ArrayList<String> proyectoshist = new ArrayList<String>();
  private ArrayList<String> proyectosvig = new ArrayList<String>();
    private ArrayList<Integer> servicio = new ArrayList<Integer>();
    private ArrayList<Integer> historicosConteo = new ArrayList<Integer>();
private ArrayList<Integer> vigentesConteo = new ArrayList<Integer>();
  /**
  *Constructor
  */
  public trabajadores(){}

   /*Metodo generadorRegistros
  * Este metodo sirve para agregar a cada trabajador
  *nombre completo,edad,direccion y tiempo en la empresa
  */  
  public void generadorRegistros(){
    String[] nombresAleatorios = {"Marisol", "Rodrigo", "Anastasio", "Annie","Jose","Marco","Pedro","Luis","Marta","Frida","Francisco", "Ramon","Lorena","Matias","Jordan","Sergio","Saul","Samantha","Miguel","Martin","Antonela","Federico","Angel","Clara","Daniela", "Jesica", "Enrique", "Mateo", "Leonardo", "Rafael","Adrián", "Sofia","Luis","Enrique","Bastian","Sebastian","Gabriel","Alejandro", "Nepamuceno", "Roque", "Grasiela","Kytzia"};
    String[] apellidosAleatorios={"Villa","Rodríguez", "Martínez", "Hernández", "López", "González", "Pérez","Sánchez", "Ramírez", "Torres", "Flores", "Rivera","Gómez", "Díaz", "Palacios", "Cruz", "Morales", "Ortiz", "Gutiérrez","Smith","Johnson", "Williams", "Morrissey", "Hazel", "West", "Yañes", "Rourke", "Joyce", "Brown", "Jones", "Miller", "Davis", "Byrne", "Wilkins", "Michaels", "Anderson", "O'Brien", "Yorke", "Greenwood", "Jackson", "Quintero", "Almazo", "Escañuela", "Vázquez", "Varela", "Skywalker", "García", "Rodríguez", "Wilson", "Spilberg", "Reyes","Sumner", "Curtis", "Rosillo", "Morales", "Mao", "Xu", "Rickles", "Reyes"};
    int indice,indice2,indice3;
    int edadMinima = 18;
    int edadMaxima = 65;
    for(int i=0;i<numTrabajadores;i++){
      indice=(int)Math.floor(Math.random()*(nombresAleatorios.length)); 
      indice2=(int)Math.floor(Math.random()*(apellidosAleatorios.length));
      indice3=(int)Math.floor(Math.random()*(apellidosAleatorios.length));
      edadTrabajador.add((int)Math.floor(Math.random()*(edadMaxima-edadMinima+1)+edadMinima));
      nombreTrabajador.add(nombresAleatorios[indice]);
      aPaternoTrabajador.add(apellidosAleatorios[indice2]);
      aMaternoTrabajador.add(apellidosAleatorios[indice3]);
    }
    int count=0;

    try{
      FileReader fr=new FileReader ("Basededatos.csv");
      BufferedReader br=new BufferedReader(fr);
      String linea=br.readLine();
      int x=0;
        while(linea!=null){
          StringTokenizer separador =new StringTokenizer(linea,",");
          while(separador.hasMoreTokens()){  
            String aux=separador.nextToken();
            if(count==0){
              alcaldia.add(aux);
              count++;
            }else if(count==1){
              colonia.add(aux);
              count++;
            }else if(count==2){
              calle.add(aux);
              count++;
            }else if(count==3){
              codigopostal.add(aux);
              count=0;
            }  
          }
          linea=br.readLine();
    }     
    br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    if(numTrabajadores<300){
      for(int i=0;i<=(299-numTrabajadores);i++){
            alcaldia.remove((numTrabajadores-1));
            codigopostal.remove((numTrabajadores-1));
            colonia.remove((numTrabajadores-1));
            calle.remove((numTrabajadores-1));
      }
    }
    /*int c=0; //imprimir las direcciones
    for(String o:alcaldia){
      System.out.println((c+1)+")"+o);
      c++;
    } */
    String aux2=null;
   
    int random=0;
    if(numTrabajadores>300){
      for(int i=300;i<numTrabajadores;i++){
        random=(int)Math.floor(Math.random()*(300));
        aux2=calle.get(random);
        calle.add(aux2);
        aux2=colonia.get(random);
        colonia.add(aux2);
        aux2=alcaldia.get(random);
        alcaldia.add(aux2);
        aux2=codigopostal.get(random);
        codigopostal.add(aux2);
      }
    }


    for(int i=0;i<numTrabajadores;i++){
      String auxiliar="Calle:"+calle.get(i)+" Colonia:"+colonia.get(i)+" Alcaldia:"+alcaldia.get(i)+" C.P:"+codigopostal.get(i);
      direccionTrabajador.add(auxiliar);
    }
    int random2=0;
    for(Integer o:edadTrabajador){
      if(o==18){
        random2=0;
      }else{
        for(int i=19;i<65;i++){
        if(o==i){
          random2=(int)Math.floor(Math.random()*((i+1-18)));
        }
        }
      }  
      servicio.add(random2);  
    }
     asignarProyectos();


   
    Actualizar();
    System.out.println("\n¡Datos generados!");
    /*int i=0; //imprimir las direcciones
    for(String o:direccionTrabajador){
      System.out.println((i+1)+")"+o);
      i++;
    }*/
  }
   /*Metodo Actualizar
  * Este metodo sirve para actualizar los trabajadores
  */  
  public void Actualizar(){
    try{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      FileWriter fw=new FileWriter("datos.csv");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter salida= new PrintWriter(bw);
      for(int i=0;i<numTrabajadores;i++){
        salida.println((i+1)+","+nombreTrabajador.get(i)+","+aPaternoTrabajador.get(i)+","+aMaternoTrabajador.get(i)+","+edadTrabajador.get(i)+","+servicio.get(i)+","+direccionTrabajador.get(i)+","+Proyectosvigentes.get(i)+","+Proyectoshistoricos.get(i));
      }
      salida.close();
    }catch(IOException ex){
    System.out.println(ex.getMessage());
    }
  }
   /*Metodo Agregar
  * este metodo sirve para agregar más trabajadores a nuestra base
  */  

  public void Agregar(){
    Scanner rt = new Scanner(System.in);
    Scanner xt = new Scanner(System.in);
    String auxiliar=null,pivote=null;
    int auxiliar2=0;
    System.out.println("\nAgregue los datos del nuevo empleado");
    System.out.println("\nNombre: ");
    auxiliar=xt.nextLine();
    nombreTrabajador.add(auxiliar);
    System.out.println("Apellido paterno: ");
    auxiliar=xt.nextLine();
    aPaternoTrabajador.add(auxiliar);
    System.out.println("Apellido Materno: ");
    auxiliar=xt.nextLine();
    aMaternoTrabajador.add(auxiliar);
    System.out.println("Edad del trabajador: ");   //Edad debe ser mayor a 18 crear restriccion
    try {
      auxiliar2 = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
    edadTrabajador.add(auxiliar2);
      System.out.println("Años de servicio en la empresa: ");   //Edad debe ser mayor a 18 crear restriccion
    try {
      auxiliar2 = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
    servicio.add(auxiliar2);
    System.out.println("\nDireccion del trabajador");
    System.out.println("Ingrese la calle: ");
    auxiliar=xt.nextLine();
    calle.add(auxiliar);
    System.out.println("Ingrese la colonia: ");
    auxiliar=xt.nextLine();
    colonia.add(auxiliar);
    System.out.println("Ingrese la alcaldia: ");
    auxiliar=xt.nextLine();
    alcaldia.add(auxiliar);
    System.out.println("Ingrese el codigo postal: ");
    auxiliar=xt.nextLine();
    codigopostal.add(auxiliar);
    auxiliar="Calle:"+calle.get(numTrabajadores)+" Colonia:"+colonia.get(numTrabajadores)+" Alcaldia:"+alcaldia.get(numTrabajadores)+" C.P:"+codigopostal.get(numTrabajadores);
    numTrabajadores++;
    System.out.println(auxiliar);
    direccionTrabajador.add(auxiliar);
    System.out.println("\nProyectos\n¿Cuantos proyectos vigentes desea agregar?");
    try {
      auxiliar2 = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
      vigentesConteo.add(auxiliar2);
      auxiliar="El trabajador no tiene ningun proyecto vigente";
      for(int i=0;i<auxiliar2;i++){
         System.out.println("Ingresa el proyecto "+(i+1)+":");
         pivote=xt.nextLine();
         if(auxiliar=="El trabajador no tiene ningun proyecto vigente"){
           auxiliar=pivote;
         }
         else{
           auxiliar=auxiliar+"-"+pivote;
         }
      }
      Proyectosvigentes.add(auxiliar);
    System.out.println("¿Cuantos proyectos historicos desea agregar?");
    try {
      auxiliar2 = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
      historicosConteo.add(auxiliar2);
      auxiliar="El trabajador no tiene ningun proyecto histórico";
      for(int i=0;i<auxiliar2;i++){
         System.out.println("Ingresa el proyecto "+(i+1)+":");
         pivote=xt.nextLine();
         if(auxiliar=="El trabajador no tiene ningun proyecto histórico"){
           auxiliar=pivote;
         }
         else{
           auxiliar=auxiliar+"-"+pivote;
         }
      } 
    Proyectoshistoricos.add(auxiliar);

    Actualizar();
    System.out.println("¡Datos actualizados!");
  }
   /*Metodo Imprimir
  * este metedo sirve para imprimir todos los trabajadores
  */  
  public void Imprimir(){
    try{
      if(numTrabajadores==0){
        System.out.println("No hay trabajadores en la base de datos");
      }else{
        for(int i=0;i<numTrabajadores;i++){
          System.out.println("------------------------------------------------------------------------------------------------------");
          System.out.println((i+1)+") El trabajador "+nombreTrabajador.get(i)+" "+aPaternoTrabajador.get(i)+" "+aMaternoTrabajador.get(i)+" tiene una edad de "+edadTrabajador.get(i)+" años y tiene "+servicio.get(i)+" año(s) en la empresa.\nSu dirección es: "+direccionTrabajador.get(i)+"\n\nProyectos historicos ("+historicosConteo.get(i)+"): "+Proyectoshistoricos.get(i)+" \n\nProyectos vigentes ("+vigentesConteo.get(i)+"): "+Proyectosvigentes.get(i));
        }
        System.out.println("------------------------------------------------------------------------------------------------------");      
      }
      Actualizar();
    }catch(IndexOutOfBoundsException ex){
      System.out.println("No hay un trabajador registrado en ese lugar");
    }
  }
   /*Metodo Modificar
  * este metodo nos sirve para modificar la lista de los trabajadores
  */  
  public void Modificar(){
  Scanner rt = new Scanner(System.in);
    Scanner xt = new Scanner(System.in);
    int trabajador=0;
    System.out.println("\nIngrese el número de empleado que desea modificar.");
    try {
      trabajador = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puede ingresar números enteros. ");
      rt.next();
    }
    System.out.println("\nEmpleado numero: "+trabajador+"\nNombre: "+nombreTrabajador.get((trabajador-1))+" "+aPaternoTrabajador.get((trabajador-1))+" "+aMaternoTrabajador.get((trabajador-1))+"\nEdad: "+edadTrabajador.get((trabajador-1))+" años\nAños de servicio: "+servicio.get(trabajador-1)+" años\nDirección: "+direccionTrabajador.get(trabajador-1)+"\n\n Proyectos: \n\nProyectos Historicos("+historicosConteo.get(trabajador-1)+"): "+Proyectoshistoricos.get((trabajador-1))+"\n\nProyectos Vigentes("+vigentesConteo.get(trabajador-1)+"): "+Proyectosvigentes.get((trabajador-1)));
    int numj=0;

    String nuevoNombre=null,nuevoApaterno=null,nuevoAmaterno=null,pivote=null;;
    int pivote2=0;
    do{
      if(numj!=0){
        System.out.println("\n¡Dato actualizado!");
      }
      System.out.println("\n\n0-Salir \n1-Modificar nombre \n2-Modificar apellidoPaterno \n3-Modificar apellidoMaterno \n4-Modificar edad \n5-Modificar direccion \n6-Modificar proyectos  \n7-Modificar años de servicio");
      try {
        numj = rt.nextInt();
      }catch (InputMismatchException ex){
        System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
        rt.next();
      }
      switch(numj){
        case 0:
          System.out.println("Saliendo....");
        break;
        case 1:
          System.out.println("Ingrese el nuevo nombre: ");
          nuevoNombre=xt.nextLine();
          nombreTrabajador.set((trabajador-1),nuevoNombre);
          Actualizar();
        break;
        case 2:
          System.out.println("Ingrese el nuevo apellido paterno: ");
          nuevoApaterno=xt.nextLine();
          aPaternoTrabajador.set((trabajador-1),nuevoApaterno);
          Actualizar();
        break;
        case 3:
          System.out.println("Ingrese el nuevo apellido materno: ");
          nuevoAmaterno=xt.nextLine();
          aMaternoTrabajador.set((trabajador-1),nuevoAmaterno);
          Actualizar();
        break;
        case 4:
          System.out.println("Ingrese la nueva edad: ");
        try {
          pivote2 = rt.nextInt();
        }catch (InputMismatchException ex){
          System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
          rt.next();
        }
          edadTrabajador.set((trabajador-1),pivote2);
          Actualizar();
        break;
        case 5:
          System.out.println("¿Que desea modificar?");
          System.out.println("\n0-Salir \n1-Modificar calle \n2-Modificar colonia \n3-Modificar alcaldia \n4-Modificar codigo postal");
        try {
          numj = rt.nextInt();
        }catch (InputMismatchException ex){
          System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
          rt.next();
        }
          switch(numj){
            case 0:
              System.out.println("\nSaliendo....");
            break;
            case 1:
              System.out.println("Ingrese la nueva calle: ");
              pivote=xt.nextLine();
              calle.set((trabajador-1),pivote);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
            break;
            case 2:
               System.out.println("Ingrese la nueva colonia: ");
              pivote=xt.nextLine();
              colonia.set((trabajador-1),pivote);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
            break;
            case 3:
               System.out.println("Ingrese la nueva alcadia: ");
              pivote=xt.nextLine();
              alcaldia.set((trabajador-1),pivote);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
            break;
            case 4:
               System.out.println("Ingrese el nuevo codigo postal: ");
              pivote=xt.nextLine();
              codigopostal.set((trabajador-1),pivote);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
              pivote2=0;
            break;
            default:
              System.out.println("Opcion no valida");
            break;
            }
          break;
      case 6:
      int numchido=0;
      System.out.println("¿Que desea modificar?");
      System.out.println("\n0-Salir \n1-Modificar proyectos vigentes \n2-Modificar proyectos Historicos");
              try{
                numj = rt.nextInt();
              }catch(InputMismatchException ex){
                System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
                rt.next();
              }
              switch(numj){
                case 0:
                  System.out.println("\nSaliendo...");
                break;
                case 1:   //Vigentes
                  ArrayList<String> pivotechido = new ArrayList<String>();
                  String linea=null,auxiliarchido=null;
                  linea=Proyectosvigentes.get((trabajador-1));
                  StringTokenizer st =new StringTokenizer(linea,"-");
                  if(st.countTokens()!=1){
                    while (st.hasMoreTokens()) {
                      pivotechido.add(st.nextToken());
                    }
                  }else{
                   
                    pivotechido.add(linea);
                  }
                  System.out.println("\n0-Salir \n1-Modificar un proyecto \n2-Agregar un proyecto \n3-Eliminar proyecto");
                  try {
                   numchido = rt.nextInt();
                  }catch (InputMismatchException ex){
                    System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
                    rt.next();
                  }switch(numchido){
                    case 0: 
                      System.out.println("\nSaliendo...");
                    break;
                    case 1:
                      if(pivotechido.contains("El trabajador no tiene ningun proyecto vigente")){
                       System.out.println("El trabajador no tiene ningun proyecto que modificar");
                      }else{
                         System.out.println("Ingrese el nombre del proyecto a modificar");
                        pivote=xt.nextLine();
                        if(pivotechido.contains(pivote)){
                          for(int i=0;i<pivotechido.size();i++){
                            if((pivotechido.get(i)).compareTo(pivote)==0){
                            System.out.println("Ingrese el nuevo proyecto");
                            pivote=xt.nextLine();
                            pivotechido.set(i,pivote);
                            }
                          }
                          pivote=null;
                          for(String o: pivotechido){
                            if(pivote==null){
                              pivote=o;
                            }
                            else{
                              pivote=pivote+"-"+o;
                            }
                          }
                          Proyectosvigentes.set((trabajador-1),pivote);
                          
                        }else{
                         System.out.println("El trabajador no tiene asociado este proyecto\n\nSaliendo...");
                      }
                      }
                      Actualizar();
                    break;
                    case 2:
                      System.out.println("Nombre del proyecto");
                      pivote=xt.nextLine(); 
                      if(pivotechido.contains("El trabajador no tiene ningun proyecto vigente")){
                        pivotechido.clear();
                        pivotechido.add(pivote);
                        pivote=null;
                      }
                      for(String o: pivotechido){
                        if(pivote==null){
                        pivote=o;
                        }
                        else{
                        pivote=pivote+"-"+o;
                        }
                      }
                      Proyectosvigentes.set((trabajador-1),pivote);
                      vigentesConteo.set((trabajador-1),(vigentesConteo.get(trabajador-1)+1));
                      Actualizar();
                    break;

                    case 3:
                      System.out.println("Ingrese el nombre del proyecto a eliminar");
                      pivote=xt.nextLine();
                      if(pivotechido.contains(pivote)){
                        for(int i=0;i<pivotechido.size();i++){
                          if((pivotechido.get(i)).compareTo(pivote)==0){
                          pivotechido.remove(i);
                          }
                        }
                        pivote=null;
                        for(String o: pivotechido){
                          if(pivote==null){
                            pivote=o;
                          }
                          else{
                          pivote=pivote+"-"+o;
                          }
                        }
                        if(pivote==null){
                          pivote="El trabajador no tiene ningun proyecto vigente";
                        } 
                        Proyectosvigentes.set((trabajador-1),pivote);
                        vigentesConteo.set((trabajador-1),(vigentesConteo.get(trabajador-1)-1));
                      }else{
                        System.out.println("El trabajador no tiene asociado este proyecto\n\nSaliendo...");
                      }
                      Actualizar();
                    break;
                    default:
                      System.out.println("Opcion no valida");
                    break;
                  }
                  
                break;
                case 2: //Historicos 
                 ArrayList<String> pivotechipocludo = new ArrayList<String>();
                  String linea1=null,auxiliarchipocludo=null;
                  linea1=Proyectoshistoricos.get((trabajador-1));
                  StringTokenizer stt =new StringTokenizer(linea1,"-");
                  if(stt.countTokens()!=1){
                    while (stt.hasMoreTokens()) {
                      pivotechipocludo.add(stt.nextToken());
                    }
                  }else{
                   
                    pivotechipocludo.add(linea1);
                  }
                  System.out.println("\n0-Salir \n1-Modificar un proyecto \n2-Agregar un proyecto \n3-Eliminar proyecto");
                  try {
                   numchido = rt.nextInt();
                  }catch (InputMismatchException ex){
                    System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
                    rt.next();
                  }switch(numchido){
                    case 0: 
                      System.out.println("\nSaliendo...");
                    break;
                    case 1:
                      if(pivotechipocludo.contains("El trabajador no tiene ningun proyecto histórico")){
                       System.out.println("El trabajador no tiene ningun proyecto histórico que modificar");
                      }else{
                         System.out.println("Ingrese el nombre del proyecto histórico a modificar");
                        pivote=xt.nextLine();
                        if(pivotechipocludo.contains(pivote)){
                          for(int i=0;i<pivotechipocludo.size();i++){
                            if((pivotechipocludo.get(i)).compareTo(pivote)==0){
                            System.out.println("Ingrese el nuevo proyecto histórico");
                            pivote=xt.nextLine();
                            pivotechipocludo.set(i,pivote);
                            }
                          }
                          pivote=null;
                          for(String o: pivotechipocludo){
                            if(pivote==null){
                              pivote=o;
                            }
                            else{
                              pivote=pivote+"-"+o;
                            }
                          }
                          Proyectoshistoricos.set((trabajador-1),pivote);
                        }else{
                         System.out.println("El trabajador no tiene asociado este proyecto\n\nSaliendo...");
                      }
                      }
                      Actualizar();
                    break;
                    case 2:
                      System.out.println("Nombre del proyecto histórico");
                      pivote=xt.nextLine(); 
                      if(pivotechipocludo.contains("El trabajador no tiene ningun proyecto histórico")){
                        pivotechipocludo.clear();
                        pivotechipocludo.add(pivote);
                        pivote=null;
                      }
                      for(String o: pivotechipocludo){
                        if(pivote==null){
                        pivote=o;
                        }
                        else{
                        pivote=pivote+"-"+o;
                        }
                      }
                      Proyectoshistoricos.set((trabajador-1),pivote);
                      historicosConteo.set((trabajador-1),(historicosConteo.get(trabajador-1)+1));
                      Actualizar();
                    break;

                    case 3:
                      System.out.println("Ingrese el nombre del proyecto histórico a eliminar");
                      pivote=xt.nextLine();
                      if(pivotechipocludo.contains(pivote)){
                        for(int i=0;i<pivotechipocludo.size();i++){
                          if((pivotechipocludo.get(i)).compareTo(pivote)==0){
                          pivotechipocludo.remove(i);
                          }
                        }
                        pivote=null;
                        for(String o: pivotechipocludo){
                          if(pivote==null){
                            pivote=o;
                          }
                          else{
                          pivote=pivote+"-"+o;
                          }
                        }
                        if(pivote==null){
                          pivote="El trabajador no tiene ningun proyecto histórico";
                        } 
                        Proyectoshistoricos.set((trabajador-1),pivote);
                        historicosConteo.set((trabajador-1),(historicosConteo.get(trabajador-1)-1));
                      }else{
                        System.out.println("El trabajador no tiene asociado este proyecto histórico \n\nSaliendo...");
                      }
                      Actualizar();
                    break;
                    default:
                      System.out.println("Opcion no valida");
                    break;
                  }

                break; 
                default:
                  System.out.println("Opcion no valida");
                break;
              }

          
        break;
        case 7:
        System.out.println("Ingrese la nueva edad de servicio");
        try {
          pivote2 = rt.nextInt();
        }catch (InputMismatchException ex){
          System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
          rt.next();
        }
          servicio.set((trabajador-1),pivote2);
          Actualizar();
        break;
      }
    }while(numj!=0);   
  }
   /*Metodo Borrar
  * este metodo sirve para poder borrar uu trabajador de la lista
  */  
  public void Borrar(){
 int x=0;
    Scanner sc = new Scanner(System.in);
    do {
      if(x!=0){
        System.out.println("¡Datos actualizados!");
      }
      System.out.println("\n0-Salir \n1-Borrar todos los trabajadores \n2-Borrar intervalo de trabajadores \n3-Borrar un trabajador");
      try {
        x = sc.nextInt();
      }catch (InputMismatchException ex){
        System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
        sc.next();
      }
      switch(x){
        case 0:
          System.out.println("\nSaliendo....");
        break;
        case 1:
          System.out.println("\nBorrando....");
          nombreTrabajador.clear();
          aPaternoTrabajador.clear();
          aMaternoTrabajador.clear();
          edadTrabajador.clear();
          direccionTrabajador.clear();
          alcaldia.clear();
          codigopostal.clear();
          colonia.clear();
          calle.clear();
          Proyectosvigentes.clear();
          Proyectoshistoricos.clear();
          servicio.clear();
          historicosConteo.clear();
          vigentesConteo.clear();
          numTrabajadores=0;
          System.out.println("\nImprimiendo los trabajadores....");
          Imprimir();
        break;
        case 2:
          System.out.println("\n\nIntervalo a borrar:");
          System.out.println("\nEscriba el inicio del intervalo");
          int inf=0;
          int sup=0;
          try {
            inf = sc.nextInt();
            System.out.println("\n\nEscriba el fin del intervalo");
            sup= sc.nextInt();
          }catch (InputMismatchException ex){
            System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
            sc.next();
          }
          System.out.println("\nBorrando....");
          for(int i=0;i<=(sup-inf);i++){
            nombreTrabajador.remove((inf-1));
            aPaternoTrabajador.remove((inf-1));
            aMaternoTrabajador.remove((inf-1));
            edadTrabajador.remove((inf-1));
            direccionTrabajador.remove((inf-1));
            alcaldia.remove((inf-1));
            codigopostal.remove((inf-1));
            colonia.remove((inf-1));
            calle.remove((inf-1));
            Proyectoshistoricos.remove((inf-1));
            Proyectosvigentes.remove((inf-1));
            servicio.remove((inf-1));
            vigentesConteo.remove((inf-1));
            historicosConteo.remove((inf-1));
          }
          numTrabajadores=numTrabajadores-(sup-inf)-1;
          System.out.println("\nImprimiendo los trabajadores....");
          Imprimir();
        break;
        case 3:
          int numT=0;
          System.out.println("Numero del trabajador a borrar");
          try {
            numT = sc.nextInt();
          }catch (InputMismatchException ex){
            System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
            sc.next();
          }
          System.out.println("\nBorrando....");
          nombreTrabajador.remove((numT-1));
          aPaternoTrabajador.remove((numT-1));
          aMaternoTrabajador.remove((numT-1));
          edadTrabajador.remove((numT-1));
          direccionTrabajador.remove((numT-1));
          alcaldia.remove((numT-1));
          codigopostal.remove((numT-1));
          colonia.remove((numT-1));
          calle.remove((numT-1));
          Proyectoshistoricos.remove((numT-1));
          Proyectosvigentes.remove((numT-1));
          servicio.remove((numT-1));
          vigentesConteo.remove((numT-1));
          historicosConteo.remove((numT-1));
          numTrabajadores--;
          Imprimir();
        break;
        default:
          System.out.println("Opcion no valida");
        break;
      }
    } while (x!=0);   
  }
   /*Metodo Registros
  * este metodo nos sirve para obtener los proyectos vigentes y historicos con la cantidad de lo años de servicio
  */  
  public void Registros(){
    proyectoshist.clear();
    proyectosvig.clear();
    int indice,indice2, j; 
    int Min = 1;
    int Max = 3;
    j = (int)Math.floor(Math.random() * (Max - Min + 1)) + Min;
    ArrayList<Integer> numRepetidos = new ArrayList<Integer>();
    Min = 0;
    Max = 9;
    for(int i=0;i<j;i++){
     indice = (int)Math.floor(Math.random() * (Max - Min + 1)) + Min;
     boolean encontrar=false;
      for(int k=0;k<i;k++){
          if(numRepetidos.get(k)==indice){
            encontrar=true;
          }
      }
      if(!encontrar){
        numRepetidos.add(indice);
        proyectosvig.add(vigentes[indice]);
      }else{
        i--;
      }
    }
    Min = 0;
    Max = 39;
    int maxProye=39;
    int minProye=0;
   maxProye=servicio.get(contadorg);
    if(maxProye>=3){
      minProye=(int)(3*maxProye)/5;
      if(maxProye>57){
        maxProye=(int)(13*maxProye)/8;
      }
      j=(int)Math.floor(Math.random() * (maxProye - minProye+1)) + minProye;
    }else{
    j= (int)Math.floor(Math.random() * (maxProye - minProye+1)) + minProye;
    } 
    numRepetidos.clear();
    for(int i=0;i<j;i++){
     indice = (int)Math.floor(Math.random() * (Max - Min + 1)) + Min;
         boolean encontrar=false;
      for(int k=0;k<i;k++){
          if(numRepetidos.get(k)==indice){
            encontrar=true;
          }
      }
      if(!encontrar){
        numRepetidos.add(indice);
        proyectoshist.add(historicos[indice]);
      }else{
        i--;
      }
    }  
  }
   /*Metodo asignarProyectos
  * nos sirve para asignar los proyectos aleatorios tanto como vigentes como historicos a los trabajadores
  */  
  public void asignarProyectos(){
    String aux=null,aux2=null;
    
    for(int i=0;i<numTrabajadores;i++){
      contadorg=i;
      Registros();
      historicosConteo.add(proyectoshist.size());
      for(int j=0;j<proyectoshist.size();j++){
        aux=proyectoshist.get(j);
        if(aux2==null){
          aux2=aux;
        }else{
          aux2=aux2+"-"+aux;
        }
      }
      if(proyectoshist.size()==0){
        Proyectoshistoricos.add("El trabajador no tiene ningun proyecto histórico");
      }else{  
    //Registros();
    Proyectoshistoricos.add(aux2);}
    aux2=null;
    
    }
    Registros();
    for(int i=0;i<numTrabajadores;i++){
      vigentesConteo.add(proyectosvig.size());
      for(int j=0;j<proyectosvig.size();j++){
        aux=proyectosvig.get(j);
        if(aux2==null){
          aux2=aux;
        }else{
          aux2=aux2+"-"+aux;
        }
      }  
    Registros();
    Proyectosvigentes.add(aux2);
    aux2=null;
    }
  }
  



  

 }
 