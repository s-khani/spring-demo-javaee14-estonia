package com.sda.springdemojavaee14.homework.optional;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalExerciseMain {

    public static void main(String[] args) {

        int nickLength = personNick() != null ? personNick().length() : 0;
        System.out.println("nick length is: " + nickLength);

       Optional<String> maybeNick = personNickIfPresent();
       if (maybeNick.isPresent()){
           System.out.println(maybeNick.get());
       } else {
           System.out.println("Sorry,no nick");
       }

        if (maybeNick.isEmpty()){
            System.out.println("Sorry,no nick");
        } else {
            System.out.println(maybeNick.get());
        }
        System.out.println("Better usage of optional");
        System.out.println("nick: " + maybeNick.orElse("no nick"));
        System.out.println("Optional with lambda");
        maybeNick.ifPresent(new MyNickConsumer());
        System.out.println("now with my own lambda");
        //Lambda is about reducing ceremony
        //Lambda is for shorter way of providing interface implementation
        //Lambda is content of missing interface method
        //We don't need argument of lambda because we know which method we implement
        // -> (arrow) is separator of arguments and method body
        //Lambda is for sending behaviour
        //we can use lambda only with interfaces with just one abstract method (one to implement)
        maybeNick.ifPresent(nick -> System.out.println("Nick is :" +nick));

        System.out.println("Now more exercises with lambda");
        Optional<String> hasContent = Optional.of("stupid content");
        Optional<String> noContent = Optional.empty();



        System.out.println("Using ifPresentOrElse methods to optional class with lambdas");
        //first argument we implement accept method
        hasContent.ifPresentOrElse(s -> System.out.println("Value is present: " + s),
                ()-> System.out.println("no content"));
       noContent.ifPresentOrElse(s -> {
                   System.out.println("has content");
                   System.out.println("content" + s);
               },
               ()->{
                   System.out.println("no content");
                   System.out.println("just null");

               }
               );





    }


    //In Kotlin language : String (never null) and String?
    public static String personNick(){

        return null;

    }

    // Optional is bag for just one item
    // we're using "factory methods" for creating instances of this class
    // factory method - is static method which is able to produce instances of classes and have good name
    public static Optional<String> personNickIfPresent() {

        return Optional.of("maniek");

    }
}

class MyNickConsumer implements Consumer<String>{


    //generic interface consumer- T will be replaced with String in our class
    @Override
    public void accept(String s) {
        System.out.println("Nick is :" +s);
    }
}
