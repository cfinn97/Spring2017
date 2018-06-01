import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 * A SimPanel handles the graphical and animation elements of a simulation.
 */
public class SimPanel extends JPanel implements ActionListener {

	private World world_; // the world of the simulation
	private Timer timer_; // timer for animation

	private Image image_; // for double-buffering the display

	/**
	 * Create a new SimPanel for the specified world.
	 * 
	 * @param world
	 *          world to simulate
	 * @param delay
	 *          time delay between simulation steps (ms)
	 */
	public SimPanel ( World world, int delay ) {
		world_ = world;
		image_ = new BufferedImage(world.getWidth(),world.getHeight(),
		                           BufferedImage.TYPE_INT_RGB);
		world_.draw(image_.getGraphics());
		timer_ = new Timer(delay,this);
		setBorder(BorderFactory.createLineBorder(Color.RED));
	}

	/**
	 * Start (or restart) the simulation running.
	 */
	public void start () {
		if ( !timer_.isRunning() ) {
			timer_.start();
		}
	}

	/**
	 * Stop the simulation.
	 */
	public void stop () {
		timer_.stop();
		world_.printStats();
	}

	/**
	 * Initialize
	 */
	public void init () {
		timer_.stop();
		world_.init();
		world_.printStats();
		world_.draw(image_.getGraphics());
		repaint();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent ( Graphics g ) {
		super.paintComponent(g);
		if ( image_ != null ) {
			g.drawImage(image_,0,0,image_.getWidth(null),image_.getHeight(null),null);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed ( ActionEvent e ) {
		// not perfect way to ensure thread-safety for world updates, but want to
		// keep it out of student code
		synchronized ( this ) {
			world_.step();
			if ( image_ != null ) {
				world_.draw(image_.getGraphics());
			}
		}
		repaint();
	}

	/**
	 * Resize the existing image. Extra space is filled with a default background
	 * color, while parts of the old image extending past the boundaries of the
	 * new image are truncated.
	 * 
	 * @param width
	 *          new width for image
	 * @param height
	 *          new height for image
	 */
	protected void resizeImage ( int width, int height ) {
		// if no existing image, there is nothing to resize
		if ( image_ == null ) {
			return;
		}

		int iwidth = image_.getWidth(null); // width of existing image
		int iheight = image_.getHeight(null); // height of existing image

		// only resize the image if the new requested size is actually different
		if ( iwidth != width || iheight != height ) {
			Image newimage =
			    new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Graphics g = newimage.getGraphics();
			g.drawImage(image_,0,0,iwidth,iheight,null);

			image_ = newimage;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#setBounds(int, int, int, int)
	 */
	@Override
	public void setBounds ( int x, int y, int width, int height ) {
		super.setBounds(x,y,width,height);
		resizeImage(width,height);
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#setBounds(java.awt.Rectangle)
	 */
	@Override
	public void setBounds ( Rectangle r ) {
		super.setBounds(r);
		resizeImage(r.width,r.height);
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#setSize(java.awt.Dimension)
	 */
	@Override
	public void setSize ( Dimension d ) {
		super.setSize(d);
		resizeImage(d.width,d.height);
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#setSize(int, int)
	 */
	@Override
	public void setSize ( int width, int height ) {
		super.setSize(width,height);
		resizeImage(width,height);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize () {
		return new Dimension(world_.getWidth(),world_.getHeight());
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#getMaximumSize()
	 */
	@Override
	public Dimension getMaximumSize () {
		return new Dimension(world_.getWidth(),world_.getHeight());
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#getMinimumSize()
	 */
	@Override
	public Dimension getMinimumSize () {
		return new Dimension(world_.getWidth(),world_.getHeight());
	}

}
