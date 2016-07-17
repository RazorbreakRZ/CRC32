/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.Checksum;
import javax.swing.Timer;

/**
 *
 * @author Razorbreak
 */
public class mainWin extends javax.swing.JFrame {

    /**
     * Creates new form mainWin
     */
    public mainWin() {
        initComponents();
        this.setLocationRelativeTo(null);
        Timer timer = new Timer(10000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateCRC32(jTextField_Base.getText());
                System.out.println(jTextField_Code.getText());
            }
        });
        timer.start();
    }
    
    public void updateCRC32(String base){
        if(!this.jTextField_Base.getText().equals("")){
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            String str = base+c.get(Calendar.DATE)+c.get(Calendar.MONTH)+c.get(Calendar.YEAR)+c.get(Calendar.HOUR)+c.get(Calendar.MINUTE);
            byte bytes[] = str.getBytes();
            Checksum checksum = new java.util.zip.CRC32();
            checksum.update(bytes,0,bytes.length);
            long lngChecksum = checksum.getValue();
            this.jTextField_Code.setText(""+lngChecksum);
        }else{
            this.jTextField_Code.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_Code = new javax.swing.JTextField();
        jTextField_Base = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRC32");
        setResizable(false);

        jTextField_Code.setEditable(false);
        jTextField_Code.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField_Base.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Base.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField_BaseCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_Code)
                    .addComponent(jTextField_Base, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_BaseCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField_BaseCaretUpdate
        this.updateCRC32(this.jTextField_Base.getText());
    }//GEN-LAST:event_jTextField_BaseCaretUpdate

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(mainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField_Base;
    private javax.swing.JTextField jTextField_Code;
    // End of variables declaration//GEN-END:variables
}