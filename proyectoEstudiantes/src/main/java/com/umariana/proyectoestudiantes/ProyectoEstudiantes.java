/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyectoestudiantes;

import Mundo.Alumno;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sistemas
 */
public class ProyectoEstudiantes {

    public static void main(String[] args) throws IOException {
        
        // Función que permite leer la opcion del usuario de manera mas controlada
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Función que permite leer la opción del usuario
        Scanner lector = new Scanner(System.in);
        
        // Bandera que permite terminar el programa
        boolean activo = true;
                
        //Creamos el array donde almacenaremos a nuestros estudiantes.
        ArrayList <Alumno> misAlumnos = new ArrayList<Alumno>();
        
        do{
        System.out.println("-----------MENU DE OPCIONES-----------");
        System.out.println("1. Insertar estudiante");
        System.out.println("2. Eliminar estudiante");
        System.out.println("3. Modificar estudiante");
        System.out.println("4. Consultar estudiante");
        System.out.println("5. Terminar programa");
        System.out.println("--------------------------------------");
        
        int opcion = lector.nextInt();
        
            switch (opcion) {
                
                //============================================================== 
                case 1:
                    
                    agregarEstudiante(misAlumnos, new BufferedReader(new InputStreamReader(System.in)), lector);
                   
                    break;
                    
                //==============================================================    
                case 2:
                    
                    eliminarEstudiante(misAlumnos, new BufferedReader(new InputStreamReader(System.in)));
                    
                    break;
                    
                //==============================================================  
                case 3:
                    
                    modificarEstudiante(misAlumnos, new BufferedReader(new InputStreamReader(System.in)), lector);
                    
                    break;
                            
                //==============================================================            
                case 4:
                    
                    consultarEstudiante(misAlumnos);
                    
                    break;
                
                //============================================================== 
                case 5:
                    System.out.println("");
                    System.out.println("Ejecución del programa finalizada :)");
                    System.out.println("");
                    activo = false;
                    break;
                default:
                    System.out.println("Debe seleccionar una de las opciones del menu");
                    break;
            }
                
                
        }while(activo == true);
        
        
    }
    
     public static void agregarEstudiante(ArrayList<Alumno> misAlumnos, BufferedReader reader, Scanner lector) throws IOException {
         
         // Bandera que permite terminar el bucle 'while' utilizado en la opcion 1.
        boolean end;
        
         // Iniciamos la bandera en true para ejecutar el bucle 'while'
                    end = true;
                    
                    // Empleamos un bucle 'while' para solicitar nuevamente el dato en caso de que no sea válido.
                    while(end == true){
                        
                    try {
                        
                        // Variable utilizada para verificar si la cédula ya está registrada.
                        boolean inUse = false;
                        
                        System.out.println("");
                        System.out.println("Introduce la cedula del estudiante");
                        String cedula = reader.readLine();
                        if (!cedula.matches("\\d+")) {
                                throw new InputMismatchException();
                            }
                        
                        /*
                        Proceso utilizado para comprobar la existencia previa de la cédula ingresada
                        */
                        for (Alumno alumno : misAlumnos) {
                            if(alumno.getCedula().equals(cedula)){
                                inUse = true;
                            }
                            
                        }
                            
                        if (inUse != true) {
                                                       
                            System.out.println("------------------------------");                          
                            System.out.println("Introduce el nombre del estudiante");
                            String nombre = reader.readLine();
                            if (nombre.matches(".*[0-9].*")) {
                                throw new InputMismatchException();
                            }
                            
                            System.out.println("------------------------------");
                            System.out.println("Introduce el apellido del estudiante");
                            String apellido = reader.readLine();
                            if (apellido.matches(".*[0-9].*")) {
                                throw new InputMismatchException();
                            }
                         
                            System.out.println("------------------------------");
                            System.out.println("Introduce el semestre del estudiante");
                            int semestre = lector.nextInt();
                            
                            System.out.println("------------------------------");
                            System.out.println("Introduce el correo del estudiante");
                            String correo = lector.next();
                            
                            System.out.println("------------------------------");
                            System.out.println("Introduce el celular del estudiante");
                            String celular = reader.readLine();
                            
                            if (!celular.matches("\\d+")) {
                                throw new InputMismatchException();
                            }
                            
                            System.out.println("------------------------------");

                            System.out.println("");
                            System.out.println("Estudiante agregado exitosamente.");
                            System.out.println("");
                            System.out.println("------------------------------");
                            System.out.println("");
                            

                            //Se crea un objeto para guardar la información de cada alumno
                            Alumno a = new Alumno(cedula, nombre, apellido, semestre, correo, celular);

                            //Almacenamos el alumno en nuestro array
                            misAlumnos.add(a);  
                            
                        }else{                       
                            System.out.println("------------------------------");
                            System.out.println("La cédula ingresada ya se encuentra registrada en el sistema.");
                            System.out.println("------------------------------");
                            System.out.println("");
                        }
                                
                        
                        
                    //Cerramos el bucle 'while'
                    end = false;
                    
                    break;
                    
                    }catch(InputMismatchException e) {
                            System.out.println("");
                            System.out.println("========================================");
                            System.out.println("Error: Debes ingresar un valor válido.");
                            System.out.println("Por favor, ingresa los datos nuevamente.");
                            System.out.println("========================================");
                            System.out.println("");
                            lector.nextLine(); // Limpiar el búfer de entrada
                        }
                    }
  
     }
     
     
     public static void modificarEstudiante(ArrayList<Alumno> misAlumnos, BufferedReader reader, Scanner lector) throws IOException 
     {
     System.out.println("");
                    System.out.println("Ingrese la cédula del estudiante que desea modificar:");
                    String cedulaModificar = reader.readLine();
    
                    boolean encontrado = false;
    
                    for (Alumno alumno : misAlumnos) {
                        if (alumno.getCedula().equals(cedulaModificar)) {
                            encontrado = true;

                            // Mostrar los campos actuales del estudiante
                            System.out.println("Datos actuales del estudiante: ");
                            System.out.println("Cédula: " + alumno.getCedula());
                            System.out.println("Nombre: " + alumno.getNombre());
                            System.out.println("Apellido: " + alumno.getApellido());
                            System.out.println("Semestre: " + alumno.getSemestre());
                            System.out.println("Correo: " + alumno.getCorreo());
                            System.out.println("Celular: " + alumno.getCelular());
                            System.out.println("");

                            try{
                                
                            // Solicitar los nuevos valores para los campos que se desean modificar
                            
                            //Solicitar la nueva cedula
                            System.out.println("Ingrese la nueva cedula del estudiante (o enter para mantener el actual):"); 
                            String nuevaCedula = reader.readLine();
                            
                            if (!nuevaCedula.isEmpty()) {
                                
                                if (!nuevaCedula.matches("\\d+")) {                                  
                                    throw new InputMismatchException();                                   
                                }else{                                  
                                    alumno.setCedula(nuevaCedula); 
                                    System.out.println("-------------------------------");
                                    System.out.println("Cédula actualizada exitosamente");
                                    System.out.println("-------------------------------");
                                }                               
                            }else{                               
                                String sinCambio = alumno.getCedula();
                                alumno.setCedula(sinCambio);                               
                            }
                            
                            
                            //Solicitar el nuevo nombre
                            System.out.println("Ingrese el nuevo nombre del estudiante (o enter para mantener el actual):");
                            String nuevoNombre = reader.readLine();
                            
                            if (!nuevoNombre.isEmpty()) {                               
                                if (nuevoNombre.matches(".*[0-9].*")) {                                    
                                    throw new InputMismatchException();                                    
                                }else{            
                                    alumno.setNombre(nuevoNombre); 
                                    System.out.println("-------------------------------");
                                    System.out.println("Nombre actualizado exitosamente");
                                    System.out.println("-------------------------------");
                                }       
                            }else{
                                String sinCambio = alumno.getNombre();
                                alumno.setNombre(sinCambio);
                            }
                            
                            
                            //Solicitar el nuevo apellido
                            System.out.println("Ingrese el nuevo apellido del estudiante (o enter para mantener el actual):");
                            String nuevoApellido = reader.readLine();
                            
                            if (!nuevoApellido.isEmpty()) {
                                if (nuevoApellido.matches(".*[0-9].*")) {                                    
                                    throw new InputMismatchException();                                    
                                }else{                
                                    alumno.setApellido(nuevoApellido);  
                                    System.out.println("-------------------------------");
                                    System.out.println("Apellido actualizado exitosamente");
                                    System.out.println("-------------------------------");
                                }         
                            }else{
                                String sinCambio = alumno.getApellido();
                                alumno.setApellido(sinCambio);
                            }
                            
                            
                            //Solicitar el nuevo semestre
                            System.out.println("Ingrese el nuevo semestre del estudiante (o enter para mantener el actual):");
                            int nuevoSemestre;
                            String nuevoSemestreP = reader.readLine();
                            if (!nuevoSemestreP.isEmpty()) {
                                nuevoSemestre = Integer.parseInt(nuevoSemestreP);
                                alumno.setSemestre(nuevoSemestre);
                                System.out.println("-------------------------------");
                                System.out.println("Semestre actualizado exitosamente");
                                System.out.println("-------------------------------");
                            }else{
                                int sinCambio = alumno.getSemestre();
                                alumno.setSemestre(sinCambio);
                            }
                            
                            
                            //Solicitar el nuevo correo electrónico
                            System.out.println("Ingrese el nuevo correo electrónico del estudiante (o enter para mantener el actual):");
                            String nuevoCorreo = reader.readLine();
                            if (!nuevoCorreo.isEmpty()) {
                                alumno.setCorreo(nuevoCorreo);
                                System.out.println("-------------------------------");
                                System.out.println("Correo actualizado exitosamente");
                                System.out.println("-------------------------------");
                            }else{
                                String sinCambio = alumno.getCorreo();
                                alumno.setCorreo(sinCambio);
                            }
                            
                            
                            //Solicitar el nuevo celular
                            System.out.println("Ingrese el nuevo celular del estudiante (o enter para mantener el actual):");
                            String nuevoCelular = reader.readLine();
                            if (!nuevoCelular.isEmpty()) {
                                if (!nuevoCelular.matches("\\d+")) {
                                throw new InputMismatchException();
                                }else{
                                   alumno.setCelular(nuevoCelular); 
                                   System.out.println("-------------------------------");
                                    System.out.println("Celular actualizado exitosamente");
                                    System.out.println("-------------------------------");
                                }                                
                            }else{
                                String sinCambio = alumno.getCelular();
                                alumno.setCelular(sinCambio);
                            }

                            // Mostrar un mensaje de éxito
                            System.out.println("");
                            System.out.println("===================================");
                            System.out.println("Estudiante modificado exitosamente.");
                            System.out.println("===================================");
                            System.out.println("");
                            } catch (InputMismatchException e) {
                                                
                                System.out.println("");
                                System.out.println("========================================");
                                System.out.println("Error: Debes ingresar valores válidos.");
                                System.out.println("========================================");
                                System.out.println("");
                                lector.nextLine(); // Limpiar el búfer de entrada
                                break;
                            } catch (NumberFormatException e){
                                System.out.println("");
                                System.out.println("========================================");
                                System.out.println("Error: Debes ingresar valores válidos.");
                                System.out.println("========================================");
                                System.out.println("");
                                lector.nextLine(); // Limpiar el búfer de entrada
                                break;
                            }
                            break; // Salir del bucle una vez encontrado y modificado el estudiante
                        }
                    }
    
                    if (!encontrado) {
                        System.out.println("No se encontró un estudiante con la cédula ingresada.");
                    }
     }
     
     public static void consultarEstudiante(ArrayList<Alumno> misAlumnos){
         if (misAlumnos.isEmpty()) {
                            System.out.println("No hay ningún estudiante en el sistema.");
                        }else{
                        System.out.println("Registro Académico de Estudiantes");
                        System.out.println("=================================");

                    for (int i = 0; i < misAlumnos.size(); i++) {
                        Alumno alumno = misAlumnos.get(i);
                        System.out.println("----------------------------");
                        System.out.println("Estudiante: " + (i+1));
                        System.out.println("Cédula: " + alumno.getCedula());
                        System.out.println("Nombre: " + alumno.getNombre());
                        System.out.println("Apellido: " + alumno.getApellido());
                        System.out.println("Semestre: " + alumno.getSemestre());
                        System.out.println("Correo: " + alumno.getCorreo());
                        System.out.println("Celular: " + alumno.getCelular());
                        System.out.println("----------------------------");
                        System.out.println("");
                    }
            }
     }
     
     
     public static void eliminarEstudiante(ArrayList<Alumno> misAlumnos, BufferedReader reader) throws IOException {
         
     boolean encontrado = false;

         System.out.println("Ingrese la cedula que desea eliminar");
         String cedulaEliminar = reader.readLine();
         
        for (Alumno alumno : misAlumnos ) {
            if (alumno.getCedula().equals(cedulaEliminar)) {
                misAlumnos.remove(alumno); // Eliminar el estudiante de la lista
                encontrado = true;
                System.out.println("Estudiante eliminado exitosamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un estudiante con la cédula ingresada.");
        }
    }
}
