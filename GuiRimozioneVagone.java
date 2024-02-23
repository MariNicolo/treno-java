import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiRimozioneVagone extends JFrame{
    private JLabel matricola;
    private JTextField matricolaText;
    private Treno treno;
    private JButton invio;
    private TrenoGUI superGui;

    /**
     * costruttore
     * @param t treno
     * @param tg gui del treno
     */
    public GuiRimozioneVagone(Treno t,TrenoGUI tg){
        treno=t;
        superGui=tg;
        creazioneGUI();
    }

    /**creazione della GUI */
    public void creazioneGUI(){
        setSize(200, 200);
        setLocation(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        //creazione del pannello e della zona di tyesto per l'inserimento dei dati
        JPanel panelCentre = new JPanel();
        panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.Y_AXIS));

        matricola = new JLabel("Matricola");
        matricolaText = new JTextField(1);
        
        //aggiunta dei componenti al pannello centrale
        panelCentre.add(matricola);
        panelCentre.add(matricolaText);

        //creazione del bottone e dell'ascolto dell'evento per la rimozione del vagone
        invio = new JButton("Invio");
        invio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int stato=treno.rimuoviVagone(matricolaText.getText());
                if(stato==-1){
                    JOptionPane.showMessageDialog(null,"non esiste treno con quella matricola","error",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    superGui.aggiornaGui();//aggiorna la gui principale
                    dispose();//chiude il secondo frame
                }
            }
            
        });
        //aggiunta componenti al frame
        add(panelCentre, BorderLayout.CENTER);
        add(invio, BorderLayout.SOUTH);
        setVisible(true);
    }
}
