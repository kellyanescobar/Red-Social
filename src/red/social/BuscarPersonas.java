package red.social;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarPersonas extends javax.swing.JFrame {
  private JTextField txtBuscarUsuario;
  private JButton btnBuscar;
  private JLabel lblResultado;
  private JButton btnRegresar;
  private JTextArea txtResultado;
  private JPanel panelResultados;
    
     public BuscarPersonas() {
        setTitle("Buscar Usuarios");
        setSize(352, 494);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        txtBuscarUsuario = new JTextField(20);
        add(txtBuscarUsuario);

        JButton btnBuscar = new JButton("Buscar");
        add(btnBuscar);

        lblResultado = new JLabel();
        lblResultado.setPreferredSize(new Dimension(300, 400)); // Tamaño para mostrar los resultados
        lblResultado.setVerticalAlignment(JLabel.TOP);
        lblResultado.setHorizontalAlignment(JLabel.LEFT);
        lblResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para mejor visibilidad
        add(lblResultado);

        btnBuscar.addActionListener(e -> buscarUsuario());

        // Agregar evento de clic al JLabel para acceder al perfil
        lblResultado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (lblResultado.getText().contains("href='#'>")) {
                    // Extraer el nombre del usuario clicado
                    String texto = lblResultado.getText();
                    int posicion = texto.indexOf("href='#'>");
                    String usuario = texto.substring(posicion + 9, texto.indexOf("</a>", posicion));
                    accederPerfil(usuario);
                }
            }
        });
    }

    // Método para buscar usuario sin necesidad de @ y mostrar usuarios coincidentes
    private void buscarUsuario() {
        String buscarNombre = txtBuscarUsuario.getText().trim().toLowerCase(); // Convertir a minúsculas para evitar problemas de mayúsculas/minúsculas
        lblResultado.setText(""); // Limpiar los resultados antes de una nueva búsqueda
        boolean usuarioEncontrado = false;
        
        StringBuilder resultado = new StringBuilder("<html>"); // Para mostrar múltiples líneas en el JLabel

        for (int i = 0; i < Login.Contar; i++) {
            if (Login.Usuarios[i] != null && Login.Usuarios[i].toLowerCase().contains(buscarNombre)) {
                // Verificar si el usuario ya está siendo seguido
                boolean esSeguido = esSeguido(Login.Usuarios[i]);
                String estadoSeguimiento = esSeguido ? "Siguiendo" : "No siguiendo";

                resultado.append("<a href='#'>").append(Login.Usuarios[i]).append("</a> - ").append(estadoSeguimiento).append("<br>");
                usuarioEncontrado = true;
            }
        }

        if (!usuarioEncontrado) {
            resultado.append("No se encontraron usuarios con '").append(buscarNombre).append("'.");
        }

        resultado.append("</html>");
        lblResultado.setText(resultado.toString());
    }

    // Método para verificar si el usuario actual sigue a otro usuario
    private boolean esSeguido(String usuario) {
        // Aquí puedes implementar la lógica para verificar si un usuario está siendo seguido
        // En este ejemplo, asumo que el `Login.UsuarioRegistrado` tiene algún mecanismo para verificarlo
        return false; // Cambia esta línea por la lógica adecuada para verificar el seguimiento
    }

    // Método para acceder al perfil del usuario
    private void accederPerfil(String usuario) {
        // Abre una ventana con el perfil del usuario seleccionado
        PerfilUsuario perfil = new PerfilUsuario(usuario); // Crea una instancia de la ventana de perfil
        perfil.setVisible(true); // Muestra la ventana del perfil
        this.dispose(); // Cierra la ventana de búsqueda actual
    }
        
     
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    public static void main(String args[]) {
        try{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPersonas().setVisible(true);
            }
        });
    

        
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
            java.util.logging.Logger.getLogger(BuscarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
            
              
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class PerfilUsuario extends JFrame {
    private String usuario;
    
    public PerfilUsuario(String usuario) {
        this.usuario = usuario;
        setTitle("Perfil de " + usuario);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Mostrar información del usuario
        JLabel lblNombre = new JLabel("Nombre de usuario: " + usuario);
        add(lblNombre);

        // Aquí puedes agregar más información sobre el usuario, como género, fecha de registro, etc.
    }
}
