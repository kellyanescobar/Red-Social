package red.social;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.HashSet;

public class Hashtags extends javax.swing.JFrame {
    private JTextField hashtagField;
    private JTextArea resultArea;
    private JButton searchButton, backButton;
    private String[] tweets; // Array que contiene todos los tweets
    private String[] mostrados; // Array para evitar duplicados
    private int contadorMostrados; // Contador de tweets ya mostrados

    public Hashtags() {
        // Configuración de la ventana
        setTitle("Buscar Hashtags");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Campo de entrada para el hashtag
        JLabel hashtagLabel = new JLabel("Buscar hashtag:");
        hashtagLabel.setBounds(20, 20, 100, 30);
        add(hashtagLabel);

        hashtagField = new JTextField();
        hashtagField.setBounds(130, 20, 150, 30);
        add(hashtagField);

        // Área de resultados (tweets encontrados)
        resultArea = new JTextArea();
        resultArea.setBounds(20, 70, 350, 200);
        resultArea.setEditable(false); // No permitir la edición del área de texto
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(20, 70, 350, 200);
        add(scrollPane);

        // Botón de buscar
        searchButton = new JButton("Buscar");
        searchButton.setBounds(290, 20, 80, 30);
        add(searchButton);

        // Botón para regresar al menú principal
        backButton = new JButton("Regresar");
        backButton.setBounds(150, 300, 100, 30);
        add(backButton);

        // Simulación de tweets con hashtags
        tweets = new String[]{
            "user1 escribió: “Amo la tecnología #Tech” el [Septiembre 2023]",
            "user2 escribió: “Hoy es un gran día #Feliz” el [Septiembre 2023]",
            "user3 escribió: “Nueva actualización en el proyecto #Tech” el [Agosto 2023]",
            "user4 escribió: “Disfrutando de la vida #Feliz” el [Agosto 2023]",
            "user5 escribió: “Aprendiendo Java #Programming” el [Septiembre 2023]"
        };
        mostrados = new String[tweets.length]; // Array para almacenar los tweets ya mostrados
        contadorMostrados = 0;

        // Acción del botón "Buscar"
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarHashtags();
            }
        });

        // Acción del botón "Regresar"
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para regresar al menú principal (puedes cambiarlo según tu lógica)
                MenuPrincipal menu = new MenuPrincipal(); // Crear una instancia del menú principal
                menu.setVisible(true); // Mostrar el menú principal
                dispose(); // Cerrar la ventana actual
            }
        });
    }

    // Método para buscar tweets con un hashtag
    private void buscarHashtags() {
        String hashtag = hashtagField.getText().trim();
        if (!hashtag.startsWith("#")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un hashtag que comience con #");
            return;
        }

        resultArea.setText(""); // Limpiamos el área de texto
        contadorMostrados = 0; // Reiniciamos el contador de tweets mostrados

        for (String tweet : tweets) {
            if (tweet.contains(hashtag)) {
                // Verificar si el tweet ya ha sido mostrado
                boolean yaMostrado = false;
                for (int i = 0; i < contadorMostrados; i++) {
                    if (mostrados[i].equals(tweet)) {
                        yaMostrado = true;
                        break;
                    }
                }
                // Si no ha sido mostrado, lo mostramos y lo añadimos a los mostrados
                if (!yaMostrado) {
                    resultArea.append(tweet + "\n");
                    mostrados[contadorMostrados] = tweet;
                    contadorMostrados++;
                }
            }
        }

        if (resultArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron tweets con ese hashtag.");
        }
    }

  

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Hasthtags = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        Buscar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Hasthtags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HasthtagsActionPerformed(evt);
            }
        });

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RegresarSmall.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(Buscar)
                .addGap(26, 26, 26)
                .addComponent(Hasthtags, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar)
                    .addComponent(Hasthtags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        MenuPrincipal principal=new MenuPrincipal();
        principal.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void HasthtagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HasthtagsActionPerformed
    String tweetText = Hasthtags.getText();
    Hasthtags.setText("");
    if(!tweetText.isEmpty()){
        
    }else{
    JOptionPane.showMessageDialog(this,"Hasthtags no encontrado");
    }
    }//GEN-LAST:event_HasthtagsActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        
        
    }//GEN-LAST:event_BuscarActionPerformed

    
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
            java.util.logging.Logger.getLogger(Hashtags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hashtags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hashtags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hashtags.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hashtags().setVisible(true);
            }
        });
    }

    void setVisivle(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Buscar;
    private javax.swing.JTextField Hasthtags;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
