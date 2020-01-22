import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
* Panel for PokemonGUIHeweiron GUI.
* Demonstrates connecting non-gui objects to GUI
*
* @author Weirong He
* @since 05/07/2018
*/
public class CarPanel extends JPanel implements ActionListener{
   
   private CanvasPanel carPanel = new CanvasPanel();
   private ArrayList<Snake> sArr = new ArrayList<>();
   private int x = 200;
   private int y = 200;
   private int tX = 100;
   private int tY = 100;
   private int xr = 200;
   private int yr = 200;
   private int rate = 0;
   private int direction = 3;
   private Random randGen = new Random();
   private Timer time = new Timer(500, this);
   private boolean stop = false;
   
   private JPanel iPanel = new JPanel();
   private JButton bStart = new JButton("start"); 

   private JLabel lMsg = new JLabel("");
   
   private Image iBuffer;
   private Graphics gBuffer;
   private Choice mode = new Choice();
   
   
   public CarPanel() {
      
      
      
      //chu shi jie mian
      
      iPanel.add(bStart);
      iPanel.add(lMsg);
      bStart.addActionListener(this); 
      add(iPanel);
      mode.add("Easy");
      mode.add("Medium");
      mode.add("Hard");
      iPanel.add(mode); 
      
      //game 
      
         //apple random 
      xr = (randGen.nextInt(26) + 1) * 50;
      yr = (randGen.nextInt(8) + 1) * 50;
         //chu shi she
      Snake s1 = new Snake(x, y);
      sArr.add(s1);
      tX = s1.getX() - 50;
      tY = s1.getY();
      Snake s2 = new Snake(tX, tY);
      sArr.add(s2);
      
      tX = s2.getX() - 50;
      tY = s2.getY();
      Snake s3 = new Snake(tX, tY);
      sArr.add(s3);
   
   
      setPreferredSize(new Dimension(1600,800));
      setLayout(new GridLayout(1, 1));
      carPanel.repaint();
      
      
      
      
      
      carPanel.addKeyListener(
         new KeyAdapter(){
            public void keyPressed(KeyEvent e){
               switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if(direction != 4) {
                        direction = 1; //up
                     }
                     break;
                  case KeyEvent.VK_LEFT:
                     if(direction != 3) {
                        direction = 2; //left
                     }
                     break;
                  case KeyEvent.VK_RIGHT:
                     if(direction != 2) {
                        direction = 3; //right
                     }
                     break;
                  case KeyEvent.VK_DOWN:
                     if(direction != 1) {
                        direction = 4; //down
                     }
                     break;
                  case KeyEvent.VK_SPACE:
                     if(!stop){
                        time.stop();
                        stop = true;
                     } else {
                        time.start();
                        stop = false;
                     }
                     break;
               }
                              
            }
         
         });
   
      
   
   
   }
   public void snakePanel() {
      x = 200;
      y = 200;
      direction = 3;
      sArr.clear();
      Snake s1 = new Snake(x, y);
      sArr.add(s1);
      tX = s1.getX() - 50;
      tY = s1.getY();
      Snake s2 = new Snake(tX, tY);
      sArr.add(s2);
      
      tX = s2.getX() - 50;
      tY = s2.getY();
      Snake s3 = new Snake(tX, tY);
      sArr.add(s3);
      carPanel.repaint();
   
   }
   
  

      
   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
   public void actionPerformed(ActionEvent event) {
      if(x > 0 && x < 1350 && y > 0 && y < 750) {
         if(direction == 1) { // up
            y = y - 50;
         } else if (direction == 2) { // left
            x = x - 50;
         } else if (direction == 3) { // right
            x = x + 50;
         } else if (direction == 4) { // down
            y = y + 50;
         }     
         for(int i = sArr.size() - 1; i >= 1; i--){ 
            sArr.get(i).setX(sArr.get(i - 1).getX());
            sArr.get(i).setY(sArr.get(i - 1).getY());
         }
         sArr.get(0).setX(x);
         sArr.get(0).setY(y);
         
         
         carPanel.repaint();
      } else {
         //You Lose!!
         Object[] options = {"Yes", "No"};
         int response=JOptionPane.showOptionDialog(this, "Please Start A New Game!", "You Lose", JOptionPane.YES_OPTION,0, null, options, options[0]);
         if(response == 0) {
            snakePanel();
         } else {
            removeAll();
            snakePanel();
            time.stop();
            add(iPanel);
            validate();
            
         }
         
      }
      for(int i = 1; i < sArr.size() - 1;i++) {
                  
         if(x == sArr.get(i).getX() && y == sArr.get(i).getY()) {
            //You Lose!
            Object[] options = {"Yes", "No"};
            int response=JOptionPane.showOptionDialog(this, "Please Start A New Game!", "You Lose", JOptionPane.YES_OPTION,0, null, options, options[0]);
            if(response == 0) {
               snakePanel();
            } else {
               removeAll();
               snakePanel();
               time.stop();
               add(iPanel);
               validate();
            
            }
           
         } 
      }
      
      if (event.getSource() == bStart) {
         
         removeAll();
         snakePanel();
         add(carPanel);
         validate();
         String sMode = mode.getSelectedItem();
         switch(sMode) {
            case "Easy": time = new Timer(300, this);
               break;
            case "Medium": time = new Timer(200, this);
               break;
            case "Hard" : time = new Timer(100, this);
         }
         
      }
   
   
   }
    
   
  
   
   
   
   class CanvasPanel extends Canvas{
      
      @Override
        public void paint(Graphics g) {
         super.paint(g);
         boolean loop = true;
         g.fillRect(0, 0, 1400, 50);
         g.fillRect(0, 0, 50, 800);
         g.fillRect(1350, 0, 50, 800);
         g.fillRect(0, 750, 1400, 50);
         for(int i = 1; i < sArr.size() - 1;i++) {
            tX = sArr.get(i).getX();
            tY = sArr.get(i).getY();
            g.drawRect(tX, tY, 50, 50);
         }
         g.setColor(Color.red);
         g.fillRect(sArr.get(0).getX(), sArr.get(0).getY(), 50, 50);
         g.setColor(Color.black);
         g.fillOval(xr, yr, 50, 50);
         time.start();
         // creat oval which not on snake
         if(x == xr && y == yr) {
            Snake s4 = new Snake(x, y);
            sArr.add(s4);
            while(loop) {
               xr = (randGen.nextInt(26) + 1) * 50;
               yr = (randGen.nextInt(14) + 1) * 50;
               for(int i = 0; i < sArr.size() - 1;i++) {
                  
                  if(xr == sArr.get(i).getX() && yr == sArr.get(i).getY()) {
                     loop = true;
                     break;
                  } else {
                     loop = false;
                  } 
               }
            }
         }
         
      }
      
     
      
      
      
   }


       
    

}