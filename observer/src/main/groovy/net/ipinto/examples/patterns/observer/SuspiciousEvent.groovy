package net.ipinto.examples.patterns.observer


class SuspiciousEvent {

    Date date
    String description

    SuspiciousEvent(String description) {
        this.date = new Date()
        this.description = description
    }
}
