package com.icloud.jxthibeault.JourneyHorde;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class JourneyHorde extends JavaPlugin{
	
	Player hordeParticipants[];				// Used to store participants until it is time for the Horde to begin
	
	@Override
	public void onEnable(){
		getLogger().info("JourneyHorde plugin developed by stormhunted, (c)2013-2014.");		//Copyrighting message for JH
	}
	
	//1 hour: 3600   6 hours: 21600   12 hours: 43200   1 Day: 86400
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("horde")){
			if(args[0].equalsIgnoreCase("join")){
				int hpArrayLocationNext = hordeParticipants.length;				// Add player to the next slot in the queue array
				hordeParticipants[hpArrayLocationNext] = getServer().getPlayerExact(sender.toString());
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

	playerInventory playerInvStore[];		// Array used to save player inventories while they are in Horde world

	class HordeUtility{
		public void teleportToHordeWorld(Player participants[]){
			for(int i=0; i < participants.length; i++){		// Save each player's inventory
				playerInvStore[i].thePlayer = participants[i].getServer().getPlayerExact(participants[i].toString());
				playerInvStore[i].playerInv = participants[i].getInventory();
			}
			for(int i=0; i < participants.length; i++){		// Send each player to Horde world
				participants[i].getLocation().setWorld(null);	//FIGURE OUT HOW TO SET WORLD!! BASE OFF OF CONFIG.YML!
			}
			for(int i=0; i < participants.length; i++){		// Clear each player's inventory while they are in the Horde world
				participants[i].getInventory().clear();
			}
		}
	}

	class playerInventory{		//The object used for the inventory saving array for simplication purposes
		@SuppressWarnings("unused")
		private Player thePlayer;
		@SuppressWarnings("unused")
		private PlayerInventory playerInv;
	}

	class CountDown {			// Inlaid interface for Java timers and countdowns (by the minute, change the 10,000 to 1,000 for sec)
		Timer timer;
		int minutes = 0;
	
		public CountDown(int time){
			minutes = time;
			timer = new Timer();
			timer.schedule(new DisplayCountdown(), 0, 10000);
		}
	
		class DisplayCountdown extends TimerTask{
			public void run(){
				if(minutes > 0){
					minutes--;
				} else {}
			}
		}
		public void newCountdown(int time){
			new CountDown(time);
		}	
	}
}