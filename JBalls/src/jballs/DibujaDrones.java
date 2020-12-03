package jballs;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
   
public class DibujaDrones extends JPanel{
    private Dron[] drones;
    private NumDron n;
    private BufferedImage ima;
    private ArrayList<Ellipse2D> circulos;
    private gPerformed panelG;
    private int datosX,datosY;
    
    DibujaDrones(BufferedImage ima, NumDron n, gPerformed panelG){
        drones=new Dron[10];
        this.ima=ima;
        this.n=n;
        circulos= new ArrayList<Ellipse2D>();
        this.panelG = panelG;
        datosX=0;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(ima, 0, 0, this);
        g2.setColor(Color.black);
        //g2.fill(new Rectangle2D.Double(0, 199, 600, 2));
        int i = 0;
        panelG.limpiar();
        for(Ellipse2D c: circulos){
            g2.setColor(Color.black);
            c.setFrame(drones[i].getX(), drones[i].getY(), 20, 20);
            g2.fill((Ellipse2D)c);
            g2.setColor(Color.white);
            g2.drawString(String.valueOf(i+1),drones[i].getX()+7,drones[i].getY()+15);
            datosY=drones[i].getY();
            panelG.actualizar(datosX, datosY,i+1);
            if(datosX>=500){
                panelG.resetear2(i+1);
            }
            i++;
        }
        panelG.pintar();
        datosX++;
    }
    public void CreaCirculos(){
        circulos.removeAll(circulos);
        for(int i = 0; i <= n.getConta(); i++){
            circulos.add(new Ellipse2D.Double());
        }
        datosX=0;
        panelG.resetear();
    }
    public void setDrones(Dron drones[], NumDron n){
        for(int i=0;i<=n.getConta();i++){
            this.drones[i]=drones[i];
        }
        this.n=n;
    }
}
