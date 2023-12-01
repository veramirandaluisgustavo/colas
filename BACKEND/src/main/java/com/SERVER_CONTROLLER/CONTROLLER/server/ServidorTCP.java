package com.SERVER_CONTROLLER.CONTROLLER.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP implements Runnable {
    private int puerto;
    private static  ServidorTCP mServidor;

    private  ServidorTCP() {
        
    }
    public static ServidorTCP getServidor() {
        if(mServidor==null){
            mServidor=new ServidorTCP();
        }
        return mServidor;
    }
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor TCP escuchando en el puerto " + puerto);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                Thread clientThread = new Thread(new ClienteHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}