package com.example.kafkaexamples

import java.util.Properties

import com.example.config.BaseConfig
import io.confluent.kafka.serializers.{KafkaAvroDeserializer, KafkaAvroDeserializerConfig}
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.consumer.ConsumerConfig._
import org.apache.kafka.common.serialization.StringDeserializer

object ConsumerProperties {

  def buildProperties: Properties = {
    val props = new Properties()

    props.put(BOOTSTRAP_SERVERS_CONFIG, BaseConfig.bootStrapServers)
    props.put("schema.registry.url",BaseConfig.schemaRegistryUrl)
    props.put(GROUP_ID_CONFIG, BaseConfig.studentTopicGroup)
    props.put(KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
    props.put(VALUE_DESERIALIZER_CLASS_CONFIG, classOf[KafkaAvroDeserializer])

    props.put(MAX_POLL_RECORDS_CONFIG, BaseConfig.maxPollRecord)
    props.put(ENABLE_AUTO_COMMIT_CONFIG, java.lang.Boolean.TRUE)
    props.put(AUTO_OFFSET_RESET_CONFIG, "earliest")
    props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, java.lang.Boolean.FALSE) //useSpecificAvro = true

    if (BaseConfig.sslEnabled) {
      props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL")
    }
    props
  }

}
