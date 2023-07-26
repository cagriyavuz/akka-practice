package AkkaEx;

import akka.actor.Props;
import akka.actor.AbstractActor;

public class Actor2 extends AbstractActor {
    public static Props props() {
        return Props.create(Actor2.class, Actor2::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("Hi from Actor1", msg -> {
                    System.out.println("Received in Actor2: " + msg);
                    getSender().tell("Hi back from Actor2", getSelf());
                })
                .build();
    }
}
