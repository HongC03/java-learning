package com.spring.multi.thread.L02_EqualHashCode.hashMap;

import com.spring.multi.thread.L02_EqualHashCode.person.Person;
import com.spring.multi.thread.L02_EqualHashCode.person.PersonWithoutHashCode;

import java.util.HashMap;

public class EqualHashCodeHashMap {

    public static void main(String[] args) {
        // normal case: should be true
        Person harry1 = new Person("Harry");
        HashMap<Person, String> hashMap1 = new HashMap<>();
        hashMap1.put(harry1, "Developer");
        Person newHarry1 = new Person("Harry");
        System.out.println("Get Developer Entry 1 = " + hashMap1.get(newHarry1));

        // error case: should be false
        PersonWithoutHashCode harry2 = new PersonWithoutHashCode("Harry");
        HashMap<PersonWithoutHashCode, String> hashMap2 = new HashMap<>();
        hashMap2.put(harry2, "Developer");
        PersonWithoutHashCode newHarry2 = new PersonWithoutHashCode("Harry");
        System.out.println("Get Developer Entry 2 = " + hashMap2.get(newHarry2));
    }

}
