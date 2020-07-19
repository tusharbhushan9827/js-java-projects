package bigSofa.calls;






import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bigSofa.Constants;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import pojo.BigSofa.MediaPojo;

@Component 
public class CallsUnirest {
	
	@Autowired
	CSVSupport csvsupport;
	Logger logger = LoggerFactory.getLogger(CallsUnirest.class);
	public String getTheToken() throws Exception {
	
		HttpRequestWithBody response = Unirest.post(csvsupport.getSignInLink());
		HttpResponse<JsonNode> token=response.asJson();
		logger.info(token.getBody().toString());
		return Constants.BEARER+token.getBody().getObject().get(Constants.ACCESSTOKEN).toString();

		
	}
	
	public MediaPojo getVideoList(String token) throws Exception {
		
		HttpResponse<MediaPojo> response = Unirest.get(csvsupport.getMediaList())
				  .header(Constants.AUTHORIZATION, token).asObject(MediaPojo.class);
		        logger.info(response.isSuccess()+"");
		        logger.info(response.getStatus()+"");
		        logger.info(response.toString());
				return response.getBody();
				  
	}
	
	public LocalDateTime getTimeStamp()  {
		try {
		String date=csvsupport.readFileAsString(Constants.DATESTORAGE);
		logger.info("ProcessedDate====="+date);
		if(date.trim().isEmpty())
			return null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT); 
		LocalDateTime dateTime = LocalDateTime.parse(date.split(Constants.SPLITTIME)[0], formatter);
		return dateTime;

		}
		catch(Exception E) {
			logger.error(E.getMessage(), E);
			return null;
		}

	}
	public LocalDateTime getTimeStamp(String timestamp) throws Exception {

		
		logger.info("DataDate====="+timestamp);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT); 
		LocalDateTime dateTime = LocalDateTime.parse(timestamp.split(Constants.SPLITTIME)[0], formatter);
	       logger.info(dateTime.toString());
			return dateTime;


	}
	public boolean upDateText(String date) throws IOException {
		
		csvsupport.upDateText(date.split(Constants.SPLITTIME)[0], Constants.DATESTORAGE);
        return true;
	}

}
