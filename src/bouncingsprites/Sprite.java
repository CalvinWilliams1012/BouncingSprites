/* File Name:
 * Author Name: Algonquin College
 * Modified By: 
 * Date:
 * Description:
 */

package bouncingsprites;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * 
 * @author Calvin A. Williams Sprite class is an object to create an oval with a
 *         size, max speed and colour as well as location. The Sprite class
 *         implements Runnable for multithreading capabilities.
 */
public class Sprite implements Runnable {
	/**
	 * random is used to create random numbers on initialization.
	 */
	public final static Random random = new Random();
	/**
	 * The size of the oval.
	 */
	final static int SIZE = 10;
	/**
	 * The speed of the oval.
	 */
	final static int MAX_SPEED = 5;

	SpritePanel panel;

	private int x;
	private int y;

	private int dx;
	private int dy;
	private Color color = Color.BLUE;

	public Sprite(SpritePanel panel) {
		this.panel = panel;
		x = random.nextInt(panel.getWidth());
		y = random.nextInt(panel.getHeight());
		dx = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
		dy = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
	}

	@Override
	public void run() {
		while (true) {

			if (this != null) {
				move();
			}
			// invokes paintComponent
			panel.repaint();

			// sleep while waiting to display the next frame of the animation
			try {
				Thread.sleep(40); // wake up roughly 25 frames per second
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, SIZE, SIZE);
	}

	public void move() {

		// check for bounce and make the ball bounce if necessary
		//
		if (x < 0 && dx < 0) {
			// bounce off the left wall
			x = 0;
			dx = -dx;
		}
		if (y < 0 && dy < 0) {
			// bounce off the top wall
			y = 0;
			dy = -dy;
		}
		if (x > panel.getWidth() - SIZE && dx > 0) {
			// bounce off the right wall
			x = panel.getWidth() - SIZE;
			dx = -dx;
		}
		if (y > panel.getHeight() - SIZE && dy > 0) {
			// bounce off the bottom wall
			y = panel.getHeight() - SIZE;
			dy = -dy;
		}

		// make the ball move
		x += dx;
		y += dy;
	}

}
