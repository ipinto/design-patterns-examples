package net.ipinto.examples.patterns.iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Humanity implements Civilization {

    private List<String> population = new ArrayList<>();

    @Override
    public void addPerson(String name) {
        population.add(name);
    }

    public Iterator createIterator() {
        return population.iterator();
    }

}
