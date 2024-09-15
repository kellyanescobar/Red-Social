package red.social;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilUsuario extends javax.swing.JFrame {
      private String usuario;
      private Login log;

    public PerfilUsuario(String usuario) { 
        this.usuario = usuario;
        this.log = new Login();  // Usamos la misma instancia de Login

        setTitle("Perfil de " + usuario);
        setSize(352, 494);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Inicializar componentes
        JLabel lblNombre = new JLabel();
        JLabel lblGenero = new JLabel();
        JLabel lblFechaIngreso = new JLabel();
        JLabel lblFotoPerfil = new JLabel();

        // Obtener datos del usuario desde la clase Login
        String[] userData = log.obtenerDatosUsuario(usuario);

        if (userData != null) {
            lblNombre.setText("Nombre de usuario: " + userData[0]);
            lblGenero.setText("Género: " + userData[1]);
            lblFechaIngreso.setText("Fecha de creación: " + userData[2]);

            // Asignar la imagen de perfil basado en el género
            ImageIcon fotoPerfilIcon = new ImageIcon(getClass().getResource(
                userData[1].equalsIgnoreCase("Masculino") ? "/Imagenes/PerfilHombre.png" : "/Imagenes/PerfilMujer.png"
            ));
            lblFotoPerfil.setIcon(fotoPerfilIcon);
        } else {
            lblNombre.setText("Usuario no encontrado.");
        }

        // Agregar componentes al frame
        add(lblFotoPerfil);
        add(lblNombre);
        add(lblGenero);
        add(lblFechaIngreso);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilUsuario("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
