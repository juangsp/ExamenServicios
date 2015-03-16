package apartado3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Cliente2 {
      public static void main(String[] args) {
        int contador = 0;
        boolean resp = false;
        boolean iniciar=true;
        String respuesta;
        int respuesta2;
        Scanner sc = new Scanner(System.in);
        PrintWriter salida = null;
        BufferedReader entrada = null;
        Socket s1 = null;
        String usuario;
        int clave;
        try {

            s1 = new Socket("localhost", 5000);

            salida = new PrintWriter(s1.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            
            salida.println("cliente2");
            
            salida.close();
            entrada.close();
            s1.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
