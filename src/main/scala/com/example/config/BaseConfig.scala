package com.example.config

import com.typesafe.config.ConfigFactory

import scala.util.Random

object BaseConfig {
  val config = ConfigFactory.load()

  val env = config.getString("app.env")
  val logLevel = config.getString("app.loglevel")

  val sslEnabled = config.getBoolean("feature.ssl")

  val pollInterval = config.getString("kafka.consumer.pollinterval").toInt
  val maxPollRecord = config.getString("kafka.max.poll.record")

  val bootStrapServers = config.getString("kafka.bootstrap.servers")
  val schemaRegistryUrl = config.getString("kafka.schemaregistry.servers")


  val sslPassword = config.getString("kafka.ssl.password")
  val sslTrustStoreLocation = config.getString("kafka.ssl.truststore.location")
  val sslTrustStorePassword = config.getString("kafka.ssl.truststore.password")

  val sslKeyStoreLocation = config.getString("kafka.ssl.keystore.location")
  val sslKeyStorePassword = config.getString("kafka.ssl.keystore.password")

  val telecomTopic = config.getString("kafka.topic.telecom")
  val telecomTopicGroup = appendRandomGroupId("kafka.group.consumergroup1")

  val studentTopic = config.getString("kafka.topic.student")
  val studentTopicGroup = appendRandomGroupId("kafka.group.studentconsumergroup1")

  def appendRandomGroupId(key: String) = {
    val x = config.getString("kafka.group.studentconsumergroup1") + Random.alphanumeric.take(10).mkString("")
    println(x)
    x
  }


}
