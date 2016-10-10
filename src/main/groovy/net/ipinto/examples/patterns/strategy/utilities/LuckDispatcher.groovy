package net.ipinto.examples.patterns.strategy.utilities


class LuckDispatcher {

    boolean hasSuccess() {
        new Random().nextInt(10) in [2, 5]
    }

}
