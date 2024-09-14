package red.social;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Perfil extends javax.swing.JFrame {
    private Login log;
    private String UsuarioActual;
    private JLabel perfilImagen;
    private String usuario;
    
    public Perfil(){
        initComponents();
        log=new Login();
        this.UsuarioActual=usuario;
        CargarImagenPerfil();
        
    }
    
    private void CargarImagenPerfil(){
     String genero=log.ObtenerGenero(UsuarioActual);
     if(genero!=null){
         if(genero.equalsIgnoreCase("Femenino")){
           Genero.setIcon(new ImageIcon(getClass().getResource("/red_social/imagenes/FotoHombre.png"))); 
         }else if(genero.equalsIgnoreCase("Masculino")){
             Genero.setIcon(new ImageIcon(getClass().getResource("/red_social/imagenes/FotoHombre.png")));
         }else{
           JOptionPane.showMessageDialog(null, "Genero no encontrado para el usuario");
         }
     }
   }
    
    
    /*Esto es innesesario
    private void Perfil(String nombre, String edad, String usuario, String genero) {
        Genero = new JLabel("Nombre: " + nombre);
        lblEdad = new JLabel("Edad: " + edad);
        lblUsuario = new JLabel("Usuario: " + usuario);
        Genero = new JLabel();

        // Cargar la imagen correspondiente según el género
        if (genero.equals("Masculino")) {
        Genero.setIcon(new ImageIcon(getClass().getResource("/proyecto2_redsocial/imagenes/FotoHombre.png")));
    } else if (genero.equals("Femenino")) {
        Genero.setIcon(new ImageIcon(getClass().getResource("/proyecto2_redsocial/imagenes/FotoMujer.png")));
    }
    } */
    
             
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        EditarPerfil = new javax.swing.JToggleButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Siguiendo = new javax.swing.JToggleButton();
        Seguidores = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        BuscarPersonas = new javax.swing.JToggleButton();
        lblNombres = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        Nombres = new javax.swing.JScrollPane();
        Genero = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EditarPerfil.setText("Editar perfil");
        EditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarPerfilActionPerformed(evt);
            }
        });

        lblUsuario.setText("@nombre");

        jLabel4.setText("Fecha");

        Siguiendo.setText("Siguiendo");
        Siguiendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguiendoActionPerformed(evt);
            }
        });

        Seguidores.setText("Seguidores");
        Seguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        BuscarPersonas.setText("Buscar Personas");
        BuscarPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPersonasActionPerformed(evt);
            }
        });

        lblNombres.setText("Name");

        lblEdad.setText("Edad");

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RegresarSmall.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        Genero.setText("foto");

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/patito.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Genero, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EditarPerfil, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BuscarPersonas, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(icono))
                            .addComponent(lblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Siguiendo)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Seguidores)))
                        .addGap(0, 86, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(BuscarPersonas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditarPerfil))
                    .addComponent(Genero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Siguiendo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seguidores))
                .addGap(160, 160, 160)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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

    private void EditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarPerfilActionPerformed
        EditarPerfil Editar =new EditarPerfil();
        Editar.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_EditarPerfilActionPerformed

    private void SiguiendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguiendoActionPerformed
        Seguidos Seguir =new Seguidos();
        Seguir.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_SiguiendoActionPerformed

    private void BuscarPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPersonasActionPerformed
    BuscarPersonas Buscar=new BuscarPersonas();
        Buscar.setVisible(true);
        this.dispose();        
        
    }//GEN-LAST:event_BuscarPersonasActionPerformed

    private void SeguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresActionPerformed
        Seguidores Seguidor =new Seguidores();
        Seguidor.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_SeguidoresActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        MenuPrincipal principal=new MenuPrincipal();
        principal.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    
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
    private javax.swing.JToggleButton BuscarPersonas;
    private javax.swing.JToggleButton EditarPerfil;
    private javax.swing.JLabel Genero;
    private javax.swing.JScrollPane Nombres;
    private javax.swing.JToggleButton Seguidores;
    private javax.swing.JToggleButton Siguiendo;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

    void mostrarPerfil(String usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
