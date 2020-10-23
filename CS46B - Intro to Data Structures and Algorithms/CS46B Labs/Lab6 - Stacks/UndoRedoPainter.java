package stacklab;

import java.util.*;

public class UndoRedoPainter extends Painter {
	public UndoRedoPainter()
	{
		this.setUndoButtonEnabled(false);
		this.setRedoButtonEnabled(false);
	}

	// Called when the user pushes the Undo button.
	void undo() {

		Stack history = this.getHistory();
		if(!history.isEmpty()) {
			this.setUndoButtonEnabled(true);
			this.getUndoHistory().push((Circle) history.pop());
			this.repaint();
			if (history.isEmpty())
			{
				setUndoButtonEnabled(false);
			}
		}
		this.setRedoButtonEnabled(true);
		

	}

	// Called when the user pushes the Redo button.
	void redo() {
		Stack undoHistory = this.getUndoHistory();
		if (!undoHistory.isEmpty()) {

			this.getHistory().push((Circle) undoHistory.pop());
			this.repaint();
			if (this.getUndoHistory().isEmpty())
			{
				this.setRedoButtonEnabled(false);
			}
		}

	}

	public static void main(String[] args) {
		new UndoRedoPainter().setVisible(true);
	}
}
