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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Cliente3 {
    public static void main(String[] args) {
        
       
        String respuesta;
        Scanner sc = new Scanner(System.in);
        PrintWriter salida = null;
        BufferedReader entrada = null;
        Socket s1 = null;
        boolean fin=false;
        try {

            s1 = new Socket("localhost", 5000);

            salida = new PrintWriter(s1.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            
            salida.println("cliente3");
            
            System.out.println("Estan conectados:"+entrada.readLine());
      

            salida.close();
            entrada.close();
            s1.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
