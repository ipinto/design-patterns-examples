package net.ipinto.examples.patterns.strategy.characters

import net.ipinto.examples.patterns.strategy.abilities.fighting.FightBehaviour
import net.ipinto.examples.patterns.strategy.abilities.singing.SingBehaviour

abstract class Character {

    String name

    @Delegate FightBehaviour fightBehaviour
    @Delegate SingBehaviour singBehaviour

}
