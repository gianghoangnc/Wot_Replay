package abc;

public class Vehicle {
	private String clanAbbrev;
	private String events;
	private String igrType;
	private String isAlive;
	private String isTeamKiller;
	private String name;
	private String team;
	private String vehicleType;
	public String getClanAbbrev() {
		return clanAbbrev;
	}
	public void setClanAbbrev(String clanAbbrev) {
		this.clanAbbrev = clanAbbrev;
	}
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public String getIgrType() {
		return igrType;
	}
	public void setIgrType(String igrType) {
		this.igrType = igrType;
	}
	public String getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(String isAlive) {
		this.isAlive = isAlive;
	}
	public String getIsTeamKiller() {
		return isTeamKiller;
	}
	public void setIsTeamKiller(String isTeamKiller) {
		this.isTeamKiller = isTeamKiller;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public String toString() {
		return "vehicle [clanAbbrev=" + clanAbbrev + ", events=" + events
				+ ", igrType=" + igrType + ", isAlive=" + isAlive
				+ ", isTeamKiller=" + isTeamKiller + ", name=" + name
				+ ", team=" + team + ", vehicleType=" + vehicleType + "]";
	}
	
	public Vehicle(String clanAbbrev, String events, String igrType,
			String isAlive, String isTeamKiller, String name, String team,
			String vehicleType) {
		super();
		this.clanAbbrev = clanAbbrev;
		this.events = events;
		this.igrType = igrType;
		this.isAlive = isAlive;
		this.isTeamKiller = isTeamKiller;
		this.name = name;
		this.team = team;
		this.vehicleType = vehicleType;
	}
	public Vehicle() {
		super();
	}
	
	
}
