package com.example.kafkaexamples

import com.example.config.BaseConfig
import com.typesafe.scalalogging.LazyLogging
import org.apache.avro.generic.GenericRecord
import org.apache.avro.specific.SpecificRecord
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object KafkaApp extends App with LazyLogging{
  consume(BaseConfig.studentTopic)

  def consume(topic: String) = {
    val kafkaConsumer = new KafkaConsumer[AnyRef, GenericRecord](ConsumerProperties.buildProperties)

    kafkaConsumer.subscribe(List(topic).asJava)
    try{
      val polledRecords = kafkaConsumer.poll(5000).iterator.asScala.toList // Polled every 5 mins by default & waits for 500 ms for messages
      val kafkaRecords = polledRecords.map(data => {
        logger.info("##################")
        println(data.topic().toString)
        println(data.value().toString)
        logger.info("##################")
        logger.info(data.topic())
        logger.info(data.value().toString)
        logger.info(data.offset().toString)
      })
    }
    catch {
      case e:Exception =>{
        logger.info(e.getMessage)
      }
    }



  }

}