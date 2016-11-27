import net.ipinto.examples.patterns.templatemethod.Programmer
import net.ipinto.examples.patterns.templatemethod.Shameless
import net.ipinto.examples.patterns.templatemethod.Worker

class Main {

    static void main(String[] args) {
        println "# The hard worker that loves her work:"
        Worker programmer = new Programmer()
        programmer.greet()
        programmer.faceWorkingDay()
        println "\n"

        println "# The sleepy worker that prefer to stay 20 minutes more sleeping:"
        Worker sleepyProgrammer = new Programmer(sleepy: true)
        sleepyProgrammer.greet()
        sleepyProgrammer.faceWorkingDay()
        println "\n"

        println "# The typical shameless person who doesn't care about anything:"
        Worker shameless = new Shameless()
        shameless.greet()
        shameless.faceWorkingDay()
    }

}
