package com.SERVER_CONTROLLER.CONTROLLER.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor implements Runnable{
    private static Servidor mServidor;
    ServerSocket servidor = null;
        Socket sc = null;
        int puerto = 5000;
        DataInputStream in;
        DataOutputStream out;


    private Servidor() {

    }

    public synchronized static Servidor getServidor() {
        if (mServidor == null) {
            mServidor = new Servidor();
        }
        return mServidor;
    }
    @Override
    public void run() {
        

        try {
            servidor = new ServerSocket(puerto);

            System.out.println("SERVIDOR INICIADO");

            System.out.println("Ingreso");
            sc = servidor.accept();
            System.out.println("Acepto");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class ConnectionHandler implements Runnable{
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        public ConnectionHandler(Socket client){
                this.client =client;
        }

        @Override
        public void run() {
            
            try {
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msn =in.readLine();
                System.out.println("MENSAJE TCP : "+msn);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
