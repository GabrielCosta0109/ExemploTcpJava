/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.util.Scanner;
import java.net.*;
import java.io.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("ec2-54-158-196-18.compute-1.amazonaws.com", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            while(0 == 0) {
            // ENVIO DE MENSAGEM
            Scanner scan = new Scanner(System.in);
            
            String msg = scan.nextLine();
            byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");
            
            // RECEBIMENTO DE MENSAGEM
            byte[] bufRec = new byte[20]; // buffer de recepção

            System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
            is.read(bufRec); // Operação bloqueante (aguardando chegada de dados)
            System.out.println("[OK] ]");
            
            String msgRec = new String(bufRec); // Mapeando vetor de bytes recebido para String
            
            System.out.println("  Mensagem recebida: "+ msgRec);
            
            } 
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}
