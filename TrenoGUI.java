import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TrenoGUI extends JFrame{
    private Treno treno;
    private JPanel buttonPanel;//pannello con i quattro bottoni
    private JPanel contenitoreTreno;//pannello che conterra le img che formeranno il treno
    private JLabel result;//label contenente lo la lunghezza totale e il peso totale nel caso si clicchino i bottoni appositi
    private JButton addButton;//bottone per l'aggiunta di un vagone
    private JButton removeButton;//bottone per la rimozione di un vagone
    private JButton showLengthButton;//bottone che mostra la lunghezza sulla label result
    private JButton showWeightButton;//bottone che mostra il peso sulla label result
    /**
     * costruttore
     */
    public TrenoGUI(){
        treno= new Treno();
        createGUI();
        buttonListener();
    } 
    /**creazioe GUI del treno */
    public void createGUI() {
        setSize(700, 500);
        setLocation(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //creazione componenti
        buttonPanel = new JPanel();
        result = new JLabel();
        contenitoreTreno = new JPanel();
        //settaggio dei bordi e delle dimensioni e dei layout
        contenitoreTreno.setLayout(new FlowLayout());
        contenitoreTreno.setBorder(new LineBorder(Color.BLACK, 2));
        contenitoreTreno.setPreferredSize(new Dimension(600,400));

        result.setBorder(new LineBorder(Color.BLACK, 2));
        result.setPreferredSize(new Dimension(600,100));
        //creazione del pannello coi bottoni
        createButtonPannel();
        //aggiunta dei bottoni al frame
        add(buttonPanel, BorderLayout.EAST);
        add(contenitoreTreno, BorderLayout.CENTER);
        add(result, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);
    }
    /**creazione delpannello dei bottoni */
    public void createButtonPannel(){
        //dimensione dei panelli
        Dimension buttonDimension = new Dimension(150,125);
        //settaggio dei layout
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));
        //creazione dei bottoni
        addButton= new JButton("Add Wagon");
        removeButton = new JButton("remove Wagon");
        showLengthButton = new JButton("Show Length");
        showWeightButton = new JButton("show Weight");
        //settaggio delle dimensioni
        addButton.setPreferredSize(buttonDimension);
        addButton.setMaximumSize(buttonDimension);
        removeButton.setPreferredSize(buttonDimension);
        removeButton.setMaximumSize(buttonDimension);
        showLengthButton.setPreferredSize(buttonDimension);
        showLengthButton.setMaximumSize(buttonDimension);
        showWeightButton.setPreferredSize(buttonDimension);
        showWeightButton.setMaximumSize(buttonDimension);
        //aggiunta dei bottoni al pannello
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(showLengthButton);
        buttonPanel.add(showWeightButton);
    }
    /**aggiornamento della panello che mostra il treno */
    public void aggiornaGui(){
        ArrayList<Vagone> lv=treno.getLIstaVagoni();
        contenitoreTreno.removeAll();
        JLabel locomotiva= new JLabel();
        locomotiva.setSize(140,100);
        locomotiva.setIcon(new ImageIcon(new ImageIcon("locomotiva.jpg").getImage().getScaledInstance(locomotiva.getWidth(), locomotiva.getHeight(),Image.SCALE_SMOOTH)));
        contenitoreTreno.add(locomotiva);
        for(Vagone v: lv){
            //creazione del pannello contente l'iimagine e la label per il numero di matricola
            JPanel generalPanel= new JPanel();
            generalPanel.setLayout(new BoxLayout(generalPanel,BoxLayout.Y_AXIS));
            //creazione label conl'immagine e il numero di matricola
            JLabel imgVagone = new JLabel();
            JLabel labelMatricola= new JLabel();
            //impostazione della grandezza delle label
            imgVagone.setSize(100,100);
            labelMatricola.setSize(100,40);
            //impostazione dell'immagine riadattata del vagone e assegnazione all lkabel
            //controllo sul tipo di vagone
            if(v instanceof VagoneMerci){
                imgVagone.setIcon(new ImageIcon(new ImageIcon("vagone_merci.jpg").getImage().getScaledInstance(imgVagone.getWidth(), imgVagone.getHeight(),Image.SCALE_SMOOTH)));
            }else{
                imgVagone.setIcon(new ImageIcon(new ImageIcon("vagone_passeggeri.jpg").getImage().getScaledInstance(imgVagone.getWidth(), imgVagone.getHeight(),Image.SCALE_SMOOTH)));
            }
            //assegnazione del numero di matricola alla label
            labelMatricola.setText("matricola: " + v.getMatricola());
            //centramento dei testi
            labelMatricola.setAlignmentX(CENTER_ALIGNMENT);
            labelMatricola.setAlignmentY(CENTER_ALIGNMENT);
            imgVagone.setAlignmentX(CENTER_ALIGNMENT);
            imgVagone.setAlignmentY(CENTER_ALIGNMENT);
            //aggiunta all pannello genrale
            generalPanel.add(imgVagone);
            generalPanel.add(labelMatricola); 
            contenitoreTreno.add(generalPanel);
            //aggiunta del mouse listener per cancellare il vagone nel caso ci si cliccki soppra
            generalPanel.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    JPanel panel = (JPanel) e.getComponent();
                    JLabel label = (JLabel) panel.getComponent(1);
                    String matricola = label.getText().substring("matricola: ".length());
                    if (SwingUtilities.isRightMouseButton(e)) {
                        treno.rimuoviVagone(matricola);
                        aggiornaGui();
                    }else{
                        JOptionPane.showMessageDialog(null,treno.cercaVagone(matricola),"information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            //aggiunta al pannello generale al pannello dei treni
        }
        contenitoreTreno.revalidate();//indica al contenitore di riorganizzare i suoi componenti secondari
        contenitoreTreno.repaint();//indica al componente di ridisegnarsi
    }
    /**
     * creazione dell'ascoltatore degli eventi per i singoli bottoni
     */
    public void buttonListener(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //creazione gui per l'inserimento dei dati del vagone
                @SuppressWarnings("unused")
                GuiInserimentoVagone g = new GuiInserimentoVagone(treno,TrenoGUI.this);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            //creazione gui per l'inserimento della matricola del vagone da rimuovere
            @Override
            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("unused")
                GuiRimozioneVagone g= new GuiRimozioneVagone(treno,TrenoGUI.this);
            }
        });
        showLengthButton.addActionListener(new ActionListener() {
            //calcolo e stampa della lunghezza totale del treno sul pannello dei risultati
            @Override
            public void actionPerformed(ActionEvent e) {
               result.setText("");
               result.setText("Lunghezza: "+((Integer)(treno.calcolaLunghezza())).toString());
            }
        });
        showWeightButton.addActionListener(new ActionListener() {
            //calcolo e stampa del peso totale del treno sul pannello dei risultati
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText("");
                result.setText("Peso: "+((Double)(treno.calcolaPesoTreno())).toString());
            }
        });
    }
}