package Ajedrez;


import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class AD {
	
        private JLabel log = new JLabel();
        private JButton agas = new JButton("Añadir");
        private JButton edas = new JButton("Editar");
        private JButton elas = new JButton("Eliminar");
        private JButton agpo = new JButton("Añadir");
        private JButton edpo = new JButton("Editar");
        private JButton elpo = new JButton("Eliminar");
        private JButton agco = new JButton("Añadir Conferencia");
        private JButton elco = new JButton("Eliminar Conferencia");
        private JButton edco = new JButton("Editar Conferencia");


        private JLabel bv = new JLabel("PANEL ADMINISTRADOR");
        private JLabel as = new JLabel("ASISTENTES");
        private JLabel po = new JLabel("PONENTES");


        static public JFrame frame = new JFrame("Admin Conferencias");
        Container contenedor = frame.getContentPane();
   // configurar GUI
   public void MostrarVentana()
   {
      // establecer objeto JTextArea
      contenedor.setLayout(null);
      contenedor.add(bv);
      contenedor.add(agas);
      contenedor.add(edas);
      contenedor.add(elas);
      contenedor.add(agpo);
      contenedor.add(edpo);
      contenedor.add(elpo);
      contenedor.add(agco);
      contenedor.add(elco);
      contenedor.add(edco);

      contenedor.add(as);
      contenedor.add(po);
      contenedor.add(log);


      agas.setBounds(35, 95, 80, 20);
      edas.setBounds(35, 155, 80, 20);
      elas.setBounds(35, 125, 80, 20);
      agpo.setBounds(150, 95, 80, 20);
      edpo.setBounds(150, 155, 80, 20);
      elpo.setBounds(150, 125, 80, 20);
      agco.setBounds(30, 185, 200, 20);
      elco.setBounds(30, 215, 200, 20);
      edco.setBounds(30, 245, 200, 20);


      as.setBounds(40, 65, 80, 20);
      po.setBounds(160, 65, 80, 20);
      bv.setBounds(10, 35, 200, 20);
      log.setBounds(110, 5, 250, 20);

      agas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botAgAs(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });
      edas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botEdAs(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });
      elas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botElAs(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });
      agpo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botAgPo(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });
      edpo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botEdPo(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });
      elpo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botElPo(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });
      agco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botAgCo(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });
      
      elco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botElCo(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });


              edco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    botEdCo(ae);
                } catch (NullPointerException exxx) {
                }
            }
        });

 }


  private void botAgAs(java.awt.event.ActionEvent evt) {
        try
        {new agAs();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botEdAs(java.awt.event.ActionEvent evt) {
        try
        {new edAs();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botElAs(java.awt.event.ActionEvent evt) {
        try
        {new elAs();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botAgPo(java.awt.event.ActionEvent evt) {
        try
        {new agPo();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botEdPo(java.awt.event.ActionEvent evt) {
        try
        {new edPo();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botElPo(java.awt.event.ActionEvent evt) {
        try
        {new elPo();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botAgCo(java.awt.event.ActionEvent evt) {
        try
        {new agCo();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botEdCo(java.awt.event.ActionEvent evt) {
        try
        {new edCo();}
        catch (Exception e) {e.printStackTrace(); }
    }
  private void botElCo(java.awt.event.ActionEvent evt) {
        try
        {new elCo();}
        catch (Exception e) {e.printStackTrace(); }
    }




  public AD() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        frame.setSize(300,350);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MostrarVentana();
    }

}