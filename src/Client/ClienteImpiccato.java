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

    /*public void scrivi(String testo) {
        try {
            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);

            out.write(testo);
            out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leggi() {
        String testo = "<html>";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            while (in.ready()) {
                testo += in.readLine() + "<br/>";
            }

            testo += "</html>";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testo;
    }*/

    public String scriviELeggi(String testo) {
        String testoRitorno = "<html>";

        try {
            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            out.write(testo);
            out.println();

            while (!in.ready()) ;

            while (in.ready()) {
                testoRitorno += in.readLine() + "<br/>";
            }

            testoRitorno += "</html>";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return testoRitorno;
    }
}
