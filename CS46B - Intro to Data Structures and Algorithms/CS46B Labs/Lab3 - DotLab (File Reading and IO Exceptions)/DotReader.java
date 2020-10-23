package dotlab;

import java.io.*;

public class DotReader {
	private BufferedReader br;

	public DotReader(BufferedReader br) {
		this.br = br;
	}

	public Dot readDot() throws DotException, IOException {

		String line = br.readLine();
		if (line == null)
		{
			return null;
		}
			String[] lineArgs = line.split(",");
			if ((lineArgs.length != 4))
			{
				throw new DotException("Line must have EXACTLY four arguments");
			}
			
				
			String name = lineArgs[0];
			int x = Integer.parseInt(lineArgs[1]);
			int y = Integer.parseInt(lineArgs[2]);
			int radius = Integer.parseInt(lineArgs[3]);
			
			Dot newDot = new Dot(name, x, y, radius);
			return newDot;
				
		}
	
	
	
}

