package apartado3;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan
 */
public class ServidorHilo2 extends Thread {
    
    private Socket s1=null;
    private ArrayList<Socket> sockets=null;
    private ServerSocket ss1=null;
    
    public  ServidorHilo2(Socket s1,ArrayList<Socket> sockets,ServerSocket ss1){
        this.s1=s1;
        this.sockets=sockets;
        this.ss1=ss1;
    }
    
    public void run(){
        
        try{
         for(Socket s : sockets){
                    s.close();
                }
                ss1.close();
                
        }catch(IOException e){
            
        }
        
    }
    
    
    
}
