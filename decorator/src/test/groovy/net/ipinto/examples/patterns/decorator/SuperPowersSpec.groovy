package net.ipinto.examples.patterns.decorator

import net.ipinto.examples.patterns.decorator.powers.Invisibility
import net.ipinto.examples.patterns.decorator.powers.UltraHardness
import net.ipinto.examples.patterns.decorator.powers.UltraStrength
import spock.lang.Specification


class SuperPowersSpec extends Specification {

    def "Two standard humans end in a tie"() {
        given:
        Animal standardHuman1 = new Human()
        Animal standardHuman2 = new Human()

        expect:
        standardHuman1.attack() == standardHuman2.attack()
        standardHuman1.defend() == standardHuman2.defend()
    }

    def "A standard human lose against a bear"() {
        given:
        Animal human = new Human()
        Animal bear = new Bear()

        expect:
        human.attack() < bear.attack()
        human.defend() < bear.defend()
    }

    def "An invisible human is more defensive than a regular bear"() {
        given:
        Animal invisibleHuman = createPoweredAnimal(Human, [Invisibility])
        Animal bear = new Bear()

        expect:
        invisibleHuman.attack() < bear.attack()
        invisibleHuman.defend() > bear.defend()
    }

    def "An invisible and ultra strong human wins against a regular bear"() {
        given:
        Animal invisibleAndStrongHuman = createPoweredAnimal(Human, [Invisibility, UltraStrength])
        Animal bear = new Bear()

        expect:
        invisibleAndStrongHuman.attack() > bear.attack()
        invisibleAndStrongHuman.defend() > bear.defend()
    }

    def "An super bear wins against anyone"() {
        given:
        Animal superBear = new UltraStrength(new UltraHardness(new Invisibility(new Bear())))
        Animal animal = createPoweredAnimal(animalKind, powers)

        expect:
        superBear.attack() > animal.attack()
        superBear.defend() > animal.defend()

        where:
        [animalKind, powers] << [
                [Human, Bear],
                [
                        [Invisibility],
                        [UltraHardness],
                        [UltraStrength],
                        [Invisibility, UltraHardness],
                        [Invisibility, UltraStrength],
                        [UltraHardness, UltraStrength]
                ]
        ].combinations()
    }

    private Animal createPoweredAnimal(Class animal, List<Class> powers) {
        Animal poweredAnimal = animal.newInstance()
        powers.each { power ->
            poweredAnimal = power.newInstance(poweredAnimal)
        }

        poweredAnimal
    }

}