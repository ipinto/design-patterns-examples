package net.ipinto.examples.patterns.observer.observable

import net.ipinto.examples.patterns.observer.observer.Observer


trait Observable {

    Set<Observer> observers = []

    void addObserver(Observer observer) {
        observers << observer
    }

    void deleteObserver(Observer observer) {
        observers.remove(observer)
    }

    void deleteObservers() {
        observers.clear()
    }

    void notifyObservers() {
        observers.each { it.update() }
    }

}