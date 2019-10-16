import java.applet.*;
import java.awt.*;
import javax.swing.text.StyleConstants;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author luizg
 */
public class ArvoreFractal extends Applet {

    LSEDTail <Ramo> lista = new LSEDTail();
    
  
    
       public void init(Graphics g){
           Graphics2D g2 = (Graphics2D) g;
           //g2.getStroke
           sDetBackground(Color.WHITE);
           setSize(1200,600);
       }
       public void imprimiLista(Graphics g, int nivel){
           System.out.println(lista.elementos());
           for(int j = nivel ; j >=0 ; j--){
               try {
                   Thread.sleep(50);
               } catch (InterruptedException ex) {
                   Logger.getLogger(ArvoreFractal.class.getName()).log(Level.SEVERE, null, ex);
               }
               for(int i = 0; i < lista.elementos();i++){
               if(lista.get(i).ant != null){
                   if(lista.get(i).nivel == j){
                       g.drawLine(lista.get(i).x1, lista.get(i).y1, lista.get(i).ant.x1, lista.get(i).ant.y1);
                       
                   }
                   
               }
           }
       }
           
           
       }
       public void paint(Graphics g){
           Ramo pai = new Ramo(600, 500, null,0 );
           
           Graphics2D g2D = (Graphics2D) g;
           Color marrom = new Color(182,112, 16);
           Color verde = new Color(0,126,0);
           GradientPaint cor = new GradientPaint(182,0,verde, 112, 116, marrom);
           g2D.setPaint(cor);
           
           g2D.setStroke(new BasicStroke(5.0f));
           
           try {
               criaArvore(5, 100, 0,pai,g);
           } catch (InterruptedException ex) {
               Logger.getLogger(ArvoreFractal.class.getName()).log(Level.SEVERE, null, ex);
           }
           imprimiLista(g,5);
       }
       
       
       
       void criaArvore(int nivel, int comp, int angulo,Ramo pai,Graphics g ) throws InterruptedException{
           if(nivel == 0){
               return;
           }
           
           
           
           
           
           int moveX = (int)(Math.cos(Math.toRadians(angulo + 90)) * comp);
           int moveY = (int)(Math.sin(Math.toRadians(angulo - 90))* comp);
           Ramo ramo = new Ramo(moveX + pai.x1,moveY+ pai.y1,pai, nivel);
           lista.insereNoFinal(ramo);
           //g.drawLine(pai.x1, pai.y1, pai.x1 + moveX, pai.y1 + moveY);
          
           if(comp>= 1){
               criaArvore(nivel -1, comp - 10, angulo + 17, ramo, g);
               criaArvore(nivel -1, comp - 10, angulo - 17, ramo, g);
               //criaArvore(nivel + 1, comp - 10, angulo + 17, x + moveX, y + moveY, g);
               //criaArvore(nivel + 1, comp - 10, angulo - 30, x + moveX, y + moveY, g);
           }
       }

    private void sDetBackground(Color WHITE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       

}
