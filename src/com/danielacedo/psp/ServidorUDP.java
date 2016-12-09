package com.danielacedo.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServidorUDP {
	
	public ServidorUDP(){
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(Constantes.PUERTO_SERVIDOR, InetAddress.getByName(Constantes.HOST_SERVIDOR));
			
			DatagramPacket dato = new DatagramPacket(new byte[255], 255);
			
			//Servicio de red en bucle infinito
			while(true){
				System.out.println("Escuchando en el puerto: "+socket.getLocalPort());
				socket.receive(dato);
				
				DatoUDP udp = DatoUDP.fromByteArray(dato.getData());
				
				System.out.println(udp.toString());
			}
			
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new ServidorUDP();
	}
}
