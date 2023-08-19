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
                        
                        System.out.println("Introduce la cedula del alumno");
                        int cedula = lector.nextInt();
                        System.out.println("------------------------------");
                        System.out.println("Introduce el nombre del alumno");
                        String nombre = lector.next();
                        System.out.println("------------------------------");
                        System.out.println("Introduce el apellido del alumno");
                        String apellido = lector.next();
                        System.out.println("------------------------------");
                        System.out.println("Introduce el semestre del estudiante");
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
                    System.out.println("opcion dos");
                    break;
                case 3:
                    System.out.println("opcion tres");
                    break;
                case 4:
                    
                    System.out.println("Registro Académico de Estudiantes");
                    System.out.println("=================================");
                    
                    for (int i = 0; i < misAlumnos.size(); i++) {
                        Alumno alumno = misAlumnos.get(i);
                        System.out.println("Alumno: " + (i+1));
                        System.out.println("Cédula: " + alumno.getCedula());
                        System.out.println("Nombre: " + alumno.getNombre());
                        System.out.println("Apellido: " + alumno.getApellido());
                        System.out.println("Semestre: " + alumno.getSemestre());
                        System.out.println("Correo: " + alumno.getCorreo());
                        System.out.println("Celular: " + alumno.getCelular());
                        System.out.println("----------------------------");
                    }
                   
                    break;
                case 5:
                    System.out.println("opcion cinco");
                    break;
                default:
                    System.out.println("Debe seleccionar una de las opciones del menu");
                    break;
            }
                
                
        }while(activo == true);
        
        
    }
}
