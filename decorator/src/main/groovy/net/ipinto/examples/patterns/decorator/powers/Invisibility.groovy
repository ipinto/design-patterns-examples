package net.ipinto.examples.patterns.decorator.powers

import net.ipinto.examples.patterns.decorator.Animal


class Invisibility extends PowerDecorator {

    Invisibility(Animal animal) {
        this.animal = animal
    }

    @Override
    Integer attack() {
        animal.attack() + 50
    }

    @Override
    Integer defend() {
        animal.defend() + 10000
    }

    String toString() {
        animal.toString() + " invisible"
    }

}
