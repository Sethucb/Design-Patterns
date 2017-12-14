package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class AirportState{
	private AirportStateI airportState;
	private String previousState;

	public AirportState(){
		MyLogger.writeMessage("Inside AirportState constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		previousState = "LOW_RISK";
	}

	// Returns the operations for respective Risks
	public String getOperations(){
		return airportState.getOperations();
	}

	// Set initial state of the airport
	public void setInitialState(){
		airportState = new LOW_RISK();
	}

	// Sets the state to the local airportState
	public void setAirportState(AirportStateI state){
		this.airportState = state;	
	}

	// Get the current airport state
	public AirportStateI getAirportState(){
		return this.airportState;
	}

	// Get the string previousState
	public String getPreviousState(){
		return this.previousState;
	}

	// Set the string previousState
	public void setPreviousState(String state){
		this.previousState = state;
	}
	
	// Checks the average Traffic and Prohibited items and set the corresponding object
	public void tightenOrLoosenSecurity(SecurityFactors factors){
		airportState.tightenOrLoosenSecurity(this,factors);
	}
}