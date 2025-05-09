package ui;

import util.UDPConnection;

// PeerB.java
public class PeerB {
    public static void main(String[] args) {
        UDPConnection connection = new UDPConnection(6001); // Puerto para recibir
        connection.start(); // Inicia hilo de recepción

        // Esperar un poco para asegurar que está escuchando
        try { Thread.sleep(10000); } catch (InterruptedException ignored) {}

        connection.sendDatagram("Hola desde PeerB", "172.20.10.2", 6000); // Enviar a PeerA
    }
}
