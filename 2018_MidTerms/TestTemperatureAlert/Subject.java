package com.example.TestTemperatureAlert;
//starting code
public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();

}
