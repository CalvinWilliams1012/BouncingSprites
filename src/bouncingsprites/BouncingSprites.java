/* File Name:
 * Author Name: Algonquin College
 * Modified By: 
 * Date:
 * Description:
 */

package bouncingsprites;

import javax.swing.JFrame;

/**
 * 
 * @author Calvin A. Williams
 * The BouncingsSprites is the start point for the application.
 */
public class BouncingSprites {
	
    private JFrame frame;
    private SpritePanel panel = new SpritePanel();

    public BouncingSprites() {
        frame = new JFrame("Bouncing Sprites 2017W");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void start(){
    	panel.animate();  // never returns due to infinite loop in animate method
    }

    public static void main(String[] args) {
        new BouncingSprites().start();
    }
}
