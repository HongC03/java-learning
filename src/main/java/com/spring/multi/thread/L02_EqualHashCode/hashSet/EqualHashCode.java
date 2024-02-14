package com.spring.multi.thread.L02_EqualHashCode.hashSet;

import com.spring.multi.thread.L02_EqualHashCode.person.Person;
import com.spring.multi.thread.L02_EqualHashCode.person.PersonWithoutHashCode;

import java.util.HashSet;

public class EqualHashCode {

    public static void main(String[] args) {
        // normal case: should be true
        Person harry1 = new Person("Harry");
        HashSet<Person> hashSet1 = new HashSet<>();
        hashSet1.add(harry1);
        Person newHarry1 = new Person("Harry");
        hashSet1.add(newHarry1);
        Boolean isContainHarryPersonObj1 = hashSet1.contains(newHarry1);
        System.out.println("isContainHarryPersonObj 1 = " + isContainHarryPersonObj1);

        // error case: should be false
        PersonWithoutHashCode harry2 = new PersonWithoutHashCode("Harry");
        HashSet<PersonWithoutHashCode> hashSet2 = new HashSet<>();
        hashSet2.add(harry2);
        PersonWithoutHashCode newHarry2 = new PersonWithoutHashCode("Harry");
        hashSet2.add(newHarry2);
        Boolean isContainHarryPersonObj2 = hashSet2.contains(newHarry2);
        System.out.println("isContainHarryPersonObj 2 = " + isContainHarryPersonObj2);

    }


}
