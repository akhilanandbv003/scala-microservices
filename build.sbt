name := "scala-microservices"

version := "0.1"

scalaVersion := "2.12.6"


val akkaV = "2.5.9"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor" %akkaV
  ).map(_.exclude("org.slf4j", "*"))
}


//Logging
libraryDependencies ++= {
  Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3"
  )
}


