package com.spring.multi.thread.L02_EqualHashCode.person;

public class PersonComparable implements Comparable<PersonComparable> {

    private final String name;

    public PersonComparable(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(PersonComparable o) {
        return o.name.compareTo(this.name);
    }
}
