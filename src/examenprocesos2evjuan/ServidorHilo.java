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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class ServidorHilo extends Thread{
    String respuesta="";
    private Socket s1=null;
    private ArrayList<Alumnos> usuarios=null;
    private BufferedReader entrada=null;
    private PrintWriter salida=null;
    private Alumnos usuario=null;
    private boolean salir = false;
  
    public ServidorHilo(Socket s1,ArrayList<Alumnos> usuarios){
        this.s1=s1;
        this.usuarios=usuarios;
    }
    
    public void run(){
         try {
                entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                salida = new PrintWriter(s1.getOutputStream(), true);
                respuesta = entrada.readLine();
                usuario = buscarMiembro(respuesta);

                if (usuario == null) {
                    salida.println("error");
                    salir=true;
                    
                } else {
                    System.out.println("El usuario conectado es: " + usuario.getAlumno());
                     salida.println("correcto");

                }
               
               

                while (salir==false) {
                    String resp = "";
                    String[] instruccion = entrada.readLine().split("/");
                    System.out.println(instruccion[0]);

                    switch (instruccion[0]) {

                        case "1":
                            resp = usuario.listar();
                            break;

                        case "2":
                            resp = usuario.anadir(instruccion[1]);
                            break;

                        case "3":
                            resp = "Nota media:"+usuario.media();
                            break;

                        case "0":
                            salir = true;
                            resp = "Desconectado";
                            break;

                    }
                    salida.println(resp);

                }
                salida.close();
                entrada.close();
                s1.close();

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public  Alumnos buscarMiembro(String nombre) {
        Alumnos usuario = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getAlumno().equalsIgnoreCase(nombre)) {
                usuario = usuarios.get(i);
            }
        }

        return usuario;
    }
    
}
