package net.ipinto.examples.patterns.observer.notifier

import net.ipinto.examples.patterns.observer.SuspiciousEvent
import net.ipinto.examples.patterns.observer.observable.Alarm
import net.ipinto.examples.patterns.observer.observer.Observer


class PoliceNotifier implements Observer, Notifier {

    Alarm alarm

    @Override
    void update() {
        notify(alarm.lastSuspiciousEvent)
    }

    @Override
    void notify(SuspiciousEvent suspiciousEvent) {
        // Notify the police via WS
    }
}
