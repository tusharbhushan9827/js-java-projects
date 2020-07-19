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
public class ExcecutionSchedule {
	Logger logger = LoggerFactory.getLogger(ExcecutionSchedule.class);
	public  void putExecutionthread() {
		ScheduleDownload schedule = new ScheduleDownload();
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int delayInHour = hour < Constants.HOURTOEXECUTE ? Constants.HOURTOEXECUTE - hour : 24 - (hour - Constants.HOURTOEXECUTE);

		
		logger.info("Current Hour: "+hour);
		logger.info("Comuted Delay for next"+ Constants.HOURTOEXECUTE +"AM: "+delayInHour);


		scheduler.scheduleAtFixedRate(schedule, delayInHour, 24, TimeUnit.HOURS);

	}

}
