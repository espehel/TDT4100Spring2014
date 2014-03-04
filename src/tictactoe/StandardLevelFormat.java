package tictactoe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StandardLevelFormat implements LevelFormat{
	
	@Override
	public String readLevel(InputStream input) {
		Scanner reader = new Scanner(input);
		StringBuilder output = new StringBuilder();
		while (reader.hasNext()){
			output.append(reader.nextLine());
		}
		reader.close();
		
		return parseOutput(output.toString());
		
	}

	//removes the seperators
	private String parseOutput(String text) {
		StringBuilder grid = new StringBuilder();
		String legalChars  = "ox";
		
		for (int i = 0; i < text.length(); i++) {
			if(legalChars.indexOf(text.charAt(i)) != -1){
				grid.append(text.charAt(i));
			}
			if(emptySlot(i,text))
				grid.append(" ");
		}
		return grid.toString();
	}
	
	//check for empty slot, which will give one whitespace
	private boolean emptySlot(int i, String text) {
		if(text.length()< i+3)
			return false;
		return text.substring(i, i+3).equals("   ");	
	}

	@Override
	public void writeLevel(String grid, OutputStream output){
		OutputStreamWriter writer = new OutputStreamWriter(output);
		try {
			writer.write(grid);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
