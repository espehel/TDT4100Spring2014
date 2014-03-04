package tictactoe;

import java.io.InputStream;
import java.io.OutputStream;

public interface LevelFormat {

	public String readLevel(InputStream input);
	public void writeLevel(String grid, OutputStream output);

}
