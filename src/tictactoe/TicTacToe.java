package tictactoe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TicTacToe implements ConsoleGame{
	
	
	private String gridString;
	private char player;
	private Stack<ArrayList<Integer>> undo;
	private Stack<ArrayList<Integer>> redo;
	
	public TicTacToe() {
		gridString = "         ";
		player = 'x';
		undo = new Stack<ArrayList<Integer>>();
		redo = new Stack<ArrayList<Integer>>();
	}
	
	public char getCell(int x, int y) {
		return gridString.charAt(indexAt(x, y));
	}
	
	public boolean setCell(char c, int x, int y) {
		if (! isOccupied(x, y) || c == ' ') {
			int index = indexAt(x, y);
			gridString = gridString.substring(0, index) + c + gridString.substring(index+1);
			
			if (c != ' ')//if char equals whitespace this is an undo-move and we dont have to save it here.
				saveMove(c, x, y);
			
			return true;
		}
		return false;
	}
	
	public boolean isOccupied(int x, int y) {
		return getCell(x, y) != ' ';
	}

	public char getCurrentPlayer() {
		return player;
	}
	
	public String toString() {
		String str = "";
		for (int y = 0; y <= 2; y++) {
			for (int x = 0; x <= 2; x++) {
				str += " " + gridString.charAt(indexAt(x, y)) + " |";
			}
			str = str.substring(0,str.length()-2) + " \n-----------\n"; //a small change from the "lf" for oving4 is made here. A whitespace is added before newline
		}
		return str.substring(0, str.length()-12);
	}
	
	/* 
	 * Grid coordinates:
	 * (0,0) | (1,0) | (2,0)
	 * ---------------------
	 * (0,1) | (1,1) | (2,1)
	 * ---------------------
	 * (0,2) | (1,2) | (2,2)
	 */
	public int indexAt(int x, int y) {
		return x + 3 * y;
	}


	public void play(int x, int y) {
		if (setCell(player, x, y)) {
			// Change player
			player = player == 'x' ? 'o' : 'x';
			//a new playermove means it should not be possible to redo old moves
			redo.clear();
		}
	}

	private boolean checkNInARow(char c, int n, int x, int y, int dx, int dy) {
		while (n > 0) {
			if (getCell(x, y) != c) {
				return false;
			}
			x += dx;
			y += dy;
			n--;
		}
		return true;
	}
	
	public boolean isWinner(char c) {
		return
			// rows
			checkNInARow(c, 3, 0, 0, 1, 0) || checkNInARow(c, 3, 0, 1, 1, 0) || checkNInARow(c, 3, 0, 2, 1, 0)
			|| // columns
			checkNInARow(c, 3, 0, 0, 0, 1) || checkNInARow(c, 3, 1, 0, 0, 1) || checkNInARow(c, 3, 2, 0, 0, 1)
			|| // diagonals
			checkNInARow(c, 3, 0, 0, 1, 1) || checkNInARow(c, 3, 2, 0, -1, 1)
			;
	}
	
	public boolean hasWinner() {
		return isWinner('x') || isWinner('o');
	}
	
	public boolean isFinished() {
		return hasWinner() || gridString.indexOf(' ') < 0;
	}
	
	
	/* 
	 *DEL 1
	 */
	
	//save the char(as int) and the position in an Integer array, then pushes it too the undo stack
	private void saveMove(int c, int x, int y){
		ArrayList<Integer> move = new ArrayList<Integer>(Arrays.asList((int)c, x, y));
		undo.push(move);

	}
	//calls the setCell method with a whitespace and coordinates for the head of the undo stack, then pops and pushes it into the redo stack
	public void undoMove(){
		
		if(undo.isEmpty())
			return;
		
		ArrayList<Integer> move = undo.pop();
		setCell(' ',move.get(1), move.get(2));
		redo.push(move);
	}
	//pops the head of the stack and calls the setCell with all the info. The first Integer is casted back to a char
	public void redoMove(){
		
		if(redo.isEmpty())
			return;
		
		ArrayList<Integer> move = redo.pop();
		setCell((char)move.get(0).intValue(),move.get(1),move.get(2));
	}

	//load the game with a prefilled grid. Checks who is the next to make a move
	public void loadGame(String grid) {
		gridString = grid;
		
		int x = 0;
		int o = 0;
		for (int i = 0; i < grid.length(); i++) {
			if(grid.charAt(i)=='x')
				x++;
			if(grid.charAt(i)=='o')
				o++;
		}
		if(x>o)
			player = 'o';
	}

	
	/*
	 * DEL 3
	 */
	
	@Override
	public void init() {
		gridString = "         ";
		player = 'x';
		undo = new Stack<ArrayList<Integer>>();
		redo = new Stack<ArrayList<Integer>>();
	}

	@Override
	public void run() {
		
	}

	@Override
	public Integer doLine(String input) {
		if(input.charAt(0)=='<')
			loadFile(input.substring(1));
		else if(input.charAt(0)=='>')
			saveGame(input.substring(1));
		else{
			int x = Integer.parseInt(input.substring(0, 1));
			int y = Integer.parseInt(input.substring(1));
			play(x, y);
		}
		if(isWinner(getCurrentPlayer()))
			return 1;
		else if(gridString.indexOf(' ') < 0)
			return 0;
		else
			return null;	
	}

	private void saveGame(String filepath) {
		LevelFormat level = new StandardLevelFormat();
		try {
			level.writeLevel(toString(), new FileOutputStream(new File(filepath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void loadFile(String filepath) {
		LevelFormat level = new StandardLevelFormat();
		try {
			String grid = level.readLevel(new FileInputStream(new File(filepath)));
			loadGame(grid);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}