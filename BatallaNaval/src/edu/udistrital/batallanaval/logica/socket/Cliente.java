package edu.udistrital.batallanaval.logica.socket;

import edu.udistrital.batallanaval.enums.Comando;
import java.io.*;
import java.net.*;

public class Cliente implements Runnable {

    private boolean running;
    private String hostName;
    private int puerto;
    private Thread hilo;
    private DataInputStream flujoLectura;
    private DataOutputStream flujoEscritura;
    private String nombreCliente;
    private Comando comando;

    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        running = false;
    }

    public void iniciarCliente(String hostName, int puerto) {
        this.hostName = hostName;
        this.puerto = puerto;
        running = true;
        hilo = new Thread(this);
        hilo.start();
        System.out.println("Cliente.iniciarCliente: Starting client in hostname: " + hostName + " puerto: " + puerto);
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(hostName, puerto)) {
            //ENVIAR EL MENSAJE CON(Saenz)
//            comando = Comando.CONECTAR;
            flujoEscritura = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            flujoEscritura.writeUTF("BNAVAL:" + Comando.CONECTAR.getNombre() + "," + nombreCliente);
            flujoEscritura.flush();

            System.out.println("Cliente: ClientSocket has started succesfully");
        } catch (IOException e) {
            System.out.println("Cliente: El socket del cliente NO ha iniciado satisfactoriamente");
            System.exit(1);
        }
    }
}