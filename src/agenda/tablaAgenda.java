/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 * Clase que solo contiene una tabla con todas las entradas
 * @author death
 */
public class tablaAgenda extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public tablaAgenda() {
        initComponents();
        this.setTitle("Agenda 2017 - Todos");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 300));

        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();

        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");

            //  Read data from a table

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from contactos");
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();
            stat.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames)
            {
                @Override
                public Class getColumnClass(int column)
                {
                    for (int row = 0; row < getRowCount(); row++)
                    {
                        Object o = getValueAt(row, column);

                        if (o != null)
                        {
                            return o.getClass();
                        }
                    }

                    return Object.class;
                }
            });

            JScrollPane scrollPane = new JScrollPane();
            getContentPane().add( scrollPane );

            JPanel buttonPanel = new JPanel();
            getContentPane().add( buttonPanel, BorderLayout.SOUTH
            );
            jScrollPane1.setViewportView(jTable1);

            jButton1.setText("Salir");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(15, 15, 15))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(337, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton1))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            JOptionPane.showMessageDialog(null, "Error!!!");
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Error!!!");
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Error!!!");
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Error!!!");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
