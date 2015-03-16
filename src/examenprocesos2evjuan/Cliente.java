/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenprocesos2evjuan;

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
public class Cliente {

    public static void main(String[] args) {

        String res = "";
        String usuario = "";
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
            System.out.println("Introduce el alumno");
            usuario = sc.nextLine();
            salida.println(usuario);
            if(entrada.readLine().equalsIgnoreCase("error")){
                fin=true;
            }
      

             while (fin==false){
                System.out.println("Que accion quieres realizar\n1-Ver todas las notas\n2-Anadir nota\n3-Ver Media\n0-Salir");
                respuesta = sc.nextLine();

                switch (respuesta) {

                    case "1":
                        res = respuesta + "/";
                        break;
                    case "2":
                        System.out.println("Introduce la nota que quieres añadir");
                        String nota = sc.nextLine();
                        res = respuesta + "/" + nota;
                        break;
                    case "3":
                        
                        res = respuesta + "/";
                        break;
                   
                    case "0":
                        res = respuesta + "/";
                        fin=true;
                        break;

                }
                salida.println(res);

                System.out.println(entrada.readLine());

            } 
            

            salida.close();
            entrada.close();
            s1.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
