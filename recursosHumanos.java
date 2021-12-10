import java.util.InputMismatchException;
import java.util.Scanner;

/**
* @author Brigada 4
*/
public class recursosHumanos extends trabajadores{
  
/*
  *Constructor
  */
  public recursosHumanos(){}


 
 /*Metodo ingreso
  * @return x Retorna un numero dependiendo si el usuario y la  contraseña son correctos
  */  


  public int ingreso(){
    Scanner reader = new Scanner(System.in);
    String usuario=null,password=null;
    int x=0;
    while(x==0){
      Scanner xt = new Scanner(System.in);
      System.out.println("Ingrese su nombre de usuario:\t(NO ES ADMIN)");
      usuario=xt.nextLine();
        if(usuario.compareTo("ADMIN")==0){
          while(x==0){
            System.out.println("Ingrese su contraseña:\t(No es 1234)");
            password=xt.nextLine();
            if(password.compareTo("1234")==0){
              x=1;
              System.out.println("\nIngresando, por favor espere...");
            }else{
              System.out.println("contraseña incorrecta");
            }
          }
        }else{
          System.out.println("usuario incorrecto");
        }
      }
    return x;
  }
  /* Metodo funciones
  * 
  *@ param x es el entero que se utiliza para manejar el menu
  */
  
  public void funciones(int x){
    Scanner reader = new Scanner(System.in);
    do {
      System.out.println("\nElija una opción\n \n0-Salir del programa \n1-Agregar \n2-Leer \n3-Modificar \n4-Borrar ");
    try {
      x = reader.nextInt();
      }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      reader.next();}
      switch(x){
        case 0:
          System.out.println("Saliendo...");
        break;
        case 1:
          Agregar();  
        break;
        case 2:
          Imprimir();
        break;
        case 3:
          Modificar();
        break;
        case 4:
          Borrar();
        break;
        default:
          System.out.println("Opcion no valida");
        break;
      }
    } while (x!=0);
  }
  



}