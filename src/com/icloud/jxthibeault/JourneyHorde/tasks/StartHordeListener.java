package com.icloud.jxthibeault.JourneyHorde.tasks;

public class StartHordeListener extends Thread{
	public StartHordeListener(){
		boolean hordeRunning = false;
		while(!hordeRunning){
			try {
				sleep(60000);
			} catch (InterruptedException e){}
		}
		//Various horde initialization tasks here
	}
}
