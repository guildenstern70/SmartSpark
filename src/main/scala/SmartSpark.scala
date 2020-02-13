import java.io.File

import org.apache.commons.io.FileUtils
import org.apache.spark.{SparkConf, SparkContext}

object SmartSpark {

    def main(args: Array[String]) {

        //Create a SparkContext to initialize Spark
        val conf = new SparkConf()

        // Run locally on computer
        conf.setMaster("local")
        conf.setAppName("SmartSpark")
        val sc = new SparkContext(conf)

        // Load the text into a Spark RDD, which is a distributed representation of each line of text
        val textFile = sc.textFile("src/main/resources/shakespeare.txt")

        //word count
        val counts = textFile.flatMap(line => line.split(" "))
                .map(word => (word, 1))
                .reduceByKey(_ + _)

        counts.foreach(println)
        System.out.println("Total words: " + counts.count())
        val outputFile = "/tmp/shakespeareWordCount"
        FileUtils.deleteQuietly(new File(outputFile))
        counts.saveAsTextFile(outputFile)
    }

}