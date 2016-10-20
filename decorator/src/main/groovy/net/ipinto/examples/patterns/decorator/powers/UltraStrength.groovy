package net.ipinto.examples.patterns.decorator.powers

import net.ipinto.examples.patterns.decorator.Animal


class UltraStrength extends PowerDecorator {

    UltraStrength(Animal animal) {
        this.animal = animal
    }

    @Override
    Integer attack() {
        animal.attack() + 100000
    }

    @Override
    Integer defend() {
        animal.defend() + 500
    }

    String toString() {
        animal.toString() + " ultraStrong"
    }

}
