package unit11_LabAssessment;

import java.util.Scanner;
import static java.lang.System.*;
import java.util.Arrays;

public class State {
	private String name;
	private City[] cityList;
	
	public State(){
		name = "";
		cityList = new City[1];
	}
	
	public State(String Name, int numCt){
		name = Name;
		cityList = new City[numCt];
	}
	
	public void addCity(int citynum, City newcity){
		cityList[citynum] = newcity;
	}
	
	public String getStateName (){
		return name;
	}
	
	public int getAverageAddress(){
	int avg = 0;
	
	for (int x = 0; x<cityList.length; x++){
		avg +=cityList[x].getSumCity();
	}
	avg = avg/cityList.length;
	return avg;
	}
	
	
	public String toString(){
		String output = "";
		
		output += name;
		
		for (int x = 0; x<cityList.length; x++){
			output += cityList[x].getCityName();
		}
		
		return output;
	}
}
