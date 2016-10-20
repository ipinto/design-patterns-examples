package net.ipinto.examples.patterns.decorator


abstract class Animal {

    String kind = "Undefined"

    abstract Integer attack()
    abstract Integer defend()

    String toString() { kind }

}
