package com.unimelb.swen30006.monopoly.observer;

import java.util.ArrayList;

public class SubjectBase {
	private ArrayList<PlayerObserver> observers = new ArrayList<>();


public void addObserver(PlayerObserver observer) {
	this.observers.add(observer);
}

public void removeObserver(PlayerObserver observer) {
	this.observers.remove(observer);
}

public void publishEvent(String source, String value) {
	for (PlayerObserver observer:observers) {
		observer.onEvent(source, value);
	}
}

}
