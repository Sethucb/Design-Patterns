package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class LOW_RISK implements AirportStateI{

	private static final String operations = "1 3 5 7 9";

	public LOW_RISK(){
		MyLogger.writeMessage("Inside LOW_RISK constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	// Changes the state if necessary by using security factors
	public void tightenOrLoosenSecurity(AirportState airport, SecurityFactors factors){
		int avgTrafficperDay = factors.getavgTrafficperDay();
		int avgProhibitedperDay = factors.getavgProhibitedperDay();
		String previousState = airport.getPreviousState();
		if(avgTrafficperDay >= 8 || avgProhibitedperDay >= 2) {
				airport.setAirportState(new HIGH_RISK());
				MyLogger.writeMessage("Changing state from "+previousState+" to HIGH_RISK" , MyLogger.DebugLevel.IN_RUN);
				airport.setPreviousState("HIGH_RISK");
		}
		else if((avgTrafficperDay >= 4 && avgTrafficperDay < 8) || (avgProhibitedperDay >= 1 && avgProhibitedperDay < 2)){
				airport.setAirportState(new MODERATE_RISK());
				MyLogger.writeMessage("Changing state from "+previousState+" to MODERATE_RISK", MyLogger.DebugLevel.IN_RUN);
				airport.setPreviousState("MODERATE_RISK");
		}
		else{
			return;
		}
	}

	// Returns the operations of LOW_RISK
	public String getOperations(){
		return this.operations;
	}
	
}