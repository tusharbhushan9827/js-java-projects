package bigSofa;


import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bigSofa.calls.CallsUnirestThreads;
import pojo.BigSofa.MediaInfo;


public class DownLoader  implements Runnable{
	
	Logger logger = LoggerFactory.getLogger(DownLoader.class);
	
	String id;
	String token;
	LocalDateTime dataTimeStamp;
	LocalDateTime proccessedTimeStamp;
	

	public DownLoader(String id,String token,LocalDateTime dataTime,LocalDateTime processed) {
		this.id=id;
		this.token=token;
		this.dataTimeStamp=dataTime;
		this.proccessedTimeStamp=processed;
	}

	@Override
	public void run() {
		try {
			if(proccessedTimeStamp==null || proccessedTimeStamp.isBefore(dataTimeStamp)) {
			CallsUnirestThreads callsUnirest= new CallsUnirestThreads();
			MediaInfo mediaInfo=callsUnirest.getMediaUrl(id, token);
	        String url=mediaInfo.getData().getAttributes().getUrl();
	        String name=mediaInfo.getData().getAttributes().getName();
	        logger.info("processing--"+name);
	        logger.info(url);
			callsUnirest.storeFile(url, name);
			}
			
		}
		catch(Exception E) {
			logger.error( E.getMessage(),E);
			
		}
		
	}
	

}
