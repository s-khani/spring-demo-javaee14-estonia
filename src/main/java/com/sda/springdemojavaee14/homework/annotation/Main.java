package com.sda.springdemojavaee14.homework.annotation;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        PersonWithAllSourceCode me = new PersonWithAllSourceCode();
        me.setName("mariusz");
        me.setSurname("p.");
        me.setAge(39);

        System.out.println("me: " + me.toString());

        PersonWithAllSourceCode anotherMe = new PersonWithAllSourceCode("mariusz","p.",39);
        System.out.println("another me: " + anotherMe);

        System.out.println("is the same object: " + (me == anotherMe));

        System.out.println("is this the same person: " + me.equals(anotherMe));

        System.out.println("are equals: " + me.equals("haha"));

        Person meAgain = new Person("khani","Samaneh",31);
        //builder is better than all args constructor - because you can see more :)
        Person meAgainWithBuilder = Person.builder()
                .name("Samaneh")
                .surname("Khani")
                .age(31)
                .build();


        //set does not store duplicates
        Set<PersonWithAllSourceCode> uniquePersons = new HashSet<>();
        uniquePersons.add(me);
        uniquePersons.add(anotherMe); // me will be replaced by anotherMe
        System.out.println("set size,after adding two equals persons: " + uniquePersons.size());
    }





}