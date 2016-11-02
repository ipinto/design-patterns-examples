package net.ipinto.examples.patterns.singleton


@Singleton(lazy = true)
class SingletonWithAnnotation {

    String capitalize(String text) {
        text?.capitalize()
    }

}
