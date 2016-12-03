package net.ipinto.examples.patterns.iterator;


import java.util.*;

public class Cylons implements Civilization {

    private Map<UUID, String> population = new HashMap<>();

    @Override
    public void addPerson(String name) {
        population.put(UUID.randomUUID(), name);
    }

    public Iterator createIterator() {
        return population.values().iterator();
    }

}
