import java.awt.*;
import java.awt.Color;

/**
 * @author Camera Finn
 */

/*
 * class represents a squirrel captures phenotype does conversion of DNA values
 * into the specific squirrel traits & value (size, color, max speed) allows DNA
 * class & implements to be reused as-is for things other than squirrels class
 * translates DNA values into squirrel-specific properties: color, size, max
 * speed gene 0 encodes color gene 1 encodes size gene 2 encodes max speed
 */
public class Squirrel {

	// instance integer variables: squirrel's position (x & y coordinates)
	private int x_;
	private int y_;
	private DNA squirrelDNA_; // instance variable for squirrel's DNA

	public Squirrel ( int x, int y ) {
		x_ = x;
		y_ = y;
		squirrelDNA_ = new DNA(5); // DNA length is 5; DNA length = 3 for grey scale
	}

	// getter for x
	public int getX () {
		return x_; // returns squirrel's x coordinate
	}

	// getter for y
	public int getY () {
		return y_; // returns squirrel's y coordinate
	}

	// getter for max speed
	public int getMaxSpeed () {
		int maxSpeed_ = (int) (squirrelDNA_.getGene(4) * 15);
		// scales the max speed phenotype 0 and 15
		return maxSpeed_; // returns the squirrel's max speed
	}

	// getter for size
	public int getSize () {
		int size_ = (int) ((squirrelDNA_.getGene(3) * 45) + 5);
		// scales the size phenitype between 5 and 50
		return size_; // returns the squirrel's size
	}

	// getter for color
	public Color getColor () {
		// each color component is scaled between 0 and 255
		int red = (int) (squirrelDNA_.getGene(0) * 255); // gene(0) determines the
		                                                 // red component of
		                                                 // squirrel's color
		int green = (int) (squirrelDNA_.getGene(1) * 255); // gene(1) determines the
		                                                   // green component of
		                                                   // squirrel's color
		int blue = (int) (squirrelDNA_.getGene(2) * 255); // gene(2) determines the
		                                                  // blue component of
		                                                  // squirrel's color

		Color color_ = new Color(red,green,blue);
		return color_;
	}

	public void move ( int left, int top, int width, int height ) {
		// squirrel's current x & y position
		int squirrelX = getX();
		int squirrelY = getY();

		// speeds are scaled between -maxSpeed and +maxSpeed
		int dy = (int) (Math.random() * 2 * getMaxSpeed() - getMaxSpeed()); // squirrel's
		                                                                    // x
		                                                                    // speed
		int dx = (int) (Math.random() * 2 * getMaxSpeed() - getMaxSpeed()); // squirrel's
		                                                                    // y
		                                                                    // speed

		squirrelX = squirrelX + dx; // change in squirrel's x coordinate
		squirrelY = squirrelY + dy; // change in squirrel's y coordinate

		/* left boundary check of squirrel in landscape */
		if ( squirrelX < left - getSize() / 2 ) {
			squirrelX = width + getSize() / 2;
		}
		/* right boundary check of squirrel in landscape */
		else if ( squirrelX > width + getSize() / 2 ) {
			squirrelX = left - getSize() / 2;
		}
		/* top boundary check of squirrel in landscape */
		 if ( squirrelY < top - getSize() ) {
			squirrelY = height + getSize() / 2;
		}

		/* bottom boundary check of squirrel in landscape */
		else if ( squirrelY > height + getSize() / 2 ) {
			squirrelY = left - getSize() / 2;
		}

		x_ = squirrelX;
		y_ = squirrelY;
	}

	public Squirrel reproduce ( double rate ) { // rate is mutation rate
		Squirrel child = new Squirrel(getX() + getSize(),getY() + getSize()); // places
		                                                                      // a
		                                                                      // new
		                                                                      // squirrel
		                                                                      // in
		                                                                      // the
		                                                                      // environment
		child.squirrelDNA_ = squirrelDNA_.clone(squirrelDNA_); // makes a copy of
		                                                       // the parent's gene
		                                                       // for the child
		child.squirrelDNA_.mutate(rate); // run possibility of mutation in the
		                                 // child's genes
		return child;
	}

	public void draw ( Graphics g ) { // draw squirrel
		
		g.setColor(getColor());
		g.fillOval(getX(),getY(),getSize(),getSize()); // draws squirrel
		g.setColor(Color.BLUE);
		// outline in contrasting color
		g.drawOval(getX(),getY(),getSize(),getSize());
	}
}