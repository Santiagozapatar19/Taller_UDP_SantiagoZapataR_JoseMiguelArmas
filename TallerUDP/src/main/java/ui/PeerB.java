package ui;

import util.UDPConnection;

// PeerB.java
public class PeerB {
    public static void main(String[] args) {
        UDPConnection connection = new UDPConnection(5001); // Puerto para recibir
        connection.start(); // Inicia hilo de recepción

        // Esperar un poco para asegurar que está escuchando
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        connection.sendDatagram("Hola desde PeerB", "127.0.0.1", 5000); // Enviar a PeerA
    }
}
