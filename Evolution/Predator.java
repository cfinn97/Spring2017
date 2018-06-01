import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author Camera Finn
 */
public class Predator {

	// returns the visibility of the squirrel
	public double getVisibility( Squirrel squirrel, BufferedImage landscape ) {
		double visibility = 0.0;
		
		// check is squirrel is in the landscape region
		if ( squirrel.getX() <= 0 || squirrel.getX() >= landscape.getWidth() || squirrel.getY() <= 0
				|| squirrel.getY() >= landscape.getHeight() ) {
			visibility = 0.0;
		} else {
			Color col = new Color( landscape.getRGB( squirrel.getX(), squirrel.getY() ) );
			double r = squirrel.getColor().getRed();
			double g = squirrel.getColor().getGreen();
			double b = squirrel.getColor().getBlue();

			// landscape color at squirrel's x & y coordinates
			double r2 = col.getRed();
			double g2 = col.getGreen();
			double b2 = col.getBlue();

			double visibility1 = Math.abs( r - r2 );
			double visibility2 = Math.abs( g - g2 );
			double visibility3 = Math.abs( b - b2 );
			
			visibility = (visibility1 + visibility2 + visibility3) / 765;
			// sets the visibility equal to the greatest difference in of the differences for
			// each color component
			if( visibility1 > visibility2 && visibility1 > visibility3 ) {
				visibility = visibility1 / 255;
			} else if( visibility2 > visibility1 && visibility2 > visibility3 ) {
				visibility = visibility1 / 255;
			} else if ( visibility3 > visibility1 && visibility3 > visibility2 ) {
				visibility = visibility3 / 255;
			}
		}
		return visibility; // returns final value of visibility
	}
}
