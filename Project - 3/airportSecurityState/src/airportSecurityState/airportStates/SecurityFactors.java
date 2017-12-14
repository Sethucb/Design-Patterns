package airportSecurityState.airportStates;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import airportSecurityState.util.MyLogger;

public class SecurityFactors{
	private HashMap<String,ArrayList<String>> travellerStat = null;
	private int avgTrafficperDay;
	private int avgProhibitedperDay;
	private int totnumOfTravellers;
	private static final ArrayList<String> listOfProhibited = new ArrayList<String>(Arrays.asList("Gun","NailCutter","Blade","Knife"));;

	public SecurityFactors(){
		MyLogger.writeMessage("Inside SecurityFactors constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		this.travellerStat = new HashMap<String,ArrayList<String>>();
		this.avgTrafficperDay = 0;
		this.avgProhibitedperDay = 0;
		this.totnumOfTravellers = 0;
	}

	// Parse input string
	public void addTraveller(String line){
		String[] arr = line.split(";");
		addTraveller(arr[0],arr[3]);
	}

	// Increment traveller count and call addToMap
	public void addTraveller(String dayString,String itemString){
		String day = dayString.substring(dayString.indexOf(":") + 1);
		String item = itemString.substring(itemString.indexOf(":") + 1);
		if(day.contains("-")){
			System.err.println("Wrong day format");
			System.exit(1);
		}
		totnumOfTravellers += 1;
		addToMap(day,item);
	}

	// Adds the day and prohibited item to a HashMap
	public void addToMap(String day,String item){
		if(travellerStat.get(day) == null){
			travellerStat.put(day,new ArrayList<String>());
		}
		if(listOfProhibited.contains(item)){
			travellerStat.get(day).add(item);
		}		
		// Calculate security
		calculateSecurity();
	}

	// Calculate avgTrafficperDay and avgProhibitedperDay
	public void calculateSecurity(){
		avgTrafficperDay = getTraffic();
		avgProhibitedperDay = getProhibited();
		if(avgTrafficperDay == -1 || avgProhibitedperDay == -1){
			System.err.println("Number exception");
			System.exit(1);
		}
	}

	// Return avgTrafficperDay
	public int getavgTrafficperDay(){
		return this.avgTrafficperDay;
	}

	// Return getavgProhibitedperDay
	public int getavgProhibitedperDay(){
		return this.avgProhibitedperDay;
	}

	// Return totalNumber of days
	public int getTotalDays(){
		return travellerStat.keySet().size();
	}


	// Calculate avgTrafficperDay
	public int getTraffic(){
		int days = getTotalDays();
		int avgTraffic;
		try{
			avgTraffic = totnumOfTravellers/days;
			return avgTraffic;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}

	// Calculate getavgProhibitedperDay
	public int getProhibited(){
		int days = getTotalDays();
		int numOfProhibited = 0;
		for(String key:travellerStat.keySet()){
			numOfProhibited += travellerStat.get(key).size();
		}
		try{
			return numOfProhibited/days;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
}