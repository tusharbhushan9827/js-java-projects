package bigSofa.calllerSchedule;

import bigSofa.Constants;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class ScheduleDownload implements Runnable {

	public void run() {
		HttpResponse<String> response = Unirest.get(Constants.INNERCALL)
				  .asString();
		System.out.println(response.isSuccess());
		
	}

}
