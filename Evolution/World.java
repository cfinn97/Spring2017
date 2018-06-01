import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author CameraFinn
 */
public class World {
	
	/**
	 * @return
	 */

	private BufferedImage land_; // landscape variable
	private Predator predator_; // predator variable
	private ArrayList<Squirrel> squirrelArrayList_; // arraylist of squirrels
	private double mutateRate_, reproduceRate_, caughtRate_;
	// rates for mutation, reproduction and predator catching squirrels
	private int startSquirrels_; // initial squirrel population variable

	
	/*
	 * initializes the landscape, reproduction, mutate and catch rates, and the squirrel population
	 * */
	public World ( int numSquirrels, BufferedImage landS, double reproduceRate,
	               double mutateRate, double catchRate, Predator predator ) {
		startSquirrels_ = numSquirrels;
		land_ = landS;
		predator_ = predator;
		squirrelArrayList_ = new ArrayList<Squirrel>();
		reproduceRate_ = reproduceRate;
		mutateRate_ = mutateRate;
		caughtRate_ = catchRate;
	}

	/**
	 * @return
	 */
	public int getHeight () {
		return land_.getHeight(); // returns height of environment
	}

	/**
	 * @return
	 */

	public int getWidth () { // returns width of environment
		return land_.getWidth();
	}

	/**
	 * @param g
	 */

	public void draw ( Graphics g ) {
		g.drawImage(land_,0,0,null); // draw landscape
		for ( int i = 0 ; i < squirrelArrayList_.size() ; i++ ) {
			squirrelArrayList_.get(i).draw(g); // draw squirrels
		}
	}

	// total amount of squirrels and the average size, speed, and visibility of the population
	public void printStats () {
		double average, sizeSum = 0, visibilityStat = 0, speedStat = 0;
		for ( int i = 0 ; i < squirrelArrayList_.size() ; i++ ) {
			sizeSum = sizeSum + squirrelArrayList_.get(i).getSize();
			speedStat += squirrelArrayList_.get(i).getMaxSpeed();
			visibilityStat +=
			    predator_.getVisibility(squirrelArrayList_.get(i),land_);
		}
		speedStat /= squirrelArrayList_.size();
		visibilityStat /= squirrelArrayList_.size();
		average = sizeSum / squirrelArrayList_.size();
		System.out.print("Total Number of Squirrels: " + squirrelArrayList_.size()
		    + "\n" + "Average Squirrel Size: " + average + "\n" + "Average Speed: "
		    + speedStat + "\n" + "Visibility Average: " + visibilityStat + "\n"
		    + "\n");
	}

	// fills the squirrel array with randomly-placed squirrels to the initialized population size
	public void init () {
		for ( int i = 0 ; i < startSquirrels_  ; i++ ) {
			int squirrelX = (int) (Math.random() * getWidth());
			int squirrelY = (int) (Math.random() * getHeight());
			squirrelArrayList_.add(i,new Squirrel(squirrelX,squirrelY));
		}
	}

	public void step () {
		// 1st step: probability of each squirrel being caught
		for ( int i = 0 ; i < squirrelArrayList_.size() ; i++ ) {
			if ( predator_.getVisibility(squirrelArrayList_.get(i),land_)
			    * caughtRate_ >= (Math.random() * 0.5) ) { // scale Math.radom() to
			                                               // 0.5 so that there is
			                                               // also the factor of
			                                               // chance into play of the
			                                               // catching of the
			                                               // squirrels
				squirrelArrayList_.remove(i);
			}
		} // end check each squirrel caught by predator

		for ( int i = 0 ; i < squirrelArrayList_.size() ; i++ ) {
			squirrelArrayList_.get(i).move(0,0,getWidth(),getHeight());
		} // end move step of each squirrel

		for ( int i = 0 ; i < squirrelArrayList_.size() ; i++ ) {
			// scale Math.radom() to 0.5 so that there is also the factor of chance
			// into play of the reproduction of the squirrels
			if ( Math.random() * 0.5 >= reproduceRate_
			    && squirrelArrayList_.size() < 100 ) { // squirrel population limit is
			                                           // 100
				squirrelArrayList_
				    .add(squirrelArrayList_.get(i).reproduce(mutateRate_));
			}
		} // end loop to test for reproduction
	}

}
