package com.unimelb.swen30006.monopoly.observer;

import java.io.FileWriter;
import java.io.IOException;

import com.unimelb.swen30006.monopoly.Player;

public class CashTransactionObserver extends PlayerObserver{
	private static FileWriter outStream = null;
	private String fileName;
	private Player player;
	public CashTransactionObserver(Player player) {
        this.fileName = "CashTransaction_" + player.getName() + ".txt" ;
        this.player = player;
        player.addObserver(this);
        try {
            outStream = new FileWriter(fileName);
            outStream.write("Amount, Balance\n");
            outStream.write("Init, " + Double.toString(player.getCash()) + "\n");
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
	
	@Override
	public void onEvent(String source, String value) {
		try {
            FileWriter outStream = new FileWriter(fileName, true);
            if (source.equals("addCash")) {
                outStream.write("+ " + value + ", " + Double.toString(player.getCash()) + "\n");
            }
            else if(source.equals("reduceCash")){
                outStream.write("- " + value + ", " + Double.toString(player.getCash()) + "\n");
            }
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
		
	}

}
