package com.icloud.jxthibeault.JourneyHorde;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.icloud.jxthibeault.JourneyHorde.tasks.ResetHorde;

public class JourneyHorde extends JavaPlugin{
	
	public Player hordeParticipants[];				// Used to store participants until it is time for the Horde to begin
	public static boolean hordeRunning = false;
	public static int HoursUntilHorde = 12;
	public static int runHour = 19;
	
	public static void setHordeTime(int hordeTime){
		HoursUntilHorde = hordeTime;
	}
	
	public static void setRunning(boolean runState){
		hordeRunning = runState;
	}
	
	@Override
	public void onEnable(){
		getLogger().info("JourneyHorde plugin developed by stormhunted, (c)2013-2014.");		//Copyrighting message for JH
		ResetHorde.Reset();
	}
	
	//1 hour: 3600   6 hours: 21600   12 hours: 43200   1 Day: 86400
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("horde")){
			if(args[0].equalsIgnoreCase("join")){
				if(hordeParticipants.length < 24){
					int hpArrayLocationNext = hordeParticipants.length;				// Add player to the next slot in the queue array
					hordeParticipants[hpArrayLocationNext] = getServer().getPlayerExact(sender.toString());
					sender.sendMessage("You have been added to the Horde queue.");
					sender.sendMessage("Current Horde queue: " + hordeParticipants.length + "/24");
				} else { 
					sender.sendMessage("The Horde queue is full!");
				}
			} else if (args[0].equalsIgnoreCase("time")){
				sender.sendMessage("Time until next Horde: " + getTimeUntilHorde() + "hours");
			} else {
				//JourneyHorde Help
				///horde join: Join the next upcoming horde.
			}
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("jh")){
			
		}
		return false;
	}
	
	public int getTimeUntilHorde(){
		int gtuh = 0;
		
		if(HoursUntilHorde > 0){
			gtuh = HoursUntilHorde;
		} else if (HoursUntilHorde < 0){
			gtuh = (24 + HoursUntilHorde);
		}
		
		return gtuh;
	}
}