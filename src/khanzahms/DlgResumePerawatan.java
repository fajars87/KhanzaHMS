/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgLhtBiaya.java
 *
 * Created on 12 Jul 10, 16:21:34
 */

package khanzahms;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.var;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author perpustakaan
 */
public final class DlgResumePerawatan extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();

    /** Creates new form DlgLhtBiaya
     * @param parent
     * @param modal */
    public DlgResumePerawatan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(885,674);

        Object[] rowRwJlDr={"<html><font color='#648664' face='Tahoma'>No.",
            "<html><font color='#648664' face='Tahoma'>Keterangan",
            "<html><font color='#648664' face='Tahoma'>Perawatan/Tindakan/Terapi",
            "<html><font color='#648664' face='Tahoma'>Paramedis/Penyakit",
            "<html><font color='#648664' face='Tahoma'>Tgl.Perawatan"};
        tabMode=new DefaultTableModel(null,rowRwJlDr){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbBangsal.setModel(tabMode);
        //tbBangsal.setDefaultRenderer(Object.class, new WarnaTable(jPanel2.getBackground(),tbBangsal.getBackground()));
        tbBangsal.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbBangsal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 5; i++) {
            TableColumn column = tbBangsal.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(37);
            }else if(i==1){
                column.setPreferredWidth(140);
            }else if(i==2){
                column.setPreferredWidth(550);
            }else if(i==3){
                column.setPreferredWidth(300);
            }else if(i==4){
                column.setPreferredWidth(150);
            }
        }
        tbBangsal.setDefaultRenderer(Object.class, new WarnaTable());

        TKd.setDocument(new batasInput((byte)20).getKata(TKd));
        
        datareg.getTable().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KdRw.setText(datareg.getTextField().getText());   
                isPasien();               
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    DlgPasien datareg=new DlgPasien(null,false);
    private String[] hlm;
    int y=0,w=0;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TKd = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbBangsal = new widget.Table();
        panelGlass5 = new widget.panelisi();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        jLabel14 = new widget.Label();
        cmbHlm = new widget.ComboBox();
        label18 = new widget.Label();
        BtnKeluar = new widget.Button();
        panelisi4 = new widget.panelisi();
        label17 = new widget.Label();
        KdRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        BtnSeek2 = new widget.Button();
        BtnCari1 = new widget.Button();

        TKd.setForeground(new java.awt.Color(255, 255, 255));
        TKd.setName("TKd"); // NOI18N
        TKd.setSelectionColor(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Data Resume/Rincian Tindakan/Terapi Pasien ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbBangsal.setAutoCreateRowSorter(true);
        tbBangsal.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbBangsal.setName("tbBangsal"); // NOI18N
        tbBangsal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBangsalMouseClicked(evt);
            }
        });
        tbBangsal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbBangsalKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbBangsal);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        panelGlass5.setName("panelGlass5"); // NOI18N
        panelGlass5.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnAll);

        jLabel14.setText("Halaman :");
        jLabel14.setName("jLabel14"); // NOI18N
        jLabel14.setPreferredSize(new java.awt.Dimension(100, 23));
        panelGlass5.add(jLabel14);

        cmbHlm.setName("cmbHlm"); // NOI18N
        cmbHlm.setOpaque(false);
        cmbHlm.setPreferredSize(new java.awt.Dimension(65, 23));
        panelGlass5.add(cmbHlm);

        label18.setName("label18"); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(110, 23));
        panelGlass5.add(label18);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnKeluar);

        internalFrame1.add(panelGlass5, java.awt.BorderLayout.PAGE_END);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label17.setText("Pasien :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(55, 23));
        panelisi4.add(label17);

        KdRw.setName("KdRw"); // NOI18N
        KdRw.setPreferredSize(new java.awt.Dimension(110, 23));
        KdRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdRwKeyPressed(evt);
            }
        });
        panelisi4.add(KdRw);

        TPasien.setEditable(false);
        TPasien.setName("TPasien"); // NOI18N
        TPasien.setPreferredSize(new java.awt.Dimension(350, 23));
        panelisi4.add(TPasien);

        BtnSeek2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek2.setMnemonic('3');
        BtnSeek2.setToolTipText("Alt+3");
        BtnSeek2.setName("BtnSeek2"); // NOI18N
        BtnSeek2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek2ActionPerformed(evt);
            }
        });
        BtnSeek2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSeek2KeyPressed(evt);
            }
        });
        panelisi4.add(BtnSeek2);

        BtnCari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari1.setMnemonic('2');
        BtnCari1.setToolTipText("Alt+2");
        BtnCari1.setName("BtnCari1"); // NOI18N
        BtnCari1.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCari1ActionPerformed(evt);
            }
        });
        BtnCari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCari1KeyPressed(evt);
            }
        });
        panelisi4.add(BtnCari1);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Sequel.queryu("delete from temporary");
            int row=tabMode.getRowCount();
            for(int r=0;r<row;r++){  
                Sequel.menyimpan("temporary","'0','"+
                                tabMode.getValueAt(r,0).toString().replaceAll("'","`") +"','"+
                                tabMode.getValueAt(r,1).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,2).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,3).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,4).toString().replaceAll("'","`")+"','','','','','','','','','','','',''","Rekap Harian Tindakan Dokter"); 
            }
            Valid.MyReport("rptResumeMedis.jrxml","report","::[ Rekap Harian Tindakan Dokter ]::",
                "select no, temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14 from temporary order by no asc");
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
           Valid.pindah(evt, BtnCari1, BtnAll);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnAll,TKd);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void tbBangsalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBangsalMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbBangsalMouseClicked

    private void tbBangsalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBangsalKeyPressed
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
}//GEN-LAST:event_tbBangsalKeyPressed

private void KdRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdRwKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            isPasien();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            isPasien();
            BtnKeluar.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            isPasien();
            BtnPrint.requestFocus();
        }
}//GEN-LAST:event_KdRwKeyPressed

private void BtnSeek2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek2ActionPerformed
        var.setStatus(true);
        datareg.tampil();
        datareg.isCek();
        datareg.emptTeks();
        datareg.setSize(internalFrame1.getWidth(),internalFrame1.getHeight());
        datareg.setLocationRelativeTo(internalFrame1);
        datareg.setVisible(true);
}//GEN-LAST:event_BtnSeek2ActionPerformed

private void BtnSeek2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSeek2KeyPressed
    //Valid.pindah(evt,Tgl2,TKd);
}//GEN-LAST:event_BtnSeek2KeyPressed

private void BtnCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCari1ActionPerformed
        tampil();
}//GEN-LAST:event_BtnCari1ActionPerformed

private void BtnCari1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCari1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tampil();
        }else{
           // Valid.pindah(evt, TKd, BtnAll);
        }
}//GEN-LAST:event_BtnCari1KeyPressed

private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        KdRw.setText("");
        TPasien.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgResumePerawatan dialog = new DlgResumePerawatan(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnCari1;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSeek2;
    private widget.TextBox KdRw;
    private widget.ScrollPane Scroll;
    private widget.TextBox TKd;
    private widget.TextBox TPasien;
    private widget.ComboBox cmbHlm;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel14;
    private widget.Label label17;
    private widget.Label label18;
    private widget.panelisi panelGlass5;
    private widget.panelisi panelisi4;
    private widget.Table tbBangsal;
    // End of variables declaration//GEN-END:variables

    public void tampil(){
        String sql="select pasien.no_rkm_medis, pasien.nm_pasien, pasien.jk, pasien.alamat, pasien.umur "+
                   "from pasien where pasien.no_rkm_medis like '%"+KdRw.getText()+"%' order by pasien.no_rkm_medis desc ";
        prosesCari(sql);
    }

    private void prosesCari(String sql) {
        Valid.tabelKosong(tabMode);
        try{
            String awal="0";
            if(cmbHlm.getItemCount()>0){
                awal=hlm[Integer.parseInt(cmbHlm.getSelectedItem().toString())];
            }
            ResultSet rs=koneksi.createStatement().executeQuery(sql+" LIMIT "+awal+",100");
            y=1;
            while(rs.next()){                
                String[] data={y+". ","No.RM",": "+rs.getString("no_rkm_medis"),"",""};
                tabMode.addRow(data);
                String[] data2={"","Nama Pasien",": "+rs.getString("nm_pasien"),"",""};
                tabMode.addRow(data2);
                String[] data3={"","Alamat",": "+rs.getString("alamat"),"",""};
                tabMode.addRow(data3);
                String[] data4={"","Umur",": "+rs.getString("umur")+" ("+rs.getString("jk") +")","",""};
                tabMode.addRow(data4);
                ResultSet rs2=koneksi.createStatement().executeQuery(
                        "select reg_periksa.no_rawat, reg_periksa.tgl_registrasi from reg_periksa where reg_periksa.no_rkm_medis='"+rs.getString("no_rkm_medis")+"'");
                while(rs2.next()){
                    String[] data5={"","No.Rawat",": "+rs2.getString("no_rawat"),"",""};
                    tabMode.addRow(data5);  
                    //menampilkan data rawat jalan dokter
                    ResultSet rs3=koneksi.createStatement().executeQuery(
                            "select jns_perawatan.nm_perawatan,dokter.nm_dokter "+
                            "from rawat_jl_dr inner join jns_perawatan inner join dokter "+
                            "on rawat_jl_dr.kd_jenis_prw=jns_perawatan.kd_jenis_prw "+
                            "and rawat_jl_dr.kd_dokter=dokter.kd_dokter where rawat_jl_dr.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs3.next()){
                        String[] judulrj={"","Rawat Jalan Dokter",":","",""};
                        tabMode.addRow(judulrj);
                    }
                    rs3.beforeFirst();
                    w=1;
                    while(rs3.next()){
                        String[] data6={"","",w+". "+rs3.getString("nm_perawatan"),rs3.getString("nm_dokter"),rs2.getString("tgl_registrasi")};
                        tabMode.addRow(data6);
                        w++;
                    }
                    //rs3.close();
                    //menampilkan data rawat inap dokter
                    ResultSet rs4=koneksi.createStatement().executeQuery(
                            "select rawat_inap_dr.tgl_perawatan,rawat_inap_dr.jam_rawat,jns_perawatan.nm_perawatan,"+
                            "dokter.nm_dokter from rawat_inap_dr inner join jns_perawatan inner join dokter "+
                            "on rawat_inap_dr.kd_jenis_prw=jns_perawatan.kd_jenis_prw "+
                            "and rawat_inap_dr.kd_dokter=dokter.kd_dokter where rawat_inap_dr.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs4.next()){
                        String[] judulri={"","Rawat Inap Dokter",":","",""};
                        tabMode.addRow(judulri);
                    }
                    w=1;
                    rs4.beforeFirst();
                    while(rs4.next()){
                        String[] data6={"","",w+". "+rs4.getString("nm_perawatan"),rs4.getString("nm_dokter"),
                                       rs4.getString("tgl_perawatan")+" "+rs4.getString("jam_rawat")};
                        tabMode.addRow(data6);
                        w++;
                    }
                    //rs4.close();
                    //menampilkan data rawat jalan perawat
                    ResultSet rs5=koneksi.createStatement().executeQuery(
                            "select jns_perawatan.nm_perawatan,petugas.nama from rawat_jl_pr inner join jns_perawatan "+
                            "inner join petugas on rawat_jl_pr.kd_jenis_prw=jns_perawatan.kd_jenis_prw "+
                            "and rawat_jl_pr.nip=petugas.nip where rawat_jl_pr.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs5.next()){
                        String[] judulrj={"","Rawat Jalan Perawat",":","",""};
                        tabMode.addRow(judulrj);
                    }
                    w=1;
                    rs5.beforeFirst();
                    while(rs5.next()){
                        String[] data7={"","",w+". "+rs5.getString("nm_perawatan"),rs5.getString("nama"),rs2.getString("tgl_registrasi")};
                        tabMode.addRow(data7);
                        w++;
                    }
                    //rs5.close();
                    //menampilkan data rawat inap perawat
                    ResultSet rs6=koneksi.createStatement().executeQuery(
                            "select rawat_inap_pr.tgl_perawatan,rawat_inap_pr.jam_rawat,jns_perawatan.nm_perawatan, "+
                             "petugas.nama  from rawat_inap_pr inner join jns_perawatan inner join petugas "+
                             "on rawat_inap_pr.kd_jenis_prw=jns_perawatan.kd_jenis_prw "+
                             "and rawat_inap_pr.nip=petugas.nip  where rawat_inap_pr.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs6.next()){
                        String[] judulri={"","Rawat Inap Perawat",":","",""};
                        tabMode.addRow(judulri);
                    }
                    w=1;
                    rs6.beforeFirst();
                    while(rs6.next()){
                        String[] data8={"","",w+". "+rs6.getString("nm_perawatan"),rs6.getString("nama"),
                                       rs6.getString("tgl_perawatan")+" "+rs6.getString("jam_rawat")};
                        tabMode.addRow(data8);
                        w++;
                    }
                    //rs6.close();
                    //menampilkan data pemberian obat
                    ResultSet rs7=koneksi.createStatement().executeQuery(
                            "select detail_pemberian_obat.tgl_perawatan,detail_pemberian_obat.jam,penyakit.nm_penyakit, "+
                            "databarang.nama_brng from detail_pemberian_obat inner join penyakit inner join databarang "+
                            "on detail_pemberian_obat.kd_penyakit=penyakit.kd_penyakit and detail_pemberian_obat.kode_brng=databarang.kode_brng  "+
                            "where detail_pemberian_obat.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs7.next()){
                        String[] judulbo={"","Pemberian Obat",":","",""};
                        tabMode.addRow(judulbo);
                    }
                    w=1;
                    rs7.beforeFirst();
                    while(rs7.next()){
                        String[] data9={"","",w+". "+rs7.getString("nama_brng"),rs7.getString("nm_penyakit"),
                                       rs7.getString("tgl_perawatan")+" "+rs7.getString("jam")};
                        tabMode.addRow(data9);
                        w++;
                    }
                    //rs7.close();
                    //menampilkan data kamar inap
                    ResultSet rs8=koneksi.createStatement().executeQuery(
                            "select kamar_inap.kd_kamar,bangsal.nm_bangsal,kamar_inap.tgl_masuk, kamar_inap.tgl_keluar "+
                            "from kamar_inap inner join bangsal inner join kamar "+
                            "on kamar_inap.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal  "+
                            "where kamar_inap.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs8.next()){
                        String[] judulki={"","Kamar Inap",":","",""};
                        tabMode.addRow(judulki);
                    }
                    w=1;
                    rs8.beforeFirst();
                    while(rs8.next()){
                        String[] data10={"","",w+". "+rs8.getString("kd_kamar")+", "+rs8.getString("nm_bangsal"),
                                        "Masuk : "+rs8.getString("tgl_masuk")+"  Pulang : "+rs8.getString("tgl_keluar"),""};
                        tabMode.addRow(data10);
                        w++;
                    }
                    //rs8.close(); 
                    //menampilkan data resep pulang
                    ResultSet rs9=koneksi.createStatement().executeQuery(
                            "select databarang.nama_brng,resep_pulang.dosis "+
                            "from resep_pulang inner join databarang "+
                            "on resep_pulang.kode_brng=databarang.kode_brng where "+
                            "resep_pulang.no_rawat='"+rs2.getString("no_rawat")+"' order by databarang.nama_brng");
                    if(rs9.next()){
                        String[] judulki={"","Resep Pulang",":","",""};
                        tabMode.addRow(judulki);
                    }
                    w=1;
                    rs9.beforeFirst();
                    while(rs9.next()){
                        String[] data10={"","",w+". "+rs9.getString("nama_brng")+", "+rs9.getString("dosis"),"",""};
                        tabMode.addRow(data10);
                        w++;
                    }
                    //rs9.close();       
                    //menampilkan data periksa lab
                    ResultSet rs10=koneksi.createStatement().executeQuery(
                            "select  petugas.nama,jns_perawatan.nm_perawatan,periksa_lab.tgl_periksa,periksa_lab.jam "+
                            " from periksa_lab inner join reg_periksa inner join pasien inner join petugas inner join jns_perawatan "+
                            " on periksa_lab.no_rawat=reg_periksa.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                            " and periksa_lab.nip=petugas.nip and periksa_lab.kd_jenis_prw=jns_perawatan.kd_jenis_prw "+
                            " where  periksa_lab.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs10.next()){
                        String[] judulri={"","Periksa Lab",":","",""};
                        tabMode.addRow(judulri);
                    }
                    w=1;
                    rs10.beforeFirst();
                    while(rs10.next()){
                        String[] data8={"","",w+". "+rs10.getString("nm_perawatan"),rs10.getString("nama"),
                                       rs10.getString("tgl_periksa")+" "+rs10.getString("jam")};
                        tabMode.addRow(data8);
                        w++;
                    }
                    //rs10.close();
                    //menampilkan data operasi
                    ResultSet rs11=koneksi.createStatement().executeQuery(
                        "select operasi.tgl_operasi,operasi.operator1, operasi.dokter_anestesi,operasi.asisten_operator1, operasi.asisten_anestesi,operasi.perawat_luar,"+
                        "operasi.kode_paket,paket_operasi.nm_perawatan,operasi.biayaoperator1, operasi.biayaasisten_operator1,operasi.biayaalat, operasi.biayadokter_anestesi,"+
                        "operasi.biayaperawat_luar, operasi.biayaasisten_anestesi,operasi.biayasewaok from operasi inner join paket_operasi "+
                        "on operasi.kode_paket=paket_operasi.kode_paket where operasi.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs11.next()){
                        String[] judulri={"","Operasi",":","",""};
                        tabMode.addRow(judulri);
                    }
                    w=1;
                    rs11.beforeFirst();
                    while(rs11.next()){
                        String[] data8={"","",w+". "+rs11.getString("nm_perawatan"),
                               Sequel.cariIsi("select nm_dokter from dokter where kd_dokter='"+rs11.getString("operator1")+"'")+", "+
                               Sequel.cariIsi("select nm_dokter from dokter where kd_dokter='"+rs11.getString("dokter_anestesi")+"'")+", "+
                               Sequel.cariIsi("select nama from petugas where nip='"+rs11.getString("asisten_operator1")+"'")+", "+
                               Sequel.cariIsi("select nama from petugas where nip='"+rs11.getString("asisten_anestesi")+"'")+", "+
                               Sequel.cariIsi("select nama from petugas where nip='"+rs11.getString("perawat_luar")+"'"),
                                       rs11.getString("tgl_operasi")};
                        tabMode.addRow(data8);
                        w++;
                    }
                    //rs11.close();
                     //menampilkan data pemberian obat operasi
                    ResultSet rs12=koneksi.createStatement().executeQuery(
                            "select beri_obat_operasi.tanggal, "+
                            "obatbhp_ok.nm_obat from beri_obat_operasi inner join obatbhp_ok  "+
                            "on  beri_obat_operasi.kd_obat=obatbhp_ok.kd_obat  "+
                            "where beri_obat_operasi.no_rawat='"+rs2.getString("no_rawat")+"'");
                    if(rs12.next()){
                        String[] judulbo={"","Obat & BHP Operasi",":","",""};
                        tabMode.addRow(judulbo);
                    }
                    w=1;
                    rs12.beforeFirst();
                    while(rs12.next()){
                        String[] data9={"","",w+". "+rs12.getString("nm_obat"),"",
                                       rs12.getString("tanggal")};
                        tabMode.addRow(data9);
                        w++;
                    }
                    //rs12.close();
                }   
                
                String[] data10={"","","","",""};
                        tabMode.addRow(data10);
                        
                y++;
                //rs2.close();
            }
            
            cmbHlm.removeAllItems();
            ResultSet rshal=koneksi.createStatement().executeQuery(sql);
            rshal.last();
            double jumlah=rshal.getRow();
            double x=jumlah/99;
            double i=Math.ceil(x);
            int z=(int) i;
            
            hlm=new String[z+1];
            for(int j=1;j<=i;j++){
                 int mulai=((j-1)*99+j)-1;
                 hlm[j]=Integer.toString(mulai);
                 cmbHlm.addItem(j);
            }
            //rshal.close();
            
            //rs.close();
           // LCount.setText(Valid.SetAngka(all));
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }

    private void getData() {
        int row=tbBangsal.getSelectedRow();
        if(row!= -1){
            String kode=tabMode.getValueAt(row,0).toString();
            TKd.setText(kode);
        }
    }
    
    public void isPasien(){
        Sequel.cariIsi("select pasien.nm_pasien from pasien where pasien.no_rkm_medis='"+KdRw.getText()+"' ",TPasien);
    }

    public  void setNoRm(String norm) {
        KdRw.setText(norm);
    }

}
