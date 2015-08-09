
public class SummonerStats {
	
	private int totalChampionKills;
	private int totalAssists;
	private int totalMinionKills;
	private int sumId;
	private String summonerName;
	private String gameType;
	
	
	public SummonerStats(int totalChampionKills, int totalAssists,
			int totalMinionkills, int summonerId, String summonerName, String gameType) {
		
		this.totalChampionKills = totalChampionKills;
		this.totalAssists = totalAssists;
		this.totalMinionKills = totalMinionkills;
		this.sumId = summonerId;
		this.summonerName = summonerName;	
		this.setGameType(gameType);
	}
	public int getTotalChampionKills() {
		return totalChampionKills;
	}
	public void setTotalChampionKills(int totalChampionKills) {
		this.totalChampionKills = totalChampionKills;
	}
	public int getTotalAssists() {
		return totalAssists;
	}
	public void setTotalAssists(int totalAssists) {
		this.totalAssists = totalAssists;
	}
	public int getTotalMinionkills() {
		return totalMinionKills;
	}
	public void setTotalMinionkills(int totalMinionkills) {
		this.totalMinionKills = totalMinionkills;
	}
	public int getSummonerId() {
		return sumId;
	}
	public void setSummonerId(int summonerId) {
		this.sumId = summonerId;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public void printStats(){
	    
	    System.out.println("Total champion kills are: " + totalChampionKills);
	    System.out.println("Total assists are: " + totalAssists);
	    System.out.println("total minion kills are: " + totalMinionKills);
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	
	
}
