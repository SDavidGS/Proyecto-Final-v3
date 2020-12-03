package jballs;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
public class JDrones extends javax.swing.JFrame {
    private DibujaDrones panel;
    private gPerformed panelG;
    private MiX xs;
    private MiY ys;
    private NumDron n;
    private BufferedImage ima;
    private Dron drones[];
    private int click=0;
    
    public JDrones() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        try{
            ima = ImageIO.read(new File ("mapa.JPG"));
        }catch(IOException e){e.printStackTrace();}
        
        drones=new Dron[10];
        n=new NumDron();
        
        panelG =  new gPerformed();
        panelG.setBounds(700, 0, 500, 400);
        
        panel = new DibujaDrones(ima,n,panelG);
        panel.setBounds(100,0,600,400);
        add(panelG);
        add(panel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bNuevo = new javax.swing.JButton();
        bAlgoritmo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 450));
        setResizable(false);

        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        bAlgoritmo.setText("Semaforos");
        bAlgoritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlgoritmoActionPerformed(evt);
            }
        });

        jLabel2.setText("Comandos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bAlgoritmo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(620, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(bNuevo)
                .addGap(18, 18, 18)
                .addComponent(bAlgoritmo)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAlgoritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlgoritmoActionPerformed
        
        switch(bAlgoritmo.getText()){
            case "Semaforos":
                bAlgoritmo.setText("Mutex");
                break;
            case "Mutex":
                bAlgoritmo.setText("VC");
                break;
            case "VC":
                bAlgoritmo.setText("Monitores");
                break;
            case "Monitores":
                bAlgoritmo.setText("Semaforos");
                break;
//            case "Barreras":
//                bAlgoritmo.setText("");
//                break;
        }

        for(int i=0;i<n.getConta();i++){
            drones[i].setalgoritmo(bAlgoritmo.getText());
            System.out.println(drones[i].getAlgoritmo()+"\n");
            drones[i].reset();
        }
    }//GEN-LAST:event_bAlgoritmoActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        switch(click){
            case 0:
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()] = new Dron(xs,ys,panel,bAlgoritmo.getText());
                
                drones[0].limites(0, 0, panel.getWidth(), panel.getHeight());
                
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);
                break;
            case 1:
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()] = new Dron(xs,ys,panel,bAlgoritmo.getText());
                
                drones[0].limites(0, 0, panel.getWidth()/2, panel.getHeight());
                drones[1].limites(panel.getWidth()/2, 0, panel.getWidth(), panel.getHeight());
                
                drones[0].reset();
                drones[1].reset();
                
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);
                break;
            case 2:
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()] = new Dron(xs,ys,panel,bAlgoritmo.getText());//
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()+1] = new Dron(xs,ys,panel,bAlgoritmo.getText());
                
                drones[0].limites(0, 0, panel.getWidth()/2, panel.getHeight()/2);
                drones[1].limites(panel.getWidth()/2, 0, panel.getWidth(), panel.getHeight()/2);//
                drones[2].limites(0, panel.getHeight()/2, panel.getWidth()/2, panel.getHeight());
                drones[3].limites(panel.getWidth()/2, panel.getHeight()/2, panel.getWidth(), panel.getHeight());
                
                drones[0].reset();
                drones[1].reset();
                drones[2].reset();
                drones[3].reset();
                
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);//
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);
                break;
            case 3:
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()] = new Dron(xs,ys,panel,bAlgoritmo.getText());//
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()+1] = new Dron(xs,ys,panel,bAlgoritmo.getText());
                
                drones[0].limites(0, 0, panel.getWidth()/3, panel.getHeight()/2);
                drones[1].limites(panel.getWidth()/3, 0, panel.getWidth()*2/3, panel.getHeight()/2);
                drones[4].limites(panel.getWidth()*2/3, 0, panel.getWidth(), panel.getHeight()/2);
                //ABAJO
                drones[2].limites(0, panel.getHeight()/2, panel.getWidth()/3, panel.getHeight());
                drones[3].limites(panel.getWidth()/3, panel.getHeight()/2, panel.getWidth()*2/3, panel.getHeight());
                drones[5].limites(panel.getWidth()*2/3, panel.getHeight()/2, panel.getWidth(), panel.getHeight());
                
                drones[0].reset();
                drones[1].reset();
                drones[2].reset();
                drones[3].reset();
                drones[4].reset();
                drones[5].reset();
                
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);//
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);
                break;
            case 4:
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()] = new Dron(xs,ys,panel,bAlgoritmo.getText());//
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()+1] = new Dron(xs,ys,panel,bAlgoritmo.getText());
                
                drones[0].limites(0, 0, panel.getWidth()/4, panel.getHeight()/2);
                drones[1].limites(panel.getWidth()/4, 0, panel.getWidth()*2/4, panel.getHeight()/2);
                drones[4].limites(panel.getWidth()*2/4, 0, panel.getWidth()*3/4, panel.getHeight()/2);
                drones[6].limites(panel.getWidth()*3/4, 0, panel.getWidth(), panel.getHeight()/2);
                //ABAJO
                drones[2].limites(0, panel.getHeight()/2, panel.getWidth()/4, panel.getHeight());
                drones[3].limites(panel.getWidth()/4, panel.getHeight()/2, panel.getWidth()*2/4, panel.getHeight());
                drones[5].limites(panel.getWidth()*2/4, panel.getHeight()/2, panel.getWidth()*3/4, panel.getHeight());
                drones[7].limites(panel.getWidth()*3/4, panel.getHeight()/2, panel.getWidth(), panel.getHeight());
                
                drones[0].reset();
                drones[1].reset();
                drones[2].reset();
                drones[3].reset();
                drones[4].reset();
                drones[5].reset();
                drones[6].reset();
                drones[7].reset();
                
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);//
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);
                break;
            case 5:
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()] = new Dron(xs,ys,panel,bAlgoritmo.getText());//
                xs= new MiX(0);
                ys= new MiY(0);
                drones[n.getConta()+1] = new Dron(xs,ys,panel,bAlgoritmo.getText());
                
                drones[0].limites(0, 0, panel.getWidth()/5, panel.getHeight()/2);
                drones[1].limites(panel.getWidth()/5, 0, panel.getWidth()*2/5, panel.getHeight()/2);
                drones[4].limites(panel.getWidth()*2/5, 0, panel.getWidth()*3/5, panel.getHeight()/2);
                drones[6].limites(panel.getWidth()*3/5, 0, panel.getWidth()*4/5, panel.getHeight()/2);
                drones[8].limites(panel.getWidth()*4/5, 0, panel.getWidth(), panel.getHeight()/2);
                //ABAJO
                drones[2].limites(0, panel.getHeight()/2, panel.getWidth()/5, panel.getHeight());
                drones[3].limites(panel.getWidth()/5, panel.getHeight()/2, panel.getWidth()*2/5, panel.getHeight());
                drones[5].limites(panel.getWidth()*2/5, panel.getHeight()/2, panel.getWidth()*3/5, panel.getHeight());
                drones[7].limites(panel.getWidth()*3/5, panel.getHeight()/2, panel.getWidth()*4/5, panel.getHeight());
                drones[9].limites(panel.getWidth()*4/5, panel.getHeight()/2, panel.getWidth(), panel.getHeight());
                
                drones[0].reset();
                drones[1].reset();
                drones[2].reset();
                drones[3].reset();
                drones[4].reset();
                drones[5].reset();
                drones[6].reset();
                drones[7].reset();
                drones[8].reset();
                drones[9].reset();
                
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);//
                panel.setDrones(drones,n);
                panel.CreaCirculos();
                drones[n.getConta()].start();
                n.setConta(n.getConta()+1);
                break;
        }
        click++;
    }//GEN-LAST:event_bNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(JDrones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDrones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDrones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDrones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDrones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlgoritmo;
    private javax.swing.JButton bNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
