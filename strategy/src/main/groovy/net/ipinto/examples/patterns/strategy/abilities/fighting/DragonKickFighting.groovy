package net.ipinto.examples.patterns.strategy.abilities.fighting

import net.ipinto.examples.patterns.strategy.utilities.LuckDispatcher


class DragonKickFighting extends FightBehaviour {

    LuckDispatcher fortune = new LuckDispatcher()

    @Override
    Integer attack() {
        fortune.hasSuccess() ? strenght * 10 : 0
    }

}
