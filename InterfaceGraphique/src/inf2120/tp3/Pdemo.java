package inf2120.tp3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

public class Pdemo extends JFrame implements ActionListener{
    public static final int FREQUENCE_ECHANTILLONAGE = 44100;
    public static final int NB_CANALS = 1;
    public static final int OCTETS_PAR_ECHANTILLON = 2;
    public static final int TAILLE_CADRE = NB_CANALS * OCTETS_PAR_ECHANTILLON;
    public static final int NB_OCTETS = FREQUENCE_ECHANTILLONAGE * TAILLE_CADRE;
    public static final int AMPLITUDE_MAXIMUM = (int) (Math.pow(2, OCTETS_PAR_ECHANTILLON * 8 - 1) - 1);

    public static final int BORDURE_X = 430;
    public static final int BORDURE_Y = 120;

    protected static Graphic dessin;

    private static final long serialVersionUID = 1L;

    /**
     * Detail decrivant l'onde.
     */
    public enum TypeOnde {
            SINUSOIDALE, TRIANGLE, TRIANGLE_GENERIQUE, SCIED, SCIEM, CARRE, PULSE_GENERIQUE, BRUIT
    }

    // Generique au son :
    // valeur entre 20 et 20000
    double frequence = 440.0;
    // valeur entre 0 et 2
    double duree = 1.0;

    // Ondes
    TypeOnde typeOnde [] = { TypeOnde.SINUSOIDALE, TypeOnde.PULSE_GENERIQUE }; 
    // valeur entre 0 et 1, utilise si nous avons onde PULSE_GENERIQUE ou TRIANGLE_GENERIQUE.
    double ondeRatio [] = { 0.5, 0.7 };

    // Peut etre Onde 2 :
    boolean utilise2Ondes = true;
    // valeur entre 0 et 1
    double ratioVolume = 0.5;

    // Filtre :
    // filtreS est enmtre 0 et 1.
    // filtreA + filtreD <= duree
    boolean utiliseFiltre = true;
    double filtreA = 0.1;
    double filtreD = 0.3;
    double filtreS = 0.5;
    double filtreR = 0.1;
    
    JButton btnJouerNote;
    JMenuBar barreMenuOnde;
    JTextField saisieOndeRatio;
    JLabel titreChamps;
    JCheckBox choixUtiliseDeuxOndes;
    JSlider choixRatioVolume;
    JSlider choixDuree;
    JTextField saisieFrequence;
    JCheckBox choixUtiliseFiltre;
    JTextField saisieADSR_A;
    JTextField saisieADSR_D;
    JTextField saisieADSR_S;
    JTextField saisieADSR_R;
    
    Container contenu; 
    JPanel panneau_de_composants; 
    
    public Pdemo(){
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout( new BorderLayout() );
        setSize( Graphic.TAILLE_X + BORDURE_X, 3 * Graphic.TAILLE_Y + BORDURE_Y );
        
        contenu = getContentPane();
        
        // Ajouter un panneau sur la fenetre
        panneau_de_composants = new JPanel();
        // 5 lignes, 4 colonnes , intervalle horizontal de 15, intervalle vertical de 10
        panneau_de_composants.setLayout(new GridLayout(5, 4, 15, 10)); 
        panneau_de_composants.setBackground(Color.LIGHT_GRAY);
        // Dessiner le graphic qui represente l'onde sur la fenetre
        dessin = new Graphic();
        contenu.add( dessin, BorderLayout.CENTER );
        
        // Ajouter le panneau sur la fenetre
        contenu.add(panneau_de_composants, BorderLayout.SOUTH);
        
        // Afficher la barre de menu qui permet de choisir notre onde
        afficherMenu();

        // Ajouter un label
        titreChamps = new JLabel("Entrez le ratio :");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le champs de saisie du ratio
        saisieOndeRatio = new JTextField();
        saisieOndeRatio.setColumns(4); // taille du champs de texte
        panneau_de_composants.add(saisieOndeRatio);   
              
        // Ajouter le checkbox qui permet de determiner si l'on utilise des deux ondes
        choixUtiliseDeuxOndes = new JCheckBox("Utilise les deux ondes");
        panneau_de_composants.add(choixUtiliseDeuxOndes);
 
        // Ajouter un label
        titreChamps = new JLabel("Choisir le volume du ratio :");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le JSlider pour choisir le ratio du volume
        choixRatioVolume = new JSlider();
        panneau_de_composants.add(choixRatioVolume);

        // Ajouter un label
        titreChamps = new JLabel("Choisir la duree :");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le JSlider pour choisir la duree
        choixDuree = new JSlider();
        panneau_de_composants.add(choixDuree);

        // Ajouter un label
        titreChamps = new JLabel("Entrez la frequence :");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le champs de saisie de la frequence
        saisieFrequence = new JTextField();
        saisieFrequence.setColumns(2); // taille du champs de texte
        panneau_de_composants.add(saisieFrequence); 

        // Ajouter le checkbox qui permet de determiner si l'on utilise le filtre
        choixUtiliseFiltre = new JCheckBox("Utilise le filtre");
        panneau_de_composants.add(choixUtiliseFiltre);
    
        // Ajouter un label
        titreChamps = new JLabel("ADSR (A):");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le champs de saisie de la frequence
        saisieADSR_A = new JTextField();
        panneau_de_composants.add(saisieADSR_A); 

        // Ajouter un label
        titreChamps = new JLabel("ADSR (D):");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le champs de saisie de la frequence
        saisieADSR_D = new JTextField();
        panneau_de_composants.add(saisieADSR_D);

        // Ajouter un label
        titreChamps = new JLabel("ADSR (S):");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le champs de saisie de la frequence
        saisieADSR_S = new JTextField();
        panneau_de_composants.add(saisieADSR_S);

        // Ajouter un label
        titreChamps = new JLabel("ADSR (R):");
        panneau_de_composants.add(titreChamps);
        
        // Ajouter le champs de saisie de la frequence
        saisieADSR_R = new JTextField();
        panneau_de_composants.add(saisieADSR_R);

        // Ajouter l'ecouteur sur le bouton qui joue la note 
        btnJouerNote = new JButton("Jouer le son");
        btnJouerNote.addActionListener(this);
        
        // Ajouter le bouton au panneau
        panneau_de_composants.add(btnJouerNote);
        
        setVisible(true);
       
    }
    
    private void afficherMenu(){

        barreMenuOnde = new JMenuBar();
        
        // Ajouter la barre de menu sur la fenetre
        setJMenuBar(barreMenuOnde);
        
        // Ajouter le menu de choix d'onde sur la barre
        JMenu menu = new JMenu("Choisir onde");
        barreMenuOnde.add(menu);
        
        // Ajouter les differents choix au menu
        JMenuItem sinusoidaleMenuItem = new JMenuItem("1- Sinusoidale");
        sinusoidaleMenuItem.setActionCommand("Sinusoidale");
        
        JMenuItem pulseGeneriqueMenuItem = new JMenuItem("2- Pulse Generique");
        pulseGeneriqueMenuItem.setActionCommand("Pulse Generique");

        sinusoidaleMenuItem.addActionListener(this);
        pulseGeneriqueMenuItem.addActionListener(this);
        
        menu.add(sinusoidaleMenuItem);
        menu.add(pulseGeneriqueMenuItem);        
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnJouerNote){
            // Obtenir ici les valeurs de tous les champs de la fenetre

            // Recuperer le choix d'utilisation des deux ondes
            utilise2Ondes = choixUtiliseDeuxOndes.isSelected();
            
            // Recuperer le choix d'utilisation du filtre
            utiliseFiltre = choixUtiliseFiltre.isSelected();
            
            /** 
             * Le reste c'est a vous le completer 
             */
            
            // les 4 commandes a faire lorsque le boutton est appuye :
            Onde onde = construireOnde();
            dessin.setFonction( onde );
            dessin.repaint();
            jouerNote( onde ); 
        }else if(e.getActionCommand().equals("Sinusoidale")){
            // desactiver le champs de saisie du ratio
            saisieOndeRatio.setEditable(false);
        }else if(e.getActionCommand().equals("Pulse Generique")){
            // activer le champs de saisie du ratio
            saisieOndeRatio.setEditable(true);
        }
        // rendre visible les changements sur la fenetre
        this.setVisible(true);
    }       
    
    
    public Onde construireOndeBase( int i ) {
            Onde resultat = null;
            switch( typeOnde[i] ) {
            case SINUSOIDALE :
                    resultat = new Sinusoidale( FREQUENCE_ECHANTILLONAGE, frequence );
                    break;
            case TRIANGLE :
                    resultat = new Triangle( FREQUENCE_ECHANTILLONAGE, frequence );
                    break;
            case SCIED :
                    resultat = new ScieD( FREQUENCE_ECHANTILLONAGE, frequence );
                    break;
            case SCIEM :
                    resultat = new ScieM( FREQUENCE_ECHANTILLONAGE, frequence );
                    break;
            case CARRE :
                    resultat = new Carre( FREQUENCE_ECHANTILLONAGE, frequence );
                    break;
            case BRUIT :
                    resultat = new Bruit();
                    break;
            case PULSE_GENERIQUE:
                    resultat = new PulseGenerique( FREQUENCE_ECHANTILLONAGE, frequence, ondeRatio[i] );
                    break;
            case TRIANGLE_GENERIQUE:
                    resultat = new TriangleGenerique( FREQUENCE_ECHANTILLONAGE, frequence, ondeRatio[i] );
                    break;
            }
            resultat.setDure( duree );
            return resultat;
    }

    public Onde construireOnde() {
            Onde resultat = construireOndeBase( 0 );

            if( utilise2Ondes ){
                    resultat = new Mixe( resultat, ratioVolume, construireOndeBase( 1 ), 1.0 - ratioVolume ); 
                    resultat.setDure( duree );
            }

            if( utiliseFiltre ){
                    ADSR f = new ADSR( FREQUENCE_ECHANTILLONAGE, filtreA, filtreD, filtreS, filtreR );
                    f.setDure( duree );
                    resultat = new Filtre( resultat, f );
                    resultat.setDure( duree );
            }

            return resultat;
    }
	
	
    public static void jouerNote(Onde onde) {
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                FREQUENCE_ECHANTILLONAGE, OCTETS_PAR_ECHANTILLON * 8, NB_CANALS,
                OCTETS_PAR_ECHANTILLON * NB_CANALS, FREQUENCE_ECHANTILLONAGE, false);

        SourceDataLine line;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                format);
        if (!AudioSystem.isLineSupported(info)) {
            System.err.print("Ligne non supporte par l'ordinateur.");
            System.exit(-1);
        }
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);

            byte[] buffer = new byte[NB_OCTETS];

            line.start();

            int j = 0;

            for (Double a : onde) {
                short amp = (short) Math.floor(AMPLITUDE_MAXIMUM * a);
                buffer[j + 0] = (byte) (amp & 0xFF);
                buffer[j + 1] = (byte) ((amp >>> 8) & 0xFF);
                j += TAILLE_CADRE;
                if (j >= NB_OCTETS) {
                    line.write(buffer, 0, NB_OCTETS);
                    j = 0;
                }
            }

            if (j != 0) {
                line.write(buffer, 0, j);
            }

            line.drain();
            line.stop();
            line.close();
        } catch (LineUnavailableException ex) {
            System.err.print("Ligne non disponible.");
            System.exit(-1);
        }
        line = null;
        
    }

    public static void main(String[] args) {
        Pdemo ecran = new Pdemo();
    }	
        
}
