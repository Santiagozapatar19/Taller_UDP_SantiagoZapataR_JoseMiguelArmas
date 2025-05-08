package util;

import java.io.IOException;
import java.net.*;

public class UDPConnection extends Thread {
    private DatagramSocket socket;
    private int port;

    public UDPConnection(int port){
        this.port = port;
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        socket.close();
    }

    @Override
    public void run(){
        try {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("Esperando mensajes en puerto " + port + "...");

            while (true) {
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido de " + packet.getAddress() + ": " + msg);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendDatagram(String msg, String ipDest, int portDest){
        new Thread(() -> {
            try {
                InetAddress ip = InetAddress.getByName(ipDest);
                byte[] data = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, ip, portDest);
                socket.send(packet);
                System.out.println("Mensaje enviado a " + ipDest + ":" + portDest);
            } catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }
}