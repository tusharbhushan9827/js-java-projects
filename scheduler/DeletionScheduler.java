package bigSofa.calllerSchedule;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import bigSofa.Constants;

@Service
public class DeletionScheduler {
	Logger logger = LoggerFactory.getLogger(DeletionScheduler.class);
	public  void putExecutionthread() {
		DeleteFiles delete = new DeleteFiles();
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int delayInHour = hour < Constants.HOURTODELETE ? Constants.HOURTODELETE - hour : 24 - (hour - Constants.HOURTODELETE);

		
		logger.info("Current Hour: "+hour);
		logger.info("Comuted Delay for next"+ Constants.HOURTODELETE +"AM: "+delayInHour);


		scheduler.scheduleAtFixedRate(delete, delayInHour, 48, TimeUnit.HOURS);

	}

}
