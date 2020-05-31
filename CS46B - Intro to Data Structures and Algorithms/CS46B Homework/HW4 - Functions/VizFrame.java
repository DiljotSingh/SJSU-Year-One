
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.*;

import javax.swing.*;


//
// Just before the class declaration, I put a comment describing the class. When you read the rest of
// this comment, don't expect to understand all of it. Just get a sense for how much detail is appropriate.
//
// This class is a JFrame subclass containing a combo box, a Quit button, and a VizPanel instance. Selection changes
// in the combo box trigger setFunction() calls to the VizPanel.
//


public class VizFrame extends JFrame implements ActionListener
{
	private final static DoubleFunctionOfTwoInts[]	FUNCTIONS 	=
	{
		null,
		new AdditionFunction(),
		new SubtractionFunction(),
		new ModFunction(),
		new HypotFunction(),
		new ComplexNormFunction(),
		new ComplexSquaredNormFunction(),
		new WeirdComplexFunction(),
		new MyCreativeFunction(),

	};
	
	// Instance variables. I line up the declarations, and use tabs to line up the variable names.
	// When you take code-writing interviews, they LOVE to see neat readable code.
	private VizPanel				vizPanel;
	private JComboBox<String>		combo;
	private JButton					quitBtn;

	
	// I consistently skip 2 lines before/after constructors and methods. Consistency is good. For curlies,
	// I line up the opening curly and the matching closing curly in the same column. This makes matching curlies
	// easy to find visually: their /spatial/ relationship tells me something about their /functional/
	// relationship.
	VizFrame()
	{
		// Build and install the main panel. This "paragraph" does one thing. The other 2
		// "paragraphs" in this ctor also do one thing.
		vizPanel = new VizPanel(null);
		add(vizPanel, BorderLayout.CENTER);
		
		// Build and install the control panel.
		JPanel controls = new JPanel();
		controls.add(new JLabel("Function:"));
		String[] names = new String[FUNCTIONS.length];
		for (int i=0; i<FUNCTIONS.length; i++)
			names[i] = (FUNCTIONS[i] == null)  ?  "No function, show Axes"  :  FUNCTIONS[i].getName();
		combo = new JComboBox<>(names);
		combo.addActionListener(this);
		controls.add(combo);
		quitBtn = new JButton("Quit");
		quitBtn.addActionListener(this);
		controls.add(quitBtn);
		add(controls, BorderLayout.NORTH);
		
		// Set component sizes.
		pack();
		
		// Frame settings.
		setResizable(false);
		setTitle("CS 46B Vizualization Homework. Copyright (c) 2018 by Philip Heller.");
	}
	
	
	// @Override is an "annotation". It tells the compiler that the following method either
	// overrides a method inherited from a superclass, or implements a method of an interface
	// that this class sayis it implements. Here the class says it implements ActionListener,
	// which defines one method: actionPerformed(ActionEvent e). The annotation catches spelling
	// errors which would otherwise be hard to find. It's useful and interviewers love it when 
	// you demonstrate that you know about it. Try changing the spelling of this method to see
	// what happens. Expect an exam question about @Override.
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == quitBtn)
			System.exit(0);
		
		int index = combo.getSelectedIndex();
		vizPanel.setFunction(FUNCTIONS[index]);
	}
	
	
	// Some people would add a comment here like "Main method of this class". I never do that.
	// Any reader who got past CS46A knows what a main method does. If your comments don't contain
	// useless information, your readers gain trust that reading your comments is worth their
	// effort. Comments shouldn't just be accurate, they should be /helpful/. Expect an exam question
	// about the previous sentence.
	public static void main(String[] args)
	{
		System.out.println("START");
		new VizFrame().setVisible(true);
	}
}
