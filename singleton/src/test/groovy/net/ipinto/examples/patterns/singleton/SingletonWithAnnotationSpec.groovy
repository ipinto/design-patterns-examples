package net.ipinto.examples.patterns.singleton

import spock.lang.Specification


class SingletonWithAnnotationSpec extends Specification {

    def "Singleton instances are always the same object"() {
        expect:
        SingletonWithAnnotation.instance.is(SingletonWithAnnotation.instance)
    }

    def "Should not be able to create an object with new statement"() {
        when:
        new SingletonWithAnnotation()

        then:
        def runtimeException = thrown RuntimeException
        runtimeException.message == "Can't instantiate singleton net.ipinto.examples.patterns.singleton.SingletonWithAnnotation. " +
                "Use net.ipinto.examples.patterns.singleton.SingletonWithAnnotation.instance"
    }

    def "Should capitalize first letter"() {
        expect:
        SingletonWithAnnotation.instance.capitalize("something") == 'Something'
    }

}