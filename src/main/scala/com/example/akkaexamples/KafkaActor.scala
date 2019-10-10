package com.example.akkaexamples

import akka.actor.Actor
import com.typesafe.scalalogging.LazyLogging

case class StartConsuming()

class KafkaActor extends Actor with LazyLogging {

  override def receive:Receive = {
    case StartConsuming => {
      logger.info("Start Consuming")
    }
  }

}

object KafkaActor
