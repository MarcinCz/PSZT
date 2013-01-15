/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author karol
 */
public class GameWindow extends javax.swing.JFrame implements ChangeListener, ActionListener{
    
    

//    JLabel time = new JLabel("-");
//    JLabel lettersRemaining = new JLabel("-");
//    JLabel nodes = new JLabel("-");
//    JLabel currentCost = new JLabel("-");
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
            // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }                                                                                                                                                                                           
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindow().setVisible(true);
            }
        });
    }
    
    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        initComponents();
        initMore();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Logger = new javax.swing.JTextArea();
        LettersPanel = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        ControlsPanel = new javax.swing.JPanel();
        TimerLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rowsField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        colsField = new javax.swing.JTextField();
        GenerateButton = new javax.swing.JButton();
        SolveButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        statSolution = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        statCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        statLastCount = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        statCost = new javax.swing.JLabel();
        radioA = new javax.swing.JRadioButton();
        radioIDA = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        TimerLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rowsField2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        colsField2 = new javax.swing.JTextField();
        GenerateButton2 = new javax.swing.JButton();
        exitBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spadające literki");

        Logger.setEditable(false);
        Logger.setColumns(20);
        Logger.setFont(new java.awt.Font("Ubuntu Mono", 0, 15)); // NOI18N
        Logger.setRows(5);
        jScrollPane2.setViewportView(Logger);

        javax.swing.GroupLayout LettersPanelLayout = new javax.swing.GroupLayout(LettersPanel);
        LettersPanel.setLayout(LettersPanelLayout);
        LettersPanelLayout.setHorizontalGroup(
            LettersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        LettersPanelLayout.setVerticalGroup(
            LettersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        tabbedPane.setName(""); // NOI18N

        ControlsPanel.setMaximumSize(new java.awt.Dimension(238, 276));
        ControlsPanel.setMinimumSize(new java.awt.Dimension(238, 276));
        ControlsPanel.setName("Rozwiazanie"); // NOI18N

        TimerLabel.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        TimerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Wiersze:");

        rowsField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rowsField.setText("6");
        rowsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowsFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Kolumny:");

        colsField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        colsField.setText("6");

        GenerateButton.setText("Nowa plansza");
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButtonActionPerformed(evt);
            }
        });

        SolveButton.setText("Rozwiąż planszę");
        SolveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolveButtonActionPerformed(evt);
            }
        });

        PreviousButton.setText("Wstecz");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Dalej");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Wyjście");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        infoPanel.setLayout(new java.awt.GridLayout(5, 2, 4, 0));

        jLabel3.setText("Najlepsze rozwiązanie:");
        infoPanel.add(jLabel3);

        statSolution.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoPanel.add(statSolution);

        jLabel5.setText("Odwiedzone węzły:");
        infoPanel.add(jLabel5);

        statCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoPanel.add(statCount);

        jLabel7.setText("Ostatnie węzły:");
        infoPanel.add(jLabel7);

        statLastCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoPanel.add(statLastCount);

        jLabel9.setText("Aktualny koszt:");
        infoPanel.add(jLabel9);

        statCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoPanel.add(statCost);

        radioA.setText("Algorytm A*");
        radioA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAActionPerformed(evt);
            }
        });

        radioIDA.setText("Algorytm IDA*");
        radioIDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIDAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ControlsPanelLayout = new javax.swing.GroupLayout(ControlsPanel);
        ControlsPanel.setLayout(ControlsPanelLayout);
        ControlsPanelLayout.setHorizontalGroup(
            ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TimerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ControlsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GenerateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SolveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ControlsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rowsField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colsField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ControlsPanelLayout.createSequentialGroup()
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(radioA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioIDA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ControlsPanelLayout.setVerticalGroup(
            ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioIDA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(colsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenerateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SolveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPane.addTab("Rozwiązanie", ControlsPanel);
        ControlsPanel.getAccessibleContext().setAccessibleName("Rozwiazanie");

        TimerLabel2.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        TimerLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerLabel2.setText("00:00:00");

        jLabel17.setText("Wiersze:");

        rowsField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rowsField2.setText("6");
        rowsField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowsField2ActionPerformed(evt);
            }
        });

        jLabel18.setText("Kolumny:");

        colsField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        colsField2.setText("6");

        GenerateButton2.setText("Nowa plansza");
        GenerateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButton2ActionPerformed(evt);
            }
        });

        exitBtn2.setText("Wyjście");
        exitBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimerLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(exitBtn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GenerateButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rowsField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colsField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimerLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowsField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(colsField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenerateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPane.addTab("Gra", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(LettersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(419, Short.MAX_VALUE)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LettersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        TitledBorder title = BorderFactory.createTitledBorder("Algorithm log:");
        jScrollPane2.setBorder(title);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed
        try{
            cols = new Integer(colsField.getText());
            rows = new Integer(rowsField.getText());
        } catch (Exception e) {
            Logger.append(">>> Błąd wartości rozmiaru planszy!" + NEW_LINE + 
                    ">>> Stworzono planszę 6x6."+ NEW_LINE + NEW_LINE);
        }
        
        Logger.setText("");
        letterTable = new LetterTable();
        letterTable.generate(rows, cols);
        Logger.append("Generated board: " + letterTable.calcPairs() + " pairs to choose" + NEW_LINE);
        Logger.append(letterTable.toString());
        Logger.append(LINE);
        Logger.append(NEW_LINE);
        Logger.append(NEW_LINE);
//        Logger.append(letterTable.getSameMap().toString());
//        Logger.append(NEW_LINE);
                
        makeBoard();
        if(timer!=null)
            timer.stop();
        TimerLabel.setText(millisToTimeLabel(0));
        SolveButton.setEnabled(true);
    }//GEN-LAST:event_GenerateButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        if(Solution != null && iterator !=null && iterator.hasPrevious())
        {
            NextButton.setEnabled(true);
            log(LINE);
            log("Wstecz:\n\n");
            letterTable=iterator.previous();
            log(letterTable.toString());
            makeBoard();
        } else if(iterator !=null && !iterator.hasPrevious())
            PreviousButton.setEnabled(false);
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void SolveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolveButtonActionPerformed
//       if(timer!=null)
//           timer.stop();
       TimerLabel.setText(millisToTimeLabel(0));
       startTimer(TimerLabel);
        
       Logger.append("Solution: " + algorithm + NEW_LINE);
       Logger.append(LINE);
        ArrayList<LetterTable> A=new ArrayList<LetterTable>();
        try {
            if(algorithm.equals("A"))
                Solution = Algorithm.A_Star(letterTable, this);
            else
                Solution = Algorithm.IDA_Star(letterTable, this);
            iterator = Solution.listIterator();
            iterator.next();
            timer.stop();
            if(Solution != null) for(LetterTable LT: Solution)
            {
                    Logger.append(LT.toString());
                    Logger.append(LINE);
            }
            else Logger.append("Nie da sie. W najlepszym rozwiazaniu zostalo "+Algorithm.getMinLetters()+" liter." + NEW_LINE);

            Logger.append("Odwiedzono "+Algorithm.getExploredNodes()+" wezlow." + NEW_LINE);
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            log("Exception: "+ e.getClass());
        } finally {
            SolveButton.setEnabled(false);
        }
        
    }//GEN-LAST:event_SolveButtonActionPerformed

    private void rowsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowsFieldActionPerformed

    private void rowsField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowsField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowsField2ActionPerformed

    private void GenerateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButton2ActionPerformed
        try{
            cols = new Integer(colsField2.getText());
            rows = new Integer(rowsField2.getText());
        } catch (Exception e) {
            Logger.append(">>> Błąd wartości rozmiaru planszy!" + NEW_LINE + 
                    ">>> Stworzono planszę 6x6."+ NEW_LINE + NEW_LINE);
        }
        
        letterTable = new LetterTable();
        letterTable.generate(rows, cols);
        Logger.append("Generated board: " + letterTable.calcPairs() + " pairs to choose" + NEW_LINE);
        Logger.append(letterTable.toString());
        Logger.append(LINE);
        Logger.append(NEW_LINE);
        Logger.append(NEW_LINE);
//        Logger.append(letterTable.getSameMap().toString());
//        Logger.append(NEW_LINE);
                
        makeBoard();
        TimerLabel2.setText(millisToTimeLabel(0));
        startTimer(TimerLabel2);
    }//GEN-LAST:event_GenerateButton2ActionPerformed

    private void exitBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtn2ActionPerformed
        // wyjście
        setVisible(false);
        dispose();
    }//GEN-LAST:event_exitBtn2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // wyjście
        timer.stop();
        timer = null;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        if(Solution != null && iterator !=null && iterator.hasNext())
        {
            PreviousButton.setEnabled(true);
            log(LINE);
            log("Dalej:\n\n");
            letterTable=iterator.next();
            log(letterTable.toString());
            makeBoard();
        } else if(iterator !=null && !iterator.hasNext())
            NextButton.setEnabled(false);
        
    }//GEN-LAST:event_NextButtonActionPerformed

    private void radioAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAActionPerformed

    private void radioIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioIDAActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GameWindow().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlsPanel;
    private javax.swing.JButton GenerateButton;
    private javax.swing.JButton GenerateButton2;
    private javax.swing.JPanel LettersPanel;
    private javax.swing.JTextArea Logger;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton SolveButton;
    private javax.swing.JLabel TimerLabel;
    private javax.swing.JLabel TimerLabel2;
    private javax.swing.JTextField colsField;
    private javax.swing.JTextField colsField2;
    private javax.swing.JButton exitBtn2;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioIDA;
    private javax.swing.JTextField rowsField;
    private javax.swing.JTextField rowsField2;
    private javax.swing.JLabel statCost;
    private javax.swing.JLabel statCount;
    private javax.swing.JLabel statLastCount;
    private javax.swing.JLabel statSolution;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
    private static final String NEW_LINE = "\n";
    private static final String LINE = "----------------------" + NEW_LINE;
    private LetterTable letterTable;
    private int cols = 6, rows = 6;
    private ArrayList<GeoButton> letters;
    private Hashtable<Point,GeoButton> points_to_buttons;
    private Point selectedPoint;
    private long startTime;
    private Timer timer;
    private int tab =0;
    private ArrayList<LetterTable> Solution;
    private ListIterator<LetterTable> iterator;
    private String algorithm = "A";
    private ButtonGroup radios;
    
    public int getTab()
    {
        return tab;
    }
    
    public JTextArea getLoggerArea(){
        return Logger;
    }
    
    public LetterTable getLetterTable() {
        return letterTable;
    }
    
    public JPanel getLettersPanel()
    {
        return LettersPanel;
    }
    
    public ArrayList<GeoButton> getGeoButtons()
    {
        return letters;
    }
    
    public Hashtable<Point,GeoButton> getPoints_to_buttons()
    {
        return points_to_buttons;
    }
    
    public Point getSelectedPoint()
    {
        return selectedPoint;
    }
    
    public void setSelectedPoint(Point p)
    {
        selectedPoint = p;
    }
    
    public Timer getTimer()
    {
        return timer;
    }
    
    public void log(String s)
    {
        this.Logger.append(s);
    }
    
    public void setStatSolution(String txt)
    {
        statSolution.setText(txt);
    }
    
    public void statCount(String txt)
    {
        statSolution.setText(txt);
    }
    public void statLastCount(String txt)
    {
        statSolution.setText(txt);
    }
    public void statCost(String txt)
    {
        statSolution.setText(txt);
    }
    
    public void makeBoard()
    {
        addLetters();
        GridLayout lettersLayout = new GridLayout(rows, cols);
        LettersPanel.setLayout(lettersLayout);
        LettersPanel.removeAll();
//        LettersPanel.validate();
        LettersPanel.repaint();
        
        for(JToggleButton button : letters)
        {
            button.validate();
            LettersPanel.add(button);
        }
        
        LettersPanel.revalidate();
    }
    
    private void addLetters()
    {
        letters = new ArrayList<GeoButton>(cols*rows);
        letters.clear();
        points_to_buttons = new Hashtable<Point, GeoButton>();
        points_to_buttons.clear();
        char[][] table = letterTable.getTable();
        
        for(int i=0; i<table.length;i++)
        {
            for(int j=0; j<table[i].length;j++)
            {
                
                GeoButton button = new GeoButton(table[i][j], j+1, i+1, this);
                if(table[i][j]==' ')
                    button.setVisible(false);
                
                letters.add(button);
                points_to_buttons.put(button.getPoint(), button);
            }
        }
        
        
    }
    
    private void startTimer(final JLabel l)
    {
        startTime = System.currentTimeMillis();
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                long t = getTimePastMillis();
//                TimerLabel.setText(""+t);
                l.setText(millisToTimeLabel(t));
//                statSolution.setText(""+Algorithm.getMinLetters());
//                statCount.setText(""+Algorithm.getExploredNodes());
//                statLastCount.setText(""+Algorithm.getLastExploredNodes());
//                statCost.setText(""+Algorithm.getLastCostLimit());
            }
        };
        
        timer = new Timer(1000, al);
        timer.start();
    }
    
    private long getTimePastMillis()
    {
        return (System.currentTimeMillis() - startTime);
    }
    
    private String millisToTimeLabel(long time)
    {
        return String.format("%02d:%02d:%02d:%02d", 
            TimeUnit.MILLISECONDS.toHours(time),
            TimeUnit.MILLISECONDS.toMinutes(time) -  
            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)), // The change is in this line
            TimeUnit.MILLISECONDS.toSeconds(time) - 
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)),
            TimeUnit.MILLISECONDS.toMillis(time)-TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(time)));  
    }
    
//    private void populateInfoPanel()
//    {
//        JPanel leftCol = new JPanel();
//        leftCol.setLayout(new BoxLayout(leftCol, BoxLayout.PAGE_AXIS));
//        JPanel rightCol = new JPanel();
//        rightCol.setLayout(new BoxLayout(rightCol, BoxLayout.PAGE_AXIS));
//        infoPanel.setLayout(new BorderLayout());
//        leftCol.add(new JLabel("Czas:"), BorderLayout.LINE_START);
//        rightCol.add(time, BorderLayout.LINE_END);
//        leftCol.add(new JLabel("Pozostałe litery:"), BorderLayout.LINE_START);
//        rightCol.add(lettersRemaining, BorderLayout.LINE_END);
//        leftCol.add(new JLabel("Odwiedzone węzły:"), BorderLayout.LINE_START);
//        rightCol.add(nodes, BorderLayout.LINE_END);
//        leftCol.add(new JLabel("Aktualny koszt:"), BorderLayout.LINE_START);
//        rightCol.add(currentCost, BorderLayout.LINE_END);
//        rightCol.revalidate();
//        leftCol.revalidate();
//        infoPanel.add(leftCol, BorderLayout.LINE_START);
//        infoPanel.add(rightCol, BorderLayout.LINE_END);
//        infoPanel.revalidate();
//    }
    
    private void initMore()
    {
        tabbedPane.addChangeListener(this);
        SolveButton.setEnabled(false);
        radioA.setActionCommand("A");
        radioA.addActionListener(this);
        radioIDA.setActionCommand("IDA");
        radioIDA.addActionListener(this);
        radios = new ButtonGroup();
        radios.add(radioA);
        radios.add(radioIDA);
        TimerLabel.setText(millisToTimeLabel(0));
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) ce.getSource();
        tab = sourceTabbedPane.getSelectedIndex();
        if(timer != null)
          timer.stop();
        LettersPanel.removeAll();
        LettersPanel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        algorithm = ae.getActionCommand();
//        log(algorithm+"\n");
    }
}
