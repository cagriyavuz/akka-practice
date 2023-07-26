package AkkaEx;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef actor2 = system.actorOf(Actor2.props());
        ActorRef actor1 = system.actorOf(Actor1.props(actor2));
        actor1.tell("start", ActorRef.noSender());
        system.terminate();
    }
}
