package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class MODERATE_RISK implements AirportStateI{

	private static final String operations = "2 3 5 8 9";

	public MODERATE_RISK(){
		MyLogger.writeMessage("Inside MODERATE_RISK constructor",MyLogger.DebugLevel.CONSTRUCTOR);
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
			return;
		}
		else if((avgTrafficperDay >= 0 && avgTrafficperDay < 4) || (avgProhibitedperDay >= 0 && avgProhibitedperDay < 1)){
				airport.setAirportState(new LOW_RISK());
				MyLogger.writeMessage("Changing state from "+previousState+" to LOW_RISK", MyLogger.DebugLevel.IN_RUN);
				airport.setPreviousState("LOW_RISK");
		}
		else{
			return;
		}
	}

	// Returns the operations of MODERATE_RISK
	public String getOperations(){
		return this.operations;
	}
}