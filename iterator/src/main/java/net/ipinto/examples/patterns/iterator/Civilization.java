package net.ipinto.examples.patterns.iterator;


import java.util.Iterator;

public interface Civilization {

    void addPerson(String name);

    Iterator createIterator();

}
