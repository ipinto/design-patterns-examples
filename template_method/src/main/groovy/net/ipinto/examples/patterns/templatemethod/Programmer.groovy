package net.ipinto.examples.patterns.templatemethod


class Programmer extends Worker {

    boolean sleepy = false

    Programmer() {
        profession = "Programmer"
    }

    @Override
    void work() {
        println "I love coding!!"
    }

    boolean amILazy() {
        return sleepy
    }
}
