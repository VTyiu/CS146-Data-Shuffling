package cs146F20.tang.project1;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

// class that reads an input data file, shuffles the data, and then outputs a data file with the shuffled data
public class ShuffleData {
	
	private String[] dataArray;
	
	// initializes the dataArray to the number of pairs of collaborators
	public ShuffleData(){
		dataArray = new String[7515];
	}
	
	/*
	 * reads the data from the input file and stores each pair into dataArray
	 */
	public void readDataFromFile() {
		
		long start = System.nanoTime(); // variable to store the starting time of this method
		
		try {
			File dataFile = new File("ErdosCA.txt");
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine(); // skip metadata line
			for(int i = 0; i < 7515; i++) {
				Array.set(dataArray, i, br.readLine());
			}
			
			br.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		long time = System.nanoTime() - start; // subtracts the starting time from the end time to get the time it took to run this method
		System.out.println("Nanoseconds to read data from file: " + time);
	}
	
	/*
	 * shuffles the data in the array dataArray with Algorithm Fisher-Yates
	 */
	public void shuffle() {
		
		long start = System.nanoTime(); // variable to store the starting time of this method
				
		Random r = new Random();
		r.setSeed(20);
		
		// shuffles with Algorithm Fisher-Yates
		for(int i = dataArray.length-1; i >= 1; i--) {
			int j = r.nextInt(i+1);
			String temp = dataArray[i];
			dataArray[i] = dataArray[j];
			dataArray[j] = temp;
		}
		
		long time = System.nanoTime() - start; // subtracts the starting time from the end time to get the time it took to run this method
		System.out.println("Nanoseconds to shuffle data: " + time);
	}
	
	/*
	 * writes the data from the shuffled array into an output file
	 */
	public void writeDataToFile() {
	
		long start = System.nanoTime(); // variable to store the starting time of this method
		
		try {
			File dataFile = new File("TangVanessaShuffled.txt");

			FileWriter fw = new FileWriter(dataFile);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(String x : dataArray) {
				bw.write(x);
				bw.newLine();
			}
			
			bw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		long time = System.nanoTime() - start; // subtracts the starting time from the end time to get the time it took to run this method
		System.out.println("Nanoseconds to write data to file: " + time);
	}
}
