package com.unimelb.swen30006.monopoly;

import java.util.ArrayList;
import java.util.Random;

import com.unimelb.swen30006.monopoly.card.GoToJailCard;
import com.unimelb.swen30006.monopoly.card.JailCard;
import com.unimelb.swen30006.monopoly.card.JailExcemptionCard;
import com.unimelb.swen30006.monopoly.card.PayJailFeeCard;
import com.unimelb.swen30006.monopoly.square.Square;

public class JailCardFacade {
	private ArrayList<JailCard> jailCardList;
	
	public JailCardFacade(){
        jailCardList = new ArrayList<>();
        jailCardList.add(new JailExcemptionCard());
        jailCardList.add(new GoToJailCard());
        jailCardList.add(new GoToJailCard());
        jailCardList.add(new PayJailFeeCard(500));
        jailCardList.add(new PayJailFeeCard(500));
    }
	
	public static JailCardFacade jailCardFacade = new JailCardFacade();
	
	static public JailCardFacade getInstance() {
		if(jailCardFacade==null)
			jailCardFacade = new JailCardFacade();
		return jailCardFacade;
	}
	
	public void pickCard(Player p, Square location){
        Random random = new Random();
        int index = random.nextInt(5);
        jailCardList.get(index).action(p,location);
    }
	
	
	
	
}
