package rickmortyapi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class ApiRepo {
	
	
static URL url;
	
	public static int connectApi() {
		int httpResponseCode = 0;
		
		try {
			url = new URL("https://rickandmortyapi.com/api/character");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			httpResponseCode = conn.getResponseCode();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResponseCode;
		
	}
	

	public static ArrayList<Map<String, String>> useApi() {
		// TODO Auto-generated constructor stub
		 ArrayList<Map<String, String>> resultMap = new ArrayList<>();
		
		int reponse = connectApi();

		if (reponse != 200)
		{
			throw new RuntimeException("HTTPSResponseCode: "+ reponse);
		}
		else
		{
			StringBuilder informacion = new StringBuilder();
			Scanner sc;
			try {
				sc = new Scanner(url.openStream());
				while (sc.hasNext())
				{
					informacion.append(sc.nextLine());
				}
//				System.out.println(informacion);
				JSONObject jsonObject = new JSONObject(informacion.toString());
				
				
				JSONArray results = jsonObject.getJSONArray("results");
				
			
				String name, gender, origin;
					
				try {
					
					for(int i = 0; i < results.length(); i++) {
						
						resultMap.add(new HashMap<String, String>());
												
						gender = results.getJSONObject(i).getString("gender");
						name = results.getJSONObject(i).getString("name");
						origin = results.getJSONObject(i).getJSONObject("origin").getString("name");
						
//						System.out.println(gender + " ; " + name + " ; " + origin);
						
						
						resultMap.get(i).put("Name", name);
						
						resultMap.get(i).put("Gender", gender); 
						
						resultMap.get(i).put("Origin", origin);
						
						switch(origin) {
						
						case "Earth (C-137)":
							resultMap.get(i).put("Pais", "Tierra (C-137)");
							break;
							
						case "Abadango":
							resultMap.get(i).put("Pais", "Malaga");
							break;
													
						case "unknown":
							resultMap.get(i).put("Pais", "Desconocido");
							break;
						
						}
						
						
						
						
					}
					
				}catch(Exception e) {
					//
				}
					
					
					
			
				
				
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return resultMap;
	}


}
