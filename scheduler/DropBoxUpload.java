package bigSofa.calls;

import java.io.File;

import org.springframework.stereotype.Component;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

@Component
public class DropBoxUpload {
	

	
	public  JSONObject uploadFile( String filename, File filePath) throws Exception {
		CSVSupport csvsupport = new CSVSupport ();
		String account=csvsupport.getaccountID();
		String apikey = "APIKey " + csvsupport.getkloudless_apikey();
		String url = csvsupport.kloudlessApiUrl() + "/accounts/" + account + "/storage/files?overwrite=True";
		String folderid=csvsupport.getkloudlessFolderID();
		

		String klMeta = "{\"parent_id\": \"" + folderid + "\", \"name\":\"" + filename + "\"}";
		try {
		
		HttpResponse<JsonNode> response = Unirest.post(url).socketTimeout(8000000).header("Authorization", apikey).header("X-Kloudless-Metadata", klMeta).field("file", filePath).asJson();
		
		if (response.getStatus() == 200 || response.getStatus() == 201) {
			JSONObject respObj =response.getBody().getObject();
	
		return respObj;
		} else {
		System.out.println(response.getStatus());
		System.out.println(response.getBody());
		return null;
		}
		} catch (Exception ex) {
		ex.printStackTrace();
		return null;
		}
		}

		


}
