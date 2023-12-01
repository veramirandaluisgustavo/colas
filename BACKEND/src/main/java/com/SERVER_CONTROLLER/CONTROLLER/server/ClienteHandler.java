package com.SERVER_CONTROLLER.CONTROLLER.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.http.WebSocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.SERVER_CONTROLLER.CONTROLLER.handler.ChatHandler;

class ClienteHandler implements Runnable {
    private Socket clientSocket;

    public ClienteHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Lógica de comunicación con el cliente aquí
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Mensaje del cliente: " + line);

                // WebSocketSession session = ChatHandler.getSesion(line);
                // if (session != null) {
                //     String men = line;
                //     System.out.println(men);
                //     String data[] = men.split(":");
                //     session.sendMessage(new TextMessage(data[1]));
                    
                // }
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}