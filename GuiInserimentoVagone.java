import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GuiInserimentoVagone extends JFrame {

    private JLabel matricola;
    private JTextField matricolaText;
    private JLabel lunghezza;
    private JTextField lunghezzaText;
    private JLabel peso;
    private JTextField pesoText;
    private JLabel type;
    private JTextField typeText;
    private JLabel max;
    private JTextField maxText;
    private JLabel attuale;
    private JTextField attualeText;
    private JButton invio;
    private Treno t;
    private TrenoGUI superGui;


    /**
     * costruttore
     * @param treno
     * @param tg gui del treno
     */
    public GuiInserimentoVagone(Treno treno,TrenoGUI tg) {
        creazioneGUI();
        superGui=tg;
        t= treno;
    }

    /**creazione della gui per l'inserimento dati */
    public void creazioneGUI() {
        setSize(300, 400);
        setLocation(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//chiude solo la finestra e non termina il programma
        setLayout(new BorderLayout());
        //creazionio dei pannelli e dell zone di testo per l'inserimento dati
        JPanel panelCentre = new JPanel();
        panelCentre.setLayout(new BoxLayout(panelCentre,BoxLayout.Y_AXIS));

        matricola = new JLabel("Matricola",SwingConstants.LEFT);//allinea a sinistra i testi
        matricolaText = new JTextField(1);
    
        lunghezza = new JLabel("Lunghezza(cm)",SwingConstants.LEFT);
        lunghezzaText = new JTextField(1);

        peso = new JLabel("Peso(tonnellate)",SwingConstants.LEFT);
        pesoText = new JTextField(1);
       
        type = new JLabel("Type(merci,passeggieri)",SwingConstants.LEFT);
        typeText = new JTextField(1);

        max = new JLabel("Max(passeggieri/peso trasportabile)",SwingConstants.LEFT);
        maxText = new JTextField(1);


        attuale = new JLabel("Attuale(peso/passeggieri a bordo)",SwingConstants.LEFT);
        attualeText = new JTextField(1);

        //aggiunta dei componenti al pannello centrale
        panelCentre.add(matricola);
        panelCentre.add(matricolaText);
        panelCentre.add(lunghezza);
        panelCentre.add(lunghezzaText);
        panelCentre.add(peso);
        panelCentre.add(pesoText);
        panelCentre.add(type);
        panelCentre.add(typeText);
        panelCentre.add(max);
        panelCentre.add(maxText);
        panelCentre.add(attuale);
        panelCentre.add(attualeText);
        //creazione del bottone per l'invio dei dati
        JPanel panelButton = new JPanel();
        invio = new JButton("Invio");
        invio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //controllo se i campi sono pieni
                if (!matricolaText.getText().equals("") && !lunghezzaText.getText().equals("") && !pesoText.getText().equals("") && !typeText.getText().equals("") && !maxText.getText().equals("") && !attualeText.getText().equals("")) {
                    //controllo che non ci siono parametri negativi
                    if(Integer.parseInt(lunghezzaText.getText()) >= 0 && Double.parseDouble(pesoText.getText()) >= 0 && Integer.parseInt(maxText.getText()) >=0 && Integer.parseInt(attualeText.getText()) >=0){
                        //controllo che la capienza massima sia maggiore di quella attuale
                        if(Integer.parseInt(maxText.getText()) >= Integer.parseInt(attualeText.getText())){
                            //controllo tipo di vagone
                            if (typeText.getText().equals("merci")) {
                                    VagoneMerci v = new VagoneMerci(matricolaText.getText(), Integer.parseInt(lunghezzaText.getText()), Double.parseDouble(pesoText.getText()), Double.parseDouble(maxText.getText()), Double.parseDouble(attualeText.getText()));
                                    t.addVagoneMerci(v);
                                    superGui.aggiornaGui();
                                    dispose();
                            } else {
                                if(typeText.getText().equals("passeggeri")){
                                        VagonePasseggeri v = new VagonePasseggeri(matricolaText.getText(), Integer.parseInt(lunghezzaText.getText()), Double.parseDouble(pesoText.getText()), Integer.parseInt(maxText.getText()), Integer.parseInt(attualeText.getText()));
                                        t.addVagonePasseggieri(v);
                                        superGui.aggiornaGui();
                                        dispose();
                                }else{
                                    JOptionPane.showMessageDialog(null,"tipo di vagone inesistente","error",JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"la capacità attuale del vagone supera le capacità massima","error",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"errore: numero negativo","error",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        //aggiunta dei componenti al frame
        panelButton.add(invio);
        add(panelCentre, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);

        setVisible(true);
    }
} 