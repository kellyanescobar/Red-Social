package red.social;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarPersonas extends javax.swing.JFrame {
  private JTextField txtBuscarUsuario;
  private JButton btnBuscar;
  private JLabel lblResultado;
  private JButton btnRegresar;
    
    public BuscarPersonas() {
        // Configuración de la ventana
        setTitle("Buscar Usuario");
        setSize(352, 494);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Inicialización y configuración de los componentes
        JLabel lblIngreseUsuario = new JLabel("Ingrese @Usuario:");
        lblIngreseUsuario.setBounds(10, 10, 120, 25);
        add(lblIngreseUsuario);

        txtBuscarUsuario = new JTextField();
        txtBuscarUsuario.setBounds(130, 10, 140, 25);
        add(txtBuscarUsuario);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(90, 50, 100, 25);
        add(btnBuscar);

        lblResultado = new JLabel("");
        lblResultado.setBounds(10, 80, 250, 25);
        add(lblResultado);

        // Acción del botón Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });

        // Configuración del botón Regresar
        btnRegresar = new JButton(new ImageIcon(getClass().getResource("/Imagenes/RegresarSmall.png")));
        btnRegresar.setBounds(220, 50, 40, 40);
        add(btnRegresar);

        // Acción del botón Regresar
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarAMenuPrincipal();
            }
        });

        // Ajuste de tamaño y visibilidad
        setVisible(true);
    }

    private void buscarUsuario() {
        String buscarNombre = txtBuscarUsuario.getText();

        if (!buscarNombre.startsWith("@")) {
            lblResultado.setText("Debe iniciar con @ para buscar.");
            return;
        }

        buscarNombre = buscarNombre.substring(1); // Remove '@' for search

        boolean usuarioEncontrado = false;
        for (int i = 0; i < Login.Contar; i++) {
            if (Login.Usuarios[i] != null && Login.Usuarios[i].equalsIgnoreCase(buscarNombre)) {
                lblResultado.setText("Usuario " + buscarNombre + " encontrado.");
                usuarioEncontrado = true;
                break;
            }
        }

        if (!usuarioEncontrado) {
            lblResultado.setText("Usuario " + buscarNombre + " no existe.");
        }
    }

    private void regresarAMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        this.dispose(); // Cierra la ventana actual
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
