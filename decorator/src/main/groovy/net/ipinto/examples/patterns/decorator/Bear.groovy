package net.ipinto.examples.patterns.decorator


class Bear extends Animal {

    Bear() {
        kind = "Bear"
    }

    @Override
    Integer attack() {
        10000
    }

    @Override
    Integer defend() {
        5000
    }

}
