package net.ipinto.examples.patterns.decorator


class Human extends Animal {

    Human() {
        kind = "Human"
    }

    @Override
    Integer attack() {
        100
    }

    @Override
    Integer defend() {
        50
    }

}
