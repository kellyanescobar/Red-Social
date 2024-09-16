package red.social;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Perfil extends javax.swing.JFrame {
    private JLabel lblNombre;
    private JLabel lblUsuario;
    private JLabel lblGenero;
    private JLabel lblEdad;
    private JLabel lblSeguidoresCount;
    private JLabel lblSeguidosCount;
    private JButton btnBuscar;
    private JButton btnSeguidores;
    private JButton btnSeguidos;
    private JButton btnRegresar;
    private static Login log;
    
     public Perfil(){
        mostrarDatosPerfil();
    }

    public static void setLoginInstance(Login loginInstance) {
        log = loginInstance;
    }

    private void mostrarDatosPerfil() {
        lblNombre = new JLabel("Nombre: ");
        lblUsuario = new JLabel("Usuario: ");
        lblGenero = new JLabel("Genero: ");
        lblEdad = new JLabel("Edad: ");

        JLabel nombreValor = new JLabel();
        JLabel usuarioValor = new JLabel();
        JLabel generoValor = new JLabel();
        JLabel edadValor = new JLabel();

        // Obtener los datos del usuario registrado desde la clase Login
        if (log != null && log.ObtenerInformacionUsuarioRegistrado() != null) {
            nombreValor.setText(log.getNombre());
            usuarioValor.setText(log.getUsuario());
            generoValor.setText(log.obtenerGeneros());
            edadValor.setText(log.obtenerEdadades());
        } else {
            nombreValor.setText("No disponible");
            usuarioValor.setText("No disponible");
            generoValor.setText("No disponible");
            edadValor.setText("No disponible");
        }

        // Crear un JPanel para mostrar los datos del perfil
        JPanel perfilPanel = new JPanel(new GridLayout(4, 2));
        perfilPanel.add(lblNombre);
        perfilPanel.add(nombreValor);
        perfilPanel.add(lblUsuario);
        perfilPanel.add(usuarioValor);
        perfilPanel.add(lblGenero);
        perfilPanel.add(generoValor);
        perfilPanel.add(lblEdad);
        perfilPanel.add(edadValor);

        // Configurar tamaño preferido para el perfilPanel
        perfilPanel.setPreferredSize(new Dimension(300, 150));

        // Crear un JPanel para los botones de Seguidores y Seguidos
        JPanel statsPanel = new JPanel(new FlowLayout());
        lblSeguidoresCount = new JLabel("0");
        lblSeguidosCount = new JLabel("0");

        btnSeguidores = new JButton("Seguidores");
        btnSeguidores.addActionListener(evt -> {
            // Lógica para mostrar los seguidores
            Seguidores seguidores = new Seguidores();
            seguidores.setVisible(true);
            this.dispose();
        });

        btnSeguidos = new JButton("Seguidos");
        btnSeguidos.addActionListener(evt -> {
            // Lógica para mostrar los seguidos
            Seguidos seguidos = new Seguidos();
            seguidos.setVisible(true);
            this.dispose();
        });

        statsPanel.add(btnSeguidores);
        statsPanel.add(lblSeguidoresCount);
        statsPanel.add(btnSeguidos);
        statsPanel.add(lblSeguidosCount);

        // Configurar tamaño preferido para el statsPanel
        statsPanel.setPreferredSize(new Dimension(300, 500));

        // Crear un JPanel para el botón Buscar
        JPanel buscarPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnBuscar = new JButton("Buscar Usuarios");
        btnBuscar.addActionListener(evt -> {
            // Lógica para buscar personas
            BuscarPersonas buscar = new BuscarPersonas();
            buscar.setVisible(true);
            this.dispose();
        });

        buscarPanel.add(btnBuscar);
        buscarPanel.setPreferredSize(new Dimension(300, 30));

        // Crear un JPanel para el botón Regresar
        JPanel regresarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnRegresar = new JButton(new ImageIcon(getClass().getResource("/Imagenes/RegresarSmall.png")));
        btnRegresar.setPreferredSize(new Dimension(40, 40));
        btnRegresar.addActionListener(evt -> regresarAMenuPrincipal()); // Acción del botón
        regresarPanel.add(btnRegresar);

        // Configurar tamaño preferido para el regresarPanel
        regresarPanel.setPreferredSize(new Dimension(300, 100));

        // Crear un JPanel principal usando BoxLayout para vertical alignment
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buscarPanel);
        mainPanel.add(perfilPanel);
        mainPanel.add(statsPanel);
        mainPanel.add(regresarPanel);

        // Configurar el JFrame
        this.setContentPane(mainPanel);
        this.setSize(352, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void regresarAMenuPrincipal() {
        // Implementa aquí la lógica para regresar al menú principal
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }  
    
    
             
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        BuscarPersonass = new javax.swing.JToggleButton();
        icono = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BuscarPersonass.setText("Buscar Personas");
        BuscarPersonass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPersonassActionPerformed(evt);
            }
        });

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/patito.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addComponent(icono)
                    .addGap(0, 166, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BuscarPersonass)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(BuscarPersonass)
                .addContainerGap(443, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarPersonassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPersonassActionPerformed
    BuscarPersonas Buscar=new BuscarPersonas();
        Buscar.setVisible(true);
        this.dispose();        
        
    }//GEN-LAST:event_BuscarPersonassActionPerformed

    
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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BuscarPersonass;
    private javax.swing.JLabel icono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables

   
    
}
