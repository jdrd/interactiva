package Ajedrez;

import Ajedrez.Inicio;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.*;


public class AS extends JFrame{

        static String usu =  Inicio.usuario;
        public JLabel bv=new JLabel("Bienvenido: "+usu);
        private JLabel titulo = new JLabel("Ajedrez:");
        private JLabel lnom = new JLabel("Nombre:");
        private JLabel lusu = new JLabel("Usuario:");
        private JLabel lpass = new JLabel("Contraseña:");
        private JLabel limg = new JLabel("Imagen:");
        JTextField TxtFnom= new JTextField(10);


        String nom;
        String user;
        String pass;
        String img;

        private JButton añadir = new JButton("Añadir");
        private JButton Eliminar = new JButton("Eliminar");
        private JButton Cancelar = new JButton("Cerrar");

        static public JFrame frame = new JFrame("Panel de usuario: "+usu);


          public void misdatos(){
        try{

        String consulta;
        ResultSet rs;
        Statement stmt;
        stmt = Inicio.db.createStatement();
        consulta="SELECT * FROM usuarios ";

        rs = stmt.executeQuery(consulta);

        while( rs.next() ) {

              nom = rs.getString(2);
              usu = rs.getString(3);
              pass = rs.getString(4);
              img = rs.getString(6);
        }

        }
        catch(SQLException es){}
        System.out.println(nom);
        System.out.println(usu);
        System.out.println(pass);
        System.out.println(img);

        TxtFnom.setText(nom);
        TxtFnom.setEditable(false);
        
          }

    JPanel creaBorde( Border b ) {
    JPanel panel = new JPanel();

    add(lnom);
    
    add(TxtFnom);
    TxtFnom.setBounds(50,50,50,50);
    
   
    add(lusu);
   add(limg);



    return( panel );
  }


        // configurar GUI
  public void MostrarVentana(){
      // establecer objeto JTextArea

      add(estado);
      titulo.setBounds(50, 50, 100, 100);
      add(titulo);
      titulo.setBounds(50, 50, 100, 100);

      misdatos();
      estado.setBounds(60, 100, 420, 200);
      estado.add(creaBorde( new TitledBorder("Mis Datos") ));        
    }



  public void btoncanc(java.awt.event.ActionEvent evt){
  frame.dispose();
  }

  public AS() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        frame.setSize(800,350);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MostrarVentana();
    }

    public static void main(java.lang.String[] args) {
      new AS();
      }

}