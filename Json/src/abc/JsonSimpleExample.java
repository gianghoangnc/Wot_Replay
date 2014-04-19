package abc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class JsonSimpleExample {
    public static void main(String[] args) throws org.json.simple.parser.ParseException, IOException {

//	JSONParser parser = new JSONParser();
//	try {
//		
		URL url = JarPath.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
	  	String jarPath = null;
			try {
				jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			File file1 = new File(".");  
	        File[] files1 = file1.listFiles();  
	    //String parentPath = new File(jarPath).getParentFile().getPath(); //Path of the jar
	        String  parentPath =  file1.getCanonicalPath();
	    
	    parentPath = parentPath + File.separator;
			String cmdFile = parentPath + "process_all_exe.cmd";
			Runtime.getRuntime().exec(new String[]{cmdFile,"/c","start"});
			
		List<String> results = new ArrayList<String>();
			File[] files = new File(parentPath+File.separator+"dist"+File.separator).listFiles();
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			for (File file : files) {
			    if (file.isFile()) {
			        results.add(file.getName());
			        if(file.getName().contains(".json") && !file.getName().contains("maps.json")
			        		&& !file.getName().contains("tanks.json")){
			        	String fileName = parentPath+"dist"+File.separator+file.getName();
			        	System.out.println(fileName);
			        geneRateFile(fileName);
			        }
			    }
			}	
			

    }
public static void geneRateFile(String replayFileName) throws ParseException{
	JSONParser parser = new JSONParser();
	try {
	Object obj = parser.parse(new FileReader(replayFileName));

	JSONObject jsonObject = (JSONObject) obj;

	JSONObject datablock_1= (JSONObject) jsonObject.get("datablock_1");
	String dateTime = (String) datablock_1.get("dateTime");
	dateTime = dateTime.replaceAll(":", "_");
	int blank = dateTime.indexOf(" ");
	String date = dateTime.substring(0, blank);
	String time = dateTime.substring(blank+1);
	String map = (String) datablock_1.get("mapDisplayName");
	String fileName = date+"_"+time+"_"+map;
	JSONObject listVehicles= (JSONObject) datablock_1.get("vehicles");
	@SuppressWarnings("unchecked")
	Set<Object> vehicle = listVehicles.keySet();
	List<Vehicle> listObjVehicle = new ArrayList<Vehicle>();
	for (Object object : vehicle) {
		String key = (String) object;
		JSONObject player= (JSONObject) listVehicles.get(key);
		
		String clanAbbrev = (String) player.get("clanAbbrev");
		String events = "";
		long igrType = (Long) player.get("igrType");
//		Boolean isAlive = (Boolean) player.get("isAlive");
//		Boolean isTeamKiller = (Boolean) player.get("isTeamKiller");
		String name = (String) player.get("name");
		long team = (Long) player.get("team");
		String vehicleType = (String) player.get("vehicleType");
		int chh = vehicleType.indexOf(":");
		vehicleType = vehicleType.substring(chh+1);
		Vehicle objVehicle = new Vehicle(clanAbbrev, events, String.valueOf(igrType), "", "", name, String.valueOf(team), vehicleType);
		listObjVehicle.add(objVehicle);
	}
	WriteExcel a = new WriteExcel();
	try {
		a.Write(listObjVehicle,fileName);
		System.out.println("Success!!!");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
} 
}
}