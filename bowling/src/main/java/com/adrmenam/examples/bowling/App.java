package com.adrmenam.examples.bowling;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		
		
		BowlingMatch match = new BowlingMatch();
		try {
			match.play(args[0]);
			match.printScores();
		}catch(NotAllowedRoll rollException) {
			System.out.println(rollException.getMessage());
		}catch(NumberFormatException numberException) {
			System.out.println("Invalid pinfall value in the input: "+numberException.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    }
}
