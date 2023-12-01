package com.SERVER_CONTROLLER.CONTROLLER.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServidorHilo extends Thread{

    private DataOutputStream out;
    private DataInputStream in;
    public ServidorHilo(DataInputStream in,DataOutputStream out){
        this.in=in;
        this.out=out;
    }
    @Override
    public void run(){
        try {
            String dato = in.readUTF();
            System.out.println(dato);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
