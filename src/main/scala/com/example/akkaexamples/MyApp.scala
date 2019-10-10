package com.example.akkaexamples

import akka.actor.{ActorSystem, Props}
import com.typesafe.scalalogging.LazyLogging

object MyApp extends App with LazyLogging{

  val system = ActorSystem("kafkaactorsystem")
  system.actorOf(Props[KafkaActor],"kafkaactor") ! StartConsuming
  system.terminate()

}
