/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.view;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import penjualan.panel.BarangPanel;
import penjualan.panel.TransaksiPanel;

/**
 *
 * @author fadil
 */
public class PenjualanView extends javax.swing.JFrame {

    /**
     * Creates new form PenjualanView
     */
    public PenjualanView() {
        initComponents();
    }
    
    private void replaceMenuView(Component c) {
        menuView.removeAll();
        menuView.add(c, new java.awt.GridBagConstraints());
        menuView.revalidate();
        menuView.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        menuView = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {6};
        jPanel1Layout.columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-run.png"))); // NOI18N
        jLabel1.setText("Home");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/main.png"))); // NOI18N
        jLabel2.setText("Master");
        jLabel2.setName("master"); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new java.awt.GridBagConstraints());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/money.png"))); // NOI18N
        jLabel3.setText("Transaksi");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new java.awt.GridBagConstraints());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/result.png"))); // NOI18N
        jLabel4.setText("Laporan");
        jPanel1.add(jLabel4, new java.awt.GridBagConstraints());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/info.png"))); // NOI18N
        jLabel5.setText("Help");
        jPanel1.add(jLabel5, new java.awt.GridBagConstraints());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        jLabel6.setText("Logout");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new java.awt.GridBagConstraints());

        menuView.setName(""); // NOI18N
        menuView.setLayout(new java.awt.GridBagLayout());

        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File(getClass().getResource("/image/logo-company.png").toURI()));

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon(fitimage(image, 380, 230));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(imageIcon);
        menuView.add(jLabel7, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addComponent(menuView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuView, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeClicked
        // TODO add your handling code here:
        replaceMenuView(jLabel7);
    }//GEN-LAST:event_homeClicked

    private void masterClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterClicked
        // TODO add your handling code here:
        replaceMenuView(new BarangPanel());
    }//GEN-LAST:event_masterClicked

    private void logoutClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new LoginView().setVisible(true);
    }//GEN-LAST:event_logoutClicked

    private void transaksiClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiClicked
        // TODO add your handling code here:
        replaceMenuView(new TransaksiPanel());
    }//GEN-LAST:event_transaksiClicked
    
    private Image fitimage(Image img , int w , int h) {
        BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0,w,h,null);
        g2.dispose();
        return resizedimage;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menuView;
    // End of variables declaration//GEN-END:variables
}
