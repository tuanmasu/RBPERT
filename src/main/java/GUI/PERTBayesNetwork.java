package GUI;

import Bayes.InitialDurationNodes;
import Bayes.Task;
import Bayes.TimeCalculation;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PERTBayesNetwork extends javax.swing.JFrame {
    int numFiles = 1;
    public static String    FILE_DIRECTORY = "./dulieu";
    String projectFilePath;
    public PERTBayesNetwork() {
        initComponents();
        // creat = new CreatAction();
        // jTable1.setEditingRow(1);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PERT Bayes Network");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("File Project");

        jButton2.setText("Kết quả PERTBN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Mạng PERTBN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setOpaque(true);
        jPanel2.setBackground(Color.WHITE);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(20, 20, 20))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton4});

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Chọn File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed  Kết quả
          if(projectFilePath != null){
              final ArrayList<Task> luuTask= new ArrayList<Task>();
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          System.out.println(projectFilePath);
                          Workbook workbook;
                          workbook  = Workbook.getWorkbook(new File(projectFilePath));
                          // get sheet want read
                          Sheet sheet = workbook.getSheet(0);
                          // get number row and col contain data
                          int rows = sheet.getRows();
                          System.out.println(sheet.getRows());
                          System.out.println("Reading data in file.......");
                          // read data in each cell
                          for (int row = 1; row < rows; row++) {
                              String riskFile = "./probability" + rand(1, numFiles) +".bin";
                              String name = sheet.getCell(1, row).getContents();
                              int optimistic = Integer.parseInt(sheet.getCell(2, row).getContents());
                              int mostlikely = Integer.parseInt(sheet.getCell(3, row).getContents());
                              int pessimistic = Integer.parseInt(sheet.getCell(4, row).getContents());
                              InitialDurationNodes duration = new InitialDurationNodes();
                              duration.innitTotalDuration(Double.valueOf(optimistic),Double.valueOf(mostlikely),Double.valueOf(pessimistic),riskFile);
                              Task task = new Task(name, riskFile, duration.getEstimatedDuration(), duration.getTotalDuration());
                              luuTask.add(task);
                          }
                          for(int row = 1; row < rows ; row++){
                              String predecessor = sheet.getCell(5,row).getContents();
                              for(int i=0;i<luuTask.size();i++){
                                  if(predecessor.contains(luuTask.get(i).name)){
                                      luuTask.get(i).getChilds().add(luuTask.get(row-1));
                                  }
                              }
                          }

                          HashSet<Task> allTasks = new HashSet<Task>();
                          for (int i = 0; i < luuTask.size(); i++) {
                              allTasks.add(luuTask.get(i));
                          }
                          TimeCalculation tc = new TimeCalculation(allTasks);

                          tc.run();
                          ArrayList<Task> lastTask = tc.lastTask((HashSet<Task>) tc.tasks);

                          JFrame fame = new JFrame();
                          Result re = new Result(lastTask);
                          fame.add(re);
                          fame.setVisible(true);
                          fame.setSize(450,450);
                          // close
                          workbook.close();
                      } catch (IOException ex) {
                          Logger.getLogger(PERTBayesNetwork.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (BiffException ex) {
                          Logger.getLogger(PERTBayesNetwork.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              }).start();

             
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            if(projectFilePath != null){
              final ArrayList<Task> luuTask= new ArrayList<Task>();
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          System.out.println(projectFilePath);
                          Workbook workbook;
                          workbook  = Workbook.getWorkbook(new File(projectFilePath));
                          // get sheet want read
                          Sheet sheet = workbook.getSheet(0);
                          // get number row and col contain data
                          int rows = sheet.getRows();
                          System.out.println(sheet.getRows());
                          System.out.println("Reading data in file.......");
                          // read data in each cell
                          for (int row = 1; row < rows; row++) {
                              String riskFile = "./probability" + rand(1, numFiles) + ".bin";
                              String name = sheet.getCell(1, row).getContents();
                              int optimistic = Integer.parseInt(sheet.getCell(2, row).getContents());
                              int mostlikely = Integer.parseInt(sheet.getCell(3, row).getContents());
                              int pessimistic = Integer.parseInt(sheet.getCell(4, row).getContents());
                              InitialDurationNodes DA = new InitialDurationNodes();
                              DA.innitTotalDuration(Double.valueOf(optimistic),Double.valueOf(mostlikely),Double.valueOf(pessimistic),riskFile);
                              Task task = new Task(name,riskFile,DA.getEstimatedDuration(), DA.getTotalDuration());
                              luuTask.add(task);
                          }
                          for(int row = 1; row < rows ; row++){
                              String predecessor = sheet.getCell(5,row).getContents();
                              for(int i=0;i<luuTask.size();i++){
                                  if(predecessor.contains(luuTask.get(i).name)){
                                      luuTask.get(i).getChilds().add(luuTask.get(row-1));
                                  }
                              }
                          }

                          HashSet<Task> allTasks = new HashSet<Task>();
                          for (int i = 0; i < luuTask.size(); i++) {
                              allTasks.add(luuTask.get(i));
                          }
                          TimeCalculation tc = new TimeCalculation(allTasks);

                          tc.run();
                          Task[] mangTask1 = tc.tasks.toArray(new Task[0]);
                          ArrayList<Task> listTask1 = new ArrayList<Task>();
                          for (int i = 0; i < mangTask1.length; i++) {
                              listTask1.add(mangTask1[i]);

                          }
                          JFrame fame = new JFrame();
                          PanelTask panelTask = new PanelTask(listTask1);

                          fame.setSize(2000, 2000);
                          fame.add(panelTask);
                          fame.setVisible(true);
                          // close
                          workbook.close();
                      } catch (IOException ex) {
                          Logger.getLogger(PERTBayesNetwork.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (BiffException ex) {
                          Logger.getLogger(PERTBayesNetwork.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              }).start();

             
          }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(FILE_DIRECTORY));
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        String filePath = selectedFile.getAbsolutePath();
        jTextField1.setText(filePath);
        projectFilePath = filePath;
    }//GEN-LAST:event_jButton1ActionPerformed
    private int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PERTBayesNetwork().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
