import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ssb
 */
public class SimWindow extends JFrame {

	private SimPanel[] panels_;

	public SimWindow ( World[] worlds, int delay ) {
		super("simulation");
		panels_ = new SimPanel[worlds.length];

		// components are added to the content pane
		Container content = getContentPane();
		// set layout manager to arrange components within the content pane
		content.setLayout(new BorderLayout());

		{
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
			content.add(BorderLayout.CENTER,panel);
			for ( int i = 0 ; i < worlds.length ; i++ ) {
				panels_[i] = new SimPanel(worlds[i],delay);
				if ( i > 0 ) {
					panel.add(Box.createHorizontalStrut(15));
				}
				panel.add(panels_[i]);
			}
		}

		{
			JPanel panel = new JPanel();
			{
				JButton button = new JButton("init");
				button.addActionListener(new InitAction());
				panel.add(button);
			}
			{
				JButton button = new JButton("start");
				button.addActionListener(new StartAction());
				panel.add(button);
			}
			{
				JButton button = new JButton("stop");
				button.addActionListener(new StopAction());
				panel.add(button);
			}
			content.add(BorderLayout.SOUTH,panel);
		}

		validate();
		pack();
		setVisible(true);
	}

	class InitAction implements ActionListener {
		/*
		 * (non-Javadoc)
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed ( ActionEvent e ) {
			for ( int i = 0 ; i < panels_.length ; i++ ) {
				panels_[i].init();
			}
		}
	}

	class StartAction implements ActionListener {
		/*
		 * (non-Javadoc)
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed ( ActionEvent e ) {
			for ( int i = 0 ; i < panels_.length ; i++ ) {
				panels_[i].start();
			}
		}
	}

	class StopAction implements ActionListener {
		/*
		 * (non-Javadoc)
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed ( ActionEvent e ) {
			for ( int i = 0 ; i < panels_.length ; i++ ) {
				panels_[i].stop();
			}
		}
	}
}
