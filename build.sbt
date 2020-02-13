name := "SmartSpark"

version := "0.1"

scalacOptions += "-target:jvm-1.8"

scalaVersion := "2.12.10"

resolvers +=
        "MvnRepository" at "https://mvnrepository.com/artifact/org.apache.spark/spark-core"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.5"
