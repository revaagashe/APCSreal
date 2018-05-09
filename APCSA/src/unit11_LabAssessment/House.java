package unit11_LabAssessment;

public class House {
	
		private int HouseNumber;
		
		public House()
		{
			setHouse(HouseNumber);
		}
		
		public House(int houseNumber)
		{
			setHouse(houseNumber);		
		}
		
		public void setHouse( int houseNumber){
			HouseNumber = houseNumber;
		}
		
		public String getHouseColor(){
			String color = " ";
			if (HouseNumber%4==0)
				color="white";
			else if (HouseNumber%4==1)
				color="blue";
			else if (HouseNumber%4==2)
				color="green";
			else if (HouseNumber%4==3)
				color="yellow";
			
			
			return color;
		}
		
		public double getHouseNumber(){
			return HouseNumber;
		}
		
		public String toString() {
			String x;
			x = getHouseNumber() + "\n" + getHouseColor();
			return x;
		}
		
	}



