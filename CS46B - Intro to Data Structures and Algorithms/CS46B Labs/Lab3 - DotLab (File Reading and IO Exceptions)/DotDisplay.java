package dotlab;

import java.lang.reflect.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/*
 * Don't touch this until Part 3. Leave all the code alone. Just add a read() method
 * as described in the instructions. When you do that correctly, the compiler
 * errors will all be corrected.
 * 
 * Run this as an application to see the dots on the screen.
 */

public class DotDisplay extends JFrame implements ActionListener {
	private ArrayList<Dot> dots;
	private DotPanel dotPanel;
	private JButton readBtn;
	private JButton quitBtn;

	public DotDisplay() {
		dots = new ArrayList<>();

		// Init GUI: DotPanel at center, control panel at north.
		dotPanel = new DotPanel();
		add(dotPanel, BorderLayout.CENTER);
		JPanel controls = new JPanel();
		readBtn = new JButton("Read...");
		readBtn.addActionListener(this);
		controls.add(readBtn);
		quitBtn = new JButton("Quit");
		quitBtn.addActionListener(this);
		controls.add(quitBtn);
		add(controls, BorderLayout.NORTH);
		pack();
	}

	// Add a dot to the display list. Don't repaint here. Caller should
	// repaint when list is fully populated.
	public void addDot(Dot dot) {
		dots.add(dot);
	}

	// Process a button click in the control panel.
	public void actionPerformed(ActionEvent e) {
		// Quit.
		if (e.getSource() == quitBtn)
			System.exit(0);

		// Read. Prompt for input file, then parse using read().
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
		File f = chooser.getSelectedFile();
		if (f == null)
			return;

		try {
			dots.clear();
			read(f);
			dotPanel.repaint();
		} catch (IOException x) {
			System.out.println("Couldn't read file " + f);
		} catch (DotException x) {
			// Caused by invalid input line in file.
			System.out.println(x.getMessage());
		}
	}

	// Inner class
	private class DotPanel extends JPanel {
		public Dimension getPreferredSize() {
			return new Dimension(800, 600);
		}

		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 3000, 3000);

			for (Dot dot : dots) {
				g.setColor(Color.LIGHT_GRAY);
				try {
					// Reflect color name. Dot ctor shouldn't accept an invalid name, so
					// this block shouldn't fail. If it does fail for some reason, the dot
					// color will failsafe to light gray.
					Field field = Color.class.getField(dot.getColorName());
					Color fill = (Color) field.get(null);
					g.setColor(fill);
				} catch (NoSuchFieldException | IllegalAccessException x) {
				}
				// Compute bounding box for the dot, and paint.
				int ulx = dot.getX() - dot.getRadius();
				int uly = dot.getY() - dot.getRadius();
				g.fillOval(ulx, uly, 2 * dot.getRadius(), 2 * dot.getRadius());
			}
		}
	} // End of inner class DotPanel.

	private void read(File f) throws IOException, DotException {
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		DotReader dr = new DotReader(br);

		Dot d;
		while ((d = dr.readDot()) != null)
		{
				addDot(d);
		}

			
		br.close();
		fr.close();

	}

	public static void main(String[] args) {
		new DotDisplay().setVisible(true);
	}
}
