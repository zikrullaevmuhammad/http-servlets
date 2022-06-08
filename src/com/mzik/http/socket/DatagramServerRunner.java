package com.mzik.http.socket;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class DatagramServerRunner {

    public static void main(String[] args) throws IOException {
        try (var datagramServer = new DatagramSocket(7777)) {
            byte[] buffer = new byte[512];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            datagramServer.receive(packet);

            System.out.println(new String(buffer));
        }
    }
}
