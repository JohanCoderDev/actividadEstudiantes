/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyectoestudiantes;

import Mundo.Alumno;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sistemas
 */
public class ProyectoEstudiantes {

    public static void main(String[] args) {
        
        // Función que permite leer la opción del usuario
        Scanner lector = new Scanner(System.in);
        
        // Bandera que permite terminar el programa
        boolean activo = true;
        
        // Bandera que permite terminar el bucle 'while' utilizado en la opcion 1.
        boolean end;
                
        ArrayList <Alumno> misAlumnos = new ArrayList<Alumno>();
        
        do{
        System.out.println("-----------MENU DE OPCIONES-----------");
        System.out.println("1. Insertar alumno");
        System.out.println("2. Eliminar alumno");
        System.out.println("3. Modificar alumno");
        System.out.println("4. Consultar alumno");
        System.out.println("5. Terminar programa");
        System.out.println("--------------------------------------");
        
        int opcion = lector.nextInt();
        
            switch (opcion) {
                case 1:
                    
                    // Iniciamos la bandera en true para ejecutar el bucle 'while'
                    end = true;
                    
                    // Empleamos un bucle 'while' para solicitar nuevamente el dato en caso de que no sea válido.
                    while(end == true){
                        
                    try {
                        
                        // Variable utilizada para verificar si la cédula ya está registrada.
                        boolean inUse = false;
                        
                        System.out.println("");
                        System.out.println("Introduce la cedula del alumno");
                        int cedula = lector.nextInt();
                        
                        /*
                        Proceso utilizado para comprobar la existencia previa de la cédula ingresada
                        */
                        for (Alumno alumno : misAlumnos) {
                            if(alumno.getCedula() == cedula){
                                inUse = true;
                            }
                            
                        }
                            
                        if (inUse != true) {
                                                       
                            System.out.println("------------------------------");
                           
                            System.out.println("Introduce el nombre del alumno");
                            String nombre = lector.next();
                            if (nombre.matches(".*[0-9].*")) {
                                throw new InputMismatchException("El valor ingresado es incorrecto.");
                            }
                            
                            System.out.println("------------------------------");
                            System.out.println("Introduce el apellido del alumno");
                            String apellido = lector.next();
                            if (apellido.matches(".*[0-9].*")) {
                                throw new InputMismatchException("El valor ingresado es incorrecto.");
                            }
                            
                            System.out.println("------------------------------");
                            System.out.println("Introduce el semestre del Alumno");
                            int semestre = lector.nextInt();
                            
                            System.out.println("------------------------------");
                            System.out.println("Introduce el correo del alumno");
                            String correo = lector.next();
                            
                            System.out.println("------------------------------");
                            System.out.println("Introduce el celular del alumno");
                            int celular = lector.nextInt();
                            
                            System.out.println("------------------------------");

                            System.out.println("");
                            System.out.println("Alumno agregado exitosamente.");
                            System.out.println("");
                            System.out.println("------------------------------");
                            System.out.println("");
                            

                            //Se crea un objeto para guardar la información de cada alumno
                            Alumno a = new Alumno(cedula, nombre, apellido, semestre, correo, celular);

                            //Almacenamos el alumno en nuestro array
                            misAlumnos.add(a);
                            
                            
                            
                        
                        }
                        else{
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
                    
                    break;
                    
                case 2:
                    System.out.println("");
                    System.out.println("opcion dos");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Ingrese la cédula del Alumno que desea modificar:");
                    int cedulaModificar = lector.nextInt();
    
                    boolean encontrado = false;
    
                    for (Alumno alumno : misAlumnos) {
                        if (alumno.getCedula() == cedulaModificar) {
                            encontrado = true;

                            // Mostrar los campos actuales del estudiante
                            System.out.println("Datos actuales del Alumno:");
                            System.out.println("Cédula: " + alumno.getCedula());
                            System.out.println("Nombre: " + alumno.getNombre());
                            System.out.println("Apellido: " + alumno.getApellido());
                            System.out.println("Semestre: " + alumno.getSemestre());
                            System.out.println("Correo: " + alumno.getCorreo());
                            System.out.println("Celular: " + alumno.getCelular());
                            System.out.println("");

                            try{
                                
                            // Solicitar los nuevos valores para los campos que se desean modificar
                            System.out.println("Ingrese la nueva cedula del Alumno (o enter para mantener el actual):");
                            int nuevaCedula;
                            String nuevaCedulaP = lector.nextLine();
                            nuevaCedulaP = lector.nextLine();
                            if (!nuevaCedulaP.isEmpty()) {
                                nuevaCedula = Integer.parseInt(nuevaCedulaP);
                                alumno.setCedula(nuevaCedula);
                            }else{
                                int sinCambio = alumno.getCedula();
                                alumno.setCedula(sinCambio);
                            }
                            
                            System.out.println("Ingrese el nuevo nombre del Alumno (o enter para mantener el actual):");
                            String nuevoNombre = lector.nextLine();
                            nuevoNombre = lector.nextLine();
                            if (!nuevoNombre.isEmpty()) {
                                alumno.setNombre(nuevoNombre);
                            }else{
                                String sinCambio = alumno.getNombre();
                                alumno.setNombre(sinCambio);
                            }
                            
                            System.out.println("Ingrese el nuevo apellido del Alumno (o enter para mantener el actual):");
                            String nuevoApellido = lector.nextLine();
                            if (!nuevoApellido.isEmpty()) {
                                alumno.setApellido(nuevoApellido);
                            }else{
                                String sinCambio = alumno.getApellido();
                                alumno.setApellido(sinCambio);
                            }
                            
                            System.out.println("Ingrese el nuevo semestre del Alumno (o enter para mantener el actual):");
                            int nuevoSemestre;
                            String nuevoSemestreP = lector.nextLine();
                            if (!nuevoSemestreP.isEmpty()) {
                                nuevoSemestre = Integer.parseInt(nuevoSemestreP);
                                alumno.setSemestre(nuevoSemestre);
                            }else{
                                int sinCambio = alumno.getSemestre();
                                alumno.setSemestre(sinCambio);
                            }
                            
                            System.out.println("Ingrese el nuevo correo electrónico del Alumno (o enter para mantener el actual):");
                            String nuevoCorreo = lector.nextLine();
                            if (!nuevoCorreo.isEmpty()) {
                                alumno.setCorreo(nuevoCorreo);
                            }else{
                                String sinCambio = alumno.getCorreo();
                                alumno.setCorreo(sinCambio);
                            }
                            
                            System.out.println("Ingrese el nuevo celular del Alumno (o enter para mantener el actual):");
                            int nuevoCelular;
                            String nuevoCelularP = lector.nextLine();
                            if (!nuevoCelularP.isEmpty()) {
                                nuevoCelular = Integer.parseInt(nuevoCelularP);
                                alumno.setCelular(nuevoCelular);
                            }else{
                                int sinCambio = alumno.getCelular();
                                alumno.setCelular(sinCambio);
                            }

                            // Mostrar un mensaje de éxito
                            System.out.println("Estudiante modificado exitosamente.");
                            } catch (NumberFormatException e) {
                                                
                                System.out.println("");
                                System.out.println("========================================");
                                System.out.println("Error: Debes ingresar valores válidos.");
                                System.out.println("Presione Enter para volver al MENÚ");
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
                            break;
                case 4:
                    if (misAlumnos.isEmpty()) {
                            System.out.println("No hay ningún estudiante en el sistema.");
                        }else{
                        System.out.println("Registro Académico de Alumnos");
                        System.out.println("=================================");

                    for (int i = 0; i < misAlumnos.size(); i++) {
                        Alumno alumno = misAlumnos.get(i);
                        System.out.println("----------------------------");
                        System.out.println("Alumno: " + (i+1));
                        System.out.println("Cédula: " + alumno.getCedula());
                        System.out.println("Nombre: " + alumno.getNombre());
                        System.out.println("Apellido: " + alumno.getApellido());
                        System.out.println("Semestre: " + alumno.getSemestre());
                        System.out.println("Correo: " + alumno.getCorreo());
                        System.out.println("Celular: " + alumno.getCelular());
                        System.out.println("----------------------------");
                        System.out.println("");
                        lector.nextLine(); // Limpiar el búfer de entrada
                    }
                    }
                                     
                    break;
                    
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
}
