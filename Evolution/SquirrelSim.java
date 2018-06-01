/**
 * @author CameraFinn
 */

// runs the program
public class SquirrelSim {
	public static void main(String[] args) {
		int wdth = 500, hgt = 500; // dimensions of the world
		Predator predator = new Predator(); // creates predator object
		World[] world = new World[3]; // creates an array of 3 worlds

		// parameters of world: inital population size when init button is pushed,
		// the height and width of the landscapes, and sets the color components to random values scaled to 255,
		// initializes the values of the mutation rate, catch rate, and reproducton rate
		// and initializes the predator
		// creates world with landscape: left half one color, right half another color
		world[0] = new World(50,
				Landscape.generateHalf( wdth, hgt, ( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 ),
						( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255 ),
						( int ) ( Math.random() * 255 )),
				0.01, 0.01, 0.01, predator);
		
		// parameters of world: inital population size when init button is pushed,
		// the height and width of the landscapes, and sets the color components to random values scaled to 255,
		// initializes the values of the mutation rate, catch rate, and reproducton rate
		// and initializes the predator
		// creates world with landscape: one color
		world[1] = new World( 50, Landscape.generateSolid( wdth, hgt, ( int ) ( Math.random() * 255 ),
				( int ) ( Math.random() * 255 ), ( int ) ( Math.random() * 255)), 0.01, 0.01, 0.01, predator );
		
		// parameters of world: inital population size when init button is pushed,
		// the height and width of the landscapes, and sets the color components to random values scaled to 255
		// and initializes the values of the mutation rate, catch rate, and reproducton rate
		// and initializes the predator
		// creates world with landscape: filled with many ovals
		world[2] = new World( 50, Landscape.generateFine( wdth, hgt ), 0.01, 0.01, 0.01, predator );

		SimWindow window = new SimWindow( world, 100 ); // creates a window to view program, showing all three
														// worlds, with a delay time of 100

		window.setResizable( true ); // allows the user to change the size of the window
		window.setVisible( true ); // makes the window visible
	}
}
