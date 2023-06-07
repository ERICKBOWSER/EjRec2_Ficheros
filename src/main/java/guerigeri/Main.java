/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerigeri;

import static guerigeri.FichaDomino.generarDominoCompleto;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author guerig
 */
public class Main {
    public static void main(String[] args) {
        
        Set<FichaDomino> lista = new TreeSet(); // El set no permite valores duplicados pero al estar los datos en diferente posiciones tampoco las incluye
        lista = Ficheros.leer("domino.txt");
        
//        Ficheros.leer("domino.txt");
        
        for (FichaDomino fichaDomino : lista) {
            System.out.println(fichaDomino);
        }
        
        // Generar domino completo                
        List<FichaDomino> dominoCompleto = new ArrayList();
        dominoCompleto = generarDominoCompleto();
        
        Ficheros.escribir("dominoCompleto.txt", dominoCompleto);
        
        System.out.println("\tDomino completo: ");
        dominoCompleto.forEach(System.out::println);
        
    }
}
