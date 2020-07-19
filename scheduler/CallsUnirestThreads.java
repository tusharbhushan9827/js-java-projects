package bigSofa.calls;

import java.io.File;

import bigSofa.Constants;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import pojo.BigSofa.MediaInfo;


public class CallsUnirestThreads  {
	


	
	public MediaInfo getMediaUrl(String id,String token) throws Exception {
		CSVSupport csvsupport = new CSVSupport ();
		
		HttpResponse<MediaInfo> response = Unirest.get(csvsupport.getMediaInfo()+id)
				 .header(Constants.AUTHORIZATION, token).asObject(MediaInfo.class);
		return response.getBody();
	}
	
	public boolean storeFile(String url,String name) throws Exception{
		
		HttpResponse<File> response = Unirest.get(url).asFile(Constants.FILESTORAGE+name);	
		DropBoxUpload dropbox = new DropBoxUpload();
		dropbox.uploadFile( name, new File(Constants.FILESTORAGE+name));
		return response.isSuccess();
	}

}
