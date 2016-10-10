package net.ipinto.examples.patterns.strategy.abilities.singing

class PoorSinging implements SingBehaviour {

    @Override
    String sing(String song) {
        song.replaceAll("\\.", '... eeerrr...').replaceAll('t', 'd')
    }
}
