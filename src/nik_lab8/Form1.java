package nik_lab8;

import javax.swing.JOptionPane;

public class Form1 extends javax.swing.JFrame {

    public Form1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_Random = new javax.swing.JButton();
        jButton_Task = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();
        jButton_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Работа с классами в JAVA");
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nik_lab8/Screenshot_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 209, 546, 169);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null},
                { new Integer(2), null},
                { new Integer(3), null},
                { new Integer(4), null},
                { new Integer(5), null},
                { new Integer(6), null},
                { new Integer(7), null},
                { new Integer(8), null},
                { new Integer(9), null},
                { new Integer(10), null}
            },
            new String [] {
                "K(i)", "Y(i)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 11, 296, 192);

        jButton_Random.setText("Заполнить случайными");
        jButton_Random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RandomActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Random);
        jButton_Random.setBounds(300, 20, 240, 30);

        jButton_Task.setText("Расчет");
        jButton_Task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TaskActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Task);
        jButton_Task.setBounds(300, 60, 240, 30);

        jButton_Clear.setText("Очистить");
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Clear);
        jButton_Clear.setBounds(300, 100, 240, 30);

        jButton_Exit.setText("Выход");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Exit);
        jButton_Exit.setBounds(300, 140, 240, 30);

        setSize(new java.awt.Dimension(569, 413));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RandomActionPerformed
        // Заполнение случайными числами
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            jTable1.setValueAt((int) (Math.random() * 11), i, 0);
        }
    }//GEN-LAST:event_jButton_RandomActionPerformed

    private void jButton_TaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TaskActionPerformed
        // Выполнение задания
        
        // Проверка заполнения таблицы
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0) == null) {
                JOptionPane.showMessageDialog(rootPane, "Проверьте правильность заполнения столбца К(i)", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        int rowCount = jTable1.getRowCount(); // Количество строк в таблице
        int[] inArray = new int[rowCount]; // Создаем исходный массив целых чисел

        for (int i = 0; i < rowCount; i++) { // Заполняем исходный массив из первого столбца таблицы
            inArray[i] = (int) jTable1.getModel().getValueAt(i, 0);
        }

        NIK_lab8 ma = new NIK_lab8(); // СОЗДАЕМ ОБЪЕКТ-РЕШАТЕЛЬ ЗАДАНИЯ !!!
        
        ma.SetMass(inArray); // ПЕРЕДАЕМ В ОБЪЕКТ-РЕШАТЕЛЬ ИСХОДНЫЙ МАССИВ
        
        double[] outArray = ma.GetMass(); // ПОЛУЧАЕМ С ОБЪЕКТА РЕШАТЕЛЯ ЗНАЧЕНИЕ РЕЗУЛЬТИРУЮЩЕГО МАССИВА

        for (int i = 0; i < rowCount; i++) { // Заносим во второй столбец таблицы значения из результирующего массива
            jTable1.getModel().setValueAt(String.format("%.3f", outArray[i]), i, 1);
        }

    }//GEN-LAST:event_jButton_TaskActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        // Очистка таблицы
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                jTable1.setValueAt(null, i, j);
            }
        }
    }//GEN-LAST:event_jButton_ClearActionPerformed

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        // Выход из программы
        System.exit(0);
    }//GEN-LAST:event_jButton_ExitActionPerformed

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
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JButton jButton_Random;
    private javax.swing.JButton jButton_Task;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
