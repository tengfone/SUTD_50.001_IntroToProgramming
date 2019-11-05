package com.example.TestTemperatureAlert;

import java.lang.reflect.Array;
import java.util.ArrayList;

//starting code
public class TemperatureAlert implements Subject {
    private int temperature;
    private ArrayList<Observer> observers;

    public TemperatureAlert() {
        observers = new ArrayList<>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void notifyObservers() {
        if (this.temperature > 35 || this.temperature < 10)
            for (Observer o : observers)
                o.update(this.temperature);
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void unregister(Observer o) {
        observers.remove(o);
    }
}
