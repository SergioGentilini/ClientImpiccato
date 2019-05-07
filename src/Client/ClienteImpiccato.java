package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteImpiccato {
    private Socket socketCliente;

    public void connettiti(String ip, int porta) {
        try {
            socketCliente = new Socket(InetAddress.getByName(ip), porta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scrivi(String testo) {
        try {
            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);

            out.write(testo);
            out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leggi() {
        String testo = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            testo = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testo;
    }
}
