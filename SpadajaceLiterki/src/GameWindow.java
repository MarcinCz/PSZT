
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Implementuje glowne okno aplikacji do prezentowania dzialania algorytmow przeszukiwania.
 * @author karol
 */
public class GameWindow extends javax.swing.JFrame implements ChangeListener, ActionListener{
    
    private static final long serialVersionUID = 1L;

    /**
    * Tworzy nowe okno gry
    */
    public GameWindow() {
        initComponents();
        initMore();
    }

    /**
     * Inicjalizuje elementy graficznego interfejsu okna.
     */
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

        jLabel7.setText("<HTML>Liczba wezlow<BR>dodanych do zbioru G:</HTML>");
        infoPanel.add(jLabel7);

        statLastCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoPanel.add(statLastCount);

        jLabel9.setText("Licznosc zbioru G:");
        infoPanel.add(jLabel9);

        statCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoPanel.add(statCost);

        radioA.setText("Algorytm A*");

        radioIDA.setText("Algorytm IDA*");

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
    
    /**
     * Obsluguje zdarzenie klikniecia na przycisk "Generuj plansze" w zakladce "Rozwiazanie"
     * @param evt zdarzenie
     */
    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed
    	if(Alg.isRunning()) 
    	{
    		Alg.setRunning(false);
    		if(AlgThread.isAlive())
        	{	
    	    	try {
    				Thread.currentThread();
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
        	}
        	return;
    	}
    	
    	try{
            cols = new Integer(colsField.getText());
            rows = new Integer(rowsField.getText());
        } catch (Exception e) {
            Logger.append(">>> Blad wartosci rozmiaru planszy!" + NEW_LINE + 
                    ">>> Stworzono plansze."+ NEW_LINE + NEW_LINE);
        }
        
        Logger.setText("");
        letterTable = new LetterTable();
        letterTable.generate(rows, cols);
        Logger.append("Generated board: " + letterTable.calcPairs() + " pairs to choose" + NEW_LINE);
        Logger.append(letterTable.toString());
        Logger.append(LINE);
        Logger.append(NEW_LINE);
        Logger.append(NEW_LINE);
                
        makeBoard();
        if(timer!=null)
            timer.stop();
        TimerLabel.setText(millisToTimeLabel(0));
        SolveButton.setEnabled(true);
    }//GEN-LAST:event_GenerateButtonActionPerformed

    /**
     * Obsluguje zdarzenie nacisniecia przycisku "Wstecz"
     * @param evt zdarzenie
     */
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

    /**
     * Obsluguje zdarzenie klikniecia przycisku "Rozwiaz plansze"
     * @param evt zdarzenie
     */
    private void SolveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolveButtonActionPerformed
       TimerLabel.setText(millisToTimeLabel(0));
       startTimer(TimerLabel);
        AlgThread=new Thread(Alg);
       Alg.setWindow(this);
       Alg.setStartNode(letterTable);
       Logger.append("Solution: " + AlgS + NEW_LINE);
       Logger.append(LINE);
  
        try {
            if(AlgS.equals("A"))
            {
                Alg.setAlgorithmChoice(0);
                AlgThread.start();
            }
            else
            {
            	Alg.setAlgorithmChoice(1);
            	AlgThread.start();
            }
          
           
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            log("Exception: "+ e.getClass());
        } finally {
            SolveButton.setEnabled(false);
        }
        
    }//GEN-LAST:event_SolveButtonActionPerformed
    
    /**
     * 
     */
    public void SolvedAction()
    {
    	 Solution = Alg.getSolutionPath();
         if(Solution!=null) 
         {iterator = Solution.listIterator();
         iterator.next();}
         timer.stop();
         
         statSolution.setText(""+Alg.getMinLetters());
         statCount.setText(""+Alg.getExploredNodes());
         statLastCount.setText(""+Alg.getLastExploredNodes());
         statCost.setText(""+Alg.getLastCostLimit());
         if(Solution != null) for(LetterTable LT: Solution)
         {
                 Logger.append(LT.toString());
                 Logger.append(LINE);
         }
         else Logger.append("Nie da sie.\nW najlepszym rozwiazaniu zostalo "+Alg.getMinLetters()+" liter." + NEW_LINE);

         Logger.append("Odwiedzono "+Alg.getExploredNodes()+" wezlow." + NEW_LINE);
    
         SolveButton.setEnabled(true);
    }
    
    private void rowsField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowsField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowsField2ActionPerformed

    /**
     * Obsluguje zdarzenie klikniecia przycisku "Generuj plansze" w zagladce "Gra"
     * @param evt zdarzenie
     */
    private void GenerateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButton2ActionPerformed
        try{
            cols = new Integer(colsField2.getText());
            rows = new Integer(rowsField2.getText());
        } catch (Exception e) {
            Logger.append(">>> Blad wartosci rozmiaru planszy!" + NEW_LINE + 
                    ">>> Stworzono plansze 6x6."+ NEW_LINE + NEW_LINE);
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

    /**
     * Obsluguje zdarzenie klikniecia na przycisk "Wyjscie" w zakladce "Rozwiazanie"
     * @param evt zdarzenie
     */
    private void exitBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtn2ActionPerformed
        // wyjście
        setVisible(false);
        dispose();
    }//GEN-LAST:event_exitBtn2ActionPerformed

    /**
     * Obsluguje zdarzenie klikniecia na przycisk "Wyjscie" w zakladce "Rozwiazanie"
     * @param evt zdarzenie
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // wyjście
        if(timer!=null)
            timer.stop();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Obsluguje zdarzenie klikniecia na przycisk "Dalej" w zakladce "Rozwiazanie"
     * @param evt zdarzenie
     */
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
    private String AlgS = "A";
    private Algorithm Alg= new Algorithm();
    private ButtonGroup radios;
    private static Thread AlgThread=new Thread();
    
    /**
     * Zwraca numer zaznaczonej zakladki w oknie gry
     * @return Numer zaznaczonej zakladki. Numeracja zakladek zaczyna się od 0.
     */
    public int getTab()
    {
        return tab;
    }
    
    /**
     * Pobiera panel logowania okna gry
     * @return Panel logowania
     */
    public JTextArea getLoggerArea(){
        return Logger;
    }
    
    /**
     * Pobiera obiekt tablicy z literami planszy do gry
     * @return Obiekt tablicy z literami planszy do gry
     */
    public LetterTable getLetterTable() {
        return letterTable;
    }
    
    /**
     * Pobiera panel wyświetlajacy plansze do gry
     * @return Panel zawierajacy plansze do gry
     */
    public JPanel getLettersPanel()
    {
        return LettersPanel;
    }
    
    /**
     * Pobiera liste przyciskow na planszy do gry
     * @return Lista przyciskow na planszy do gry
     */
    public ArrayList<GeoButton> getGeoButtons()
    {
        return letters;
    }
    
    /**
     * Pobiera tablice haszujaca odwzorowujaca wspolrzedne pola na planszy na konkretny przycisk
     * @return Tablica haszujaca pola na planszy do konkretnych przyciskow 
     */
    public Hashtable<Point,GeoButton> getPoints_to_buttons()
    {
        return points_to_buttons;
    }
    
    /**
     * Pobiera wspolrzedne przycisku zaznaczonego na planszy
     * @return Wspolrzedne przycisku zaznaczonego na planszy
     */
    public Point getSelectedPoint()
    {
        return selectedPoint;
    }
    
    /**
     * Ustawia wpolrzedne przycisku zaznaczonego na planszy
     * @param Wspolrzedne przycisku w postaci obiekt typu Point 
     */
    public void setSelectedPoint(Point p)
    {
        selectedPoint = p;
    }
    
    /**
     * Pobiera zegar
     * @return Zegar
     */
    public Timer getTimer()
    {
        return timer;
    }
    
    /**
     * Wypisuje ciag znakow w panalu logowania okna gry
     * @param s Ciag znakow
     */
    public void log(String s)
    {
        this.Logger.append(s);
    }
    
    /**
     * Ustawia tekst etykiety z liczba pozostalych liter w najlepszym rozwiazaniu
     * znalezionym przez algorytm.
     * @param txt Liczba liter
     */
    public void setStatSolution(String txt)
    {
        statSolution.setText(txt);
    }
    
    /**
     * Ustawia tekst etykiety z liczba wezlow odwiedzonych w trakcie dzialania algorytmu.
     * @param txt Liczba wezlow
     */
    public void statCount(String txt)
    {
        statCount.setText(txt);
    }
    
    /**
     * Ustawia tekst etykiety z liczba wezlow odwiedzonych w trakcie ostatniej iteracji algorytmu.
     * @param txt Liczba wezlow
     */
    public void statLastCount(String txt)
    {
        statLastCount.setText(txt);
    }
    
    
    /**
     * Ustawia tekst etykiety z aktualnym kosztem wyliczonym przez algorytm.
     * @param txt Wartosc kosztu
     */
    public void statCost(String txt)
    {
        statCost.setText(txt);
    }
    
    /**
     * Tworzy i wyswietla plansze w panelu planszy do gry
     */
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
    
    /**
     * Tworzy liste przyciskow, ktorymi zostaje wypelniony panel planszy do gry
     */
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
    
    /**
     * Uruchamia Zegar
     * @param l Etykieta, w ktorej bedzie wyswietlane wskazanie zegara
     */
    private void startTimer(final JLabel l)
    {
        startTime = System.currentTimeMillis();
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                long t = getTimePastMillis();
                l.setText(millisToTimeLabel(t));
                statSolution.setText(""+Alg.getMinLetters());
                statCount.setText(""+Alg.getExploredNodes());
                statLastCount.setText(""+Alg.getLastExploredNodes());
                statCost.setText(""+Alg.getLastCostLimit());
            }
        };
        
        timer = new Timer(10, al);
        timer.start();
    }
    
    /**
     * Pobiera czas w milisekundach, jaki uplynal od momentu uruchomienia zegara.
     * @return 
     */
    private long getTimePastMillis()
    {
        return (System.currentTimeMillis() - startTime);
    }
    
    /**
     * Konwertuje czas w milisekundach do wskazania zegara wyświetlanego w etykiecie.
     * @param time Czas w milisekundach
     * @return Ciag znakow odpowiadajacy wartosci czasu, który upłynął. Formatowanie HH:MM:SS:MSMS.
     */
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
    
    /**
     * Inicjalizuje dodatkowe zmienne glownego okna gry
     */
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
        radioA.setSelected(true);
        TimerLabel.setText(millisToTimeLabel(0));
        TimerLabel2.setText(millisToTimeLabel(0));
    }
    
    /**
     * Obsluguje zdarzenie zmiany zakladki w glownym oknie gry
     * @param ce zdarzenie
     */
    @Override
    public void stateChanged(ChangeEvent ce) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) ce.getSource();
        tab = sourceTabbedPane.getSelectedIndex();
        if(timer != null)
        {
          timer.stop();
          TimerLabel2.setText(millisToTimeLabel(0));
        }
        Logger.setText("");
        LettersPanel.removeAll();
        LettersPanel.revalidate();
    }
    
    /**
     * Obsluguje zdarzenie wyboru algorytmu
     * @param ae zdarzenie
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        AlgS = ae.getActionCommand();
        if(AlgS.equals("A"))
        {
            jLabel7.setText("<HTML>Liczba wezlow<BR>dodanych do zbioru G:</HTML>");
            jLabel9.setText("Licznosc zbioru G:");
        }
        else
        {
            jLabel7.setText("Ostatnie wezly:");
            jLabel9.setText("Aktualny koszt:");
        }
    }
}
