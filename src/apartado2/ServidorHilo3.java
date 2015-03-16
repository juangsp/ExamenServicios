/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartado2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class ServidorHilo3 extends Thread {

    private Socket s1 = null;
    private ArrayList<String> conectados = null;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;
    private String respuesta="";

    public ServidorHilo3(ArrayList<String> conectados, Socket s1) {
        this.s1 = s1;
        this.conectados = conectados;

    }

    public void run() {
        try {
            entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            salida = new PrintWriter(s1.getOutputStream(), true);
            
            for(int i=0;i<conectados.size();i++){
                respuesta=respuesta+"/"+conectados.get(i);
                
            }
            salida.println(respuesta);
            entrada.close();
            salida.close();
            s1.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo3.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }

}
