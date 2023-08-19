/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyectoestudiantes;

import Mundo.Alumno;
import java.util.ArrayList;
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
                    System.out.println("Introduce la cedula del alumno");
                    int cedula = lector.nextInt();
                    System.out.println("Introduce el nombre del alumno");
                    lector.next();
                    String nombre = lector.next();
                    System.out.println("Introduce el apellido del alumno");
                    String apellido = lector.next();
                    System.out.println("Introduce el semestre del estudiante");
                    int semestre = lector.nextInt();
                    System.out.println("Introduce el correo del alumno");
                    String correo = lector.next();
                    System.out.println("Introduce el celular del alumno");
                    int celular = lector.nextInt();
                    
                    //Se crea un objeto para guardar la información de cada alumno
                    //Alumno a = new Alumno(cedula, nombre, apellido, semestre, correo, celular);
                    Alumno a = new Alumno();
                    
                    a.setCedula(cedula);
                    a.setNombre(nombre);
                    a.setApellido(apellido);
                    a.setSemestre(semestre);
                    a.setCorreo(correo);
                    a.setCelular(celular);
                    
                    
                    break;
                case 2:
                    System.out.println("opcion dos");
                    break;
                case 3:
                    System.out.println("opcion tres");
                    break;
                case 4:
                    System.out.println("opcion cuatro");
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
