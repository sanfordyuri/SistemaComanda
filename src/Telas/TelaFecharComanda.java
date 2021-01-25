/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Metodos.CadastroProdutos;
import Metodos.Produto;
import static Telas.TelaGerenciarComanda.labela1;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yuri Sanford
 */
public class TelaFecharComanda extends javax.swing.JFrame {

    /**
     * Creates new form TelaFecharComanda
     */
    public TelaFecharComanda() {
        initComponents();
        readJTable();
    }
    String cc = null;
    public void recebendo(String recebe) {
        cc = recebe;
        labela3.setVisible(false);
        labela3.setText(cc);
        readJTable();
    }
                    double valor_total = 0;
        public void readJTable() {
            cc = labela3.getText();
            System.out.println(cc);

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            if(Metodos.CadastroProdutos.verificarSeComandaExiste(cc)) {

                modelo.setNumRows(0);
                CadastroProdutos c = new CadastroProdutos();
                for(Produto p : c.read(cc)) {
                    valor_total +=  p.getValor() * p.getQuantidade();
                   if(p.getQuantidade() > 0) {
                        modelo.addRow(new Object[]{
                        p.getCodigo(),p.getNome(),p.getQuantidade(),"R$" + p.getValor() * p.getQuantidade()
                });  
                   }

                }

                labela1.setText("Valor total: R$" + valor_total);                
            } else {
                labela1.setText("Valor total: R$0,00");
                modelo.setNumRows(0);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        labela1 = new javax.swing.JLabel();
        jFormattedTextField2 = new Telas.JTextFH(new JFormattedTextField(), "etiqueta-de-preco", "Valor Entregue pelo Cliente.");
        labela2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        labela3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Produto", "Nome. Produto", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(91, 95, 99));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Aqui você pode Finalizar uma Comanda.");

        labela1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        labela1.setForeground(new java.awt.Color(0, 255, 0));
        labela1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labela1.setText("Valor Total: R$ 0,00");

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jFormattedTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField2FocusLost(evt);
            }
        });
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        labela2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        labela2.setForeground(new java.awt.Color(51, 204, 0));
        labela2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labela2.setText("Valor Troco: R$ 0,00");

        jButton3.setBackground(new java.awt.Color(58, 65, 74));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Finalizar");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(217, 81, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Voltar");
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        labela3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        labela3.setForeground(new java.awt.Color(0, 255, 0));
        labela3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labela3.setText("Valor Total: R$ 0,00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labela2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labela1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labela3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labela1)
                .addGap(30, 30, 30)
                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labela2)
                .addGap(30, 30, 30)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(labela3)
                .addGap(34, 34, 34))
        );

        jPanel2.setBackground(new java.awt.Color(27, 155, 222));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fechamento da Comanda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField2FocusLost
        if(!("".equalsIgnoreCase(jFormattedTextField2.getText()))) {
            String valor = labela1.getText();
            String vr = valor.replace("Valor", "").replace("R$", "").replace(" ", "").replace(",", ".").replace("total:", "");
            double valor_total = Double.parseDouble(vr);
            String sv = jFormattedTextField2.getText();
            double dinheiro = Double.parseDouble(sv);
            if(dinheiro >= valor_total) {
                double resultado = dinheiro - valor_total;
                labela2.setText("Valor do Troco: R$" + resultado);
            }
            String sv2 = jFormattedTextField2.getText();
            String vsf = sv2.replace("R$", "").replace(" ","").replace(",", ".");
            BigDecimal valor2 = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor2);
            jFormattedTextField2.setText(valorFormatado);
        }
    }//GEN-LAST:event_jFormattedTextField2FocusLost

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBackground(new Color(235,235,235));
        jButton3.setForeground(new Color(58,65,84));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBackground(new Color(58,65,74));
        jButton3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Date data = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        String dataf = f.format(data);
        Metodos.CadastroProdutos.adicionarRelatorio(dataf,valor_total);
        CadastroProdutos c = new CadastroProdutos();
        try {
            for(Produto p : c.read(labela3.getText())) {
                Metodos.CadastroProdutos.removerProdutoE(p.getCodigo(), p.getQuantidade());
            }
            Metodos.CadastroProdutos.removeC(labela3.getText());
            readJTable();
            labela3.setForeground(Color.green);
            labela3.setText("Comanda Finalizada com Sucesso.");
            labela3.setVisible(true);           
        } catch(Exception e) {
            
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setBackground(new Color(235,235,235));
        jButton4.setForeground(new Color(217,81,51));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setBackground(new Color(217,81,51));
        jButton4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaGerenciarComanda tg = new TelaGerenciarComanda();
        this.setVisible(false);
        tg.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFecharComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFecharComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFecharComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFecharComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFecharComanda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JLabel labela1;
    public static javax.swing.JLabel labela2;
    public static javax.swing.JLabel labela3;
    // End of variables declaration//GEN-END:variables
}
