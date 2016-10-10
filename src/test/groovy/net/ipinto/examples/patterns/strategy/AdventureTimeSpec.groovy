package net.ipinto.examples.patterns.strategy

import net.ipinto.examples.patterns.strategy.abilities.singing.*
import net.ipinto.examples.patterns.strategy.abilities.fighting.*
import net.ipinto.examples.patterns.strategy.characters.*
import net.ipinto.examples.patterns.strategy.utilities.LuckDispatcher
import spock.lang.Specification


class AdventureTimeSpec extends Specification {

    def "Finn attacks with a dragon kick, and sometimes fails :("() {
        given:
        Character finn = new Finn(
                fightBehaviour: getDragonKickFighting(hasSuccess),
                singBehaviour: new CoolSinging())

        expect:
        damage == finn.attack()

        where:
        hasSuccess || damage
        true       || 100
        false      || 0
    }

    def "BMO beats Finn because he learns how to punch, but Finn is sick and he can't fight"() {
        given:
        Character finn = new Finn(
                fightBehaviour: new PeacefulFighting(),
                singBehaviour: new CoolSinging())

        Character bMO = new BMO(
                fightBehaviour: new PunchFighting(strenght: 2),
                singBehaviour: new CoolSinging())

        expect:
        finn.attack() < bMO.attack()
    }

    def "Finn sings as well as BMO"() {
        given:
        Character finn = new Finn(
                fightBehaviour: getDragonKickFighting(),
                singBehaviour: new CoolSinging())

        Character bMO = new BMO(
                fightBehaviour: new PeacefulFighting(),
                singBehaviour: new CoolSinging())

        and:
        String adventureTimeSong = """
            Adventure Time
            Come on grab your friends
            well go to very distant lands
            with Jake the dog
            and Finn the human
            The fun will never end
            its adventure time!
            """

        expect:
        finn.sing(adventureTimeSong) == bMO.sing(adventureTimeSong)
    }

    def "Ice King tries to sing, but even Gunther has flown away..."() {
        given:
        Character iceKing = new IceKing(
                fightBehaviour: new PunchFighting(strenght: 300),
                singBehaviour: new PoorSinging()
        )

        and:
        String song = "Marceline, I can feel myself slipping away. " +
                "I can't remember what it made me say. " +
                "But I remember that I saw you frown. " +
                "I swear it wasn't me, it was the crown."

        expect:
        iceKing.sing(song) == "Marceline, I can feel myself slipping away... eeerrr... " +
                "I can'd remember whad id made me say... eeerrr... " +
                "Bud I remember dhad I saw you frown... eeerrr... " +
                "I swear id wasn'd me, id was dhe crown... eeerrr..."
    }

    private DragonKickFighting getDragonKickFighting(boolean hitsTheEnemy = true) {
        DragonKickFighting dragonKickFighting = new DragonKickFighting(strenght: 10)
        dragonKickFighting.fortune = Stub(LuckDispatcher) {
            hasSuccess() >> { hitsTheEnemy }
        }
        dragonKickFighting
    }

}
