package net.ipinto.examples.patterns.observer.observable

import net.ipinto.examples.patterns.observer.SuspiciousEvent


class Alarm implements Observable {

    List<SuspiciousEvent> suspiciousEvents = []

    void addSuspiciousEvent(String description) {
        suspiciousEvents << new SuspiciousEvent(description)
        notifyObservers()
    }

    SuspiciousEvent getLastSuspiciousEvent() {
        suspiciousEvents.last()
    }

}
