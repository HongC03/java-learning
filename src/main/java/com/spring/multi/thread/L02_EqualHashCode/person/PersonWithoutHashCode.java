package com.spring.multi.thread.L02_EqualHashCode.person;

import java.util.Objects;

public class PersonWithoutHashCode {

    private final String name;

    public PersonWithoutHashCode(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithoutHashCode that = (PersonWithoutHashCode) o;
        return Objects.equals(name, that.name);
    }

}
