package airportSecurityState.airportStates;

public interface AirportStateI{
	public String getOperations();
	public void tightenOrLoosenSecurity(AirportState airport, SecurityFactors factors);
}