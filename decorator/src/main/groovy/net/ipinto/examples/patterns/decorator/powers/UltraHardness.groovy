package net.ipinto.examples.patterns.decorator.powers

import net.ipinto.examples.patterns.decorator.Animal


class UltraHardness extends PowerDecorator {

    UltraHardness(Animal animal) {
        this.animal = animal
    }

    @Override
    Integer attack() {
        animal.attack() + 10000
    }

    @Override
    Integer defend() {
        animal.defend() + 100000
    }

    String toString() {
        animal.toString() + " ultraHard"
    }

}
