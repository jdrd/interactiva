package Ajedrez;

import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Inicio {
	static Connection db;
        private JLabel log = new JLabel();
        private JLabel log1 = new JLabel("Nota: Espere la notificación de conexión para iniciar.");
        private JTextArea log2 = new JTextArea("Si usted aún no tiene cuenta, puede ingresar con los\n siguientes "
                + "datos:\n-> Nombre: juan \n-> Contraseña: 123.\nEsta es la cuenta predeterminada, para luego crear su\npropio perfil.");
        private JLabel log3 = new JLabel("Juan David Ramirez Dominguez - 0832443");
        private JLabel bv = new JLabel("Bienvenido a Ajedrez!");
        private JLabel nusu = new JLabel("Ingrese su nombre de usuario:");
        private JLabel cusu = new JLabel("Ahora su contraseña:");
        private JTextField AreaLogin = new JTextField();
        private JPasswordField AreaPass = new JPasswordField();
        private JButton in = new JButton("Acceder");

        static public JFrame frame = new JFrame("Ajedrez - Programación Interactiva");
        Container contenedor = frame.getContentPane();

        // configurar GUI
  public void MostrarVentana(){
      // establecer objeto JTextArea
      contenedor.setLayout(null);
      contenedor.add(bv);
      contenedor.add(log);
      contenedor.add(in);
      contenedor.add(log1);
      contenedor.add(log2);
      contenedor.add(log3);
      contenedor.add(AreaLogin);
      contenedor.add(AreaPass);
      contenedor.add(nusu);
      contenedor.add(cusu);


      bv.setBounds(10, 25, 200, 20);
      log.setBounds(210, 25, 250, 20);
      log1.setBounds(30, 280, 320, 40);
      log2.setBounds(30, 185, 320, 100);
      log3.setBounds(152, 302, 320, 40);
      nusu.setBounds(30, 60, 250, 20);
      cusu.setBounds(30, 120, 250, 20);
      AreaLogin.setBounds(30, 90, 200, 20);
      AreaPass.setBounds(30, 150, 200, 20);
      in.setBounds(270, 120, 100, 20);

         boolean error_loading_driver=false;
       try {
			Class.forName("com.mysql.jdbc.Driver");
                    }catch (ClassNotFoundException cnfe){
                            error_loading_driver=true;
                        }
		if (!error_loading_driver) {
			boolean connected=false;
			try {
 				System.out.println ("");
                                log.setText("Conectando a la base de datos!");
                                /* Obtenemos una conexión a la base de datos */
				db = DriverManager.getConnection("jdbc:mysql://colombiafincas.com/fincas_Proyecto", "fincas_ajedrez","123");
                                connected=true;
                            } catch (SQLException se) {
                                    System.out.println ("No se ha logrado conexión.");
                                    log.setText( "No se ha logrado conexión.");
                                                      }

                        if (connected) {
                                log.setText("                      Conexión efectuada!");
				System.out.println ("Ya se ha conectado a la base de datos");
                          }

                 }
   else  {
          System.out.println ("No se ha podido encontrar el driver JDBC para MySql.");

         }


      in.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                try {
                    btonlog(ae);

                } catch (NullPointerException exxx) {
                }
            }
        });
 }

  public static String usuario = new String();

  public boolean validarUsuario(String user,String pass)throws SQLException{

                String consulta;
		ResultSet rs;
	        Statement stmt;
                stmt = db.createStatement();
                //stmt.executeUpdate("CREATE TABLE usos (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), usuario VARCHAR(20), pass VARCHAR(20),rol VARCHAR(20))");
                //stmt.executeUpdate("INSERT INTO usuarios VALUES ('', 'admin', 'a', 'a','admin')");

                consulta = "SELECT * FROM usuarios WHERE usuario='"+user+"' AND pass='"+pass+"'";
                rs = stmt.executeQuery(consulta);
                usuario = user;

                if( rs.first() ) {       // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
                 return true;
                    }       //usuario validado correctamente
                     else{
                        return false;
                        //usuario validado incorrectamente
                        }

    }

  public void btonlog(java.awt.event.ActionEvent evt) {

        try
        {
             //valida si el usuario escribio el nombre de usuario y contraseña
           if (AreaLogin.getText().length() > 0 && AreaPass.getText().length() > 0 )
           {
                       // Si el usuario si fue validado correctamente
              if( validarUsuario( AreaLogin.getText(), AreaPass.getText() ) )    //enviar datos a validar
              {
                String rol = new String();
                String consulta,valido;
		ResultSet rs;
	        Statement stmt;
                stmt = db.createStatement();

                consulta = "SELECT rol FROM usuarios WHERE usuario='"+usuario+"'";
                rs = stmt.executeQuery(consulta);

                while( rs.next() ) {
                valido = rs.getString("rol");

                if(valido.contentEquals("ad")){
                frame.dispose();
                 JOptionPane.showMessageDialog(null,"  Acceso concedido! \n BIENVENIDO A CONFERENCIAS ADMINISTRADOR");
                 new AD();
                  }

                if(valido.contentEquals("")){
                frame.dispose();
                 JOptionPane.showMessageDialog(null,"  Acceso concedido! \n Bienvenido a Ajedrez " + usuario+", empieza el juego. ");
                 new AS();
                  }
                  }
              }

              else
              {
                 JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contraseña no son validos.");
                 JOptionPane.showMessageDialog(null, "Datos ingresados: "+AreaLogin.getText()+" - " +AreaPass.getText() );
                 AreaLogin.setText(""); //limpiar campos
                 AreaPass.setText("");
                 AreaLogin.requestFocusInWindow();
              }

           }
           else
           {
              JOptionPane.showMessageDialog(null, "Debe escribir un nombre de usuario y contraseña.\n" +
                           "NO puede dejar ningun campo vacio");
           }

        }
            catch (Exception e)
           {
              e.printStackTrace();
           }
    }

  public Inicio() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        frame.setSize(400,360);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MostrarVentana();
    }

  public static void main(java.lang.String[] args) throws IOException{
      new Inicio();
      }
}