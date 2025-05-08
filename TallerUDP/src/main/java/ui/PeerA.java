package ui;

import util.UDPConnection;

// PeerA.java
public class PeerA {
    public static void main(String[] args) {
        UDPConnection connection = new UDPConnection(6000); // Puerto para recibir
        connection.start(); // Inicia hilo de recepción

        // Esperar un poco para asegurar que está escuchando
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        connection.sendDatagram("Hola desde PeerA", "127.0.0.1", 6001); // Enviar a PeerB
    }
}