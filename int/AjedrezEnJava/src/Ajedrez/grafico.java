package Ajedrez;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class grafico implements ActionListener, KeyListener, WindowFocusListener {
    
    private windowChessBoard tableroPrinc;
    private objCreateAppletImage crearImg;
    private JButton btnJuegoNuevo, btnEstNoms;
    private JTextField txtJugUno, txtJugDos;
    private JLabel etqJugUno, etqJugDos;
    private String[] strPiezasNegras = {"peonN.png","torreN.png","caballoN.png","alfilN.png","reinaN.png","reyN.png"};
    private String[] strPiezasBlancas = {"peon.png","torre.png","caballo.png","alfil.png","reina.png","rey.png"};
    private Color clrBlue = new Color(7,141,221);
    private MediaTracker mt;
    
    public void grafico() {
    }
    
    public Container grafico(JFrame mainApp) {
        
        JPanel panelRaiz = new JPanel(new BorderLayout());
        panelRaiz.setOpaque(true);
        panelRaiz.setPreferredSize(new Dimension(550,650));
        
        tableroPrinc = new windowChessBoard();
        crearImg = new objCreateAppletImage();
        
        tableroPrinc.setSize(new Dimension(500, 500));
        
        btnJuegoNuevo = new JButton("Crear nuevo juego");
        btnEstNoms = new JButton("Establecer nombres");
        
        btnJuegoNuevo.addActionListener(this);
        btnEstNoms.addActionListener(this);
        
        txtJugUno = new JTextField("Henry Wong", 10);
        txtJugDos = new JTextField("Oponente",10);
        
        txtJugUno.addKeyListener(this);
        txtJugDos.addKeyListener(this);
        
        etqJugUno = new JLabel("    ", JLabel.RIGHT);
        etqJugDos = new JLabel("    ", JLabel.RIGHT);
        
        try {
            
            Image[] imgNeg = new Image[6];
            Image[] imgBlanco = new Image[6];
            mt = new MediaTracker(mainApp);
            
            for (int i = 0; i < 6; i++) {
                
                imgNeg[i] = crearImg.getImage(this, "/images/" + strPiezasNegras[i], 5000);
                imgBlanco[i] = crearImg.getImage(this,"/images/" + strPiezasBlancas[i], 5000);
                mt.addImage(imgNeg[i], 0);
                mt.addImage(imgBlanco[i], 0);
                
            }
            
            try {
                mt.waitForID(0);
            } catch (InterruptedException e) {
            }
            
            tableroPrinc.setupImages(imgNeg, imgBlanco);
            
        } catch (NullPointerException e) {
            
            JOptionPane.showMessageDialog(null, "Imposible cargar las imagenes.", "ERROR", JOptionPane.WARNING_MESSAGE);
            btnJuegoNuevo.setEnabled(false);
            btnEstNoms.setEnabled(false);
            e.printStackTrace();
            
        }
        
        JPanel panBottomHalf = new JPanel(new BorderLayout());
        JPanel panNameArea = new JPanel(new GridLayout(3,1,2,2));
        JPanel panPlayerOne = new JPanel();
        JPanel panPlayerTwo = new JPanel();
        JPanel panNameButton = new JPanel();
        JPanel panNewGame = new JPanel();
        
        panelRaiz.add(tableroPrinc, BorderLayout.NORTH);
        panelRaiz.add(panBottomHalf, BorderLayout.SOUTH);
        panBottomHalf.add(panNameArea, BorderLayout.WEST);
        panNameArea.add(panPlayerOne);
        panPlayerOne.add(etqJugUno);
        panPlayerOne.add(txtJugUno);
        panNameArea.add(panPlayerTwo);
        panPlayerTwo.add(etqJugDos);
        panPlayerTwo.add(txtJugDos);
        panNameArea.add(panNameButton);
        panNameButton.add(btnEstNoms);
        panBottomHalf.add(panNewGame, BorderLayout.SOUTH);
        panNewGame.add(btnJuegoNuevo);
        
        panelRaiz.setBackground(clrBlue);
        panBottomHalf.setBackground(clrBlue);
        panNameArea.setBackground(clrBlue);
        panPlayerOne.setBackground(clrBlue);
        panPlayerTwo.setBackground(clrBlue);
        panNameButton.setBackground(clrBlue);
        panNewGame.setBackground(clrBlue);
        
        etqJugUno.setBackground(new Color(236,17,17));
        etqJugDos.setBackground(new Color(17,27,237));
        
        btnJuegoNuevo.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        return panelRaiz;
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnEstNoms) {
            
            if (txtJugUno.getText().equals("")) {
                txtJugUno.setText("Jugador1");
            }
            
            if (txtJugDos.getText().equals("")) {
                txtJugDos.setText("Jugador2");
            }
            
            tableroPrinc.setNames(txtJugUno.getText(), txtJugDos.getText());
            
        } else if (e.getSource() == btnJuegoNuevo) {
            tableroPrinc.newGame();
        }
        
    }
    
    public void keyTyped(KeyEvent e) {
        
        String strBuffer = "";
        char c = e.getKeyChar();
        
        if (e.getSource() == txtJugUno) {
            strBuffer = txtJugUno.getText();
        } else {
            strBuffer = txtJugDos.getText();
        }
        
        if (strBuffer.length() > 10 && !((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }
        
    }
    
    public void keyPressed(KeyEvent e) {
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void windowGainedFocus(WindowEvent e) {
        tableroPrinc.gotFocus();
    }
    
    public void windowLostFocus(WindowEvent e) {
    }
    
}