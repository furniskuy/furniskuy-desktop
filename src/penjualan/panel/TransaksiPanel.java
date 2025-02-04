/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package penjualan.panel;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import penjualan.entity.TransaksiEntity;
import penjualan.implement.TransaksiImplement;
import penjualan.koneksi.KoneksiSql;

public class TransaksiPanel extends javax.swing.JPanel {
    TransaksiImplement transaksiImplement = new TransaksiImplement();
    ArrayList<TransaksiEntity> lisTransaksi = new ArrayList<>();
    /**
     * Creates new form TransaksiPanel
     */
    public TransaksiPanel() {
        initComponents();
        
        try {
            setKodeBarang();
            setIdPelanggan();
            tableBarang.setModel(new DefaultTableModel(null, new String [] {
                "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Subtotal"
            }));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal mendapat data dari database \n" + e.getMessage());
        }
    }
     
    private void setKodeBarang() throws SQLException {
        TransaksiImplement transaksiImpl = new TransaksiImplement();
        ArrayList<String> urutanArr = transaksiImpl.viewKdBarang();
        
        DefaultComboBoxModel dcm = new  DefaultComboBoxModel<String>();
        dcm.addElement("--Pilih--");
        for (String str : urutanArr) {
            dcm.addElement(str);
        }
        selectBarang.setModel(dcm);
    }
    
    private void setIdPelanggan() throws SQLException {
        TransaksiImplement transaksiImpl = new TransaksiImplement();
        ArrayList<String> urutanArr = transaksiImpl.viewIdPelanggan();
        
        DefaultComboBoxModel dcm = new  DefaultComboBoxModel<String>();
         dcm.addElement("--Pilih--");
        for (String str : urutanArr) {
            dcm.addElement(str);
        }
        selectPelanggan.setModel(dcm);
    }
    
    private void hitungTotalBayar() {
        int jmlRow = tableBarang.getRowCount();
        long total = 0;
        
        if (jmlRow == 0) {
            return;
        } else {
            for (int i = 0; i < jmlRow; i++) {
                long jmlTotal = (long) tableBarang.getValueAt(i, 4);
                total += jmlTotal;
            }
        }
        totalField.setText(String.valueOf(total));   
    }
    
    boolean fieldIsEmpty() {
        return ((String) selectPelanggan.getSelectedItem()).isEmpty() || ((String) selectBarang.getSelectedItem()).isEmpty() || jumlahField.getText().isEmpty();
    }
    
    void clearField() {
        selectPelanggan.setSelectedItem("--Pilih--");
        alamatField.setText("");
        noTelpField.setText("");
        selectBarang.setSelectedItem("--Pilih--");
        jumlahField.setText("");
        hargaField.setText("");
        
        tableBarang.setModel(new DefaultTableModel(null, new String [] {
            "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Subtotal"
        }));
    }
    
     void simpanData() {
        if (!lisTransaksi.isEmpty()) {
            
            try {
                transaksiImplement.insert(lisTransaksi);
                JOptionPane.showMessageDialog(this, "Berhasil menyimpan data ke database");
                clearField();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data ke database \n" + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong");
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

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jumlahField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        hargaField = new javax.swing.JTextField();
        selectBarang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tambahBarangButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        simpanField = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        noTelpField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        alamatField = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        selectPelanggan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableBarang);

        jLabel19.setText("Nama Barang");

        jLabel20.setText("Jumlah");

        jLabel21.setText("Harga");

        selectBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectBarangItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(56, 56, 56)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahField)
                    .addComponent(hargaField)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(selectBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(selectBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Data Barang");

        tambahBarangButton.setText("Tambah ke Keranjang");
        tambahBarangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBarangButtonActionPerformed(evt);
            }
        });

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Pembayaran");

        simpanField.setText("Simpan");
        simpanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(422, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambahBarangButton)
                        .addGap(18, 18, 18)
                        .addComponent(hapusButton)
                        .addGap(85, 85, 85))))
            .addComponent(jScrollPane4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(simpanField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahBarangButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(simpanField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel6.setText("No Tlp");

        alamatField.setColumns(20);
        alamatField.setRows(5);
        jScrollPane3.setViewportView(alamatField);

        jLabel7.setText("Alamat");

        jLabel9.setText("Nama Pelanggan");

        selectPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectPelanggan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectPelangganItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3)
                    .addComponent(selectPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(selectPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(noTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel6))
                            .addComponent(jLabel7))))
                .addGap(61, 61, 61))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Data Pelanggan");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Transaksi Penjualan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectPelangganItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectPelangganItemStateChanged
        String kode = (String) selectPelanggan.getSelectedItem();
        String kodeFix = kode.split("-")[0];
        try {
            Statement st = KoneksiSql.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT alamat, notlp FROM pelanggan WHERE id_pelanggan= '" + kodeFix + "';");
            while(rs.next()) {
                alamatField.setText(rs.getString("alamat"));
                noTelpField.setText(rs.getString("notlp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_selectPelangganItemStateChanged

    private void simpanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanFieldActionPerformed
            simpanData();
    }//GEN-LAST:event_simpanFieldActionPerformed

    private void tambahBarangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBarangButtonActionPerformed
        String kode = (String) selectBarang.getSelectedItem();
        String kodeFix = kode.split("-")[0];
        String namaBarang  = kode.split("-")[1];
        
        String idPelangganStr = (String) selectPelanggan.getSelectedItem();
        int idPelanggan = Integer.parseInt(idPelangganStr.split("-")[0]);

        int harga = Integer.valueOf(hargaField.getText());
        int jumlah = Integer.valueOf(jumlahField.getText());
        long subTotal = harga * jumlah;

        Object[] data = new Object[5];
        data[0] = kodeFix;
        data[1] = namaBarang;
        data[2] = hargaField.getText();
        data[3] = jumlahField.getText();
        data[4] = subTotal;
        
        TransaksiEntity transaksi = new TransaksiEntity();
        transaksi.setIdPelanggan(idPelanggan);
        transaksi.setIdBarang(kodeFix);
        transaksi.setJumlah(jumlah);
        transaksi.setSubTotal(subTotal);
        
        lisTransaksi.add(transaksi);

        DefaultTableModel model = (DefaultTableModel) tableBarang.getModel();
        model.addRow(data);
        hitungTotalBayar();
    }//GEN-LAST:event_tambahBarangButtonActionPerformed

    private void selectBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectBarangItemStateChanged
        String kode = (String) selectBarang.getSelectedItem();
        String kodeFix = kode.split("-")[0];
        try {
            Statement st = KoneksiSql.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT jumlah, harga FROM barang WHERE kode_barang = '" + kodeFix + "';");
            while(rs.next()) {
                jumlahField.setText(rs.getString("jumlah"));
                hargaField.setText(rs.getString("harga"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_selectBarangItemStateChanged

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        int delData = this.tableBarang.getSelectedRow();

        if(delData == -1){
            return;
        }
        else{
            DefaultTableModel model = (DefaultTableModel) tableBarang.getModel();
            model.removeRow(delData);
            this.hitungTotalBayar();
        }
    }//GEN-LAST:event_hapusButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatField;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextField hargaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jumlahField;
    private javax.swing.JTextField noTelpField;
    private javax.swing.JComboBox<String> selectBarang;
    private javax.swing.JComboBox<String> selectPelanggan;
    private javax.swing.JButton simpanField;
    private javax.swing.JTable tableBarang;
    private javax.swing.JButton tambahBarangButton;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
