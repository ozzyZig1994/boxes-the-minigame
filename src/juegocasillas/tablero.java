package juegocasillas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Josue Galvan Torres
 */
public class tablero extends javax.swing.JFrame {

    int casilla= 1,
        tiro= 1,
        i= 1;
    
    public tablero(){
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlZona = new javax.swing.JPanel();
        pnlDibujo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlZona.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlZona.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout pnlDibujoLayout = new javax.swing.GroupLayout(pnlDibujo);
        pnlDibujo.setLayout(pnlDibujoLayout);
        pnlDibujoLayout.setHorizontalGroup(
            pnlDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        pnlDibujoLayout.setVerticalGroup(
            pnlDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        pnlZona.add(pnlDibujo);

        getContentPane().add(pnlZona);
        pnlZona.setBounds(10, 10, 460, 270);

        jButton1.setText("A jugar!!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 290, 72, 28);

        setBounds(0, 0, 505, 367);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        dibujos.pintarTablero(this.pnlDibujo.getGraphics(), this.pnlDibujo);
        dibujos.pintarFicha(this.pnlDibujo.getGraphics(), this.pnlDibujo, 1, 1);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        dibujos.pintarTablero(this.pnlDibujo.getGraphics(), this.pnlDibujo);
        dibujos.pintarFicha(this.pnlDibujo.getGraphics(), this.pnlDibujo, 1, 1);
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            leeArchivo();
        } catch (IOException ex) {
            Logger.getLogger(tablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(tablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(tablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void leeArchivo() throws FileNotFoundException, IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException
    {
        int j= 0,
            k= 0;
        String secuencia,
               secuencia2[];
        BufferedReader br = new BufferedReader(new FileReader("src/juegocasillas/secuencia.txt"));
        
        secuencia= br.readLine();
        while (secuencia != null) 
        {
            Clip ambientacion = AudioSystem.getClip();
            ambientacion.open(AudioSystem.getAudioInputStream(new File("src/juegocasillas/ambientacion.wav")));
            ambientacion.start();
            secuencia2= secuencia.split("-");
            while(k < secuencia2.length)
            {
                if(k == 0 | casilla == 1 | casilla == 2)
                {
                    if(casilla == 2 && tiro == 3)
                    {
                        dibujos.quitarFicha(this.pnlDibujo.getGraphics(), this.pnlDibujo, 111, casilla);
                        dibujos.pintarCasillas(this.pnlDibujo.getGraphics(), this.pnlDibujo);
                    }
                    else
                    {
                        dibujos.quitarFicha(this.pnlDibujo.getGraphics(), this.pnlDibujo, tiro, casilla);
                        dibujos.pintarCasillas(this.pnlDibujo.getGraphics(), this.pnlDibujo);
                    }
                }
                else
                {
                    dibujos.quitarFicha(this.pnlDibujo.getGraphics(), this.pnlDibujo, tiro, casilla-1);
                    dibujos.pintarCasillas(this.pnlDibujo.getGraphics(), this.pnlDibujo);
                }
                
                tiro= Integer.parseInt(secuencia2[j]);
                Thread.sleep(1000);
                dibujos.pintarFicha(this.pnlDibujo.getGraphics(), this.pnlDibujo, tiro, casilla);
                Thread.sleep(1000);
                
                switch(casilla)
                {
                    case 1:
                        if(tiro == 1 | tiro == 2 | tiro == 4 | tiro == 6)
                            casilla= 1;
                        else
                        {
                            if(tiro == 3)
                                casilla++;
                            else
                                casilla+=2;
                        }
                        break;
                    case 2:
                        if(tiro == 3 | tiro == 4 | tiro == 5 | tiro == 6)
                            casilla++;
                        else
                        {
                            i+=1;
                            casilla= 2;
                            if(i == 3)
                            {
                                dibujos.quitarFicha(this.pnlDibujo.getGraphics(), this.pnlDibujo, 
                                        tiro, 2);
                                dibujos.pintarCasillas(this.pnlDibujo.getGraphics(), this.pnlDibujo);
                                casilla= 1;
                            }
                        }
                        break;
                    case 3:
                        if(tiro == 6)
                            casilla++;
                        else
                        {
                            if(tiro == 2)
                               casilla= 2;
                            else
                                casilla= 1;
                        }
                        break;
                    case 4:
                        if(tiro == 4 | tiro == 5 | tiro == 6)
                        {
                            casilla++;
                            Clip victoria = AudioSystem.getClip();
                            victoria.open(AudioSystem.getAudioInputStream(new File("src/juegocasillas/claps.wav")));
                            victoria.start();
                            JOptionPane.showMessageDialog(rootPane, "FELICIDADES HAS GANADO!!! :D");
                            System.exit(0);
                        }
                        break;
                }
                j++;
                k++;
            }
            secuencia= br.readLine();
        }
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new tablero().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pnlDibujo;
    private javax.swing.JPanel pnlZona;
    // End of variables declaration//GEN-END:variables
}