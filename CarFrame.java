import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
* Demonstrates using GUI with Pokemon class.
* @author Weirong He
* @since 10/23/2018
*/

public class CarFrame {
   /** main method.
   * @param args not used
   */
   

   public static void main(String[ ] args) {
      //setup basic JFrame
      JFrame frm = new JFrame("Snake"){
      
      };
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add PokemonPanel object to Frame
      frm.getContentPane().add(new CarPanel());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
   }
  

   
}