package bigSofa;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bigSofa.calllerSchedule.DeletionScheduler;
import bigSofa.calllerSchedule.ExcecutionSchedule;

@RestController
@Component
public class ExecutorController {
	@Autowired
	Logic logic;
	@Autowired
	ExcecutionSchedule thredschedule;
	@Autowired 
	DeletionScheduler deletionscheduler;

	@RequestMapping(value = "/executeDownload", method = RequestMethod.GET, produces = "application/json")
	public  boolean executeDownload() {
		try {
			logic.executeDownload();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@RequestMapping(value = "/scheduleDownload", method = RequestMethod.GET, produces = "application/json")
	public  boolean scheduleDownload() {
		try {
			thredschedule.putExecutionthread();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@RequestMapping(value = "/scheduleDelete", method = RequestMethod.GET, produces = "application/json")
	public  boolean scheduleDelete() {
		try {
			deletionscheduler.putExecutionthread();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@RequestMapping(value = "/deleteFiles", method = RequestMethod.GET, produces = "application/json")
	public  boolean DeleteFiles() {
		try {
			Files.walk(Paths.get(Constants.FILEDELETION))
			.filter(Files::isRegularFile)
			.map(Path::toFile)
			.forEach(File::delete);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
