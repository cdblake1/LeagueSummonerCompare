import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CallApi extends JsonReader{

	public static void sumStats(String summonerName1, String summonerName2, String gameType) throws IOException, JSONException{
		
//	    String summonerName = "proteje";
		summonerName1 = summonerName1.toLowerCase();
		summonerName2 = summonerName2.toLowerCase();
		
		
	  //Grabs summonerid from api using Summoner Name
	    JSONObject json1 = readJsonFromUrl("https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/"+ summonerName1 + "?api_key=bf272907-42f9-4085-9470-1049579d9d2f");
	    JSONObject json2 = readJsonFromUrl("https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/"+ summonerName2 + "?api_key=bf272907-42f9-4085-9470-1049579d9d2f");
	    JSONObject sumName1 = json1.getJSONObject(summonerName1);
	    JSONObject sumName2 = json2.getJSONObject(summonerName2);
		JSONObject playerStatSummariesObject1 = null, playerStatSummariesObject2 = null;
	    int sumId1 = sumName1.getInt("id");
	    int sumId2 = sumName2.getInt("id");
		
	    //Grabs Championkills and Minionkills and Assists from summoner id
	    JSONObject jsonSum1 = readJsonFromUrl("https://na.api.pvp.net/api/lol/na/v1.3/stats/by-summoner/"+ sumId1 +"/summary?season=SEASON2015&api_key=bf272907-42f9-4085-9470-1049579d9d2f"); 
	    JSONObject jsonSum2 = readJsonFromUrl("https://na.api.pvp.net/api/lol/na/v1.3/stats/by-summoner/"+ sumId2 +"/summary?season=SEASON2015&api_key=bf272907-42f9-4085-9470-1049579d9d2f"); 
	    JSONArray playerStatSummaries1 = (JSONArray) jsonSum1.get("playerStatSummaries");
	    JSONArray playerStatSummaries2 = (JSONArray) jsonSum2.get("playerStatSummaries");
	    for(int i = 0; i < playerStatSummaries1.length(); i++){
	    	System.out.println(playerStatSummaries1.get(i));
	    	if(playerStatSummaries1.get(i).toString().contains(gameType)){
	    		playerStatSummariesObject1 = (JSONObject) playerStatSummaries1.get(i);
	    	}
	    }
	    for(int i = 0; i < playerStatSummaries2.length(); i++){
	    	if(playerStatSummaries2.get(i).toString().contains(gameType)){
	    		playerStatSummariesObject2 = (JSONObject) playerStatSummaries2.get(i);
	    	}
	    }
	    JSONObject aggregatedStats1 = (JSONObject) playerStatSummariesObject1.get("aggregatedStats");
	    JSONObject aggregatedStats2 = (JSONObject) playerStatSummariesObject2.get("aggregatedStats");
	    String playerstatsummaries = playerStatSummariesObject1.getString("playerStatSummaryType");
	    
	    int totalChampionKills1 = Integer.parseInt(aggregatedStats1.get("totalChampionKills").toString());
	    int totalMinionKills1 = Integer.parseInt(aggregatedStats1.get("totalMinionKills").toString());
	    int totalAssists1 = Integer.parseInt(aggregatedStats1.get("totalAssists").toString());
	    int totalChampionKills2 = Integer.parseInt(aggregatedStats2.get("totalChampionKills").toString());
	    int totalMinionKills2 = Integer.parseInt(aggregatedStats2.get("totalMinionKills").toString());
	    int totalAssists2 = Integer.parseInt(aggregatedStats2.get("totalAssists").toString());
	    
	    SummonerStats stats1 = new SummonerStats(totalChampionKills1, totalAssists1, totalMinionKills1, sumId1, summonerName1, playerstatsummaries);
	    SummonerStats stats2 = new SummonerStats(totalChampionKills2, totalAssists2, totalMinionKills2, sumId2, summonerName2, playerstatsummaries);
	    
	    LeagueOfLegendsGUI.setStats(stats1, stats2);
	}
	
	public static void sumMatcHist(String sumName) throws IOException, JSONException {
		
		JSONObject json1 = readJsonFromUrl("https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/"+ sumName + "?api_key=bf272907-42f9-4085-9470-1049579d9d2f");
	    JSONObject grabJsonBod = json1.getJSONObject(sumName);
	    System.out.println(grabJsonBod);
	    int sumId1 = grabJsonBod.getInt("id");
	    System.out.println(sumId1);
	    JSONObject jsonMatHist = readJsonFromUrl("https://na.api.pvp.net/api/lol/na/v2.2/matchhistory/21949248?api_key=bf272907-42f9-4085-9470-1049579d9d2f");
	    System.out.println(jsonMatHist.toString());
	    
	}	
}
