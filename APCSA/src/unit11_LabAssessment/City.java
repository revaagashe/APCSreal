package unit11_LabAssessment;
import java.util.Scanner;
import static java.lang.System.*;
import java.lang.Comparable;


public class City {

	private String cityName;
	private Street[] theStreetList;
	
	public City(){
		setCityName("");
		setStreet("", "", 0);
	}
	
	public City(String cityname, String streetList, String streetName){
		setCityName(cityname);
	}
	
	public void setCityName(String cityname){
		cityName = cityname;
	}
	
	public void setStreet(String streetList, String streetName, int spot){
		Street streetNew = new Street(streetList, streetName);
		theStreetList[spot] = streetNew;
	}
	
	public void setHouses (int streetNum, int spot, int houseNumber){
		theStreetList[streetNum].setHouse(spot, houseNumber);
	}
	
	public String getCityName(){
		return cityName;
	}
	
	public Street getStreet(int spot){
		return theStreetList[spot];
	}
	
	public int getSumCity(){
		int sumCity = 0;
		for (int x = 0; x<theStreetList.length; x++){
			sumCity += theStreetList[x].getSum();
		}
		return sumCity;
	}
	
	public double getAverageCity(){
		int sumCity = 0;
		for (int x = 0; x<theStreetList.length; x++){
			sumCity += theStreetList[x].getSum();
		}
		int average = sumCity/theStreetList.length;
		return average;
	}
}
