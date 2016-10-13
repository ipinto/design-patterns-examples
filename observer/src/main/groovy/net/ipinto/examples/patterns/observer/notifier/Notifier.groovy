package net.ipinto.examples.patterns.observer.notifier

import net.ipinto.examples.patterns.observer.SuspiciousEvent


interface Notifier {

    void notify(SuspiciousEvent suspiciousEvent)

}