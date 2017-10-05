package org.mule.modules.itunes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;



import org.mule.modules.itunes.config.ConnectorConfig;

@Connector(name="itunes", friendlyName="Itunes")
public class ItunesConnector {

	@Config
    ConnectorConfig config;

    private final String BASEURI = "https://itunes.apple.com/search?";

	
	private  URL url;


	HttpURLConnection con ;


    @Processor
    public String findOnArtist(String term) {
        String response;
    	try {
    		url  = new URL(BASEURI+"term="+term);
			response=processConnection(url);
		} catch (MalformedURLException e) {
			response="Error connecting to endpoint Please retry";
			e.printStackTrace();
		}
    	catch (Exception e) {
    		response="Error connecting to endpoint Please retry" ;  				
			e.printStackTrace();
		}
    	return response;
  
    }
   
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
    
    private String processConnection(URL url){
    	
    	StringBuffer response = new StringBuffer();
    	
    	try {
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");

			// add request header
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}  catch (Exception e) {
			response=new StringBuffer("Error getting requested info");
			e.printStackTrace();
		}

		// print result
		return response.toString();
    }

}