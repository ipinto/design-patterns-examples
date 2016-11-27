package net.ipinto.examples.patterns.templatemethod


abstract class Worker {

    String profession = "Worker"

    final void faceWorkingDay() {
        wakeUp()
        if (!amILazy()) { eatBreakFast() }
        work()
        socialize()
        relax()
        goToSleep()
    }

    void wakeUp() {
        println "Today is going to be a great day!"
    }

    boolean amILazy() {
        false
    }

    void eatBreakFast() {
        println "I'm having a delicious breakfast"
    }

    abstract void work()

    void socialize() {
        println "It's time to have a good time with friends"
    }

    void relax() {
        println "I need to have a rest..."
    }

    void goToSleep() {
        println "ZzZzZzZzZzZzZz..."
    }

    void greet() {
        println "Hi, I'm a $profession"
    }

}
