package net.ipinto.examples.patterns.observer

import net.ipinto.examples.patterns.observer.notifier.CustomerNotifier
import net.ipinto.examples.patterns.observer.notifier.PoliceNotifier
import net.ipinto.examples.patterns.observer.observable.Alarm
import spock.lang.Shared
import spock.lang.Specification


class AlarmTriggerSpec extends Specification {

    @Shared Alarm alarm = new Alarm()

    def cleanup() {
        alarm.deleteObservers()
    }

    def "All the observers should be notified when an alarm is triggered"() {
        setup:
        PoliceNotifier policeNotifier = Mock(PoliceNotifier)
        CustomerNotifier customerNotifier = Mock(CustomerNotifier)
        alarm.addObserver(policeNotifier)
        alarm.addObserver(customerNotifier)

        when:
        alarm.addSuspiciousEvent("Something strange happens")

        then:
        1 * policeNotifier.update()
        1 * customerNotifier.update()
    }

    def "Removed observer should not be notified again"() {
        setup:
        PoliceNotifier policeNotifier = Mock(PoliceNotifier)
        CustomerNotifier customerNotifier = Mock(CustomerNotifier)
        alarm.addObserver(policeNotifier)
        alarm.addObserver(customerNotifier)

        when:
        alarm.addSuspiciousEvent("Something strange happens")

        then:
        1 * policeNotifier.update()
        1 * customerNotifier.update()

        when:
        alarm.deleteObserver(policeNotifier)
        alarm.addSuspiciousEvent("Opened window")

        then:
        0 * policeNotifier.update()
        1 * customerNotifier.update()
    }

}