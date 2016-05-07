package com.sparkApp.Demo


import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
/**
  * Created by Hyman on 2016/5/7.
  */
object SimpleApp {

  def main(args: Array[String]){

    val logFile = "Your_SPARK_HOME/README.md"
    val conf = new SparkConf().setAppName("Simple application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile,2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()

    print("line with a : %s,line with b: %s".format(numAs,numBs))
  }

}
