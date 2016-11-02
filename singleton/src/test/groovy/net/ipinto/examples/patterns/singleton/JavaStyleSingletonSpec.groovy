package net.ipinto.examples.patterns.singleton

import spock.lang.Specification


class JavaStyleSingletonSpec extends Specification {

    def "Singleton instances are always the same object"() {
        expect:
        JavaStyleSingleton.instance.is(JavaStyleSingleton.instance)
    }

    def "Should capitalize first letter"() {
        expect:
        JavaStyleSingleton.instance.capitalize("something") == 'Something'
    }

}