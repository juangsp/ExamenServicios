/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartado3;

import examenprocesos2evjuan.*;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Alumnos {

    private String alumno;
    private ArrayList<String> notas;

    public Alumnos(String alumno) {
        this.alumno = alumno;
        notas = new ArrayList();
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public synchronized String listar() {
        String s = "Notas: ";
        for (int i = 0; i < notas.size(); i++) {
            s +=notas.get(i)+"-";
        }
        return s;
    }

    public synchronized int media() {
        int numero = 0;
        int media = 0;
        for (int i = 0; i < notas.size(); i++) {
            numero = numero + Integer.parseInt(notas.get(i));
        }
        media = numero / notas.size();

        return media;

    }

    public synchronized String anadir(String s) {
        notas.add(s);
        return "Operacion realizada con exito";
    }

}
