/** Snake object.
* @author: Weirong He
* @since 04/16/2018
*/
public class Snake {
   /** Snake's x position. */
   private int x = 0;
   /** Snake's y pisition. */
   private int y = 0;
   /** constructor.
   * @param newX  the new Snake's x position
   * @param newY  the new Snake's y pisition
   */
   public Snake(int newX, int newY) {
      this.x = newX;
      this.y = newY;
   }
    
  /* get methods. */
  
  /**
  * Gets the Snake's x position.
  * @return The x
  */
   public int getX() {
      return x;
   }
  /**
  * Gets the Snake's y position.
  * @return The y
  */
   public int getY() {
      return y;
   }
   
   /* set methods. */
   
  /**
  * Sets the Snake's x position.
  * @param newX  the new Snake's x position
  * @return The x
  */
   public int setX(int newX) {
      x = newX;
      return x;
   }
  /**
  * Sets the Snake's y position.
  * @param newY  the new Snake's y position
  * @return The y
  */
   public int setY(int newY) {
      y = newY;
      return y;
   }
   

}