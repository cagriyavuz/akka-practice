package AkkaEx;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.ActorRef;

public class Actor1 extends AbstractActor {
    private final ActorRef actor2;

    public Actor1(ActorRef actor2) {
        this.actor2 = actor2;
    }

    public static Props props(ActorRef actor2) {
        return Props.create(Actor1.class, () -> new Actor1(actor2));
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", msg -> {
                    actor2.tell("Hi from Actor1", getSelf());
                })
                .matchEquals("Hi back from Actor2", msg -> {
                    System.out.println("Received reply in Actor1: " + msg);
                })
                .build();
    }
}
