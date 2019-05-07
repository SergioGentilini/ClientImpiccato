import Client.ClienteImpiccato;
import Client.InterfacciaGrafica;

public class Principale {
    public static void main(String[] args) {
        ClienteImpiccato clImp = new ClienteImpiccato();
        InterfacciaGrafica intGr = new InterfacciaGrafica(clImp);
    }
}
