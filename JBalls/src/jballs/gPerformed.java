package jballs;

 import javax.swing.*;
 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;

public class gPerformed extends JPanel{
    
 XYSeries series1 = new XYSeries("D1");
 XYSeries series2 = new XYSeries("D2");
 XYSeries series3= new XYSeries("D3");
 XYSeries series4 = new XYSeries("D4");
 XYSeries series5 = new XYSeries("D5");
 XYSeries series6 = new XYSeries("D6");
 XYSeries series7 = new XYSeries("D7");
 XYSeries series8 = new XYSeries("D8");
 XYSeries series9 = new XYSeries("D9");
 XYSeries series10 = new XYSeries("D10");
 private ChartPanel panel;
 private XYSeriesCollection dataset;

    public gPerformed(){
         XYSeries series = new XYSeries("");
        dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Rendimiento de los Drones","Iteracciones->","Minimos ->",
            dataset,PlotOrientation.VERTICAL,true,true,false);
        panel = new ChartPanel(chart);
        setLayout(new java.awt.BorderLayout());
        add(panel);
        validate();

    }

    public void actualizar(int datosX,int datosY,int num){
        /*for(int i=0;i<datosX.length;i++){
            seriesX.add(i,(double)datosX[i]);
            seriesY.add(i,(double)datosY[i]);
        }*/
        switch(num){
            case 1:series1.add(datosX, datosY);
                dataset.addSeries(series1);
                break;
            case 2:series2.add(datosX, datosY);
                dataset.addSeries(series2);
                break;
            case 3:series3.add(datosX, datosY);
                dataset.addSeries(series3);
                break;
            case 4:series4.add(datosX, datosY);
                dataset.addSeries(series4);
                break;
            case 5:series5.add(datosX, datosY);
                dataset.addSeries(series5);
                break;
            case 6:series6.add(datosX, datosY);
                dataset.addSeries(series6);
                break;
            case 7:series7.add(datosX, datosY);
                dataset.addSeries(series7);
                break;
            case 8:series8.add(datosX, datosY);
                dataset.addSeries(series8);
                break;
            case 9:series9.add(datosX, datosY);
                dataset.addSeries(series9);
                break;
            case 10:series10.add(datosX, datosY);
                dataset.addSeries(series10);
                break;
        }
    }
    public void pintar(){
        panel.repaint();
    }
    public void limpiar(){
        dataset.removeAllSeries();
    }
    public void resetear(){
        series1 = new XYSeries("D1");
        series2 = new XYSeries("D2");
        series3= new XYSeries("D3");
        series4 = new XYSeries("D4");
        series5 = new XYSeries("D5");
        series6 = new XYSeries("D6");
        series7 = new XYSeries("D7");
        series8 = new XYSeries("D8");
        series9 = new XYSeries("D9");
        series10 = new XYSeries("D10");
    }
    public void resetear2(int num){
        switch(num){
            case 1:series1.remove(0);
                break;
            case 2:series2.remove(0);
                break;
            case 3:series3.remove(0);
                break;
            case 4:series4.remove(0);
                break;
            case 5:series5.remove(0);
                break;
            case 6:series6.remove(0);
                break;
            case 7:series7.remove(0);
                break;
            case 8:series8.remove(0);
                break;
            case 9:series9.remove(0);
                break;
            case 10:series10.remove(0);
                break;
        }
    }
}