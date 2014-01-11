package com.icloud.jxthibeault.JourneyHorde.tasks;

import java.util.Calendar;
import com.icloud.jxthibeault.JourneyHorde.*;

public class DayCountdown extends Thread{
	public DayCountdown(int runHour){
		boolean stopLoop = false;
		int currentHour = 100;
		Calendar now = null;
		
		while(stopLoop != true){
			now = Calendar.getInstance();
			currentHour = now.get(Calendar.HOUR_OF_DAY);
			if(currentHour == runHour){
				JourneyHorde.setRunning(true);
				stopLoop = true;
			} else {
				JourneyHorde.setHordeTime(runHour - currentHour);
			}
			try {
				sleep(60000);
			} catch (InterruptedException e) {}
		}
	}
}
