package com.icloud.jxthibeault.JourneyHorde.tasks;

import com.icloud.jxthibeault.JourneyHorde.JourneyHorde;

public class ResetHorde{
	public static void Reset(){
		Thread dc = new DayCountdown(JourneyHorde.runHour);
		Thread shl = new StartHordeListener();
		dc.start();
		shl.start();
	}
}
