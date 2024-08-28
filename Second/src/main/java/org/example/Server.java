package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Manzana", "Fruta"));
        products.add(new Product(2L, "Uva", "Fruta"));
        products.add(new Product(3L, "Moto", "Vehiculo"));
        products.add(new Product(4L, "Auto", "Vehiculo"));

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("-> Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Object object = input.readObject();

            System.out.println("Mensaje recibido: " + object.toString());

            output.writeObject(products);

            socket.close();
        }
    }
}