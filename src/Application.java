//// Justerat design och ändrat knapp från “alla kunders konton” till “alla konton”. (vi ska skriva ut antal konton inkl saldo för en person enligt uppgiften) ///HS 191127

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Application {

    private JFrame frame;
    private JTextField textName;
    private JTextField textPNbr;
    private JLabel lblResponse;
    
    private Controller controller;    
    private PersonRegister personRegister;
    private JTextField textKontoNr;
    private JTextField textSaldo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Application window = new Application();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Application() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1244, 690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        personRegister = new PersonRegister();
        controller = new Controller(personRegister, frame);
        
        lblResponse = new JLabel("");
        lblResponse.setBounds(64, 521, 69, 20);
        frame.getContentPane().add(lblResponse);
        
        JLabel lblinfo = new JLabel("Personuppgifter ");
        lblinfo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblinfo.setBounds(68, 42, 164, 20);
        frame.getContentPane().add(lblinfo);
        
        JLabel lblNamn = new JLabel("Namn");
        lblNamn.setBounds(68, 120, 69, 20);
        frame.getContentPane().add(lblNamn);
        
        textName = new JTextField();
        textName.setBounds(219, 117, 146, 26);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        JLabel lblPnbr = new JLabel("Personnummer");
        lblPnbr.setBounds(68, 179, 117, 20);
        frame.getContentPane().add(lblPnbr);
        
        textPNbr = new JTextField();
        textPNbr.setBounds(219, 176, 146, 26);
        frame.getContentPane().add(textPNbr);
        textPNbr.setColumns(10);
        
        JLabel lblVal = new JLabel("Val");
        lblVal.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblVal.setBounds(64, 272, 69, 20);
        frame.getContentPane().add(lblVal);
        
        JButton btnHitta = new JButton("Hitta person");
        btnHitta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pNbr = textPNbr.getText();
                String[] tmpPerson = controller.findPerson(pNbr);
                if(tmpPerson != null) {
                    lblResponse.setText("Händelse: Personen hittad");
                    if(tmpPerson.length==2) {
                        textPNbr.setText(tmpPerson[0]);
                        textName.setText(tmpPerson[1]);
                    }
                }
                else {
                    lblResponse.setText("Händelse: Personen hittades inte");
                }
            }
        });
        btnHitta.setBounds(64, 387, 181, 29);
        frame.getContentPane().add(btnHitta);
        
        JButton btnLggTillNy = new JButton("L\u00E4gg till ny person");
        btnLggTillNy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pNbr = textPNbr.getText();
                String name = textName.getText();
                controller.addPerson(pNbr, name);
                lblResponse.setText("Händelse: Personen lades till");
            }
        });
        btnLggTillNy.setBounds(64, 332, 181, 29);
        frame.getContentPane().add(btnLggTillNy);
        
        JButton btnRadera = new JButton("Radera person");
        btnRadera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String PNbr = textPNbr.getText();
                controller.removePerson(PNbr);
                lblResponse.setText("Händelse: Personen togs bort");
                textPNbr.setText("");
                textName.setText("");

            }
        });
        btnRadera.setBounds(64, 440, 181, 29);
        frame.getContentPane().add(btnRadera);
        
        lblResponse = new JLabel("");
        lblResponse.setBounds(68, 586, 294, 20);
        frame.getContentPane().add(lblResponse);
        
        textKontoNr = new JTextField();
        textKontoNr.setBounds(593, 107, 146, 26);
        frame.getContentPane().add(textKontoNr);
        textKontoNr.setColumns(10);
        
        JLabel lblKontonummer = new JLabel("Kontonummer");
        lblKontonummer.setBounds(455, 113, 111, 14);
        frame.getContentPane().add(lblKontonummer);
        
        JButton btnLggTillKonto = new JButton("Lägg till konto");
        btnLggTillKonto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLggTillKonto.setBounds(455, 332, 193, 29);
        frame.getContentPane().add(btnLggTillKonto);
        
        JButton btnSkrivUtAlla = new JButton("Skriv ut alla konton");
        btnSkrivUtAlla.setBounds(455, 440, 193, 29);
        frame.getContentPane().add(btnSkrivUtAlla);
        
        JLabel lblKontouppgifter = new JLabel("Kontouppgifter");
        lblKontouppgifter.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblKontouppgifter.setBounds(455, 42, 128, 20);
        frame.getContentPane().add(lblKontouppgifter);
        
        JLabel lblSaldo = new JLabel("Saldo");
        lblSaldo.setBounds(455, 169, 69, 20);
        frame.getContentPane().add(lblSaldo);
        
        textSaldo = new JTextField();
        textSaldo.setBounds(593, 166, 146, 26);
        frame.getContentPane().add(textSaldo);
        textSaldo.setColumns(10);
        
        JButton btnRaderaKonto = new JButton("Radera konto");
        btnRaderaKonto.setBounds(455, 387, 193, 29);
        frame.getContentPane().add(btnRaderaKonto);
    }
}

