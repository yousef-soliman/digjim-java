
/**
 * 
 */
import java.io.*;

import java.util.*;



/**
 * @author Dell
 *
 */
public class file {

	/**
	 * 
	 */
	
	
	
	public file() {
		// TODO Auto-generated constructor stub
	}
	private Formatter output;
	public void openfile()
	{
		
		
		try {
		output=new Formatter("score.txt");
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		
	}
	public void add(String x)
	{
		output.format(x);
	
	}
	public void close()
	{
	output.close();
	}
	
	
	
	
	
	
	
}
