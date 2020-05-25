package com.unimelb.swen30006.monopoly.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import com.unimelb.swen30006.monopoly.Player;

public class OwnedSquareObserver extends PlayerObserver{
	
	private static FileWriter outStream = null;
	private String fileName;
	private ArrayList<String> assets;
	public OwnedSquareObserver(Player player) {
        fileName = "OwnedSquares_" + player.getName() + ".txt" ;
        player.addObserver(this);
    }

	@Override
	public void onEvent(String source, String value) {
		if(source.equals("attempPurchase")) {
			this.assets.add(value);
			try {
				outStream = new FileWriter(fileName);
				Map<Object, Long> counts = this.assets.stream().collect(Collectors.groupingBy(e -> e,
	                    Collectors.counting()));
				for(Map.Entry<Object, Long> entry: counts.entrySet()) {
	                outStream.write(entry.getKey()+" x "+entry.getValue()+"\n");
	            }
			}catch(IOException e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
		}
		
	}
	

}
