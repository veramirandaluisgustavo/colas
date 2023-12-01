package com.SERVER_CONTROLLER.CONTROLLER;

import com.SERVER_CONTROLLER.CONTROLLER.server.Servidor;
import com.SERVER_CONTROLLER.CONTROLLER.server.ServidorTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControllerApplication {


	public static void main(String[] args) {
		

		SpringApplication.run(ControllerApplication.class, args);
        int puertoTCP = 12345; // Puerto para el servidor TCP

        //Iniciar el servidor TCP en un hilo separado
        ServidorTCP serv=ServidorTCP.getServidor();
        serv.setPuerto(puertoTCP);
        Thread servidorTCPThread = new Thread(serv);
        servidorTCPThread.start();
        //System.out.println("El hash del servidor es: "+serv.hashCode());
        

		try {
            servidorTCPThread.join();
            // Espera de otros hilos de servicios si es necesario
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
	}

}
