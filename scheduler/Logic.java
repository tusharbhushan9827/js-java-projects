package bigSofa;


import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bigSofa.calls.CallsUnirest;
import pojo.BigSofa.Datum;
import pojo.BigSofa.MediaPojo;

@Component
public class Logic  {

	@Autowired
	CallsUnirest callsunirest;

	Logger logger = LoggerFactory.getLogger(Logic.class);

	public void executeDownload() {
		try {
			String token =callsunirest.getTheToken();

			MediaPojo mediapojo=callsunirest.getVideoList(token);
			List<Datum> mediaData = mediapojo.getData();
			ExecutorService executorService2 = Executors.newFixedThreadPool(Constants.NoOfthreads);
			LocalDateTime dateTimeProcessed=callsunirest.getTimeStamp();

			for(Datum data:mediaData) {
				try {
					logger.info(data.getId());
					logger.info(token);
					LocalDateTime dateData=callsunirest.getTimeStamp(data.getAttributes().getDate());
					DownLoader downloader = new DownLoader(data.getId(),token,dateData,dateTimeProcessed);
					executorService2.submit(downloader);


				}
				catch(Exception E) {
					E.printStackTrace();
					logger.error(E.getMessage(),E);
				}
			}

			executorService2.shutdown();
			try {
				executorService2.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				logger.error(e.getMessage(),e);
			}
			callsunirest.upDateText(mediaData.get(mediaData.size()-1).getAttributes().getDate().split(Constants.SPLITTIME)[0]);
		}
		catch(Exception E) {
			logger.error(E.getMessage(),E);

		}


	}

}
