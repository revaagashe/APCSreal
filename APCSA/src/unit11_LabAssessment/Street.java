package unit11_LabAssessment;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;


public class Street {

	private House[] housesList;
	int numHouses;
	String streetName;
	
	public Street(){
		setStreet("");
	}
	
	public Street(String housesList, String streetName){
		setStreet(housesList);
		setStreetName(streetName);
	}
	
	public void setStreet (String houseList){
		Scanner houseScanner = new Scanner(houseList);
		numHouses = houseScanner.nextInt();
		for (int x = 0; x<numHouses; x++){
			housesList[x] = new House(houseScanner.nextInt());
		}
	}
	public void setStreetName(String name){
		streetName = name;
	}
	
	public void setHouse (int place, int address){
		House newHouse = new House(address);
	}
	
	public String getMostColors(){
		String mostColors = "0";
		int white = 0;
		int blue = 0;
		int green = 0;
		int yellow = 0;
		
		for (int x = 0; x<housesList.length; x++){
			if (housesList[x].getHouseColor() == "white"){
				white ++;
			}
			
			if (housesList[x].getHouseColor() == "blue"){
				blue ++;
			}
			
			if (housesList[x].getHouseColor() == "green"){
				green ++;
			}
			
			if (housesList[x].getHouseColor() == "yellow"){
				yellow ++;
			}
		}
		
		if ((blue>white && blue > green) && blue > yellow)
			mostColors = "blue";
		if ((white>blue && white > green) && white > yellow)
			mostColors = "white";
		if ((yellow>white && yellow > green) && yellow > blue)
			mostColors = "yellow";
		if ((green>white && green > blue) && green > yellow)
			mostColors = "green";
		return mostColors;
	}
	
	public double getAverageNumber(){
		int sum = 0;
		double average = 0;
		for (int x = 0; x<numHouses; x++){
			sum +=housesList[x].getHouseNumber();
		}
		average = sum/numHouses;
		return average;
	}
	
	public int getSum(){
		int sum = 0;
		double average = 0;
		for (int x = 0; x<numHouses; x++){
			sum +=housesList[x].getHouseNumber();
		}
		return sum;
	}
	
	public String getStreetName(){
		return streetName;
	}
}
