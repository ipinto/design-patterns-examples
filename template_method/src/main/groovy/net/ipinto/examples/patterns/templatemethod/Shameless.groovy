package net.ipinto.examples.patterns.templatemethod


class Shameless extends Worker {

    Shameless() {
        profession = "Shameless"
    }

    @Override
    void work() {
        println "Let's pretend that I'm working..."
    }

    boolean amILazy() {
        return true
    }

}
