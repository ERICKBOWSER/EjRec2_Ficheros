/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerigeri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author guerig
 */
public class Ficheros {
    public static Set<FichaDomino> leer(String nombre){
        // Fichero a leer con datos de ejemplo
        String idFichero = nombre;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        
        Set<FichaDomino> listaSet = new HashSet();

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO_8859_1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split("-");
                            
                
                // Condicional para que no lea la última linea vacía 
                if(!tokens[0].equals("") && !tokens[1].equals("")){
                    int token1 = Integer.parseInt(tokens[0].trim());
                    int token2 = Integer.parseInt(tokens[1].trim());
                    if(token1 < 7 && token2 < 7){
                    
                        FichaDomino ficha = new FichaDomino(Integer.parseInt(tokens[0].trim()), Integer.parseInt(tokens[1].trim())); // Usamos trim() para quitar todos los espacios innecesarios
                
                        listaSet.add(ficha);
                    }
                }
        
//                System.out.println("token 0: " + tokens[0]);
//                System.out.println("token 1: " + tokens[1]);

            }
            
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaSet;
    }
    
    public static void escribir(String nombre, List<FichaDomino> ficha){
        
        String ruta = nombre;
        
        // List para almacenar los datos 
        List<FichaDomino> fichas = new ArrayList();
        fichas = ficha;
               
        
        try(BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))){
              
            // Bucle para obtener cada dato de la lista
            for (FichaDomino f : ficha) {            
                    
                    flujo.write(f.toString()); // Convertimos los datos en String 
                    
                    flujo.newLine(); // Nueva linea 
            
                
            }
                // Guardar cambios en el disco
                flujo.flush();
                
            } catch(IOException e){
                System.out.println(e.getMessage());
            }   

    }
    
    
}
