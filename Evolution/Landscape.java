import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author Camera Finn
 */

public class Landscape {
	// all methods have the width and height of the BufferedImages as parameters
	
	// method that returns an image/landscape of the specified color
	// color red, green, blue values are initialized in parameters
	public static BufferedImage generateSolid( int width, int height, int red, int green, int blue ) {
		BufferedImage img = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
		Graphics g = img.getGraphics();
		g.setColor( new Color( red, green, blue ));
		g.fillRect( 0, 0, width, height ); // returns a rectangle the size of the world
		return img;
	}

	// returns an image with the left half of the image/landscape one color and
	// the right half another color
	// red, green, and blue components are parameters
	public static BufferedImage generateHalf( int width, int height, int red1, int green1, int blue1, int red2,
			int green2, int blue2 ) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor( new Color( red1, green1, blue1 ));
		g.fillRect( 0, 0, width / 2, height );
		g.setColor( new Color( red2, green2, blue2 ));
		g.fillRect( width / 2, 0, width / 2, height );
		return img;
	}

	// returns an image/landscape with several largish shapes inside it
	public static BufferedImage generateCoarse( int width, int height ) {
		BufferedImage img = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
		Graphics g = img.getGraphics();
		g.setColor( new Color(( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 )));
		g.fillRect( 0, 0, width, height ); // rectangle the size of the world =
											// background of landscape
		g.setColor( new Color(( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 )));
		g.fillRect( 0, 0, width / 3, height / 4 );
		g.setColor( new Color(( int ) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255 ) ) );
		g.fillRect( width / 3, 3 * height / 5, 6 * width / 10, 5 * height / 6);
		g.setColor( new Color((int) ( Math.random() * 255 ), ( int ) ( Math.random() * 255), (int) ( Math.random() * 255 ) ) );
		g.fillOval( width / 4, height / 4, width / 2, height / 2 );
		g.setColor( new Color((int) (Math.random() * 255 ), ( int ) ( Math.random() * 255), ( int ) (Math.random() * 255 ) ) );
		g.fillRect( 2 * width / 3, 0, 2 * width / 5, 2 * height / 5 );
		return img;
	}

	// returns an image/landscape with ying-yang sign in the middle
	// has 2 different colors, each with one set of red, green, blue components
	// all of the red, green, and blue components are set to random values scaled to 255
	public static BufferedImage generateCoarse2( int width, int height ) {
		BufferedImage img = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
		Graphics g = img.getGraphics();
		int red = ( int ) ( Math.random() * 255 );
		int green = ( int ) ( Math.random() * 255 );
		int blue = ( int ) ( Math.random() * 255 );

		int red2 = ( int ) ( Math.random() * 255 );
		int green2 = ( int ) ( Math.random() * 255 );
		int blue2 = ( int ) ( Math.random() * 255 );

		g.setColor(new Color(( int ) (Math.random() * 255 ), ( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 )));
		g.fillRect(0, 0, width, height); // rectangle the size of the world =
											// background of landscape
		g.setColor(new Color( red, green, blue ));
		g.fillArc( width / 4, height / 4, width / 2, width / 2, 0, 180 );
		g.setColor( new Color(red2, green2, blue2 ));
		g.fillArc( width / 4, height / 4, width / 2, width / 2, 0, -180 );
		g.setColor( new Color(red2, green2, blue2));
		g.fillArc( width / 4, height / 4 + width / 8 + 1, width / 4, width / 4, 0, 180 );
		g.setColor( new Color(red, green, blue ));
		g.fillArc( width / 2, height / 4 + width / 8, width / 4, width / 4, 0, -180 );
		g.setColor( new Color(red, green, blue ));
		g.fillArc( width / 4 + width / 8 - width / 32, height / 4 + width / 4 - width / 32,
				width / 16, width / 16, 0, 360 );
		g.setColor( new Color( red2, green2, blue2 ));
		g.fillArc( width / 4 + width /4 + ( width / 32 ) * 3, height / 4 + width / 4 - width / 32,
				width / 16, width / 16, 0, 360 );
		return img;
	}

	// returns an image/landscape filled with 100 ovals randomly placed with random sizes
	public static BufferedImage generateFine( int width, int height ) {

		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(new Color(( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 ) ));
		g.fillRect( 0, 0, width, height ); // rectangle the size of the world =
											// background of landscape
		for ( int i = 0; i < 100; i++ ) {
			g.setColor(
					new Color(( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255), ( int ) ( Math.random() * 255 )));
			g.fillOval(( int ) ( Math.random() * width - 25 ), ( int ) ( Math.random() * height - 25 ),
					( int ) ( Math.random() * 50 + 50), ( int ) ( Math.random() * 50 + 50 ));
		}
		return img;
	}
}