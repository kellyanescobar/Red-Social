package red.social;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;


 public class MenuPrincipal extends javax.swing.JFrame {
    private JTextArea postTextArea;
    private JTextArea displayTextArea;
    private JButton postButton;
    private JButton perfilButton;
    private JButton interaccionesButton;
    private JButton hashtagsButton;
    private JButton cerrarSesionButton;
    private String usuarioActual; // Nombre del usuario actual

    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear un JPanel para contener el logo y el texto "Duckling"
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.X_AXIS)); // Layout horizontal para icono + texto

        // Crear y agregar el logo (imagen)
        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/patito.png")));

        // Crear y agregar el texto "Duckling"
        JLabel textLabel = new JLabel("Duckling");
        textLabel.setFont(new java.awt.Font("Bold", java.awt.Font.BOLD, 15)); // Ajustar fuente y tamaño de letra
        textLabel.setForeground(new java.awt.Color(204, 204, 0));

        // Centrar ambos elementos dentro del logoPanel
        logoPanel.add(logoLabel);
        logoPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espaciado entre el logo y el texto
        logoPanel.add(textLabel);

        // Centrar el panel completo en la parte superior
        logoPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        add(logoPanel, BorderLayout.NORTH);

        Login loginInstance = new Login();
        this.usuarioActual = loginInstance.getUsuario(); // Método no estático

        // Crear área de texto para ingresar publicaciones
        postTextArea = new JTextArea(5, 20);
        JScrollPane postScrollPane = new JScrollPane(postTextArea);
        postScrollPane.setBorder(BorderFactory.createTitledBorder("Escribe tu publicación"));

        // Crear botón para publicar
        postButton = new JButton("Publicar");
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postButtonActionPerformed();
            }
        });

        // Crear área de texto para mostrar publicaciones
        displayTextArea = new JTextArea(10, 40);
        displayTextArea.setEditable(false);
        JScrollPane displayScrollPane = new JScrollPane(displayTextArea);
        displayScrollPane.setBorder(BorderFactory.createTitledBorder("Publicaciones"));

        // Crear botones para navegación
        perfilButton = new JButton("Perfil");
        perfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPerfil();
            }
        });

        interaccionesButton = new JButton("Interacciones");
        interaccionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInteracciones();
            }
        });

        hashtagsButton = new JButton("Hashtags");
        hashtagsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openHashtags();
            }
        });

        cerrarSesionButton = new JButton("Cerrar Sesión");
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPantallaInicial();
            }
        });

        // Crear panel para los botones de navegación
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS)); // Botones en layout vertical
        navigationPanel.add(perfilButton);
        navigationPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado entre botones
        navigationPanel.add(interaccionesButton);
        navigationPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Más espaciado
        navigationPanel.add(hashtagsButton);

        // Crear panel para los componentes de publicación
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BorderLayout());
        postPanel.add(postScrollPane, BorderLayout.CENTER);
        postPanel.add(postButton, BorderLayout.SOUTH);

        // Panel principal que contiene el panel de navegación y el área de publicaciones
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(navigationPanel, BorderLayout.WEST); // Navegación a la izquierda
        mainPanel.add(postPanel, BorderLayout.CENTER); // Publicación en el centro
        mainPanel.add(displayScrollPane, BorderLayout.SOUTH); // Publicaciones abajo

        // Añadir el botón de cerrar sesión al final de la ventana
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(cerrarSesionButton, BorderLayout.EAST);

        // Añadir componentes al JFrame
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Restringir el número de caracteres en el área de texto
        postTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (postTextArea.getText().length() >= 140) {
                    evt.consume(); // Ignorar el evento de tecla
                    Toolkit.getDefaultToolkit().beep(); // Sonido de advertencia
                }
            }
        });
    }

    private void postButtonActionPerformed() {
        String postText = postTextArea.getText();

        // Si el texto del post no está vacío
        if (!postText.trim().isEmpty()) {
            // Obtener la fecha actual en el formato [dd/MM/yyyy]
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = dateFormat.format(new Date());

            // Formato del mensaje del tweet
            String tweetMessage = usuarioActual + " escribió:\n“" + postText + "” el [" + currentDate + "]\n\n";

            // Mostrar el mensaje en el área de texto de publicaciones
            displayTextArea.append(tweetMessage);

            // Limpiar el área de texto de publicación
            postTextArea.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, escribe algo antes de publicar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openPerfil() {
        Perfil perfil = new Perfil();
        perfil.setVisible(true);
        this.dispose();
    }

    private void openInteracciones() {
        Interacciones interacciones = new Interacciones();
        interacciones.setVisible(true);
        this.dispose();
    }

    private void openHashtags() {
        Hashtags hashtags = new Hashtags();
        hashtags.setVisible(true);
        this.dispose();
    }

    private void openPantallaInicial() {
        PantallaInicial pantallaInicial = new PantallaInicial();
        pantallaInicial.setVisible(true);
        this.dispose();
    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menutransparente = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        Perfil = new javax.swing.JButton();
        Interacciones = new javax.swing.JButton();
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

        Interacciones.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Interacciones.setText("Interacciones");
        Interacciones.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Interacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InteraccionesActionPerformed(evt);
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
        Texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextoKeyTyped(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(CerrarSesion)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Hashtags, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Interacciones, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Perfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Publicar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Publicar)
                        .addGap(49, 49, 49)
                        .addComponent(Perfil)
                        .addGap(18, 18, 18)
                        .addComponent(Interacciones)
                        .addGap(18, 18, 18)
                        .addComponent(Hashtags)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(CerrarSesion)
                .addContainerGap())
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
   
          
    }//GEN-LAST:event_PublicarActionPerformed

    private void TextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoActionPerformed
     
        
     //TxT para escribir el tweet
    }//GEN-LAST:event_TextoActionPerformed

    private void TextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextoKeyTyped
        if(Texto.getText().length()>=140){
            evt.consume();
        Toolkit.getDefaultToolkit().beep();
        
    }  
    //restrincion de los 140 caracteres    
    }//GEN-LAST:event_TextoKeyTyped

   
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logo;
    private javax.swing.JPopupMenu menutransparente;
    private javax.swing.JList<String> twet;
    // End of variables declaration//GEN-END:variables

    
 

   
}
