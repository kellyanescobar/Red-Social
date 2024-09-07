package red.social;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 public class MenuPrincipal extends javax.swing.JFrame {
    DefaultListModel texto=new DefaultListModel();
    private JTextArea postTextArea;
    private JTextArea displayTextArea;
    private JScrollPane displayScrollPane;
    private JPanel jPanell;

    public MenuPrincipal() {
        initComponents();
        initCustomComponents();
         texto=new DefaultListModel();
         twet.setModel(texto);

    } 

    private void initCustomComponents() {
        // Crear área de texto para la publicación
        postTextArea = new JTextArea();
        postTextArea.setRows(5);
        postTextArea.setColumns(20);
        JScrollPane postScrollPane = new JScrollPane(postTextArea);

        // Crear botón para publicar
        JButton BotonPublicar = new JButton("Publicar");
        BotonPublicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        displayTextArea = new JTextArea();
        displayTextArea.setEditable(false); // No permitir edición del texto publicado
        displayTextArea.setRows(10);
        displayTextArea.setColumns(20);

        displayScrollPane = new JScrollPane(displayTextArea);

        // Agregar componentes al panel
        jPanel1.add(postScrollPane);
        jPanel1.add(BotonPublicar);
        jPanel1.add(displayScrollPane);
    }

    private void postButtonActionPerformed(ActionEvent evt) {
        // Obtener el texto de la publicación
        String postText = postTextArea.getText();

        // Verificar que el texto no esté vacío
        if (!postText.isEmpty()) {
            // Añadir el texto publicado al JTextArea
            displayTextArea.append(postText + "\n\n");
            postTextArea.setText(""); // Limpiar el área de texto después de la publicación
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, escribe algo antes de publicar.");
        }
    }
        
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menutransparente = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        Perfil = new javax.swing.JButton();
        Tweet = new javax.swing.JButton();
        Interacciones = new javax.swing.JButton();
        TimeLine = new javax.swing.JButton();
        Hashtags = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        CerrarSesion = new javax.swing.JToggleButton();
        Publicar = new javax.swing.JButton();
        Texto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        twet = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Perfil.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Perfil.setText("Perfil");
        Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilActionPerformed(evt);
            }
        });

        Tweet.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Tweet.setText("Tweet");
        Tweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TweetActionPerformed(evt);
            }
        });

        Interacciones.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Interacciones.setText("Interacciones");
        Interacciones.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Interacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InteraccionesActionPerformed(evt);
            }
        });

        TimeLine.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        TimeLine.setText("Time Line");
        TimeLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeLineActionPerformed(evt);
            }
        });

        Hashtags.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Hashtags.setText("Hashtags");
        Hashtags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HashtagsActionPerformed(evt);
            }
        });

        logo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logo.setForeground(new java.awt.Color(204, 204, 0));
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/patito.png"))); // NOI18N
        logo.setText("Duckling");

        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });

        Publicar.setText("Publicar");
        Publicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicarActionPerformed(evt);
            }
        });

        Texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoActionPerformed(evt);
            }
        });

        twet.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(twet);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(logo)
                                .addComponent(TimeLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tweet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Interacciones)
                                    .addComponent(CerrarSesion)
                                    .addComponent(Hashtags, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                                .addComponent(Publicar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane3)))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Publicar))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TimeLine)
                        .addGap(18, 18, 18)
                        .addComponent(Tweet)
                        .addGap(18, 18, 18)
                        .addComponent(Interacciones)
                        .addGap(18, 18, 18)
                        .addComponent(Perfil)
                        .addGap(18, 18, 18)
                        .addComponent(Hashtags)
                        .addGap(170, 170, 170)
                        .addComponent(CerrarSesion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TimeLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeLineActionPerformed
        TimeLine tiempo=new TimeLine();
        tiempo.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_TimeLineActionPerformed

    private void HashtagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HashtagsActionPerformed
        Hashtags hash =new Hashtags();
        hash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HashtagsActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        PantallaInicial Pantalla =new PantallaInicial(); 
        Pantalla.setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilActionPerformed
        Perfil VerPerfil=new Perfil();
        VerPerfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PerfilActionPerformed

    private void InteraccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InteraccionesActionPerformed
        Interacciones Interacion=new Interacciones();
        Interacion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_InteraccionesActionPerformed

    private void PublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicarActionPerformed
    String tex=Texto.getText();
    texto.addElement(tex);        
    }//GEN-LAST:event_PublicarActionPerformed

    private void TextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoActionPerformed

    private void TweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TweetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TweetActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CerrarSesion;
    private javax.swing.JButton Hashtags;
    private javax.swing.JButton Interacciones;
    private javax.swing.JButton Perfil;
    private javax.swing.JButton Publicar;
    private javax.swing.JTextField Texto;
    private javax.swing.JButton TimeLine;
    private javax.swing.JButton Tweet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logo;
    private javax.swing.JPopupMenu menutransparente;
    private javax.swing.JList<String> twet;
    // End of variables declaration//GEN-END:variables

 

   
}
