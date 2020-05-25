package com.unimelb.swen30006.monopoly.observer;

import com.unimelb.swen30006.monopoly.Player;

public abstract class PlayerObserver {
	public abstract void onEvent(String source, String value);
	
}
