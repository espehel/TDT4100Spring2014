package tictactoe;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;

public class TicTacToeProgram {
	
	private TicTacToeExtended ticTacToe;
	
	public void init() {
		ticTacToe = new TicTacToeExtended(6,4);
	}
	
	private String instructions = "Enter x and y coordinate of next placement (separated by whitespace) corresponding to board positions:\n0 0|1 0|2 0\n-----------\n0 1|1 1|2 1\n-----------\n0 2|1 2|2 2\n###########\n";

	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to load an previously saved game?(y/n)");
		String a = scanner.next();
		
		if(a.equalsIgnoreCase("y")){
			System.out.println("Please enter filepath");
			loadLevel(scanner.next());
		}
		
		System.out.println("***Enter \"s\" at the start of a turn to save the current state of the game.***");
		System.out.println("***To undo or redo a move, enter \"z\"(undo) or \"y\"(redo) at the start of your turn***");
		System.out.println(instructions);
		while (! ticTacToe.isFinished()) {
			System.out.println(ticTacToe);
			System.out.println("Player " + ticTacToe.getCurrentPlayer() + ", enter position of desired move:");
			
			char m = scanner.next().charAt(0);
			if(m == 'z'){
				ticTacToe.undoMove();
				continue;
			}else if (m == 'y'){
				ticTacToe.redoMove();
				continue;
			}else if (m == 's'){
				System.out.println("please write the filepath to where you want to save the file");
				saveLevel(scanner.next());
				continue;
			}
				
			
			int x = Character.getNumericValue(m);
			int y = scanner.nextInt();
			ticTacToe.play(x, y);
		}
		System.out.println(ticTacToe);
		if (! ticTacToe.hasWinner()) {
			// The game ended in a draw
			System.out.println("The game ended in a draw.");
		} else if (ticTacToe.isWinner('x')) {
			System.out.println("Player x has won the game.");
		} else if (ticTacToe.isWinner('o')) {
			System.out.println("Player o has won the game.");
		}
		scanner.close();
	}
	
	/*
	 * DEL 2
	 */
	
	//saves the current state of the game to a file
	private void saveLevel(String filepath) {
		LevelFormat level = new StandardLevelFormat();
		try {
			level.writeLevel(ticTacToe.toString(), new FileOutputStream(new File(filepath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//reads a level from file and loads the game with it
	private void loadLevel(String filepath) {
		LevelFormat level = new StandardLevelFormat();
		try {
			String grid = level.readLevel(new FileInputStream(new File(filepath)));
			ticTacToe.loadGame(grid);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TicTacToeProgram program = new TicTacToeProgram();
		program.init();
		program.run();
	}
}