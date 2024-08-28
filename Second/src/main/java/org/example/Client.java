package org.example;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        int port = 8080;
        String host = "127.0.0.1";

        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            output.writeObject("Hola, soy el cliente. Dame por favor el listado de productos");

            Object message = input.readObject();

            System.out.println("Mensaje del servidor: " + message.toString());

            output.close();
            input.close();
            socket.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
