package com.danielacedo.psp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DatoUDP implements Serializable {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	public String cadenaTexto ;
	public Integer cadenaNumero;
	
	public DatoUDP(String cadena, Integer numero){
		this.cadenaTexto = cadena;
		this.cadenaNumero = numero;
	}
	
	//Serializador
	public byte[] toByteArray(){
		//Se hace la conversion usando un ByteArrayOutputStream y
		//un objeto ObjectOutputStream
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(bytes);
			os.writeObject(this);
			
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return bytes.toByteArray();
	}
	
	//Deserializador
	public static DatoUDP fromByteArray(byte[] bytes){
		ByteArrayInputStream bytesS = new ByteArrayInputStream(bytes);
		ObjectInputStream is;
		DatoUDP udp = null;
		
		try {
			is = new ObjectInputStream(bytesS);
			udp = (DatoUDP)is.readObject();
			is.close();
		}catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		return udp;
	}
	
	@Override
	public String toString(){
		return "Cadena: "+cadenaTexto+". Numero: "+cadenaNumero;
	}
	
}
