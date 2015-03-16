/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartado2;

import examenprocesos2evjuan.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Servidor {

    public static ArrayList<Alumnos> usuarios = new ArrayList();
    public static ArrayList<String> conectados = new ArrayList();

    public static void main(String[] args) {
        usuarios.add(new Alumnos("juan"));
        usuarios.add(new Alumnos("david"));
        usuarios.add(new Alumnos("carlos"));
        usuarios.add(new Alumnos("Katy"));
        String respuesta = "";
        String respuesta2 = "";
        Alumnos alumno = null;
        Scanner sc = new Scanner(System.in);
        BufferedReader entrada = null;
        PrintWriter salida = null;
        ServerSocket ss1 = null;
        Socket s1 = null;
        boolean resp = false;
        try {
            ss1 = new ServerSocket(5000);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Arrancado");
        while (!resp) {
            try {
                s1 = ss1.accept();
                System.out.println("Conectado ");
                entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));

                if (entrada.readLine().equalsIgnoreCase("cliente3")) {
                    ServidorHilo3 s3 = new ServidorHilo3(conectados, s1);
                    s3.start();
                } else {
                    ServidorHilo s = new ServidorHilo(s1, usuarios, conectados);
                    s.start();
                }

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            ss1.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
