package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacciaGrafica extends JFrame {
    private ClienteImpiccato clienteImpiccato;
    public InterfacciaGrafica(ClienteImpiccato clImp) throws HeadlessException {
        clienteImpiccato = clImp;

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimensioniSchermo = tk.getScreenSize();

        setSize(dimensioniSchermo.width/2, dimensioniSchermo.height/2);
        setLocation(dimensioniSchermo.width/4, dimensioniSchermo.height/4);

        creaPannelliConnessione();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void creaPannelliConnessione() {
        JPanel pannelloPrincipale = new JPanel();
        add(pannelloPrincipale);

        JTextField testo = new JTextField("Indirizzo IP", 10);
        pannelloPrincipale.add(testo);

        JLabel etichettaDuePunti = new JLabel(":");
        pannelloPrincipale.add(etichettaDuePunti);

        JTextField porta = new JTextField("Porta", 5);
        pannelloPrincipale.add(porta);

        JButton pulsanteAvvio = new JButton("Vai");
        pannelloPrincipale.add(pulsanteAvvio);

        ActionListener ascoltatorePulsante = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteImpiccato.connettiti(testo.getText(), Integer.parseInt(porta.getText()));

                remove(pannelloPrincipale);
                setVisible(false);
                creaPannelloImpiccato();
            }
        };

        pulsanteAvvio.addActionListener(ascoltatorePulsante);
    }

    private void creaPannelloImpiccato() {

        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new BorderLayout());
        add(pannelloPrincipale);

        JTextField testoInput = new JTextField(1);
        pannelloPrincipale.add(testoInput, BorderLayout.NORTH);

        JPanel pannelloOutput = new JPanel();
        pannelloPrincipale.add(pannelloOutput, BorderLayout.CENTER);

        JLabel testoOutput = new JLabel();
        pannelloOutput.add(testoOutput);

        setVisible(true);

        ActionListener mandaMessaggio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String testoDaInviare = testoInput.getText();
                testoInput.setText("");

                clienteImpiccato.scrivi(testoDaInviare);
            }
        };

        testoInput.addActionListener(mandaMessaggio);

        ActionListener riceviMessaggio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
    }
}
