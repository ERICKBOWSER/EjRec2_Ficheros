/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package guerigeri;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author guerig
 */
public class FichaDomino {           
    
    private int ficha1;
    private int ficha2;

    public FichaDomino(int ficha1, int ficha2) {
        this.ficha1 = ficha1;
        this.ficha2 = ficha2;
    }

    public int getFicha1() {
        return ficha1;
    }

    public void setFicha1(int ficha1) {
        this.ficha1 = ficha1;
    }

    public int getFicha2() {
        return ficha2;
    }

    public void setFicha2(int ficha2) {
        this.ficha2 = ficha2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ficha1).append("-");
        sb.append(ficha2);
        return sb.toString();
    }
    
    public static List<FichaDomino> generarDominoCompleto(){
        
        List <FichaDomino> lista = new ArrayList();
        
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                FichaDomino ficha = new FichaDomino(i, j);
                lista.add(ficha);
            }
        }
        return lista;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.ficha1;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FichaDomino other = (FichaDomino) obj;
        return this.ficha1 == other.ficha1;
    }
    
    
    
}
