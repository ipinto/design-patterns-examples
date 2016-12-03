package net.ipinto.examples.patterns.iterator

import spock.lang.Specification

/*
 * Groovy has the createIterator pattern built right in to many of its closure operators,
 * e.g. each and eachWithIndex as well as the for .. in loop.
 *
 * So we emulate Java usage with Iterator pattern.
 */
class PeaceSpec extends Specification {

    def "Humanity and Cylons want to merge their population registries"() {
        given:
        Humanity humanity = new Humanity()
        Cylons cylons = new Cylons()

        and:
        addSamplePeople(humanity)
        addSamplePeople(cylons)

        expect:
        countThroughIterator(humanity) == 5
        countThroughIterator(cylons) == 5
    }

    private void addSamplePeople(Civilization civilization) {
        (1..5).each { civilization.addPerson("Person $it") }
    }

    private Integer countThroughIterator(Civilization civilization) {
        int numberOfPeople = 0

        Iterator<Civilization> iterator = civilization.createIterator()
        iterator.each { numberOfPeople++ }

        numberOfPeople
    }

}